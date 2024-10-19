package dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private String orderId;
    private String customerName;
    private String customerEmail;
    private LocalDate orderDate;
    private LocalTime orderTime;
    private List<OrderDetails> orderDetails;
    private Double orderTotal;

    public Order(String orderId, String customerName, String customerEmail, LocalDate orderDate,LocalTime orderTime, Double orderTotal) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.orderDate = orderDate;
        this.orderTime=orderTime;
        this.orderTotal = orderTotal;
    }
}
