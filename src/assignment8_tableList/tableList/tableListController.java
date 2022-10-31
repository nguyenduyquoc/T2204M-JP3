package assignment8_tableList.tableList;

import assignment8_tableList.InformationBook;
import assignment8_tableList.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class tableListController implements Initializable {
    public static ObservableList<InformationBook> listBook = FXCollections.observableArrayList();
    public TextField txtSearch;
    public TableView<InformationBook> tbBook;
    public TableColumn<InformationBook, String> cBookId;
    public TableColumn<InformationBook, String> cBookName;
    public TableColumn<InformationBook, String> cAuthor;
    public TableColumn<InformationBook, String> cPublisher;
    public TableColumn<InformationBook, String> cType;
    public TableColumn<InformationBook, String> cPrice;
    public TableColumn<InformationBook, String> cQuantity;
    public TableColumn<InformationBook, Button> cEdit;
    public TableColumn<InformationBook,Button> cDelete;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cBookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        cBookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        cAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        cPublisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        cType.setCellValueFactory(new PropertyValueFactory<>("kindOfBook"));
        cPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        cQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        cEdit.setCellValueFactory(new PropertyValueFactory<>("edit"));
        cDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));

        if (listBook.size() == 0){
            listBook.add(new InformationBook("NDQ001","Detective Conan","Hoang Duy Quoc","NXB Kim Dong","Detective Stories",30,5000));
            listBook.add(new InformationBook("NDQ002","1000 best Vietnamese folk stories","many authors","NXB Tong hop TP Ho Chi Minh","Folk Tale",40,7000));
            listBook.add(new InformationBook("NDQ003","Outstanding smart kids in the world","Nguyen Duy Quoc","NXB Lao Dong","Science and Education",20,1000));
            listBook.add(new InformationBook("NDQ004","Vietnam Air Force 2025","Nguyen Phú Trong","NXB Lao Dong","Military",25,4500));
            listBook.add(new InformationBook("NDQ005","Ghosts in the old house","Cristiano Ronaldo","NXB Tre","Horror Stories",45,2000));
            listBook.add(new InformationBook("NDQ006","Drinking beer 2 bottles a day helps improve health","Hoang Duy Quoc","NXB Tong hop TP Ho Chi Minh","Health and Life",40,6000));
        }
        tbBook.setItems(listBook);
    }

    public void addBook(ActionEvent actionEvent) throws Exception {
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm");
        confirmAlert.setHeaderText("Do you want to create new information?");
        if (confirmAlert.showAndWait().get() == ButtonType.OK) {
            Parent addBook = FXMLLoader.load(getClass().getResource("../add_agm8_tableList/addBook_agm8_tableList.fxml"));
            Scene sc = new Scene(addBook,1024,625);
            Main.rootStage.setScene(sc);
        }
    }

    public void searchBook(ActionEvent actionEvent) {
        try {
            String search = txtSearch.getText();
            if (search.isEmpty()) {
                throw new Exception("enter the search word");
            }
            ObservableList<InformationBook> result = listBook.stream()
                    .filter(book -> book.getBookName().toLowerCase().contains(search.toLowerCase()))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));
            tbBook.setItems(result);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }


    public void clear(ActionEvent actionEvent) {
        tbBook.setItems(listBook);
    }
}
