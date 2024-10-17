package controller.dto_controllers;

import dto.Cart;
import dto.Order;
import dto.OrderDetails;
import entity.OrderEntity;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import service.ServiceFactory;
import service.custom.OrderService;
import util.ServiceType;

import java.util.regex.Pattern;

public class OrderController {
    private static OrderController instance;
    private OrderController(){}

    public static OrderController getInstance() {
        return instance==null?instance=new OrderController():instance;
    }

    OrderService orderService= ServiceFactory.getInstance().getService(ServiceType.ORDER);

    public Boolean placeOrder(Order order,ObservableList<OrderDetails> orderDetails){
        return orderService.addOrder(order,orderDetails);
    }
    public OrderEntity searchOrder(String id){
        return orderService.searchOrderById(id);
    }
    public String generateOrderId(){
        ObservableList<OrderEntity> allOrders = orderService.getAllOrders();
        System.out.println(allOrders.isEmpty());
        int idNum=allOrders.isEmpty() ? 1 : Integer.parseInt(allOrders.getLast().getOrderId().split("Ord")[1])+1;
        return "Ord"+idNum;
    }
    public Boolean deleteOrder(String id){
        return orderService.deleteOrder(id);
    }
    public Boolean validateOrderDetails(String customerName, String customerEmail, ObservableList<Cart> cart){
        String regEmailPattern = "^[A-Za-z0-9._%+-]+@gmail\\.com$";
        Pattern emailPattern = Pattern.compile(regEmailPattern);
        if (customerName.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter Customer Name").showAndWait();
            return false;
        }else if (!emailPattern.matcher(customerEmail).matches()){
            new Alert(Alert.AlertType.ERROR,"Invalid Email Address").showAndWait();
            return false;
        } else if (cart.isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"Add An Item To Cart").showAndWait();
            return false;
        }else {
            return true;
        }
    }

    public ObservableList<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }

    public boolean updateOrder(Order order, ObservableList<OrderDetails> orderDetailsList) {
        return orderService.updateOrder(order,orderDetailsList);
    }
}
