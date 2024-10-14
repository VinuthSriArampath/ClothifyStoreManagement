package controller.dto_controllers;

import dto.Supplier;
import entity.SupplierEntity;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import service.custom.SupplierService;
import service.custom.impl.SupplierServiceImpl;

import java.util.regex.Pattern;

public class SupplierController {
    private static SupplierController instance;

    private SupplierService supplierService=new SupplierServiceImpl();

    private SupplierController(){}

    public static SupplierController getInstance() {
        return instance==null?instance=new SupplierController():instance;
    }

    public Boolean validateSupplier(String supplierName,String supplierEmail,String supplierCompanyName,String supplierAddress){
        String regEmailPattern = "^[A-Za-z0-9._%+-]+@gmail\\.com$";
        Pattern emailPattern=Pattern.compile(regEmailPattern);

        if (supplierName.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter Supplier Name").showAndWait();
            return false;
        } else if (!emailPattern.matcher(supplierEmail).matches()) {
            new Alert(Alert.AlertType.ERROR,"Invalid Email Address").showAndWait();
            return false;
        } else if (supplierCompanyName.isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"Enter Supplier Company Name").showAndWait();
            return false;
        } else if (supplierAddress.isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"Enter Supplier Address").showAndWait();
            return false;
        }else{
            return true;
        }
    }

    public Boolean addSupplier(Supplier supplier){
        return supplierService.addSupplier(supplier);
    }
    public Supplier searchSupplierById(String id){
        return supplierService.searchSupplier(id);
    }
    public Boolean updateSupplier(Supplier supplier){
        return supplierService.updateSupplier(supplier);
    }


    public String generateSupplierId(){
        ObservableList<SupplierEntity> allSuppliers = supplierService.getAllSuppliers();
        int idNum=allSuppliers.isEmpty() ? 1 : Integer.parseInt(allSuppliers.getLast().getSupplierId().split("Sup")[1])+1;
        return "Sup"+idNum;
    }
}
