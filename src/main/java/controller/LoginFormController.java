package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXPasswordField pfPassword;

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        Stage stage = new Stage();
        stage.setTitle("Clothify Shop Management System | Employee");
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/employee-main-form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
