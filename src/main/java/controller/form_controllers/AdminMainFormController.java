package controller.form_controllers;

import com.jfoenix.controls.*;
import controller.dto_controllers.EmployeeController;
import controller.dto_controllers.ItemController;
import controller.dto_controllers.SupplierController;
import dto.Employee;
import dto.Item;
import dto.Supplier;
import entity.EmployeeEntity;
import entity.ItemEntity;
import entity.SupplierEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.Encryptor;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AdminMainFormController implements Initializable {

    @FXML
    private JFXButton btnLogOut;
    @FXML
    private AnchorPane annualSalesReportPage;

    @FXML
    private LineChart<?, ?> chartAnnualSales;

    @FXML
    private LineChart<?, ?> chartDailySales;

    @FXML
    private BarChart<?, ?> chartEmployeeReport;

    @FXML
    private LineChart<?, ?> chartMonthlySales;

    @FXML
    private PieChart chartProductMovement;

    @FXML
    private BarChart<?, ?> chartSupplierReport;

    @FXML
    private JFXComboBox<String> cmbAddItemCategory;

    @FXML
    private JFXComboBox<String> cmbAddItemSupplier;

    @FXML
    private JFXComboBox<String> cmbDeleteItemCategory;

    @FXML
    private JFXComboBox<String> cmbDeleteItemSupplier;

    @FXML
    private JFXComboBox<String> cmbPlaceItemId;

    @FXML
    private JFXComboBox<String> cmbUpdateItemCategory;

    @FXML
    private JFXComboBox<String> cmbUpdateItemSupplier;

    @FXML
    private JFXComboBox<String> cmbUpdateOrderItemId;

    @FXML
    private JFXComboBox<String> cmbViewItemCategory;

    @FXML
    private JFXComboBox<String> cmbViewItemSupplierId;

    @FXML
    private JFXComboBox<String> cmdAddItemSize;

    @FXML
    private JFXComboBox<String> cmdAddSupplierItemId;

    @FXML
    private JFXComboBox<String> cmdDeleteItemSize;

    @FXML
    private JFXComboBox<String> cmdUpdateItemSize;

    @FXML
    private JFXComboBox<String> cmdUpdateSupplierItemId;

    @FXML
    private JFXComboBox<String> cmdViewItemSize;

    @FXML
    private TableColumn<?, ?> collAddSupplierItemListId;

    @FXML
    private TableColumn<?, ?> collAddSupplierItemListName;

    @FXML
    private TableColumn<?, ?> collAddSupplierItemListUnitPrice;

    @FXML
    private TableColumn<?, ?> collDeleteOrderCartListItemId;

    @FXML
    private TableColumn<?, ?> collDeleteOrderCartListItemName;

    @FXML
    private TableColumn<?, ?> collDeleteOrderCartListItemQuantity;

    @FXML
    private TableColumn<?, ?> collDeleteOrderCartListItemTotalAmount;

    @FXML
    private TableColumn<?, ?> collDeleteOrderCartListItemUnitPrice;



    // * Delete Supplier Item List
    @FXML
    private TableView<ItemEntity> tblDeleteSupplierItemList;

    @FXML
    private TableColumn<?, ?> collDeleteSupplierItemId;

    @FXML
    private TableColumn<?, ?> collDeleteSupplierItemName;

    @FXML
    private TableColumn<?, ?> collDeleteSupplierUnitPrice;




    @FXML
    private TableColumn<?, ?> collPlaceOrderCartListItemId;

    @FXML
    private TableColumn<?, ?> collPlaceOrderCartListItemName;

    @FXML
    private TableColumn<?, ?> collPlaceOrderCartListItemQuantity;

    @FXML
    private TableColumn<?, ?> collPlaceOrderCartListItemTotalAmount;

    @FXML
    private TableColumn<?, ?> collPlaceOrderCartListItemUnitPrice;

    @FXML
    private TableColumn<?, ?> collUpdateOrderCartIListItemName;

    @FXML
    private TableColumn<?, ?> collUpdateOrderCartListItemId;

    @FXML
    private TableColumn<?, ?> collUpdateOrderCartListItemQuantity;

    @FXML
    private TableColumn<?, ?> collUpdateOrderCartListItemTotalAmount;

    @FXML
    private TableColumn<?, ?> collUpdateOrderCartListItemUnitPrice;

    @FXML
    private TableColumn<?, ?> collUpdateSupplierItemId;

    @FXML
    private TableColumn<?, ?> collUpdateSupplierItemName;

    @FXML
    private TableColumn<?, ?> collUpdateSupplierUnitPrice;


    // * View Employee Table

    @FXML
    private TableView<EmployeeEntity> tblViewEmployeeList;
    @FXML
    private TableColumn collViewEmployeeListAddress;

    @FXML
    private TableColumn collViewEmployeeListContact;

    @FXML
    private TableColumn collViewEmployeeListEmail;

    @FXML
    private TableColumn collViewEmployeeListId;

    @FXML
    private TableColumn collViewEmployeeListName;





    @FXML
    private TableColumn<?, ?> collViewOrderCartListItemId;

    @FXML
    private TableColumn<?, ?> collViewOrderCartListItemName;

    @FXML
    private TableColumn<?, ?> collViewOrderCartListItemQuantity;

    @FXML
    private TableColumn<?, ?> collViewOrderCartListItemTotalAmount;

    @FXML
    private TableColumn<?, ?> collViewOrderCartListItemUnitPrice;

    @FXML
    private TableColumn<?, ?> collViewOrderListCustomerId;

    @FXML
    private TableColumn<?, ?> collViewOrderListDate;

    @FXML
    private TableColumn<?, ?> collViewOrderListId;

    @FXML
    private TableColumn<?, ?> collViewOrderListTotalAmount;



    @FXML
    private AnchorPane dailySalesReportPage;

    @FXML
    private DatePicker dpDeleteOrderDate;

    @FXML
    private DatePicker dpViewOrderDate;

    @FXML
    private AnchorPane employeeReportPage;

    @FXML
    private Label lblAnnualIncome;

    @FXML
    private Label lblDailyIncome;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblDeleteEmployeeHiredDate;

    @FXML
    private Label lblDeleteOrderFinalTotalAmount;

    @FXML
    private Label lblMonthlyIncome;

    @FXML
    private Label lblPlaceOrderFinalTotalAmount;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblUpdateEmployeeHiredDate;

    @FXML
    private Label lblUpdateOrderFinalTotalAmount;

    @FXML
    private Label lblViewEmployeeHiredDate;

    @FXML
    private AnchorPane monthlySalesReportPage;

    @FXML
    private AnchorPane pageAddEmployee;

    @FXML
    private AnchorPane pageAddInventory;

    @FXML
    private AnchorPane pageAddSupplier;

    @FXML
    private AnchorPane pageDashboard;

    @FXML
    private AnchorPane pageDeleteEmployee;

    @FXML
    private AnchorPane pageDeleteInventory;

    @FXML
    private AnchorPane pageDeleteOrder;

    @FXML
    private AnchorPane pageDeleteSupplier;

    @FXML
    private AnchorPane pageEmployeeManagement;

    @FXML
    private AnchorPane pageInventoryManagement;

    @FXML
    private AnchorPane pageOrderManagement;

    @FXML
    private AnchorPane pagePlaceOrder;

    @FXML
    private AnchorPane pageReportGeneration;

    @FXML
    private AnchorPane pageSupplierManagement;

    @FXML
    private AnchorPane pageUpdateEmployee;

    @FXML
    private AnchorPane pageUpdateInventory;

    @FXML
    private AnchorPane pageUpdateOrder;

    @FXML
    private AnchorPane pageUpdateSupplier;

    @FXML
    private AnchorPane pageViewEmployee;

    @FXML
    private AnchorPane pageViewInventory;

    @FXML
    private AnchorPane pageViewOrder;

    @FXML
    private AnchorPane pageViewSupplier;

    @FXML
    private JFXPasswordField pfAddEmployeeLoginPassword;



    @FXML
    private AnchorPane productReportPage;

    @FXML
    private AnchorPane supplierReportPage;

    @FXML
    private TableView<?> tblAddSupplierItemList;

    @FXML
    private TableView<?> tblDeleteOrderCartList;



    @FXML
    private TableView<?> tblPlaceOrderCartList;

    @FXML
    private TableView<?> tblUpdateOrderCartList;

    @FXML
    private TableView<?> tblUpdateSupplierItemList;

    // * View Items Tables
    @FXML
    private TableView<ItemEntity> tblViewItemList;

    @FXML
    private TableColumn collViewItemListItemCategory;

    @FXML
    private TableColumn collViewItemListItemId;

    @FXML
    private TableColumn collViewItemListItemName;

    @FXML
    private TableColumn collViewItemListItemSize;

    @FXML
    private TableColumn collViewItemListItemStock;

    @FXML
    private TableColumn collViewItemListItemSupplier;

    @FXML
    private TableColumn collViewItemListItemUnitPrice;






    @FXML
    private TableView<?> tblViewOrderCartList;

    @FXML
    private TableView<?> tblViewOrderList;

    // * View Supplier Item List
    @FXML
    private TableView<ItemEntity> tblViewSupplierItemList;
    @FXML
    private TableColumn<?, ?> collViewSupplierItemId;

    @FXML
    private TableColumn<?, ?> collViewSupplierItemName;

    @FXML
    private TableColumn<?, ?> collViewSupplierUnitPrice;



    // * View All Supplier Table
    @FXML
    private TableView<SupplierEntity> tblViewSupplierList;
    @FXML
    private TableColumn<?, ?> collViewSupplierListAddress;

    @FXML
    private TableColumn<?, ?> collViewSupplierListCompanyName;

    @FXML
    private TableColumn<?, ?> collViewSupplierListEmail;

    @FXML
    private TableColumn<?, ?> collViewSupplierListId;

    @FXML
    private TableColumn<?, ?> collViewSupplierListSupplierName;



    @FXML
    private JFXTextArea txtAddEmployeeAddress;

    @FXML
    private JFXTextField txtAddEmployeeContact;

    @FXML
    private JFXTextField txtAddEmployeeEmail;

    @FXML
    private JFXTextField txtAddEmployeeName;

    @FXML
    private JFXTextField txtAddItemName;

    @FXML
    private JFXTextField txtAddItemStockLevel;

    @FXML
    private JFXTextField txtAddItemUnitPrice;

    @FXML
    private JFXTextField txtAddSupplierAddress;

    @FXML
    private JFXTextField txtAddSupplierCompanyName;

    @FXML
    private JFXTextField txtAddSupplierEmail;

    @FXML
    private JFXTextField txtAddSupplierItemName;

    @FXML
    private JFXTextField txtAddSupplierItemUnitPrice;

    @FXML
    private JFXTextField txtAddSupplierName;

    @FXML
    private JFXTextArea txtDeleteEmployeeAddress;

    @FXML
    private JFXTextField txtDeleteEmployeeContact;

    @FXML
    private JFXTextField txtDeleteEmployeeEmail;

    @FXML
    private JFXTextField txtDeleteEmployeeId;

    @FXML
    private JFXTextField txtDeleteEmployeeName;

    @FXML
    private JFXTextField txtDeleteItemId;

    @FXML
    private JFXTextField txtDeleteItemName;

    @FXML
    private JFXTextField txtDeleteItemStockLevel;

    @FXML
    private JFXTextField txtDeleteItemUnitPrice;

    @FXML
    private JFXTextField txtDeleteOrderCustomerEmail;

    @FXML
    private JFXTextField txtDeleteOrderCustomerName;

    @FXML
    private JFXTextField txtDeleteOrderId;

    @FXML
    private JFXTextField txtDeleteSupplierAddress;

    @FXML
    private JFXTextField txtDeleteSupplierCompanyName;

    @FXML
    private JFXTextField txtDeleteSupplierEmail;

    @FXML
    private JFXTextField txtDeleteSupplierId;

    @FXML
    private JFXTextField txtDeleteSupplierName;

    @FXML
    private JFXTextField txtPlaceOrderCustomerEmail;

    @FXML
    private JFXTextField txtPlaceOrderCustomerName;

    @FXML
    private JFXTextField txtPlaceOrderItemName;

    @FXML
    private JFXTextField txtPlaceOrderItemSize;

    @FXML
    private JFXTextField txtPlaceOrderItemStockLevel;

    @FXML
    private JFXTextField txtPlaceOrderItemUnitPrice;

    @FXML
    private JFXTextField txtPlaceOrderQty;

    @FXML
    private JFXTextArea txtUpdateEmployeeAddress;

    @FXML
    private JFXTextField txtUpdateEmployeeContact;

    @FXML
    private JFXTextField txtUpdateEmployeeEmail;

    @FXML
    private JFXTextField txtUpdateEmployeeId;

    @FXML
    private JFXTextField txtUpdateEmployeeName;

    @FXML
    private JFXTextField txtUpdateItemId;

    @FXML
    private JFXTextField txtUpdateItemName;

    @FXML
    private JFXTextField txtUpdateItemStockLevel;

    @FXML
    private JFXTextField txtUpdateItemUnitPrice;

    @FXML
    private JFXTextField txtUpdateOrderCustomerEmail;

    @FXML
    private JFXTextField txtUpdateOrderCustomerName;

    @FXML
    private JFXTextField txtUpdateOrderId;

    @FXML
    private JFXTextField txtUpdateOrderItemName;

    @FXML
    private JFXTextField txtUpdateOrderItemSize;

    @FXML
    private JFXTextField txtUpdateOrderItemStockLevel;

    @FXML
    private JFXTextField txtUpdateOrderItemUnitPrice;

    @FXML
    private JFXTextField txtUpdateOrderQty;

    @FXML
    private JFXTextField txtUpdateSupplierAddress;

    @FXML
    private JFXTextField txtUpdateSupplierCompanyName;

    @FXML
    private JFXTextField txtUpdateSupplierEmail;

    @FXML
    private JFXTextField txtUpdateSupplierId;

    @FXML
    private JFXTextField txtUpdateSupplierItemName;

    @FXML
    private JFXTextField txtUpdateSupplierItemUnitPrice;

    @FXML
    private JFXTextField txtUpdateSupplierName;

    @FXML
    private JFXTextArea txtViewEmployeeAddress;

    @FXML
    private JFXTextField txtViewEmployeeContact;

    @FXML
    private JFXTextField txtViewEmployeeEmail;

    @FXML
    private JFXTextField txtViewEmployeeId;

    @FXML
    private JFXTextField txtViewEmployeeName;

    @FXML
    private JFXTextField txtViewEmployeePassword;

    @FXML
    private JFXTextField txtViewItemId;

    @FXML
    private JFXTextField txtViewItemName;

    @FXML
    private JFXTextField txtViewItemStockLevel;

    @FXML
    private JFXTextField txtViewItemUnitPrice;

    @FXML
    private JFXTextField txtViewOrderCustomerEmail;

    @FXML
    private JFXTextField txtViewOrderCustomerName1;

    @FXML
    private JFXTextField txtViewOrderId;

    @FXML
    private JFXTextField txtViewSupplierAddress;

    @FXML
    private JFXTextField txtViewSupplierCompanyName;

    @FXML
    private JFXTextField txtViewSupplierEmail;

    @FXML
    private JFXTextField txtViewSupplierId;

    @FXML
    private JFXTextField txtViewSupplierName;

    private AnchorPane currentMainPanel;
    private AnchorPane currentSubPanel;

    // * NAVIGATION'S
    @FXML
    void btnLogOutOnAction(ActionEvent event) {
        Stage stage=new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login-form.fxml"))));
            stage.setTitle("Clothify Shop Management System");
            stage.setMaxHeight(660);
            stage.setMaxWidth(480);
            stage.setMinHeight(660);
            stage.setMinWidth(480);
            stage.setResizable(false);
            new Alert(Alert.AlertType.INFORMATION,"Log Out Successfully").showAndWait();
            btnLogOut.getScene().getWindow().hide();
            stage.show();
        } catch (IOException e) {
            new Alert(Alert.AlertType.INFORMATION,"Something Went Wrong ").showAndWait();
        }

    }

    // * Main Navigation Panel

    @FXML
    void btnDashboardPageOnAction(ActionEvent event) {
        currentMainPanel.setVisible(false);
        currentSubPanel.setVisible(false);
        currentMainPanel=pageDashboard;
        currentMainPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    void btnInventoryManagementPageOnAction(ActionEvent event) {
        currentMainPanel.setVisible(false);
        currentSubPanel.setVisible(false);
        currentMainPanel=pageInventoryManagement;
        currentMainPanel.setVisible(true);
        currentSubPanel=pageAddInventory;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    void btnSupplierManagementPageOnAction(ActionEvent event) {
        currentMainPanel.setVisible(false);
        currentSubPanel.setVisible(false);
        currentMainPanel=pageSupplierManagement;
        currentMainPanel.setVisible(true);
        currentSubPanel=pageAddSupplier;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    void btnOrderManagementPageOnAction(ActionEvent event) {
        currentMainPanel.setVisible(false);
        currentSubPanel.setVisible(false);
        currentMainPanel=pageOrderManagement;
        currentMainPanel.setVisible(true);
        currentSubPanel=pagePlaceOrder;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    void btnEmployeeManagementPageOnAction(ActionEvent event) {
        currentMainPanel.setVisible(false);
        currentSubPanel.setVisible(false);
        currentMainPanel=pageEmployeeManagement;
        currentMainPanel.setVisible(true);
        currentSubPanel=pageAddEmployee;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    void btnReportGenerationPageOnAction(ActionEvent event) {
        currentMainPanel.setVisible(false);
        currentSubPanel.setVisible(false);
        currentMainPanel=pageReportGeneration;
        currentMainPanel.setVisible(true);
        currentSubPanel=employeeReportPage;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }


    // ! Dashboard Dose Note Include Sub Navigation's On Admins Panel
    // * Sub Navigation Panels (Inventory Management page)
    @FXML
    void btnAddItemPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageAddInventory;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    void btnUpdateItemPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageUpdateInventory;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    void btnDeleteItemPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageDeleteInventory;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    void btnViewItemPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageViewInventory;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }


    // * Sub Navigation Panels (Supplier Management page)
    @FXML
    void btnAddSupplierPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageAddSupplier;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    void btnUpdateSupplierPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageUpdateSupplier;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    void btnDeleteSupplierPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageDeleteSupplier;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    void btnViewSupplierPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageViewSupplier;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }


    // * Sub Navigation Panels (Employee Management page)
    @FXML
    void btnAddEmployeePageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageAddEmployee;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    void btnUpdateEmployeePageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageUpdateEmployee;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    void btnDeleteEmployeePageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageDeleteEmployee;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    void btnViewEmployeePageOnAction(ActionEvent event) {
        loadViewEmployeeTable();
        currentSubPanel.setVisible(false);
        currentSubPanel=pageViewEmployee;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }


    // * Sub Navigation Panels (Order Management page)
    @FXML
    void btnPlaceOrderPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pagePlaceOrder;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    void btnUpdateOrderPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageUpdateOrder;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    void btnDeleteOrderPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageDeleteOrder;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    void btnViewOrderPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageViewOrder;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }


    // * Sub Navigation Panels (Report Generation page)
    @FXML
    void btnProductReportPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=productReportPage;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    void btnSupplierReportPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=supplierReportPage;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    void btnEmployeeReportPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=employeeReportPage;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    public void btnDailyReportPageOnAction(ActionEvent actionEvent) {
        currentSubPanel.setVisible(false);
        currentSubPanel=dailySalesReportPage;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    public void btnMonthlyReportPageOnAction(ActionEvent actionEvent) {
        currentSubPanel.setVisible(false);
        currentSubPanel=monthlySalesReportPage;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }
    @FXML
    public void btnAnnualSalesReportPageOnAction(ActionEvent actionEvent) {
        currentSubPanel.setVisible(false);
        currentSubPanel=annualSalesReportPage;
        currentSubPanel.setVisible(true);
        clearAllForms();
    }

    // ? FUNCTIONALITIES OF BUTTONS

    // ? Item Management Page

    // * add Item
    @FXML
    void btnAddItemOnAction(ActionEvent event) {
        String itemName = txtAddItemName.getText().trim();
        String itemStockLevel = txtAddItemStockLevel.getText().trim();
        String itemUnitPrize = txtAddItemUnitPrice.getText().trim();
        String itemCategory = cmbAddItemCategory.getValue();
        String itemSize = cmdAddItemSize.getValue();
        String itemSupplierId = cmbAddItemSupplier.getValue();

        if(ItemController.getInstance().validateItem(itemName,itemStockLevel,itemUnitPrize,itemCategory,itemSize,itemSupplierId)){
            if (ItemController.getInstance().addItem(new Item(ItemController.getInstance().genarateItemId(), itemName,itemCategory,itemSize,Integer.parseInt(itemStockLevel),Double.parseDouble(itemUnitPrize),itemSupplierId))){
                new Alert(Alert.AlertType.CONFIRMATION,"Item Added Successfully").showAndWait();
                loadViewItemsTable();
                btnAddItemClearFormOnAction(new ActionEvent());
            }else {
                new Alert(Alert.AlertType.ERROR,"Item Adding Failed").showAndWait();
            }
        }
    }
    @FXML
    void btnAddItemClearFormOnAction(ActionEvent event) {
        txtAddItemName.setText("");
        txtAddItemStockLevel.setText("");
        txtAddItemUnitPrice.setText("");
        cmbAddItemCategory.setValue(null);
        cmdAddItemSize.setValue(null);
        cmbAddItemSupplier.setValue(null);
    }

    // * update Item
    Boolean updateItemSearched=false;

    @FXML
    void btnUpdateItemOnAction(ActionEvent event) {
        if(updateItemSearched){
            String itemId = txtUpdateItemId.getText().trim();
            String itemName = txtUpdateItemName.getText().trim();
            String itemUnitPrice = txtUpdateItemUnitPrice.getText().trim();
            String itemStockLevel = txtUpdateItemStockLevel.getText().trim();
            String itemCategory = cmbUpdateItemCategory.getValue();
            String itemSize = cmdUpdateItemSize.getValue();
            String itemSupplierId = cmbUpdateItemSupplier.getValue();
            if(itemId.isEmpty() || itemName.isEmpty() || itemUnitPrice.isEmpty() || itemStockLevel.isEmpty() || itemCategory==null || itemSize==null || itemSupplierId==null){
                new Alert(Alert.AlertType.ERROR,"Fill All The Fields").showAndWait();
            }else if (ItemController.getInstance().validateItem(itemName,itemStockLevel,itemUnitPrice,itemCategory,itemSize,itemSupplierId)){
                if (ItemController.getInstance().updateItem(new Item(itemId,itemName,itemCategory,itemSize,Integer.parseInt(itemStockLevel.split("\\.")[0]),Double.parseDouble(itemUnitPrice),itemSupplierId))){
                    new Alert(Alert.AlertType.INFORMATION,"Item Updated Successfully !!").showAndWait();
                    loadViewItemsTable();
                    btnUpdateItemClearFormOnAction(new ActionEvent());
                }else {
                    new Alert(Alert.AlertType.ERROR,"Item Update Failed !! ").showAndWait();
                }
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Search An Item First").showAndWait();
        }
    }
    @FXML
    void btnUpdateItemClearFormOnAction(ActionEvent event) {
        txtUpdateItemId.setEditable(true);
        txtUpdateItemId.setText("");
        txtUpdateItemName.setText("");
        txtUpdateItemStockLevel.setText("");
        txtUpdateItemUnitPrice.setText("");
        cmbUpdateItemCategory.setValue(null);
        cmdUpdateItemSize.setValue(null);
        cmbUpdateItemSupplier.setValue(null);
    }
    @FXML
    void btnUpdateItemSearchOnAction(ActionEvent event) {
        String itemId = txtUpdateItemId.getText().trim();
        if (itemId.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter Item Id ").showAndWait();
        }else{
            Item item=ItemController.getInstance().searchItemById(itemId);
            if (item==null){
                new Alert(Alert.AlertType.ERROR,"Item Not Found ").showAndWait();
            }else {
                txtUpdateItemId.setEditable(false);
                txtUpdateItemName.setText(item.getItemName());
                txtUpdateItemStockLevel.setText(String.valueOf(item.getItemStockLevel()));
                txtUpdateItemUnitPrice.setText(String.valueOf(item.getItemUnitPrice()));
                cmbUpdateItemCategory.setValue(item.getItemCategory());
                cmdUpdateItemSize.setValue(item.getItemSize());
                cmbUpdateItemSupplier.setValue(item.getItemSupplierId());
                updateItemSearched=true;
            }
        }
    }

    // * delete Item
    boolean deleteItemSearched=false;
    @FXML
    void btnDeleteItemOnAction(ActionEvent event) {
        if(deleteItemSearched){
            if (ItemController.getInstance().deleteItem(txtDeleteItemId.getText().trim())) {
                new Alert(Alert.AlertType.ERROR, "Item Deleted Successfully").showAndWait();
                loadViewItemsTable();
                deleteItemClearForm();
            } else {
                new Alert(Alert.AlertType.ERROR, "Item Deletion Failed").showAndWait();
                deleteEmployeeClearForm();
            }
        }else {
            new Alert(Alert.AlertType.INFORMATION,"Search Item First").showAndWait();
        }
    }
    @FXML
    void btnDeleteItemSearchOnAction(ActionEvent event) {
        String itemId = txtDeleteItemId.getText().trim();
        if (itemId.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter Item Id ").showAndWait();
        }else{
            Item item=ItemController.getInstance().searchItemById(itemId);
            if (item==null){
                new Alert(Alert.AlertType.ERROR,"Item Not Found ").showAndWait();
            }else {
                txtDeleteItemId.setEditable(false);
                txtDeleteItemName.setText(item.getItemName());
                txtDeleteItemStockLevel.setText(String.valueOf(item.getItemStockLevel()));
                txtDeleteItemUnitPrice.setText(String.valueOf(item.getItemUnitPrice()));
                cmbDeleteItemCategory.setValue(item.getItemCategory());
                cmdDeleteItemSize.setValue(item.getItemSize());
                cmbDeleteItemSupplier.setValue(item.getItemSupplierId());
                deleteItemSearched=true;
            }
        }
    }

    private void deleteItemClearForm(){
        txtDeleteItemId.setEditable(true);
        txtDeleteItemId.setText("");
        txtDeleteItemName.setText("");
        txtDeleteItemStockLevel.setText("");
        txtDeleteItemUnitPrice.setText("");
        cmbDeleteItemCategory.setValue(null);
        cmdDeleteItemSize.setValue(null);
        cmbDeleteItemSupplier.setValue(null);
    }

    // * view Item
    @FXML
    void btnViewItemSearchOnAction(ActionEvent event) {
        String itemId=txtViewItemId.getText();
        if (itemId.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter Item Id ").showAndWait();
        }else{
            Item item=ItemController.getInstance().searchItemById(itemId);
            if (item==null){
                new Alert(Alert.AlertType.ERROR,"Item Not Found ").showAndWait();
            }else {
                txtViewItemName.setText(item.getItemName());
                txtViewItemStockLevel.setText(String.valueOf(item.getItemStockLevel()));
                txtViewItemUnitPrice.setText(String.valueOf(item.getItemUnitPrice()));
                cmbViewItemCategory.setValue(item.getItemCategory());
                cmdViewItemSize.setValue(item.getItemSize());
                cmbViewItemSupplierId.setValue(item.getItemSupplierId());
            }
        }
    }
    private void loadViewItemsTable(){
        tblViewItemList.setItems(ItemController.getInstance().getAllItems());
    }
    private void itemListSetText(ItemEntity itemEntity){
        txtViewItemId.setText(itemEntity.getItemId());
        txtViewItemName.setText(itemEntity.getItemName());
        txtViewItemStockLevel.setText(String.valueOf(itemEntity.getItemStockLevel()));
        txtViewItemUnitPrice.setText(String.valueOf(itemEntity.getItemUnitPrice()));
        cmdViewItemSize.setValue(itemEntity.getItemSize());
        cmbViewItemCategory.setValue(itemEntity.getItemCategory());
        cmbViewItemSupplierId.setValue(itemEntity.getItemSupplierId());
    }

    // ? Supplier Management

    // * add supplier
    @FXML
    void btnAddSupplierOnAction(ActionEvent event) {
        String supplierName = txtAddSupplierName.getText().trim();
        String supplierEmail = txtAddSupplierEmail.getText().trim();
        String supplierCompanyName = txtAddSupplierCompanyName.getText().trim();
        String supplierAddress = txtAddSupplierAddress.getText().trim();
        SupplierController supplierController=SupplierController.getInstance();
        if(supplierController.validateSupplier(supplierName,supplierEmail,supplierCompanyName,supplierAddress)){
            if (SupplierController.getInstance().addSupplier(new Supplier(supplierController.generateSupplierId(), supplierName,supplierEmail,supplierCompanyName,supplierAddress))){
                new Alert(Alert.AlertType.CONFIRMATION,"Supplier Registration Success !!").showAndWait();
                loadViewSupplierListTable();
                btnAddSupplierClearFormOnAction(new ActionEvent());
            }else{
                new Alert(Alert.AlertType.ERROR,"Supplier Registration Failed !!").showAndWait();
            }
        }
    }

    @FXML
    void btnAddSupplierClearFormOnAction(ActionEvent event) {
        txtAddSupplierName.setText("");
        txtAddSupplierEmail.setText("");
        txtAddSupplierCompanyName.setText("");
        txtAddSupplierAddress.setText("");
    }

    // * update supplier
    private Boolean updateSupplierSearched=false;

    @FXML
    void btnUpdateSupplierSearchOnAction(ActionEvent event) {
        String supplierId = txtUpdateSupplierId.getText();
        if (supplierId.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Search a Supplier !!").showAndWait();
        }else{
            Supplier supplier = SupplierController.getInstance().searchSupplierById(supplierId);
            if(supplier==null){
                new Alert(Alert.AlertType.ERROR,"Supplier Not Found").showAndWait();
            }else{
                txtUpdateSupplierId.setEditable(false);
                txtUpdateSupplierName.setText(supplier.getSupplierName());
                txtUpdateSupplierEmail.setText(supplier.getSupplierEmail());
                txtUpdateSupplierCompanyName.setText(supplier.getCompanyName());
                txtUpdateSupplierAddress.setText(supplier.getSupplierAddress());
                updateSupplierSearched=true;
            }
        }
    }

    @FXML
    void btnUpdateSupplierOnAction(ActionEvent event) {
        if (updateSupplierSearched){
            String supplierId = txtUpdateSupplierId.getText().trim();
            String supplierName = txtUpdateSupplierName.getText().trim();
            String supplierCompanyName = txtUpdateSupplierCompanyName.getText().trim();
            String supplierEmail = txtUpdateSupplierEmail.getText().trim();
            String supplierAddress = txtUpdateSupplierAddress.getText().trim();
            if (supplierId.isEmpty() || supplierName.isEmpty() || supplierCompanyName.isEmpty() || supplierEmail.isEmpty() || supplierAddress.isEmpty()){
                new Alert(Alert.AlertType.ERROR,"Fill All the Fields !! ").showAndWait();
            }else if (SupplierController.getInstance().validateSupplier(supplierName,supplierEmail,supplierCompanyName,supplierAddress)){
                if (SupplierController.getInstance().updateSupplier(new Supplier(supplierId,supplierName,supplierEmail,supplierCompanyName,supplierAddress))){
                    new Alert(Alert.AlertType.CONFIRMATION,"Supplier Updated Successfully !! ").showAndWait();
                    loadViewSupplierListTable();
                    btnUpdateSupplierClearFormOnAction(new ActionEvent());
                }else {
                    new Alert(Alert.AlertType.ERROR,"Updating Supplier Failed !! ").showAndWait();
                }
            }else {
                new Alert(Alert.AlertType.ERROR,"Fill All the Fields !! ").showAndWait();
            }
        }else{
            new Alert(Alert.AlertType.ERROR,"Search A Supplier First").showAndWait();
        }
    }

    @FXML
    void btnUpdateSupplierClearFormOnAction(ActionEvent event) {
        updateSupplierSearched=false;
        txtUpdateSupplierId.setEditable(true);
        txtUpdateSupplierId.setText("");
        txtUpdateSupplierName.setText("");
        txtUpdateSupplierAddress.setText("");
        txtUpdateSupplierCompanyName.setText("");
        txtUpdateSupplierEmail.setText("");
    }


    // * delete supplier
    boolean isDeleteSupplerSearched=false;

    @FXML
    void btnDeleteSupplierOnAction(ActionEvent event) {
        if(isDeleteSupplerSearched){
            if (SupplierController.getInstance().deleteSupplier(txtDeleteSupplierId.getText().trim())) {
                new Alert(Alert.AlertType.ERROR, "Supplier Deleted Successfully").showAndWait();
                loadViewSupplierListTable();
                deleteSupplierClearForm();
                loadDeleteSupplierItemListTable(null);
            } else {
                new Alert(Alert.AlertType.ERROR, "Supplier Deletion Failed").showAndWait();
                deleteEmployeeClearForm();
            }
        }else {
            new Alert(Alert.AlertType.INFORMATION,"Search Supplier First").showAndWait();
        }
    }

    @FXML
    void btnDeleteSupplierSearchOnAction(ActionEvent event) {
        if (txtDeleteSupplierId.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter An Supplier Id").showAndWait();
        }else {
            Supplier supplier = SupplierController.getInstance().searchSupplierById(txtDeleteSupplierId.getText().trim());
            if (supplier==null){
                new Alert(Alert.AlertType.ERROR,"Supplier Not Found").showAndWait();
            }else {
                isDeleteSupplerSearched=true;
                txtDeleteSupplierId.setEditable(false);
                txtDeleteSupplierName.setText(supplier.getSupplierName());
                txtDeleteSupplierEmail.setText(supplier.getSupplierEmail());
                txtDeleteSupplierAddress.setText(supplier.getSupplierAddress());
                txtDeleteSupplierCompanyName.setText(supplier.getCompanyName());
                loadDeleteSupplierItemListTable(txtDeleteSupplierId.getText().trim());
            }
        }
    }

    private void loadDeleteSupplierItemListTable(String id){
        tblDeleteSupplierItemList.setItems(ItemController.getInstance().getAllItemsForSupplier(id));
    }

    private void deleteSupplierClearForm(){
        isDeleteSupplerSearched=false;
        txtDeleteSupplierId.setEditable(true);
        txtDeleteSupplierId.setText("");
        txtDeleteSupplierName.setText("");
        txtDeleteSupplierEmail.setText("");
        txtDeleteSupplierAddress.setText("");
        txtDeleteSupplierCompanyName.setText("");
        loadDeleteSupplierItemListTable(null);
    }

    // * view supplier

    private void loadViewSupplierListTable(){
        tblViewSupplierList.setItems(SupplierController.getInstance().getAllSuppliers());
    }

    private void loadViewSupplierItemListTable(String id){
        tblViewSupplierItemList.setItems(ItemController.getInstance().getAllItemsForSupplier(id));
    }

    private void supplierListSetText(SupplierEntity supplierEntity){
        loadViewSupplierItemListTable(supplierEntity.getSupplierId());
        txtViewSupplierId.setText(supplierEntity.getSupplierId());
        txtViewSupplierName.setText(supplierEntity.getSupplierName());
        txtViewSupplierCompanyName.setText(supplierEntity.getCompanyName());
        txtViewSupplierEmail.setText(supplierEntity.getSupplierEmail());
        txtViewSupplierAddress.setText(supplierEntity.getSupplierAddress());
    }
    @FXML
    void btnViewSupplierSearchOnAction(ActionEvent actionEvent) {
        if (txtViewSupplierId.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter An Supplier Id").showAndWait();
        }else {
            Supplier supplier = SupplierController.getInstance().searchSupplierById(txtViewSupplierId.getText().trim());
            if (supplier==null){
                new Alert(Alert.AlertType.ERROR,"Supplier Not Found").showAndWait();
            }else {
                txtViewSupplierId.setEditable(false);
                txtViewSupplierName.setText(supplier.getSupplierName());
                txtViewSupplierEmail.setText(supplier.getSupplierEmail());
                txtViewSupplierAddress.setText(supplier.getSupplierAddress());
                txtViewSupplierCompanyName.setText(supplier.getCompanyName());
                loadViewSupplierItemListTable(supplier.getSupplierId());
            }
        }
    }

    // ? Employee Management

    // * add employee
    @FXML
    void btnAddEmployeeOnAction(ActionEvent event) throws NoSuchAlgorithmException {

        Encryptor encryptor=new Encryptor();

        String employeeName = txtAddEmployeeName.getText().trim();
        String employeeEmail = txtAddEmployeeEmail.getText().trim();
        String employeePassword = pfAddEmployeeLoginPassword.getText().trim();
        String employeeAddress = txtAddEmployeeAddress.getText().trim();
        String employeeContact = txtAddEmployeeContact.getText().trim();

        if (Boolean.TRUE.equals(EmployeeController.getInstance().validateEmployee(employeeName, employeeEmail, employeePassword, employeeAddress, employeeContact))) {
            if(EmployeeController.getInstance().addEmployee( new Employee(EmployeeController.getInstance().genarateEmployeeId(),employeeName,employeeEmail,encryptor.encryptString(employeePassword),employeeAddress,employeeContact,LocalDate.now()))){
                new Alert(Alert.AlertType.INFORMATION,"Employee Added Successfully").showAndWait();
                loadViewEmployeeTable();
                btnAddEmployeeClearFormOnAction(new ActionEvent());
            }else {
                new Alert(Alert.AlertType.ERROR,"Failed To Add Employee").showAndWait();
            }
        }
    }
    @FXML
    void btnAddEmployeeClearFormOnAction(ActionEvent event) {
        txtAddEmployeeName.setText("");
        txtAddEmployeeEmail.setText("");
        pfAddEmployeeLoginPassword.setText("");
        txtAddEmployeeAddress.setText("");
        txtAddEmployeeContact.setText("");
        txtUpdateEmployeeId.setEditable(true);
    }

    // * update employee
    private Boolean updateEmployeeSearched=false;
    private String tempEmployeePassword=null;
    @FXML
    void btnUpdateEmployeeSearchOnAction(ActionEvent event) {
        if (txtUpdateEmployeeId.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter Employee ID").showAndWait();
        }else{
            Employee employee = EmployeeController.getInstance().searchEmployeeById(txtUpdateEmployeeId.getText());
            if (employee==null){
                new Alert(Alert.AlertType.ERROR,"Employee Not Found").showAndWait();
            }else {
                txtUpdateEmployeeId.setText(employee.getEmployeeId());
                txtUpdateEmployeeName.setText(employee.getName());
                txtUpdateEmployeeContact.setText(employee.getContact());
                txtUpdateEmployeeEmail.setText(employee.getEmail());
                tempEmployeePassword=employee.getPassword();
                txtUpdateEmployeeAddress.setText(employee.getAddress());
                lblUpdateEmployeeHiredDate.setText(employee.getHiredDate().toString());
                txtUpdateEmployeeId.setEditable(false);
                updateEmployeeSearched=true;
            }
        }

    }
    @FXML
    void btnUpdateEmployeeOnAction(ActionEvent event){
        String employeeId = txtUpdateEmployeeId.getText();
        String employeeName = txtUpdateEmployeeName.getText();
        String employeeEmail = txtUpdateEmployeeEmail.getText();
        String employeeAddress = txtUpdateEmployeeAddress.getText();
        String employeeContact = txtUpdateEmployeeContact.getText();
        String employeeHiredDate = lblUpdateEmployeeHiredDate.getText();

        if(employeeId.isEmpty() || employeeName.trim().isEmpty() || employeeContact.trim().isEmpty() || employeeAddress.trim().isEmpty() || employeeEmail.isEmpty() || employeeHiredDate.isEmpty() || !updateEmployeeSearched){
            new Alert(Alert.AlertType.INFORMATION,"Search Employee First").showAndWait();
        }else {
            if (Boolean.TRUE.equals(EmployeeController.getInstance().validateEmployee(employeeName, employeeEmail, employeeAddress, employeeContact))) {
                if(EmployeeController.getInstance().updateEmployee( new Employee(employeeId.trim(),employeeName.trim(),employeeEmail.trim(),tempEmployeePassword.trim(),employeeAddress.trim(),employeeContact.trim(),LocalDate.parse(employeeHiredDate.trim())))){
                    new Alert(Alert.AlertType.INFORMATION,"Employee Updated Successfully").showAndWait();
                    btnAddEmployeeClearFormOnAction(new ActionEvent());
                    txtUpdateEmployeeId.setEditable(true);
                    loadViewEmployeeTable();
                }else {
                    new Alert(Alert.AlertType.ERROR,"Failed To Update Employee").showAndWait();
                    btnUpdateEmployeeClearFormOnAction(new ActionEvent());
                }
            }
        }

    }
    @FXML
    void btnUpdateEmployeeClearFormOnAction(ActionEvent event) {
        txtUpdateEmployeeId.setText("");
        txtUpdateEmployeeName.setText("");
        txtUpdateEmployeeContact.setText("");
        txtUpdateEmployeeEmail.setText("");
        txtUpdateEmployeeAddress.setText("");
        txtUpdateEmployeeId.setEditable(true);
        updateEmployeeSearched=false;
    }

    // * delete employee
    private Boolean deleteEmployeeSearched=false;
    @FXML
    void btnDeleteEmployeeSearchOnAction(ActionEvent event) {
        if (txtDeleteEmployeeId.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter Employee ID").showAndWait();
        }else {
            Employee employee = EmployeeController.getInstance().searchEmployeeById(txtDeleteEmployeeId.getText());
            if (employee == null) {
                new Alert(Alert.AlertType.ERROR, "Employee Not Found").showAndWait();
            } else {
                txtDeleteEmployeeId.setText(employee.getEmployeeId());
                txtDeleteEmployeeName.setText(employee.getName());
                txtDeleteEmployeeContact.setText(employee.getContact());
                txtDeleteEmployeeEmail.setText(employee.getEmail());
                txtDeleteEmployeeAddress.setText(employee.getAddress());
                lblDeleteEmployeeHiredDate.setText(employee.getHiredDate().toString());
                deleteEmployeeSearched=true;
            }
        }
    }
    @FXML
    void btnDeleteEmployeeOnAction(ActionEvent event) {
        if(txtDeleteEmployeeId.getText().isEmpty() || txtDeleteEmployeeName.getText().isEmpty() || txtDeleteEmployeeContact.getText().isEmpty() || txtDeleteEmployeeAddress.getText().isEmpty() || txtDeleteEmployeeEmail.getText().isEmpty() || lblDeleteEmployeeHiredDate.getText().isEmpty() || !deleteEmployeeSearched){
            new Alert(Alert.AlertType.INFORMATION,"Search Employee First").showAndWait();
        }else {
            if (EmployeeController.getInstance().deleteEmployee(txtDeleteEmployeeId.getText())) {
                new Alert(Alert.AlertType.ERROR, "Employee Deleted Successfully").showAndWait();
                deleteEmployeeClearForm();
            } else {
                new Alert(Alert.AlertType.ERROR, "Employee Deletion Failed").showAndWait();
                loadViewEmployeeTable();
                deleteEmployeeClearForm();
            }
        }
    }
    private void deleteEmployeeClearForm(){
        txtDeleteEmployeeId.setText("");
        txtDeleteEmployeeName.setText("");
        txtDeleteEmployeeContact.setText("");
        txtDeleteEmployeeEmail.setText("");
        txtDeleteEmployeeAddress.setText("");
        deleteEmployeeSearched=false;
    }

    // * view employee
    @FXML
    void btnViewEmployeeSearchOnAction(ActionEvent event) {
        if (txtViewEmployeeId.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter Employee ID").showAndWait();
        }else {
            Employee employee = EmployeeController.getInstance().searchEmployeeById(txtViewEmployeeId.getText());
            if (employee == null) {
                new Alert(Alert.AlertType.ERROR, "Employee Not Found").showAndWait();
            } else {
                txtViewEmployeeId.setText(employee.getEmployeeId());
                txtViewEmployeeName.setText(employee.getName());
                txtViewEmployeeContact.setText(employee.getContact());
                txtViewEmployeeEmail.setText(employee.getEmail());
                txtViewEmployeeAddress.setText(employee.getAddress());
                lblViewEmployeeHiredDate.setText(employee.getHiredDate().toString());
            }
        }
    }

    private void loadViewEmployeeTable(){
        tblViewEmployeeList.setItems(EmployeeController.getInstance().getAllEmployees());
    }
    private void employeeListSetText(EmployeeEntity newValue) {
        if (newValue != null) {
            txtViewEmployeeId.setText(newValue.getEmployeeId());
            txtViewEmployeeName.setText(newValue.getName());
            txtViewEmployeeContact.setText(newValue.getContact());
            txtViewEmployeeAddress.setText(newValue.getAddress());
            txtViewEmployeeEmail.setText(newValue.getEmail());
        }
    }


    // ? Order Management

    // * place order
    @FXML
    void btnPlaceOrderAddToCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderClearCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

    // * update order

    @FXML
    void btnUpdateOrderSearch(ActionEvent event) {

    }
    @FXML
    void btnUpdateOrderAddToCartOnAction(ActionEvent event) {

    }
    @FXML
    void btnUpdateOrderItemQtyOnAction(ActionEvent event) {

    }
    @FXML
    void btnUpdateOrderClearCartOnAction(ActionEvent event) {

    }
    @FXML
    void btnUpdateOrderOnAction(ActionEvent event) {

    }

    // * delete order

    @FXML
    void btnDeleteOrderPageSearch(ActionEvent event) {

    }
    @FXML
    void btnDeleteOrderOnAction(ActionEvent event) {

    }
    @FXML
    void btnDeleteOrderRemoveItemFromCartOnAction(ActionEvent event) {

    }

    // * view order

    @FXML
    void btnViewOrderSearch(ActionEvent event) {

    }

    // ? Generate Report

    // * Product Report

    @FXML
    void btnGenerateProductReportOnAction(ActionEvent event) {

    }

    // * Employee Report

    @FXML
    void btnGenerateEmployeeReportOnAction(ActionEvent event) {

    }

    // * Supplier Report

    @FXML
    void btnGenerateSupplierReportOnAction(ActionEvent event) {

    }

    // * Daily Sales Report

    @FXML
    void btnGenerateDailySalesReportOnAction(ActionEvent event) {

    }

    // * Monthly Sales Report

    @FXML
    void btnGenerateMonthlySalesReportOnAction(ActionEvent actionEvent) {

    }

    // * Annual Sales Report
    @FXML
    void btnGenerateAnnualSalesReportOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // !  Initializing Table Columns

        // ? Delete Supplier Item List Columns
        collDeleteSupplierItemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        collDeleteSupplierItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        collDeleteSupplierUnitPrice.setCellValueFactory(new PropertyValueFactory<>("itemUnitPrice"));

        // ? View Supplier Item List Columns
        collViewSupplierItemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        collViewSupplierItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        collViewSupplierUnitPrice.setCellValueFactory(new PropertyValueFactory<>("itemUnitPrice"));

        // ? View Supplier List Table Columns
        collViewSupplierListId.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        collViewSupplierListCompanyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        collViewSupplierListSupplierName.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        collViewSupplierListEmail.setCellValueFactory(new PropertyValueFactory<>("supplierEmail"));
        collViewSupplierListAddress.setCellValueFactory(new PropertyValueFactory<>("supplierAddress"));

        // ? View Employee Table Columns
        collViewEmployeeListId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        collViewEmployeeListName.setCellValueFactory(new PropertyValueFactory<>("name"));
        collViewEmployeeListAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        collViewEmployeeListEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        collViewEmployeeListContact.setCellValueFactory(new PropertyValueFactory<>("contact"));

        // ? View Item Table Columns
        collViewItemListItemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        collViewItemListItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        collViewItemListItemCategory.setCellValueFactory(new PropertyValueFactory<>("itemCategory"));
        collViewItemListItemSize.setCellValueFactory(new PropertyValueFactory<>("itemSize"));
        collViewItemListItemStock.setCellValueFactory(new PropertyValueFactory<>("itemStockLevel"));
        collViewItemListItemUnitPrice.setCellValueFactory(new PropertyValueFactory<>("itemUnitPrice"));
        collViewItemListItemSupplier.setCellValueFactory(new PropertyValueFactory<>("itemSupplierId"));

        // ! Load All Tables On Initialize

        loadViewEmployeeTable();
        loadViewItemsTable();
        loadViewSupplierListTable();

        // ! Initializing the Navigation Panel Variables
        currentMainPanel=pageDashboard;
        currentMainPanel.setVisible(true);
        currentSubPanel=pageAddInventory;

        // ! Load Contents From Table When Click Record

        // *  View Employee Table

        tblViewEmployeeList.getSelectionModel().selectedItemProperty().addListener (((observableValue, oldValue, newValue) -> {
            employeeListSetText(newValue);
        }));

        // * View Item Table

        tblViewItemList.getSelectionModel().selectedItemProperty().addListener (((observableValue, oldValue, newValue) -> itemListSetText(newValue)
        ));

        // * View Supplier Table

        tblViewSupplierList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> supplierListSetText(newValue));

        // ! Initializing Combo boxes

        // * Inventory

        // ? item categories
        ObservableList<String> itemCategories= FXCollections.observableArrayList();
        itemCategories.add("Gents");
        itemCategories.add("Ladies");
        itemCategories.add("Kids");
        cmbAddItemCategory.setItems(itemCategories);
        cmbUpdateItemCategory.setItems(itemCategories);
        cmbDeleteItemCategory.setItems(itemCategories);
        cmbViewItemCategory.setItems(itemCategories);

        // ? item Sizes
        ObservableList<String> itemSizes= FXCollections.observableArrayList();
        itemSizes.add("XS");
        itemSizes.add("S");
        itemSizes.add("M");
        itemSizes.add("L");
        itemSizes.add("XL");
        itemSizes.add("XXL");
        itemSizes.add("XXXL");
        cmdAddItemSize.setItems(itemSizes);
        cmdUpdateItemSize.setItems(itemSizes);
        cmdDeleteItemSize.setItems(itemSizes);
        cmdViewItemSize.setItems(itemSizes);

        // ? item Supplier
        ObservableList<String> allSupplierIds = SupplierController.getInstance().getAllSupplierIds();
        cmbAddItemSupplier.setItems(allSupplierIds);
        cmbUpdateItemSupplier.setItems(allSupplierIds);
        cmbDeleteItemSupplier.setItems(allSupplierIds);
        cmbViewItemSupplierId.setItems(allSupplierIds);

    }

    private void clearAllForms(){
        // *  Employee Pages

        btnAddEmployeeClearFormOnAction(new ActionEvent());
        btnUpdateEmployeeClearFormOnAction(new ActionEvent());
        deleteEmployeeClearForm();

        // * Supplier Pages

        btnAddSupplierClearFormOnAction(new ActionEvent());
        btnUpdateSupplierClearFormOnAction(new ActionEvent());
        deleteSupplierClearForm();

        // * Item Pages

        btnAddItemClearFormOnAction(new ActionEvent());
        btnUpdateItemClearFormOnAction(new ActionEvent());
        deleteItemClearForm();
    }




}
