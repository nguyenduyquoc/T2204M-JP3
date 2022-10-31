package assignment8_tableList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage rootStage;
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        rootStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("tableList/tableList.fxml"));
        primaryStage.setTitle("T2204M_assignment8_TableList");
        primaryStage.setScene(new Scene(root, 1024,625));
        primaryStage.show();
    }
}
