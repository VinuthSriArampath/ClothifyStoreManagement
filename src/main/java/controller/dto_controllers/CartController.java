package controller.dto_controllers;

import javafx.scene.control.Alert;

public class CartController {
    private static CartController instance;
    private  CartController(){}

    public static CartController getInstance() {
        return instance==null?instance=new CartController():instance;
    }

    public Boolean validateCartItemsSelected(String itemId){
        if (itemId==null){
            new Alert(Alert.AlertType.ERROR,"Select an item id").showAndWait();
            return false;
        }else {
            return true;
        }
    }

    public Boolean validateAddingQty(Integer itemStockLevel,Integer itemAddingQty){
        if (itemAddingQty <=0){
            new Alert(Alert.AlertType.ERROR,"Enter a Valid Qty").showAndWait();
            return false;
        }else if (itemAddingQty>itemStockLevel){
            new Alert(Alert.AlertType.ERROR,"Not Enough Stock To Supply").showAndWait();
            return false;
        }else {
            return true;
        }
    }
}
