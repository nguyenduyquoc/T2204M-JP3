package javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ContactController {

    public TextField txtName;
    public TextField txtEmail;
    public ListView<Contact> lv;

    private ObservableList<Contact> list_contact = FXCollections.observableArrayList();



    public void submit(ActionEvent actionEvent) {
        String name = txtName.getText();

        String email = txtEmail.getText();

        Contact ct = new Contact(name, email);
        list_contact.add(ct);
        printf();


    }

    public void printf(){
        lv.setItems(list_contact);
    }
}
