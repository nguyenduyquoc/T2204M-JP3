package assignment8_tableList;

import assignment8_tableList.edit_agm8_tableList.EditController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import static assignment8_tableList.tableList.tableListController.listBook;


public class InformationBook {

    private String bookId;
    private String bookName;
    private String author;
    private String publisher;
    private String kindOfBook;
    private int price;
    private int quantity;
    private Button edit;
    private Button delete;


    // CONSTRUCTOR
    public InformationBook(String bookId, String bookName, String author, String publisher, String kindOfBook, int price, int quantity) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.kindOfBook = kindOfBook;
        this.price = price;
        this.quantity = quantity;
        this.edit = new Button("Edit");
        this.edit.setStyle("-fx-background-color: #eed12e; -fx-text-fill: #fff");
        this.edit.setOnAction(event -> {
            try {
                Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
                confirmAlert.setTitle("Confirm");
                confirmAlert.setHeaderText("Do you want to edit this information?");
                if (confirmAlert.showAndWait().get() == ButtonType.OK){
                    EditController.editedBook_assignment8_tableview = this;
                    Parent editBook_agm8_tableview = FXMLLoader.load(getClass().getResource("edit_agm8_tableList/editBook.fxml"));
                    Scene sc = new Scene(editBook_agm8_tableview, 1024,625);
                    Main.rootStage.setScene(sc);
                }
            } catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!!!");
                alert.setHeaderText(e.getMessage());
                alert.show();
            }
        });

        this.delete = new Button("Delete");
        this.delete.setStyle("-fx-background-color: #e02a2a; -fx-text-fill: #fff");
        this.delete.setOnAction(event -> {
            try {
                Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
                confirmAlert.setTitle("Confirm");
                confirmAlert.setHeaderText("Do you want to delete this information?");
                if (confirmAlert.showAndWait().get() == ButtonType.OK){
                    listBook.remove(this);
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error!!!");
                alert.setHeaderText(e.getMessage());
                alert.show();
            }

        });
    }

    // GETTER AND SETTER

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getKindOfBook() {
        return kindOfBook;
    }

    public void setKindOfBook(String kindOfBook) {
        this.kindOfBook = kindOfBook;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    // toString method
    public String toString(){
        return "\t" + this.bookId + "\n" + "\t" + this.bookName + "\n" + "\t" + this.author + "\n" + "\t" + this.publisher + "\n" + "\t" + this.kindOfBook + "\n" + "\t" + "$" + this.price + "\n" + "\t" + this.quantity + "books";
    }
}
