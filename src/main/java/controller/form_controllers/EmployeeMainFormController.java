package controller.form_controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeMainFormController implements Initializable {

    public JFXButton btnEmployeeLogOut;
    @FXML
    private BarChart<?, ?> chartEmployeeReport;

    @FXML
    private PieChart chartProductMovement;

    @FXML
    private BarChart<?, ?> chartSupplierReport;

    @FXML
    private JFXComboBox<?> cmbAddItemCategory;

    @FXML
    private JFXComboBox<?> cmbAddItemSupplier;

    @FXML
    private JFXComboBox<?> cmbDeleteItemCategory;

    @FXML
    private JFXComboBox<?> cmbDeleteItemSupplier;

    @FXML
    private JFXComboBox<?> cmbPlaceItemId;

    @FXML
    private JFXComboBox<?> cmbUpdateItemCategory;

    @FXML
    private JFXComboBox<?> cmbUpdateItemSupplier;

    @FXML
    private JFXComboBox<?> cmbUpdateOrderItemId;

    @FXML
    private JFXComboBox<?> cmbViewItemCategory;

    @FXML
    private JFXComboBox<?> cmbViewItemSupplierId;

    @FXML
    private JFXComboBox<?> cmdAddItemSize;

    @FXML
    private JFXComboBox<?> cmdAddSupplierItemId;

    @FXML
    private JFXComboBox<?> cmdDeleteItemSize;

    @FXML
    private JFXComboBox<?> cmdUpdateItemSize;

    @FXML
    private JFXComboBox<?> cmdUpdateSupplierItemId;

    @FXML
    private JFXComboBox<?> cmdViewItemSize;

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

    @FXML
    private TableColumn<?, ?> collViewItemListItemCategory;

    @FXML
    private TableColumn<?, ?> collViewItemListItemId;

    @FXML
    private TableColumn<?, ?> collViewItemListItemName;

    @FXML
    private TableColumn<?, ?> collViewItemListItemSize;

    @FXML
    private TableColumn<?, ?> collViewItemListItemStock;

    @FXML
    private TableColumn<?, ?> collViewItemListItemSupplier;

    @FXML
    private TableColumn<?, ?> collViewItemListItemUnitPrice;

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
    private TableColumn<?, ?> collViewSupplierItemId;

    @FXML
    private TableColumn<?, ?> collViewSupplierItemName;

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
    private TableColumn<?, ?> collViewSupplierUnitPrice;

    @FXML
    private DatePicker dpDeleteOrderDate;

    @FXML
    private DatePicker dpViewOrderDate;

    @FXML
    private AnchorPane employeeReportPage;

    @FXML
    private Label lblDashboardEmployeeAddress;

    @FXML
    private Label lblDashboardEmployeeContactNo;

    @FXML
    private Label lblDashboardEmployeeEmail;

    @FXML
    private Label lblDashboardEmployeeId;

    @FXML
    private Label lblDashboardEmployeeName;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblDeleteOrderFinalTotalAmount;

    @FXML
    private Label lblPlaceOrderFinalTotalAmount;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblUpdateOrderFinalTotalAmount;

    @FXML
    private AnchorPane pageAddInventory;

    @FXML
    private AnchorPane pageAddSupplier;

    @FXML
    private AnchorPane pageDashboard;

    @FXML
    private AnchorPane pageDeleteInventory;

    @FXML
    private AnchorPane pageDeleteOrder;

    @FXML
    private AnchorPane pageDeleteSupplier;

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
    private AnchorPane pageUpdateInventory;

    @FXML
    private AnchorPane pageUpdateOrder;

    @FXML
    private AnchorPane pageUpdateSupplier;

    @FXML
    private AnchorPane pageViewInventory;

    @FXML
    private AnchorPane pageViewOrder;

    @FXML
    private AnchorPane pageViewSupplier;

    @FXML
    private AnchorPane productReportPage;

    @FXML
    private AnchorPane supplierReportPage;

    @FXML
    private TableView<?> tblAddSupplierItemList;

    @FXML
    private TableView<?> tblDeleteOrderCartList;

    @FXML
    private TableView<?> tblDeleteSupplierItemList;

    @FXML
    private TableView<?> tblPlaceOrderCartList;

    @FXML
    private TableView<?> tblUpdateOrderCartList;

    @FXML
    private TableView<?> tblUpdateSupplierItemList;

    @FXML
    private TableView<?> tblViewItemList;

    @FXML
    private TableView<?> tblViewOrderCartList;

    @FXML
    private TableView<?> tblViewOrderList;

    @FXML
    private TableView<?> tblViewSupplierItemList;

    @FXML
    private TableView<?> tblViewSupplierList;

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
            btnEmployeeLogOut.getScene().getWindow().hide();
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // * Main Navigation Panel

    @FXML
    void btnDashboardPageOnAction(ActionEvent event) {
        currentMainPanel.setVisible(false);
        currentSubPanel.setVisible(false);
        currentMainPanel=pageDashboard;
        currentMainPanel.setVisible(true);
    }
    @FXML
    void btnInventoryManagementPageOnAction(ActionEvent event) {
        currentMainPanel.setVisible(false);
        currentSubPanel.setVisible(false);
        currentMainPanel=pageInventoryManagement;
        currentMainPanel.setVisible(true);
        currentSubPanel=pageAddInventory;
        currentSubPanel.setVisible(true);
    }
    @FXML
    void btnSupplierManagementPageOnAction(ActionEvent event) {
        currentMainPanel.setVisible(false);
        currentSubPanel.setVisible(false);
        currentMainPanel=pageSupplierManagement;
        currentMainPanel.setVisible(true);
        currentSubPanel=pageAddSupplier;
        currentSubPanel.setVisible(true);
    }
    @FXML
    void btnOrderManagementPageOnAction(ActionEvent event) {
        currentMainPanel.setVisible(false);
        currentSubPanel.setVisible(false);
        currentMainPanel=pageOrderManagement;
        currentMainPanel.setVisible(true);
        currentSubPanel=pagePlaceOrder;
        currentSubPanel.setVisible(true);
    }
    @FXML
    void btnReportGenerationPageOnAction(ActionEvent event) {
        currentMainPanel.setVisible(false);
        currentSubPanel.setVisible(false);
        currentMainPanel=pageReportGeneration;
        currentMainPanel.setVisible(true);
        currentSubPanel=employeeReportPage;
        currentSubPanel.setVisible(true);
    }

    // ! Dashboard Dose Note Include Sub Navigation's On Admins Panel
    // * Sub Navigation Panels (Inventory Management page)
    @FXML
    void btnAddItemPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageAddInventory;
        currentSubPanel.setVisible(true);
    }
    @FXML
    void btnUpdateItemPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageUpdateInventory;
        currentSubPanel.setVisible(true);
    }
    @FXML
    void btnDeleteItemPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageDeleteInventory;
        currentSubPanel.setVisible(true);
    }
    @FXML
    void btnViewItemPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageViewInventory;
        currentSubPanel.setVisible(true);
    }


    // * Sub Navigation Panels (Supplier Management page)
    @FXML
    void btnAddSupplierPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageAddSupplier;
        currentSubPanel.setVisible(true);
    }
    @FXML
    void btnUpdateSupplierPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageUpdateSupplier;
        currentSubPanel.setVisible(true);
    }
    @FXML
    void btnDeleteSupplierPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageDeleteSupplier;
        currentSubPanel.setVisible(true);
    }
    @FXML
    void btnViewSupplierPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageViewSupplier;
        currentSubPanel.setVisible(true);
    }

    // * Sub Navigation Panels (Order Management page)
    @FXML
    void btnPlaceOrderPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pagePlaceOrder;
        currentSubPanel.setVisible(true);
    }
    @FXML
    void btnUpdateOrderPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageUpdateOrder;
        currentSubPanel.setVisible(true);
    }
    @FXML
    void btnDeleteOrderPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageDeleteOrder;
        currentSubPanel.setVisible(true);
    }
    @FXML
    void btnViewOrderPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=pageViewOrder;
        currentSubPanel.setVisible(true);
    }


    // * Sub Navigation Panels (Report Generation page)
    @FXML
    void btnProductReportPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=productReportPage;
        currentSubPanel.setVisible(true);
    }
    @FXML
    void btnSupplierReportPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=supplierReportPage;
        currentSubPanel.setVisible(true);
    }
    @FXML
    void btnEmployeeReportPageOnAction(ActionEvent event) {
        currentSubPanel.setVisible(false);
        currentSubPanel=employeeReportPage;
        currentSubPanel.setVisible(true);
    }


    // ? FUNCTIONALITIES OF BUTTONS

    // ? Dashboard page

    // * dashboard

    @FXML
    void btnDashboardEmployeeChangePasswordOnAction(ActionEvent actionEvent) {

    }

    // ? Item Management Page

    // * add Item
    @FXML
    void btnAddItemOnAction(ActionEvent event) {

    }
    @FXML
    void btnAddItemClearFormOnAction(ActionEvent event) {

    }

    // * update Item
    @FXML
    void btnUpdateItemOnAction(ActionEvent event) {

    }
    @FXML
    void btnUpdateItemClearFormOnAction(ActionEvent event) {

    }
    @FXML
    void btnUpdateItemSearchOnAction(ActionEvent event) {

    }

    // * delete Item
    @FXML
    void btnDeleteItemOnAction(ActionEvent event) {

    }
    @FXML
    void btnDeleteItemSearchOnAction(ActionEvent event) {

    }

    // * view Item
    @FXML
    void btnViewItemSearchOnAction(ActionEvent event) {

    }

    // ? Supplier Management

    // * add supplier
    @FXML
    void btnAddSupplierOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddSupplierClearItemListOnAction(ActionEvent event) {

    }

    // * update supplier
    @FXML
    void btnUpdateSupplierSearchOnAction(ActionEvent event) {

    }
    @FXML
    void btnUpdateSupplierOnAction(ActionEvent event) {

    }
    @FXML
    private void btnUpdateSupplierClearFormOnAction(ActionEvent actionEvent) {
    }


        // * delete supplier
    @FXML
    void btnDeleteSupplierOnAction(ActionEvent event) {

    }
    @FXML
    void btnDeleteSupplierSearchOnAction(ActionEvent event) {

    }

    // * view supplier
    @FXML
    void btnViewSupplierSearchOnAction(ActionEvent actionEvent) {

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentMainPanel=pageDashboard;
        currentMainPanel.setVisible(true);
        currentSubPanel=pageAddInventory;
    }

}
