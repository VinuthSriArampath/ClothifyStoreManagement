package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class OrderDetailEntity {
    private String orderId;
    private String itemId;
    private Integer itemQty;
    private Double itemTotalPrice;
}
