package service.custom.impl;

import dto.Item;
import entity.ItemEntity;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.impl.ItemDaoImpl;
import service.custom.ItemService;
import util.DaoType;

public class ItemServiceImpl implements ItemService{
    ItemDaoImpl itemDao=DaoFactory.getInstance().getDao(DaoType.ITEM);;

    @Override
    public ObservableList<ItemEntity> getAllItems() {
        return itemDao.getAll();
    }

    @Override
    public Boolean addItem(Item item) {
        return itemDao.save(new ModelMapper().map(item, ItemEntity.class));
    }

    @Override
    public Item searchItemById(String id) {
        ItemEntity itemEntity = itemDao.searchById(id);
        return itemEntity ==null? null : new ModelMapper().map(itemEntity, Item.class) ;
    }

    @Override
    public boolean updateItem(Item item) {
        return itemDao.update(new ModelMapper().map(item, ItemEntity.class));
    }

    @Override
    public boolean deleteItem(String id) {
        return itemDao.delete(id);
    }

    @Override
    public ObservableList<ItemEntity> getAllItemsForSupplier(String id) {
        return itemDao.getAllItemForSupplier(id);
    }
}
