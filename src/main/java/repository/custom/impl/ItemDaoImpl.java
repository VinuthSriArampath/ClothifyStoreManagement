package repository.custom.impl;

import entity.ItemEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import repository.custom.ItemDao;
import util.HibernateUtil;

import java.util.List;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean save(ItemEntity itemEntity) {
        try{
            Session session = HibernateUtil.getItemSession();
            session.beginTransaction();
            session.persist(itemEntity);
            session.getTransaction().commit();
            session.close();
            return true;
        }catch (HibernateException e){
            return false;
        }
    }

    @Override
    public boolean update(ItemEntity itemEntity) {
        try {
            Session session = HibernateUtil.getItemSession();
            session.beginTransaction();
            session.merge(itemEntity);
            session.getTransaction().commit();
            session.close();
            return true;
        }catch (HibernateException e){
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            Session session = HibernateUtil.getItemSession();
            session.beginTransaction();
            session.remove(session.get(ItemEntity.class,id));
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            return false;
        }

    }

    @Override
    public ItemEntity searchById(String id) {
        Session session = HibernateUtil.getItemSession();
        return session.get(ItemEntity.class,id);
    }

    @Override
    public ObservableList<ItemEntity> getAll() {
        ObservableList<ItemEntity> itemList= FXCollections.observableArrayList();
        try {
            Session session = HibernateUtil.getItemSession();
            List<ItemEntity> itemEntityList = session.createQuery("From ItemEntity", ItemEntity.class).list();
            itemList.addAll(itemEntityList);
            return itemList;
        } catch (Exception e) {
            return itemList;
        }
    }
}
