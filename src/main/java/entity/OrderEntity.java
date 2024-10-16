package entity;

import dto.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class OrderEntity {
    private String orderId;
    private LocalDate orderDate;
    private LocalTime orderTime;
    private List<OrderDetails> orderDetails;
    private Double orderTotal;
}
