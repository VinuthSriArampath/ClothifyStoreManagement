package service;

import service.custom.impl.EmployeeServiceImpl;
import util.ServiceType;

public class ServiceFactory {
    private ServiceFactory instance;

    private ServiceFactory(){}

    public ServiceFactory getInstance() {
        return instance==null?instance=new ServiceFactory():instance;
    }

    public <T extends SuperService>T getService(ServiceType type){
        switch (type){
            case EMPLOYEE : return (T) new EmployeeServiceImpl();
            default:return null;
        }
    }
}
