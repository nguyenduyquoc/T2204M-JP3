package assignment7.form;


import assignment7.Main;
import assignment7.Mark_Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static assignment7.list.ListController.ls;


public class FormController implements Initializable {



    public TextField txtName;
    public TextField txtEmail;
    public TextField txtMark;
    public ComboBox<String> cbGender;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> gender = FXCollections.observableArrayList();
        gender.add("Male");
        gender.add("Female");
        gender.add("Other");
        cbGender.setItems(gender);
    }
    public void backToList(ActionEvent event) throws Exception{
        Parent listScene = FXMLLoader.load(getClass().getResource("../list/listStudent.fxml"));
        Scene sc = new Scene(listScene,800,600);
        Main.rootStage.setScene(sc);
    }

    public void submit(ActionEvent event) throws Exception{
        // thêm sinh viên
        try{
            String name = txtName.getText();
            String email = txtEmail.getText();
            int mark = Integer.parseInt(txtMark.getText());
            if(mark < 0 || mark > 10)
                throw new Exception("Vui lòng nhập điểm trong khoảng 0 -> 10");
            String gender = cbGender.getValue();
            Mark_Student ms = new Mark_Student(name,email,mark,gender);
            for (Mark_Student mark_student : ls){
                if (mark_student.getName().equals(name)){
                    throw new Exception("bạn nhập trùng tên");

                }
            }
            ls.add(ms);
            backToList(null);
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }



    }

}
