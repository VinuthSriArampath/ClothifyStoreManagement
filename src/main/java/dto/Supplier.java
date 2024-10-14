package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Supplier {
    private String supplierId;
    private String supplierName;
    private String supplierEmail;
    private String companyName;
    private String supplierAddress;
}
