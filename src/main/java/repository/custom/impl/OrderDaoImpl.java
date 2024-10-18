package repository.custom.impl;

import dto.OrderDetails;
import entity.ItemEntity;
import entity.OrderDetailEntity;
import entity.OrderEntity;
import entity.SupplierEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.custom.OrderDao;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean update(OrderEntity orderEntity, ObservableList<OrderDetailEntity> orderDetailEntities) {
        Session session = HibernateUtil.getOrderSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            OrderEntity existingOrder = session.get(OrderEntity.class, orderEntity.getOrderId());
            if (existingOrder == null) {
                return false;
            }

            // Update order details
            existingOrder.setCustomerName(orderEntity.getCustomerName());
            existingOrder.setCustomerEmail(orderEntity.getCustomerEmail());
            existingOrder.setOrderTotal(orderEntity.getOrderTotal());

            // Handle new and existing items in order details
            for (OrderDetailEntity newDetail : orderDetailEntities) {
                boolean found = false;
                for (OrderDetailEntity existingDetail : existingOrder.getOrderDetails()) {
                    if (existingDetail.getItemId().equals(newDetail.getItemId())) {
                        found = true;
                        int qtyDifference = existingDetail.getItemQty() - newDetail.getItemQty();

                        // Update existing detail
                        existingDetail.setItemQty(newDetail.getItemQty());
                        existingDetail.setItemTotalPrice(newDetail.getItemTotalPrice());

                        // Update stock levels
                        ItemEntity item = session.get(ItemEntity.class, newDetail.getItemId());
                        if (item.getItemStockLevel() + qtyDifference >= 0) {
                            item.setItemStockLevel(item.getItemStockLevel() + qtyDifference);
                        } else {
                            throw new RuntimeException("Insufficient stock level for item: ");
                        }

                        session.merge(item);
                        session.merge(existingDetail);
                    }
                }

                // If new item is not found, add it to the order
                if (!found) {
                    existingOrder.getOrderDetails().add(newDetail);

                    ItemEntity item = session.get(ItemEntity.class, newDetail.getItemId());
                    if (item.getItemStockLevel() >= newDetail.getItemQty()) {
                        item.setItemStockLevel(item.getItemStockLevel() - newDetail.getItemQty());
                    } else {
                        throw new RuntimeException("Insufficient stock level for new item: " + item.getItemName());
                    }

                    session.merge(item);
                    session.persist(newDetail);
                }
            }

            // Remove items that are not in the new order details
            List<OrderDetailEntity> detailsToRemove = new ArrayList<>();
            for (OrderDetailEntity existingDetail : existingOrder.getOrderDetails()) {
                boolean isStillPresent = false;
                for (OrderDetailEntity newDetail : orderDetailEntities) {
                    if (newDetail.getItemId().equals(existingDetail.getItemId())) {
                        isStillPresent = true;
                        break;
                    }
                }

                // If the detail is not present in the new list, mark for removal
                if (!isStillPresent) {
                    detailsToRemove.add(existingDetail);

                    // Update stock level before removal
                    ItemEntity item = session.get(ItemEntity.class, existingDetail.getItemId());
                    item.setItemStockLevel(item.getItemStockLevel() + existingDetail.getItemQty());
                    session.merge(item);
                }
            }

            // Remove the items from the existing order and delete them from the database
            for (OrderDetailEntity detailToRemove : detailsToRemove) {
                session.remove(detailToRemove);  // Deletes the record from the database
            }
            existingOrder.getOrderDetails().removeAll(detailsToRemove);

            // Merge the updated order
            session.merge(existingOrder);

            // Commit transaction
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean save(OrderEntity orderEntity, ObservableList<OrderDetailEntity> orderDetailEntity) {
        Session orderSession = HibernateUtil.getOrderSession();
        Transaction transaction = null;
        try {
            transaction = orderSession.beginTransaction();

            orderSession.persist(orderEntity);

            for (OrderDetailEntity orderDetail : orderDetailEntity) {
                orderSession.persist(orderDetail);

                // Update stock levels
                ItemEntity item = orderSession.get(ItemEntity.class, orderDetail.getItemId());
                if (item.getItemStockLevel() > orderDetail.getItemQty()) {
                    item.setItemStockLevel(item.getItemStockLevel() - orderDetail.getItemQty());
                } else {
                    throw new RuntimeException("Insufficient stock level");
                }
            }

            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            orderSession.close();
        }
    }

    @Override
    public boolean save(OrderEntity orderEntity) {
        try {
            Session session = HibernateUtil.getOrderSession();
            session.beginTransaction();
            session.persist(orderEntity);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(OrderEntity orderEntity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        Session orderSession = HibernateUtil.getOrderSession();
        Transaction transaction = null;
        try {
            transaction = orderSession.beginTransaction();
            OrderEntity orderEntity = orderSession.get(OrderEntity.class, id);

            if (orderEntity == null) {
                return false;
            }

            // Update stock levels for each order detail before deleting the order
            List<OrderDetailEntity> orderDetails = orderEntity.getOrderDetails();
            for (OrderDetailEntity detail : orderDetails) {
                ItemEntity item = orderSession.get(ItemEntity.class, detail.getItemId());
                if (item != null) {
                    item.setItemStockLevel(item.getItemStockLevel() + detail.getItemQty());
                    orderSession.merge(item);
                }
            }

            // Delete the order
            orderSession.remove(orderEntity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            orderSession.close();
        }
    }

    @Override
    public OrderEntity searchById(String id) {
        try {
            Session session = HibernateUtil.getOrderSession();
            return session.get(OrderEntity.class, id);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ObservableList<OrderEntity> getAll() {
        ObservableList<OrderEntity> orderList = FXCollections.observableArrayList();
        try {
            Session session = HibernateUtil.getOrderSession();
            List<OrderEntity> orderEntityList = session.createQuery("From OrderEntity", OrderEntity.class).list();
            orderList.addAll(orderEntityList);
            return orderList;
        } catch (Exception e) {
            e.printStackTrace();
            return orderList;
        }
    }
}
