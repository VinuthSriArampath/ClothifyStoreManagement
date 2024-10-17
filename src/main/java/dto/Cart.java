package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cart {
    private String itemId;
    private String itemName;
    private Double itemUnitPrice;
    private Integer itemQty;
    private Double itemTotal;
}
