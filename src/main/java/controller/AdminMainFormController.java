package controller;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminMainFormController {

    public JFXButton btnLogOut;
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
    private TableColumn<?, ?> collViewEmployeeListAddress;

    @FXML
    private TableColumn<?, ?> collViewEmployeeListContact;

    @FXML
    private TableColumn<?, ?> collViewEmployeeListEmail;

    @FXML
    private TableColumn<?, ?> collViewEmployeeListId;

    @FXML
    private TableColumn<?, ?> collViewEmployeeListName;

    @FXML
    private TableColumn<?, ?> collViewEmployeeListPassword;

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
    private JFXPasswordField pfDeleteEmployeeLoginPassword;

    @FXML
    private JFXPasswordField pfUpdateEmployeeLoginPassword;

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
    private TableView<?> tblViewEmployeeList;

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
            throw new RuntimeException(e);
        }

    }

    // * Main Navigation Panel

    @FXML
    void btnDashboardPageOnAction(ActionEvent event) {

    }
    @FXML
    void btnInventoryManagementPageOnAction(ActionEvent event) {

    }
    @FXML
    void btnSupplierManagementPageOnAction(ActionEvent event) {

    }
    @FXML
    void btnOrderManagementPageOnAction(ActionEvent event) {

    }
    @FXML
    void btnReportGenerationPageOnAction(ActionEvent event) {

    }
    @FXML
    void btnEmployeeManagementPageOnAction(ActionEvent event) {

    }

    // ! Dashboard Dose Note Include Sub Navigation's On Admins Panel
    // * Sub Navigation Panels (Inventory Management page)
    @FXML
    void btnAddItemPageOnAction(ActionEvent event) {

    }
    @FXML
    void btnUpdateItemPageOnAction(ActionEvent event) {

    }
    @FXML
    void btnDeleteItemPageOnAction(ActionEvent event) {

    }
    @FXML
    void btnViewItemPageOnAction(ActionEvent event) {

    }


    // * Sub Navigation Panels (Supplier Management page)
    @FXML
    void btnAddSupplierPageOnAction(ActionEvent event) {

    }
    @FXML
    void btnUpdateSupplierPageOnAction(ActionEvent event) {

    }
    @FXML
    void btnDeleteSupplierPageOnAction(ActionEvent event) {

    }
    @FXML
    void btnViewSupplierPageOnAction(ActionEvent event) {

    }


    // * Sub Navigation Panels (Employee Management page)
    @FXML
    void btnAddEmployeePageOnAction(ActionEvent event) {

    }
    @FXML
    void btnUpdateEmployeePageOnAction(ActionEvent event) {

    }
    @FXML
    void btnDeleteEmployeePageOnAction(ActionEvent event) {

    }
    @FXML
    void btnViewEmployeePageOnAction(ActionEvent event) {

    }


    // * Sub Navigation Panels (Order Management page)
    @FXML
    void btnPlaceOrderPageOnAction(ActionEvent event) {

    }
    @FXML
    void btnUpdateOrderPageOnAction(ActionEvent event) {

    }
    @FXML
    void btnDeleteOrderPageOnAction(ActionEvent event) {

    }
    @FXML
    void btnViewOrderPageOnAction(ActionEvent event) {

    }


    // * Sub Navigation Panels (Report Generation page)
    @FXML
    void btnProductReportPageOnAction(ActionEvent event) {

    }
    @FXML
    void btnSupplierReportPageOnAction(ActionEvent event) {

    }
    @FXML
    void btnEmployeeReportPageOnAction(ActionEvent event) {

    }
    @FXML
    public void btnAnnualSalesReportPageOnAction(ActionEvent actionEvent) {

    }
    @FXML
    public void btnMonthlyReportPageOnAction(ActionEvent actionEvent) {

    }
    @FXML
    public void btnDailyReportPageOnAction(ActionEvent actionEvent) {

    }


    // ? FUNCTIONALITIES OF BUTTONS

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
    void btnAddItemToSupplierList(ActionEvent event) {

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
    void btnUpdateSupplierAddItemToList(ActionEvent event) {

    }
    @FXML
    void btnUpdateSupplierRemoveItemFromListOnAction(ActionEvent event) {

    }
    @FXML
    void btnUpdateSupplierClearItemListOnAction(ActionEvent event) {

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


    // ? Employee Management

    // * add employee
    @FXML
    void btnAddEmployeeOnAction(ActionEvent event) {

    }
    @FXML
    void btnAddEmployeeClearFormOnAction(ActionEvent event) {

    }

    // * update employee
    @FXML
    void btnUpdateEmployeeSearchOnAction(ActionEvent event) {

    }
    @FXML
    void btnUpdateEmployeeOnAction(ActionEvent event) {

    }
    @FXML
    void btnUpdateEmployeeClearFormOnAction(ActionEvent event) {

    }

    // * delete employee
    @FXML
    void btnDeleteEmployeeSearchOnAction(ActionEvent event) {

    }
    @FXML
    void btnDeleteEmployeeOnAction(ActionEvent event) {

    }

    // * view employee
    @FXML
    void btnViewEmployeeSearchOnAction(ActionEvent event) {

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
}
