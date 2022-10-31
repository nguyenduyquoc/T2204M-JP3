package session5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.ResourceBundle;

public class Session5Controller implements Initializable {

    public static ObservableList<StudentSession5> ls = FXCollections.observableArrayList();

    public TableView<StudentSession5> tbStudent;

    public TableColumn<StudentSession5, String> cName;
    public TableColumn<StudentSession5, String> cEmail;
    public TableColumn<StudentSession5, String> cMark;
    public TableColumn<StudentSession5, String> cGender;
    public TableColumn<StudentSession5,Button> cAction;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cMark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        cGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        cAction.setCellValueFactory(new PropertyValueFactory<>("edit"));

        if(ls.size() == 0){
            ls.add(new StudentSession5("Hoang Duy Quoc","quocndth@gmail.com",2,"Male"));
            ls.add(new StudentSession5("Nguyen Duy Quoc ","quoc1288@gmail.com",4,"Male"));
            ls.add(new StudentSession5("Hoang Duy Quoc","quocndth@gmail.com",2,"Male"));
            ls.add(new StudentSession5("Nguyen Duy Quoc ","quoc1288@gmail.com",4,"Male"));
            ls.add(new StudentSession5("Hoang Duy Quoc","quocndth@gmail.com",2,"Male"));
            ls.add(new StudentSession5("Nguyen Duy Quoc ","quoc1288@gmail.com",4,"Male"));
        }
        tbStudent.setItems(ls);
    }

    public void addStudent(ActionEvent actionEvent) throws Exception {
        Parent createForm = FXMLLoader.load(getClass().getResource("add/addSession5.fxml"));
        Scene sc = new Scene(createForm,800,600);
        session5.Main.rootStage.setScene(sc);
    }


}
