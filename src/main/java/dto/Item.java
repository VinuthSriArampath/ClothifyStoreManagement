package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
    private String itemId;
    private String itemName;
    private String itemCategory;
    private String itemSize;
    private int itemStockLevel;
    private Double itemUnitPrice;
    private String itemSupplierId;
}
