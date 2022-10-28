package assignment8.edit;

import assignment8.InformationBook;
import assignment8.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditBookController implements Initializable {
    public TextField txtBookId;
    public TextField txtBookName;
    public TextField txtAuthor;
    public ComboBox<String> cbPublisher;
    public ComboBox<String> cbKindOfBook;
    public TextField txtPrice;
    public TextField txtQuantity;

    public static InformationBook editedBook;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtBookId.setText(editedBook.getBookId());
        txtBookName.setText(editedBook.getBookName());
        txtAuthor.setText(editedBook.getAuthor());

        cbPublisher.setValue(editedBook.getPublisher());
        ObservableList<String> publisher = FXCollections.observableArrayList();
        publisher.add("NXB Kim Dong");
        publisher.add("NXB TRe");
        publisher.add("NXB Tong Hop TP Ho Chi Minh");
        publisher.add("NXB Hoi Nha Van");
        publisher.add("NXB Lao Dong");
        cbPublisher.setItems(publisher);

        cbKindOfBook.setValue(editedBook.getKindOfBook());
        ObservableList<String> kindOfBooks = FXCollections.observableArrayList();
            kindOfBooks.add("Folk tale");
            kindOfBooks.add("Economic and Social");
            kindOfBooks.add("Science and Education");
            kindOfBooks.add("Military");
            kindOfBooks.add("Horror Stories");
            kindOfBooks.add("Detective Stories");
            kindOfBooks.add("Health and Life");
        cbKindOfBook.setItems(kindOfBooks);

        txtPrice.setText(Integer.toString(editedBook.getPrice()));
        txtQuantity.setText(Integer.toString(editedBook.getQuantity()));



    }

    public void submit(ActionEvent actionEvent) {
        try {
            String bookId = txtBookId.getText();
            String bookName = txtBookName.getText();
            String author = txtAuthor.getText();
            String publisher = cbPublisher.getValue();
            String kindOfBook = cbKindOfBook.getValue();
            int price = Integer.parseInt(txtPrice.getText());
            if (price < 0)
                throw new Exception("price is not sound");
            int quantity = Integer.parseInt(txtQuantity.getText());
            if (quantity < 0)
                throw new Exception("you must enter a positive number");
            editedBook.setBookId(bookId);
            editedBook.setBookName(bookName);
            editedBook.setAuthor(author);
            editedBook.setPublisher(publisher);
            editedBook.setKindOfBook(kindOfBook);
            editedBook.setPrice(price);
            editedBook.setQuantity(quantity);
            backToList(null);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    public void backToList(ActionEvent actionEvent) throws Exception {
        Parent listScene = FXMLLoader.load(getClass().getResource("../list/listOfBooks.fxml"));
        Scene sc = new Scene(listScene, 800, 600);
        Main.rootStage.setScene(sc);
    }
}
