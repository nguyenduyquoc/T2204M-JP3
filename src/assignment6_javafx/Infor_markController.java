package assignment6_javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class Infor_markController implements Initializable {

    public TextField txtName;
    public TextField txtEmail;
    public TextField txtMark;
    public ListView<Mark_Student> listView;

    private ObservableList<Mark_Student> ls = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public ObservableList<Mark_Student> getList_mark_student() {
        return ls;
    }

    public void setList_mark_student(ObservableList<Mark_Student> ls) {
        this.ls = ls;
    }

    public void addMark_student(ActionEvent actionEvent) {
        try{
            String name = txtName.getText();
            String email = txtEmail.getText();
            int mark = Integer.parseInt(txtMark.getText());
            Mark_Student ms = new Mark_Student(name, email, mark);
            for (Mark_Student mark_student : ls){
                if(mark_student.getName().equals(name)){
                    mark_student.setMark(mark);
                    printf();
                    return;
                }
            }
            ls.add(ms);
            printf();

        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }




    }
    private boolean status = false;
    public void sortByName(ActionEvent actionEvent) {
        status = !status;
        Collections.sort(getList_mark_student(), new Comparator<Mark_Student>() {
           @Override
           public int compare(Mark_Student o1, Mark_Student o2) {
               if (!status) {
                   return o1.getName().compareTo(o2.getName());
               }
               return o2.getName().compareTo(o1.getName());
           }

       });
    }

    public void sortByMark(ActionEvent actionEvent) {
        status = !status;
        Collections.sort(getList_mark_student(), new Comparator<Mark_Student>() {
            @Override
            public int compare(Mark_Student o1, Mark_Student o2) {
                if (!status){
                    return o1.getMark() - o2.getMark();
                }
                return o2.getMark() - (o1.getMark());
            }
        });
    }

    public void printf() {
        listView.setItems(ls);
        listView.refresh();
    }
}
