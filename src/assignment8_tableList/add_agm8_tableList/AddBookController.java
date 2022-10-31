package assignment8_tableList.add_agm8_tableList;


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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static assignment8_tableList.tableList.tableListController.listBook;

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

    public void submit(ActionEvent actionEvent) throws Exception {
        try{
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
            InformationBook bk = new InformationBook(bookId,bookName,author,publisher,kindOfBook,price,quantity);
            for (InformationBook loopBook : listBook) {
                if (loopBook.getBookId().equals(bookId)){
                    throw new Exception("This book already exists");
                }
            }
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("Confirm");
            confirm.setHeaderText("Do you want to create this information?");
            if (confirm.showAndWait().get() == ButtonType.OK){
                listBook.add(bk);
            }
            backToList(null);
        } catch (Exception e){
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
