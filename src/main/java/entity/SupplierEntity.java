package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "supplier")
public class SupplierEntity {
    @Id
    private String supplierId;
    private String supplierName;
    private String supplierEmail;
    private String companyName;
    private String supplierAddress;
}
