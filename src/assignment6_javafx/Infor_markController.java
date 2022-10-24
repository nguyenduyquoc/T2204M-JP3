package assignment6_javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.Collections;
import java.util.Comparator;

public class Infor_markController {

    public TextField txtName;
    public TextField txtEmail;
    public TextField txtMark;
    public ListView<Mark_Student> listView;

    private ObservableList<Mark_Student> list_mark_student = FXCollections.observableArrayList();

    public ObservableList<Mark_Student> getList_mark_student() {
        return list_mark_student;
    }

    public void setList_mark_student(ObservableList<Mark_Student> list_mark_student) {
        this.list_mark_student = list_mark_student;
    }

    public void addMark_student(ActionEvent actionEvent) {
        String name = txtName.getText();
        String email = txtEmail.getText();
        int mark = Integer.parseInt(txtMark.getText());
        Mark_Student ms = new Mark_Student(name, email, mark);
        for (Mark_Student mark_student : list_mark_student){
            if(mark_student.getName().equals(name)){
                mark_student.setMark(mark);
                printf();
                return;
            }
        }
        list_mark_student.add(ms);
        printf();
    }
    public boolean status = false;
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
        listView.setItems(list_mark_student);
        listView.refresh();
    }
}
