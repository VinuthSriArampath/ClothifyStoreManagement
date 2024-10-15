package repository.custom.impl;

import entity.ItemEntity;
import entity.SupplierEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import repository.custom.SupplierDao;
import util.HibernateUtil;

import java.util.List;

public class SupplierDaoImpl implements SupplierDao {
    @Override
    public boolean save(SupplierEntity supplierEntity) {
        try {
            Session session = HibernateUtil.getSupplierSession();
            session.beginTransaction();
            session.persist(supplierEntity);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public boolean update(SupplierEntity supplierEntity) {
        try {
            Session session = HibernateUtil.getSupplierSession();
            session.beginTransaction();
            session.merge(supplierEntity);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            Session session = HibernateUtil.getSupplierSession();
            session.beginTransaction();
            session.remove(session.get(SupplierEntity.class,id));
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            return false;
        }
    }

    @Override
    public SupplierEntity searchById(String id) {
        try {
            Session session = HibernateUtil.getSupplierSession();
            return session.get(SupplierEntity.class,id);
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ObservableList<SupplierEntity> getAll() {
        ObservableList<SupplierEntity> supplier= FXCollections.observableArrayList();
        try {
            Session session = HibernateUtil.getSupplierSession();
            List<SupplierEntity> supplierEntityList = session.createQuery("From SupplierEntity", SupplierEntity.class).list();
            supplier.addAll(supplierEntityList);
            return supplier;
        } catch (Exception e) {
            return supplier;
        }
    }
}
