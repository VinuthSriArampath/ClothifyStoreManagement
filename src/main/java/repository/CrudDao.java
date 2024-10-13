package repository;

import javafx.collections.ObservableList;

public interface CrudDao<T> extends SuperDao{
    boolean save(T t);
    boolean update(T t);
    boolean delete(String id);
    T searchById(String id);
    ObservableList<T> getAll();
}
