package assignment5_javafx2;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("information.fxml"));
        primaryStage.setTitle("T2204M Javafx2");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

    }
}
