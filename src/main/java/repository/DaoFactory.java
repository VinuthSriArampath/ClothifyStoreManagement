package repository;


import repository.custom.impl.EmployeeDaoImpl;
import repository.custom.impl.SupplierDaoImpl;
import service.custom.impl.SupplierServiceImpl;
import util.DaoType;

public class DaoFactory {
    private static DaoFactory instance;
    private DaoFactory(){}

    public static DaoFactory getInstance() {
        return instance==null?instance=new DaoFactory():instance;
    }
    public <T extends SuperDao>T getDao(DaoType type){
        switch (type){
            case EMPLOYEE : return (T) new EmployeeDaoImpl();
            case SUPPLIER : return (T) new SupplierDaoImpl();
            default:return null;
        }
    }
}
