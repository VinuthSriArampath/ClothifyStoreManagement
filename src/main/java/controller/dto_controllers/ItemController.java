package controller.dto_controllers;

import dto.Item;
import entity.ItemEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Alert;
import service.ServiceFactory;
import service.custom.impl.ItemServiceImpl;
import util.ServiceType;

import java.util.Comparator;
import java.util.regex.Pattern;


public class ItemController{
    private static ItemController instance;
    private ItemController(){}

    public static ItemController getInstance() {
        return instance==null?instance=new ItemController():instance;
    }

    ItemServiceImpl itemService=ServiceFactory.getInstance().getService(ServiceType.ITEM);

    public boolean validateItem(String itemName, String itemStockLevel, String itemUnitPrize, String itemCategory, String itemSize, String itemSupplierId) {
        String regPattern="^[\\d]+(\\.[\\d])?$";
        Pattern itemPattern =Pattern.compile(regPattern);
        if (itemName.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter Item Name").showAndWait();
            return false;
        } else if (!itemPattern.matcher(itemStockLevel).matches() || itemStockLevel.isEmpty() || Integer.parseInt(itemStockLevel.split("\\.")[0])<=0 ) {
            new Alert(Alert.AlertType.ERROR,"Invalid stock level").showAndWait();
            return false;
        } else if (!itemPattern.matcher(itemUnitPrize).matches() ||itemUnitPrize.isEmpty() || Double.parseDouble(itemUnitPrize) < 0 ) {
            new Alert(Alert.AlertType.ERROR,"Invalid unit price").showAndWait();
            return false;
        } else if (itemCategory==null) {
            new Alert(Alert.AlertType.ERROR,"Select an item category").showAndWait();
            return false;
        } else if (itemSize==null) {
            new Alert(Alert.AlertType.ERROR,"Select an item size").showAndWait();
            return false;
        } else if (itemSupplierId==null) {
            new Alert(Alert.AlertType.ERROR,"Select a supplier id").showAndWait();
            return false;
        }else {
            return true;
        }
    }

    public ObservableList<ItemEntity> getAllItems(){
        return itemService.getAllItems();
    }
    public boolean addItem(Item item){
        return itemService.addItem(item);
    }

    public Item searchItemById(String id){
        return itemService.searchItemById(id);
    }

    public String generateItemId(){
        ObservableList<ItemEntity> allItems = getAllItems();
        allItems.sort((item1,item2) ->{
            int id1=Integer.parseInt(item1.getItemId().split("Itm")[1]);
            int id2=Integer.parseInt(item2.getItemId().split("Itm")[1]);
            return Integer.compare(id1,id2);
        });
        int idNum= allItems.isEmpty() ? 1 : (Integer.parseInt(allItems.getLast().getItemId().split("Itm")[1]))+1;
        return "Itm"+idNum;
    }

    public boolean updateItem(Item item) {
        return itemService.updateItem(item);
    }

    public boolean deleteItem(String id){
        return itemService.deleteItem(id);
    }

    public ObservableList<ItemEntity> getAllItemsForSupplier(String id){
        return itemService.getAllItemsForSupplier(id);
    }

    public ObservableList<String> getAllItemIds() {
        ObservableList<ItemEntity> allItems = getAllItems();
        ObservableList<String> allItemIds= FXCollections.observableArrayList();
        allItems.forEach(item ->{
            allItemIds.add(item.getItemId());
        });
        return allItemIds;
    }
}
