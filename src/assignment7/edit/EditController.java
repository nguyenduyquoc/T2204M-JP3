package assignment7.edit;

import assignment7.Main;
import assignment7.Mark_Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditController implements Initializable {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtMark;
    public static Mark_Student editedStudent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtName.setText(editedStudent.getName());
        txtEmail.setText(editedStudent.getEmail());
        txtMark.setText(Integer.toString(editedStudent.getMark()));
    }

    public void submit(ActionEvent actionEvent) throws Exception{
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            int mark = Integer.parseInt(txtMark.getText());
            if (mark < 0 || mark > 10) throw new Exception("Nhap sai mark");

            editedStudent.setName(name);
            editedStudent.setEmail(email);
            editedStudent.setMark(mark);
            backToList(null);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    public void backToList(ActionEvent actionEvent) throws Exception {
        Parent listScene = FXMLLoader.load(getClass().getResource("../list/listStudent.fxml"));
        Scene sc = new Scene(listScene,800,600);
        Main.rootStage.setScene(sc);
    }
}
