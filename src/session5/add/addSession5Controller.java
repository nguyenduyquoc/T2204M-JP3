package session5.add;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import session5.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import session5.Session5Controller;
import session5.StudentSession5;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class addSession5Controller implements Initializable {

    public TextField txtName;
    public TextField txtEmail;
    public TextField txtMark;
    public ComboBox<String> cbGender;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> genders = FXCollections.observableArrayList();
        genders.add("Male");
        genders.add("Female");
        genders.add("Other");
        cbGender.setItems(genders);
    }

    public void backToList(ActionEvent actionEvent) throws Exception {
        Parent tableList = FXMLLoader.load(getClass().getResource("../studentMarkSession5.fxml"));
        Scene sc = new Scene(tableList, 800, 600);
        Main.rootStage.setScene(sc);
    }

    public void submit(ActionEvent actionEvent) throws Exception{
        try {
            Integer m = Integer.parseInt(txtMark.getText());
            if (m < 0 || m > 10 )
                throw new Exception("nhap lai diem");
            StudentSession5 s=  new StudentSession5(null, txtName.getText(),txtEmail.getText(),m,cbGender.getValue());

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Session5Controller.connectionString,Session5Controller.user,Session5Controller.pwd);
            Statement stt = conn.createStatement();
            String sql_txt = "insert into students(name,email,mark,gender) values('"
                    +txtName.getText()+"','"
                    +txtEmail.getText()+"',"
                    +m +",'"
                    +cbGender.getValue()+"')"
                    ;
            stt.executeUpdate(sql_txt);
            backToList(null);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }

    }
}
