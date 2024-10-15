package service.custom;

import dto.Employee;
import dto.Supplier;
import entity.SupplierEntity;
import javafx.collections.ObservableList;
import service.SuperService;

public interface SupplierService extends SuperService {
    boolean addSupplier(Supplier supplier);
    Supplier searchSupplier(String id);
    boolean updateSupplier(Supplier supplier);
    ObservableList<SupplierEntity> getAllSuppliers();
    boolean deleteSupplier(String id);
}
