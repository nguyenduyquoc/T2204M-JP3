package assignment5_javafx2;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class informationController {

    public TextField txtFullName;
    public TextField txtEmail;
    public TextField txtAddress;
    public TextField txtAge;
    public TextField txtPhoneNumber;
    public Text strFullName;
    public Text strEmail;
    public Text strAddress;
    public Text strAge;
    public Text strPhoneNumber;

    public void submit(ActionEvent actionEvent) {
        String fullName = txtFullName.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();
        String age = txtAge.getText();
        String PhoneNumber = txtPhoneNumber.getText();

        strFullName.setText(fullName);
        strEmail.setText(email);
        strAddress.setText(address);
        strAge.setText(age);
        strPhoneNumber.setText(PhoneNumber);
    }
}
