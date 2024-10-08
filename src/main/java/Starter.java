import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Starter extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/login-form.fxml"))));
        primaryStage.setTitle("Clothify Shop Management System");
        primaryStage.setMaxHeight(660);
        primaryStage.setMaxWidth(480);
        primaryStage.setMinHeight(660);
        primaryStage.setMinWidth(480);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
