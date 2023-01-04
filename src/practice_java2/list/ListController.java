package practice_java2.list;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import practice_java2.Book;
import practice_java2.Main;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;


public class ListController implements Initializable {

    public static ObservableList<Book> listBook = FXCollections.observableArrayList();


    public TableView<Book> tbBook;
    public TableColumn<Book, String> cBookId;
    public TableColumn<Book, String> cBookTitle;
    public TableColumn<Book, String> cAuthor;
    public TableColumn<Book, String> cPrice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cBookId.setCellValueFactory(new PropertyValueFactory<>("id"));
        cBookTitle.setCellValueFactory(new PropertyValueFactory<>("name"));
        cAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        cPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        display(null);
    }

    public void addBook(ActionEvent actionEvent) throws Exception {
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm");
        confirmAlert.setHeaderText("Do you want to create new information?");
        if (confirmAlert.showAndWait().get() == ButtonType.OK) {
            Parent addBook = FXMLLoader.load(getClass().getResource("../add/add.fxml"));
            Scene sc = new Scene(addBook, 600, 400);
            Main.rootStage.setScene(sc);
        }

    }


    public void exit(ActionEvent actionEvent) {
        Main.rootStage.close();
    }

    public void display(ActionEvent event) {
        try {
            listBook.clear();
            FileInputStream fis = new FileInputStream("books.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (fis.available() > 0) {
                try {
                    Book b = (Book) ois.readObject();
                    listBook.add(b);
                } catch (ClassNotFoundException e ) {
                    e.printStackTrace();
                }
            }
            ois.close();
            tbBook.setItems(listBook);
        } catch (Exception e ) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }

    }
}
