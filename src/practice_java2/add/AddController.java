package practice_java2.add;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import practice_java2.Book;
import practice_java2.Main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


import static practice_java2.list.ListController.listBook;

public class AddController {
    public TextField txtId;

    public TextField txtName;

    public TextField txtAuthor;

    public TextField txtPrice;


    public void goBack(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../list/listBook.fxml"));
        Main.rootStage.setTitle("Book store management");
        Main.rootStage.setScene(new Scene(root, 600, 400));

    }

    public void save(ActionEvent event) {
        try {
            if (txtId.getText().isEmpty()) throw new Exception("Book ID is empty");
            if (txtName.getText().isEmpty()) throw new Exception("Book Name is empty");
            if (txtAuthor.getText().isEmpty()) throw new Exception("Author is empty");
            if (txtPrice.getText().isEmpty()) throw new Exception("Price is empty");

            String id = txtId.getText();
            for (Book b : listBook) {
                if (b.getId().equals(id)){
                    throw new Exception("This book already exists");
                }
            }
            String name = txtName.getText();
            String author = txtAuthor.getText();
            Double price = Double.parseDouble(txtPrice.getText());
            if (price < 0) throw new Exception("Price cannot be negative");

            boolean exists = new File("books.dat").exists();

            FileOutputStream fos = new FileOutputStream("books.dat", true);
            ObjectOutputStream oos = exists ?
                    new ObjectOutputStream(fos) {
                        protected void writeStreamHeader() throws IOException {
                            reset();
                        }
                    }:new ObjectOutputStream(fos);

            Book book = new Book(id, name, author, price);

            oos.writeObject(book);
            oos.flush();
            oos.close();

            goBack(event);
        } catch (IOException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }

    }
}
