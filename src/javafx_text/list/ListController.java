package javafx_text.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx_text.StudentText;

import java.net.URL;
import java.util.ResourceBundle;

public class ListController implements Initializable {
    public TableView<StudentText> tbStudent;
    public TableColumn<StudentText,String> cName;
    public TableColumn<StudentText,String> cEmail;
    public TableColumn<StudentText,String> cMark;
    public TableColumn<StudentText,String> cGender;
    public TableColumn<StudentText, Button> cAction;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cMark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        cGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        cAction.setCellValueFactory(new PropertyValueFactory<>("editt"));
    }

    public void addStudent(ActionEvent actionEvent) {

    }
}
