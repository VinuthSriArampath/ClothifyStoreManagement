package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetails {
    private Order order;
    private String itemId;
    private Integer itemQty;
    private Double itemTotalPrice;

    public OrderDetails(String itemId, Integer itemQty, Double itemTotalPrice) {
        this.itemId = itemId;
        this.itemQty = itemQty;
        this.itemTotalPrice = itemTotalPrice;
    }
}
