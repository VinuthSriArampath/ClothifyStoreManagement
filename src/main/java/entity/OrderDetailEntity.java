package entity;

import dto.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "order_details")
public class OrderDetailEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrderEntity order;

    @Id
    private String itemId;
    private Integer itemQty;
    private Double itemTotalPrice;

    public OrderDetailEntity(String itemId, Integer itemQty, Double itemTotalPrice) {
        this.itemId = itemId;
        this.itemQty = itemQty;
        this.itemTotalPrice = itemTotalPrice;
    }

}
