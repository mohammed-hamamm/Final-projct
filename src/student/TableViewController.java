/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.io.IOException;
import java.net.URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Extreme
 */
public class TableViewController implements Initializable {

    @FXML
    private TableColumn<students, String> tcID;
    @FXML
    private TableColumn<students, String> tcFirstN;
    @FXML
    private TableColumn<students, String> tcLastN;
    @FXML
    private TableColumn<students, String> tcAge;
    @FXML
    private TableColumn<students, String> tcAddress;
    @FXML
    private TableColumn<students, String> tcDeptN;
    @FXML
    private TableColumn<students, String> tcGpa;
    @FXML
    private TableColumn<students, String> tcEmail;

//    @FXML
//    private Button buttonReset;
    @FXML
    private TableView<students> TableView;
    Statement statement;
    @FXML
    private Button buttonShow;
    @FXML
    private Button buttonGoBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection
                    = DriverManager.getConnection("jdbc:mysql://localhost:3306/asd2020", "root", "");
            this.statement = connection.createStatement();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tcID.setCellValueFactory(new PropertyValueFactory("ID"));
        tcFirstN.setCellValueFactory(new PropertyValueFactory("Firstname"));
        tcLastN.setCellValueFactory(new PropertyValueFactory("lastname"));
        tcAge.setCellValueFactory(new PropertyValueFactory("age"));
        tcAddress.setCellValueFactory(new PropertyValueFactory("address"));
        tcDeptN.setCellValueFactory(new PropertyValueFactory("Dept_name"));
        tcEmail.setCellValueFactory(new PropertyValueFactory("email"));
        tcGpa.setCellValueFactory(new PropertyValueFactory("GPA"));

    }

    ResultSet rs = null;

    public TableViewController() {
    }

    @FXML
    private void buttonShowHandle(ActionEvent event) throws Exception {
        ResultSet rs = this.statement.executeQuery("Select * From student");
        while (rs.next()) {
            students employee = new students();
            employee.setID(rs.getString("id"));
            employee.setFirstname(rs.getString("firstname"));
            employee.setLastname(rs.getString("lastname"));
            employee.setAge(rs.getString("age"));
            employee.setAddress(rs.getString("address"));
            employee.setDept_name(rs.getString("dept_name"));
            employee.setEmail(rs.getString("email"));
            employee.setGPA(rs.getString("GPA"));
            System.out.println(employee.toString());
            TableView.getItems().add(employee);
        }
    }

    @FXML
    private void buttonBackHandle(ActionEvent event) throws Exception {

        try {
            Parent blah = FXMLLoader.load(getClass().getResource("..\\login\\TableView.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
