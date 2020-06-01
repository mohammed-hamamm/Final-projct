/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course;

import HomworkCh1Q1.*;
import course.course;
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
    private TextField TextFeiledID;
    @FXML
    private TextField TextFeiledName;
    @FXML
    private TextField TextFeiledHours;
    @FXML
    private TextField TextFeiledGrade;
    @FXML
    private TableColumn<course, String> tcID;
    @FXML
    private TableColumn<course, String> tcName;
    @FXML
    private TableColumn<course, String> tcHours;
    @FXML
    private TableColumn<course, String> tcGrade;
    @FXML
    private Button buttonShow;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonUpdate;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonReset;
    @FXML
    private TableView<course> TableView;
    Statement statement;
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
            
            statement = connection.createStatement();

        } catch (Exception ex) {
            ex.printStackTrace();
          
        }
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("Name"));
        tcHours.setCellValueFactory(new PropertyValueFactory("Hours"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("Grade"));
        TableView.getSelectionModel().selectedItemProperty().addListener(
                event -> showSelectedEmployee());
    }

    private void showSelectedEmployee() {
        course cou = TableView.getSelectionModel().getSelectedItem();
        if (cou != null) {
            TextFeiledID.setText(cou.getId());
            TextFeiledName.setText(cou.getName());
            TextFeiledHours.setText(cou.getHours());
            TextFeiledGrade.setText(cou.getGrade());
        }
    }
    ResultSet rs = null;

    public TableViewController() {
    }

    @FXML
    private void buttonShowHandle(ActionEvent event) throws Exception {
        ResultSet rs = this.statement.executeQuery("Select * From course");
        while (rs.next()) {
            course couu = new course();
            couu.setId(rs.getString("id_course"));
            couu.setName(rs.getString("name_course"));
            couu.setHours(rs.getString("course_hours"));
            couu.setGrade(rs.getString("grade_course"));
            TableView.getItems().add(couu);
        }
    }

    @FXML
    private void buttonAddHandle(ActionEvent event) throws Exception {
        String id = TextFeiledID.getText();
        String Name = TextFeiledName.getText();
        String Hours = TextFeiledHours.getText();
        String Grade = TextFeiledGrade.getText();
        String sql = "Insert Into course values(" + id + ",'" + Name + "','"
                + Hours + "'," + Grade + ")";
        this.statement.executeUpdate(sql);

    }

    @FXML
    private void buttonUpdateHandle(ActionEvent event) throws Exception {

        String id = TextFeiledID.getText();
        String name = TextFeiledName.getText();
        String departement = TextFeiledHours.getText();
        String salary = TextFeiledGrade.getText();
        String sql = "Update course Set name_course='" + name + "', course_hours='"
                + departement + "', grade_course=" + salary + " Where id_course=" + id;
        this.statement.executeUpdate(sql);
    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event) throws Exception {
        String id = TextFeiledID.getText();
        String name = TextFeiledName.getText();
        String departement = TextFeiledHours.getText();
        String salary = TextFeiledGrade.getText();
        String sql = "delete from course where id_course=" + id;
        this.statement.executeUpdate(sql);

    }

    @FXML
    private void buttonResetHandle(ActionEvent event) {
        resetControls();
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

    private void resetControls() {
        TextFeiledID.setText("");
        TextFeiledName.setText("");
        TextFeiledHours.setText("");
        TextFeiledGrade.setText("");
        TableView.getItems().clear();
    }
    
    @FXML
    private void buttonGoBack(ActionEvent event) {
          
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
