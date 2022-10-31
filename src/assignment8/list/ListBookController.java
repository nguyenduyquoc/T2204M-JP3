package assignment8.list;

import assignment8.InformationBook;
import assignment8.Main;
import assignment8.edit.EditBookController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ListBookController implements Initializable {

    public ListView<InformationBook> listView;
    public static ObservableList<InformationBook> ls = FXCollections.observableArrayList();
    public TextField searchBoxName;

    private boolean status = false;
    public static InformationBook deleteBook;

    public static ObservableList<InformationBook> getList() {
        return ls;
    }

    public static void setList(ObservableList<InformationBook> ls) {
        ListBookController.ls = ls;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setItems(ls);
    }

    public void addBook(ActionEvent actionEvent) throws Exception{
        Parent creatBook = FXMLLoader.load(getClass().getResource("../add/addBook.fxml"));
        Scene sc = new Scene(creatBook, 800, 600);
        Main.rootStage.setScene(sc);
    }

    public void shortByPrice(ActionEvent actionEvent) {
        status = !status;
        Comparator<InformationBook> book = (o1, o2) -> {
            if (!status) {
                return o1.getPrice() - o2.getPrice();
            }
            return o2.getPrice() - o1.getPrice();
        };
        Collections.sort(getList(),book);
    }

    public void shortByQuantity(ActionEvent actionEvent) {
        status = !status;
        Comparator<InformationBook> book = (o1, o2) -> {
            if (!status) {
                return o1.getQuantity() - o2.getQuantity();
            }
            return o2.getQuantity() - o1.getQuantity();
        };
        Collections.sort(getList(),book);
    }

    public void edit(ActionEvent actionEvent) {
        try {
            if (listView.getSelectionModel().getSelectedItem() == null) {
                throw new Exception("Click to select a book you want to edit and then click edit");
            }
            EditBookController.editedBook = listView.getSelectionModel().getSelectedItem();

            Parent editBook = FXMLLoader.load(getClass().getResource("../edit/editBook.fxml"));
            Scene sc = new Scene(editBook,800,600);
            assignment8.Main.rootStage.setScene(sc);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    public void search(ActionEvent actionEvent) {
        try {
            String s = searchBoxName.getText();
            if (s.isEmpty()){
                listView.setItems(ls);
                throw new Exception("Nhap tu can tim kiem");
            }

            ObservableList<InformationBook> result = ls.stream()
                    .filter(student -> student.getBookName().toLowerCase().contains(s.toLowerCase()))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));
            listView.setItems(result);

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    public void delete(ActionEvent actionEvent) {
        try {
            if (listView.getSelectionModel().getSelectedItem() == null) {
                throw new Exception("Click to select a book you want to delete and then click delete");
            }
            deleteBook = listView.getSelectionModel().getSelectedItem();
            ls.remove(deleteBook);

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }
}
