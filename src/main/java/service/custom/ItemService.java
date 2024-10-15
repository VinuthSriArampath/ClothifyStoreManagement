package service.custom;

import dto.Item;
import entity.ItemEntity;
import javafx.collections.ObservableList;
import service.SuperService;

public interface ItemService extends SuperService {
    ObservableList<ItemEntity> getAllItems();

    Boolean addItem(Item item);

    Item searchItemById(String id);

    boolean updateItem(Item item);

    boolean deleteItem(String id);

    ObservableList<ItemEntity> getAllItemsForSupplier(String id);
}
