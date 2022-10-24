package assignment5_javafx2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class InformationController {

    public TextField txtFullName;
    public TextField txtEmail;
    public TextField txtAddress;
    public TextField txtAge;
    public TextField txtPhoneNumber;

   public ListView<Contact> lv;

   private ObservableList<Contact> list_contact = FXCollections.observableArrayList();


    public void submit(ActionEvent actionEvent) {
        String fullName = txtFullName.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();
        String age = txtAge.getText();
        String PhoneNumber = txtPhoneNumber.getText();
        Contact ct = new Contact(fullName,email,address,age,PhoneNumber);
        for (Contact ctt : list_contact){
            if (ctt.getFullName().equals(fullName)){
                ctt.setPhoneNumber(PhoneNumber);
                printf();
                return;
            }
        }
        list_contact.add(ct);
        printf();

    }

    public void printf() {
        lv.setItems(list_contact);
        lv.refresh();
    }


}
