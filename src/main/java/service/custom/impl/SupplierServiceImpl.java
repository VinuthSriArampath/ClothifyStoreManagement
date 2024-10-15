package service.custom.impl;

import dto.Supplier;
import entity.SupplierEntity;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.SupplierDao;
import service.custom.SupplierService;
import util.DaoType;

public class SupplierServiceImpl implements SupplierService{
    SupplierDao supplierDao=DaoFactory.getInstance().getDao(DaoType.SUPPLIER);;
    @Override
    public boolean addSupplier(Supplier supplier) {
        return supplierDao.save(new ModelMapper().map(supplier, SupplierEntity.class));
    }

    @Override
    public Supplier searchSupplier(String id) {
        SupplierEntity supplierEntity = supplierDao.searchById(id);
        return supplierEntity==null ? null : new ModelMapper().map(supplierEntity,Supplier.class);
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        return supplierDao.update(new ModelMapper().map(supplier, SupplierEntity.class));
    }

    @Override
    public ObservableList<SupplierEntity> getAllSuppliers() {
        return supplierDao.getAll();
    }

    @Override
    public boolean deleteSupplier(String id) {
        return false;
    }

}
