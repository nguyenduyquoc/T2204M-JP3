package javafx;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class contactController {

    public TextField txtName;
    public TextField txtEmail;
    public Text strName;
    public Text strEmail;

    public void submit(ActionEvent actionEvent) {
        String name = txtName.getText();
//      System.out.println("Submitted   " +name);
        strName.setText(name);

        String email = txtEmail.getText();
        strEmail.setText(email);
    }
}
