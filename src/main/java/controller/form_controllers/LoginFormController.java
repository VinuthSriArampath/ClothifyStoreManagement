package controller.form_controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginFormController {

    public JFXButton btnLogin;
    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXPasswordField pfPassword;

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        String email = txtEmail.getText();
        String password = pfPassword.getText();
        Stage stage=new Stage();
//        email.equals("Admin") && password.equals("Admin")
        if (email.equals("1")){
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/admin-main-form.fxml"))));
                stage.setTitle("Clothify Shop Management System | Admin Panel");
                stage.setMinHeight(900);
                stage.setMinWidth(1300);
                new Alert(Alert.AlertType.INFORMATION,"Log In Successfully").showAndWait();
                btnLogin.getScene().getWindow().hide();
                stage.show();
            } catch (IOException e) {
                new Alert(Alert.AlertType.ERROR,"LogIn Failed");
            }
        }else if (email.equals("2")){
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/employee-main-form.fxml"))));
                stage.setTitle("Clothify Shop Management System | Employee Panel");
                stage.setMinHeight(900);
                stage.setMinWidth(1300);
                new Alert(Alert.AlertType.INFORMATION,"Log In Successfully").showAndWait();
                btnLogin.getScene().getWindow().hide();
                stage.show();
            } catch (IOException e) {
                new Alert(Alert.AlertType.ERROR,"Login Failed");
            }
        }
    }

}
