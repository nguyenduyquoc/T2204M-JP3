package session5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.*;


import java.net.URL;
import java.util.ResourceBundle;

public class Session5Controller implements Initializable {

    public ObservableList<StudentSession5> ls = FXCollections.observableArrayList();

    public TableView<StudentSession5> tbStudent;

    public TableColumn<StudentSession5, String> cName;
    public TableColumn<StudentSession5, String> cEmail;
    public TableColumn<StudentSession5, String> cMark;
    public TableColumn<StudentSession5, String> cGender;
    public TableColumn<StudentSession5,Button> cAction;

    public final static String connectionString = "jdbc:mysql://localhost:3306/t2204m_java1";
    public final static String user = "root";
    public final static String pwd = "";
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cMark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        cGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        cAction.setCellValueFactory(new PropertyValueFactory<>("edit"));

        //lây dữ liệu từ database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString,user,pwd);
            Statement stt = conn.createStatement();
            String sql_txt = "select * from students";
            ResultSet rs = stt.executeQuery(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email  = rs.getString("email");
                int mark = Integer.parseInt(rs.getString("mark"));
                String gender =  rs.getString("gender");
                StudentSession5 s = new StudentSession5(id, name, email, mark,gender);
                ls.add(s);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        tbStudent.setItems(ls);
    }

    public void addStudent(ActionEvent actionEvent) throws Exception {
        Parent createForm = FXMLLoader.load(getClass().getResource("add/addSession5.fxml"));
        Scene sc = new Scene(createForm,800,600);
        session5.Main.rootStage.setScene(sc);
    }


}
