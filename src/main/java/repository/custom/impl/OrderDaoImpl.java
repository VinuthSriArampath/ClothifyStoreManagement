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
            existingOrder.setCustomerName(orderEntity.getCustomerName());
            existingOrder.setCustomerEmail(orderEntity.getCustomerEmail());
            existingOrder.setOrderTotal(orderEntity.getOrderTotal());

            for (OrderDetailEntity newDetail : orderDetailEntities) {
                boolean found = false;
                for (OrderDetailEntity existingDetail : existingOrder.getOrderDetails()) {
                    if (existingDetail.getItemId().equals(newDetail.getItemId())) {

                        found = true;
                        int qtyDifference = existingDetail.getItemQty() - newDetail.getItemQty();


                        existingDetail.setItemQty(newDetail.getItemQty());
                        existingDetail.setItemTotalPrice(newDetail.getItemTotalPrice());

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
            List<OrderDetailEntity> detailsToRemove = new ArrayList<>();

            for (OrderDetailEntity existingDetail : existingOrder.getOrderDetails()) {
                boolean isStillPresent = false;

                for (OrderDetailEntity newDetail : orderDetailEntities) {
                    if (newDetail.getItemId().equals(existingDetail.getItemId())) {
                        isStillPresent = true;
                        break;
                    }
                }

                if (!isStillPresent) {
                    System.out.println(existingDetail);
                    detailsToRemove.add(existingDetail);
                    ItemEntity item = session.get(ItemEntity.class, existingDetail.getItemId());
                    item.setItemStockLevel(item.getItemStockLevel() + existingDetail.getItemQty());
                }
            }

            existingOrder.getOrderDetails().removeAll(detailsToRemove);


            session.merge(existingOrder);

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
            transaction=orderSession.beginTransaction();

            orderSession.persist(orderEntity);

            for (OrderDetailEntity orderDetail:orderDetailEntity){
                orderSession.persist(orderDetail);

                ItemEntity item = orderSession.get(ItemEntity.class,orderDetail.getItemId());
                if (item.getItemStockLevel()>orderDetail.getItemQty()){
                    item.setItemStockLevel(item.getItemStockLevel()- orderDetail.getItemQty());
                }else {
                    throw new RuntimeException("Insufficient stock level");
                }
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            return false;
        }finally {
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
            List<OrderDetailEntity> orderDetails = orderEntity.getOrderDetails();

            for (OrderDetailEntity detail : orderDetails) {
                ItemEntity item = orderSession.get(ItemEntity.class, detail.getItemId());
                if (item != null) {
                    item.setItemStockLevel(item.getItemStockLevel() + detail.getItemQty());
                    orderSession.merge(item);
                }
            }
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
            return session.get(OrderEntity.class,id);
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ObservableList<OrderEntity> getAll() {
        ObservableList<OrderEntity> orderList= FXCollections.observableArrayList();
        try {
            Session session = HibernateUtil.getOrderSession();
            List<OrderEntity> orderEntityList = session.createQuery("From OrderEntity", OrderEntity.class).list();
            orderList.addAll(orderEntityList);
            return orderList;
        } catch (Exception e) {
            return orderList;
        }
    }
}
