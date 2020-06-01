/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import lecturers.*;
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
import javafx.scene.control.PasswordField;
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

    
   
  
    Statement statement;
    @FXML
    private TextField TextFeiledUsername;
    @FXML
    private PasswordField TextFeiledPassword;
    @FXML
    private Button buttonLogin;
    @FXML
    private Button buttonReset;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
     
    }

    private void showSelectedEmployee() {
      
    }
    ResultSet rs = null;

    public TableViewController() {
    }

    private void buttonShowHandle(ActionEvent event) throws Exception {
      
        }


    

  

    @FXML
    private void buttonResetHandle(ActionEvent event) {
        resetControls();
    }
    
    
    private void resetControls(){
        TextFeiledUsername.setText("");
        TextFeiledPassword.setText("");
    }

    @FXML
    private void buttonLoginHandle(ActionEvent event) {
        if (TextFeiledUsername.getText().equalsIgnoreCase("user") &&TextFeiledPassword.getText().equalsIgnoreCase("123456")) {
                    try {
                        Parent blah = FXMLLoader.load(getClass().getResource("..\\course\\TableView.fxml"));
                        Scene scene = new Scene(blah);
                        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        appStage.setScene(scene);
                        appStage.show();
                        
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                } else if (TextFeiledUsername.getText().equalsIgnoreCase("mohammed") && TextFeiledPassword.getText().equalsIgnoreCase("12345"))  {
                      try {
                        Parent blah = FXMLLoader.load(getClass().getResource("..\\student\\TableView.fxml"));
                        Scene scene = new Scene(blah);
                        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        appStage.setScene(scene);
                        appStage.show();
                    
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }else if (TextFeiledUsername.getText().equalsIgnoreCase("admin") && TextFeiledPassword.getText().equalsIgnoreCase("12345678")) {
                     try {
                        Parent blah = FXMLLoader.load(getClass().getResource("..\\semester\\TableView.fxml"));
                        Scene scene = new Scene(blah);
                        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        appStage.setScene(scene);
                        appStage.show();
                        
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }else if (TextFeiledUsername.getText().equalsIgnoreCase("Hamdie") && TextFeiledPassword.getText().equalsIgnoreCase("123456")) {
                    try {
                        Parent blah = FXMLLoader.load(getClass().getResource("..\\lecturers\\TableView.fxml"));
                        Scene scene = new Scene(blah);
                        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        appStage.setScene(scene);
                        appStage.show();
                        
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    } 
                }else{
                    System.out.println("Please try Again !!!!!");
                }
        
        
    }
        

}
