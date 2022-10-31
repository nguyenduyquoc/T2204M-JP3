package assignment8_tableList.edit_agm8_tableList;

import assignment8_tableList.InformationBook;
import assignment8_tableList.Main;
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

public class EditController implements Initializable {

    public TextField txtBookId;
    public TextField txtBookName;
    public TextField txtAuthor;
    public TextField txtPrice;
    public ComboBox<String> cbPublisher;
    public ComboBox<String> cbKindOfBook;
    public TextField txtQuantity;
    public static InformationBook editedBook_assignment8_tableview;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtBookId.setText(editedBook_assignment8_tableview.getBookId());
        txtBookName.setText(editedBook_assignment8_tableview.getBookName());
        txtAuthor.setText(editedBook_assignment8_tableview.getAuthor());

        ObservableList<String> publisher = FXCollections.observableArrayList();
        publisher.add("NXB Kim Dong");
        publisher.add("NXB TRe");
        publisher.add("NXB Tong Hop TP Ho Chi Minh");
        publisher.add("NXB Hoi Nha Van");
        publisher.add("NXB Lao Dong");
        cbPublisher.setItems(publisher);
        cbPublisher.setValue(editedBook_assignment8_tableview.getPublisher());

        ObservableList<String> kindOfBooks = FXCollections.observableArrayList();
        kindOfBooks.add("Folk tale");
        kindOfBooks.add("Economic and Social");
        kindOfBooks.add("Science and Education");
        kindOfBooks.add("Military");
        kindOfBooks.add("Horror Stories");
        kindOfBooks.add("Detective Stories");
        kindOfBooks.add("Health and Life");
        cbKindOfBook.setItems(kindOfBooks);
        cbKindOfBook.setValue(editedBook_assignment8_tableview.getKindOfBook());

        txtPrice.setText(Integer.toString(editedBook_assignment8_tableview.getPrice()));
        txtQuantity.setText(Integer.toString(editedBook_assignment8_tableview.getQuantity()));

    }

    public void submit(ActionEvent actionEvent) throws Exception{
        try {
            String bookId = txtBookId.getText();
            String bookName = txtBookName.getText();
            String author = txtAuthor.getText();
            String publisher = cbPublisher.getValue();
            String kindOfBook = cbKindOfBook.getValue();
            int price = Integer.parseInt(txtPrice.getText());
            if (price <= 0)
                throw new Exception("Price is not sound");
            int quantity = Integer.parseInt(txtQuantity.getText());
            if (quantity <= 0)
                throw new Exception("You must enter a positive number");
            editedBook_assignment8_tableview.setBookId(bookId);
            editedBook_assignment8_tableview.setBookName(bookName);
            editedBook_assignment8_tableview.setAuthor(author);
            editedBook_assignment8_tableview.setPublisher(publisher);
            editedBook_assignment8_tableview.setKindOfBook(kindOfBook);
            editedBook_assignment8_tableview.setPrice(price);
            editedBook_assignment8_tableview.setQuantity(quantity);
            backToList(null);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    public void backToList(ActionEvent actionEvent) throws Exception{

        Parent tableList = FXMLLoader.load(getClass().getResource("../tableList/tableList.fxml"));
        Scene sc = new Scene(tableList, 1024, 625);
        Main.rootStage.setScene(sc);

    }
}
