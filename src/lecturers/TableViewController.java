/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturers;

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
    private TableColumn<lecturer, Integer> tcID;
    @FXML
    private TableColumn<lecturer, String> tcFirstN;
    @FXML
    private TableColumn<lecturer, String> tcLastN;
    @FXML
    private TableColumn<lecturer, String> tcEmail;
    @FXML
    private TableColumn<lecturer, String> tcTitle;
   
    @FXML
    private TableView<lecturer> TableView;
    Statement statement;
    @FXML
    private Button buttonReset;
    @FXML
    private TableColumn<lecturer, String> tcPhone;
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
                    = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_affriess", "root", "");
            this.statement = connection.createStatement();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcFirstN.setCellValueFactory(new PropertyValueFactory("firstname"));
        tcLastN.setCellValueFactory(new PropertyValueFactory("lastname"));
        tcPhone.setCellValueFactory(new PropertyValueFactory("phone"));
           tcEmail.setCellValueFactory(new PropertyValueFactory("email"));
              tcTitle.setCellValueFactory(new PropertyValueFactory("title"));
        
    }

    
    ResultSet rs = null;

    public TableViewController() {
    }

    @FXML
    private void buttonShowHandle(ActionEvent event) throws Exception {
        ResultSet rs = this.statement.executeQuery("Select * From lecturers");
        while (rs.next()) {
            lecturer lec = new lecturer();
            lec.setId(rs.getInt("LecId"));
            lec.setFirstname(rs.getString("LecFName"));
            lec.setLastname(rs.getString("LecLName"));
            lec.setPhone(rs.getString("LecPhone"));
            lec.setEmail(rs.getString("LecEmail"));
            lec.setTitle(rs.getString("LecTitle"));
            TableView.getItems().add(lec);
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


