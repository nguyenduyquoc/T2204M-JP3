package assignment7.list;

import assignment7.Main;
import assignment7.Mark_Student;
import assignment7.edit.EditController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;


import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;


public class ListController implements Initializable {

    public ListView<Mark_Student> listView;

    public static ObservableList<Mark_Student> ls = FXCollections.observableArrayList();

    public static ObservableList<Mark_Student> getLs() {
        return ls;
    }

    public static void setLs(ObservableList<Mark_Student> ls) {
        ListController.ls = ls;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setItems(ls);
    }

    public void addStudent(ActionEvent actionEvent) throws Exception {
        Parent createForm = FXMLLoader.load(getClass().getResource("../form/formStudent.fxml"));
        Scene sc = new Scene(createForm,800,600);
        Main.rootStage.setScene(sc);
    }

    private boolean status = false;
    public void sortByName(ActionEvent actionEvent) {
        status = !status;
       Collections.sort(getLs(), new Comparator<Mark_Student>() {
           @Override
           public int compare(Mark_Student o1, Mark_Student o2) {
               if (status) {
                   return o1.getName().compareTo(o2.getName());
               }
               return o2.getName().compareTo(o1.getName());
           }
       });
    }

    public void sortByMark(ActionEvent actionEvent) {
        status = !status;
        Collections.sort(getLs(), new Comparator<Mark_Student>() {
            @Override
            public int compare(Mark_Student o1, Mark_Student o2) {
                if (status) {
                    return o1.getMark() - o2.getMark();
                }
                return o2.getMark() - o1.getMark();
            }
        });
    }

    public void edit(ActionEvent actionEvent) throws Exception{
        try {
            if (listView.getSelectionModel().getSelectedItem() == null){
                throw new Exception("Vui long chon sinh vien muon sua");
            }
            EditController.editedStudent = listView.getSelectionModel().getSelectedItem();

            Parent editForm = FXMLLoader.load(getClass().getResource("../edit/editStudent.fxml"));
            Scene sc = new Scene(editForm,800,600);
            Main.rootStage.setScene(sc);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }


}
