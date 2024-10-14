package service.custom.impl;

import dto.Employee;
import dto.Supplier;
import entity.SupplierEntity;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.SuperDao;
import repository.custom.SupplierDao;
import repository.custom.impl.SupplierDaoImpl;
import service.custom.SupplierService;
import util.DaoType;

public class SupplierServiceImpl implements SupplierService {
    @Override
    public boolean addSupplier(Supplier supplier) {
        SupplierDaoImpl dao = DaoFactory.getInstance().getDao(DaoType.SUPPLIER);
        return dao.save(new ModelMapper().map(supplier, SupplierEntity.class));
    }

    @Override
    public Supplier searchSupplier(String id) {
        SupplierDaoImpl dao=DaoFactory.getInstance().getDao(DaoType.SUPPLIER);
        SupplierEntity supplierEntity = dao.searchById(id);
        return supplierEntity==null ? null : new ModelMapper().map(supplierEntity,Supplier.class);
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        SupplierDao dao= DaoFactory.getInstance().getDao(DaoType.SUPPLIER);
        return dao.update(new ModelMapper().map(supplier, SupplierEntity.class));
    }

    @Override
    public ObservableList<SupplierEntity> getAllSuppliers() {
        SupplierDao dao= DaoFactory.getInstance().getDao(DaoType.SUPPLIER);
        return dao.getAll();
    }

    @Override
    public boolean deleteSupplier(String id) {
        return false;
    }
}
