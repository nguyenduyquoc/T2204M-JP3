package javafx_text;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class StudentText {
    private int id;
    private String name;
    private String email;
    private int mark;
    private String gender;
    private Button editt;

    public StudentText(int id, String name, String email, int mark, String gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mark = mark;
        this.gender = gender;
        this.editt = new Button("Edit");
        this.editt.setOnAction(event -> {
            try {
                Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
                confirmAlert.setTitle("confirm alert");
                confirmAlert.setHeaderText("Do want to edit this???");
                if (confirmAlert.showAndWait().get() == ButtonType.OK){
                    Parent edit = FXMLLoader.load(getClass().getResource(""));
                    Scene sc = new Scene(edit, 800, 600);
                    Main.rootStage.setScene(sc);
                }
            } catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alert");
                alert.setHeaderText(e.getMessage());
                alert.show();
            }
        });
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Button getEdit() {
        return editt;
    }

    public void setEdit(Button editt) {
        this.editt = editt;
    }
    public String toString() {
        return this.getName()+"\n"+this.getMark();
    }
}

