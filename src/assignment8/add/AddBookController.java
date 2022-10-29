package assignment8.add;

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

import static assignment8.list.ListBookController.ls;

public class AddBookController implements Initializable {

    public TextField txtBookId;
    public TextField txtBookName;
    public TextField txtAuthor;
    public TextField txtPrice;
    public ComboBox<String> cbPublisher;
    public ComboBox<String> cbKindOfBook;
    public TextField txtQuantity;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> publisher = FXCollections.observableArrayList();
        publisher.add("NXB Kim Dong");
        publisher.add("NXB TRe");
        publisher.add("NXB Tong hop TP Ho Chi Minh");
        publisher.add("NXB Hoi Nha Van");
        publisher.add("NXB Lao Dong");
        cbPublisher.setItems(publisher);

        ObservableList<String> kindOfBook = FXCollections.observableArrayList();
        kindOfBook.add("Folk Tale");
        kindOfBook.add("Economic and Social");
        kindOfBook.add("Science and Education");
        kindOfBook.add("Military");
        kindOfBook.add("Horror Stories");
        kindOfBook.add("Detective Stories");
        kindOfBook.add("Health and Life");
        cbKindOfBook.setItems(kindOfBook);

    }

    public void backToList(ActionEvent actionEvent) throws Exception{
        Parent listScene = FXMLLoader.load(getClass().getResource("../list/listOfBooks.fxml"));
        Scene sc = new Scene(listScene, 800, 600);
        Main.rootStage.setScene(sc);
    }

    public void submit(ActionEvent actionEvent) throws Exception {
        // ADD INFORMATION BOOK
        try{
            String bookId = txtBookId.getText();
            String bookName = txtBookName.getText();
            String author = txtAuthor.getText();
            String publisher = cbPublisher.getValue();
            String kindOfBook = cbKindOfBook.getValue();
            int price = Integer.parseInt(txtPrice.getText());
            if (price <= 0)
                throw new Exception("price is not sound");
            int quantity = Integer.parseInt(txtQuantity.getText());
            if (quantity < 0)
                throw new Exception("you must enter a positive number");
            InformationBook nb = new InformationBook(bookId,bookName,author,publisher,kindOfBook,price,quantity);
            for (InformationBook iB : ls ){
                if (iB.getBookId().equals(bookId)) {
                    throw new Exception("This book already exists");
                }
            }
            ls.add(nb);
            backToList(null);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!!");
            alert.setHeaderText(e.getMessage());
            alert.show();

        }

    }
}
