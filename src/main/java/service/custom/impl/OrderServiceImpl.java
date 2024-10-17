package service.custom.impl;

import dto.Order;
import dto.OrderDetails;
import entity.OrderDetailEntity;
import entity.OrderEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.OrderDao;
import service.custom.OrderService;
import util.DaoType;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao= DaoFactory.getInstance().getDao(DaoType.ORDER);
    @Override
    public ObservableList<OrderEntity> getAllOrders() {
        return orderDao.getAll();
    }

    @Override
    public Boolean addOrder(Order order, ObservableList<OrderDetails> orderDetails) {
        ObservableList<OrderDetailEntity> orderDetailEntities= FXCollections.observableArrayList();
        orderDetails.forEach(orderDetail ->orderDetailEntities.add(new ModelMapper().map(orderDetail, OrderDetailEntity.class)));
        OrderEntity orderEntity = new ModelMapper().map(order, OrderEntity.class);
        orderEntity.setOrderDetails(orderDetailEntities);
        return orderDao.save(orderEntity,orderDetailEntities);
    }

    @Override
    public OrderEntity searchOrderById(String id) {
        OrderEntity orderEntity = orderDao.searchById(id);
        return orderEntity;
    }

    @Override
    public boolean updateOrder(Order order,ObservableList<OrderDetails> orderDetails) {
        ObservableList<OrderDetailEntity> orderDetailEntities= FXCollections.observableArrayList();
        orderDetails.forEach(orderDetail ->orderDetailEntities.add(new ModelMapper().map(orderDetail, OrderDetailEntity.class)));
        OrderEntity orderEntity = new ModelMapper().map(order, OrderEntity.class);
        orderEntity.setOrderDetails(orderDetailEntities);
        return orderDao.update(orderEntity,orderDetailEntities);
    }

    @Override
    public boolean deleteOrder(String id) {
        return orderDao.delete(id);
    }
}
