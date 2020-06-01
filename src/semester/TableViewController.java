/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semester;

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
import student.students;

/**
 * FXML Controller class
 *
 * @author Extreme
 */
public class TableViewController implements Initializable {

    @FXML
    private TextField TextFeiledID;
    @FXML
    private TextField TextFeiledSemester;
    @FXML
    private TextField TextFeiledLecturerId;
    @FXML
    private TextField TextFeiledYear;
    @FXML
    private TableColumn<semester, String> tcID;
    private TableColumn<semester, String> tcSemester;
    @FXML
    private TableColumn<semester, String> tcYear;
    private TableColumn<semester, String> tcLecturerId;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonUpdate;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonReset;
    @FXML
    private TableView<semester> TableView;
    Statement statement;
    @FXML
    private Button buttonShow;

    @FXML
    private Button buttonBackHandle;
    @FXML
    private TableColumn<semester, String> tcName;
    @FXML
    private TableColumn<semester, String> tcLectuerId;

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
        tcSemester.setCellValueFactory(new PropertyValueFactory("semester"));
        tcYear.setCellValueFactory(new PropertyValueFactory("lecturerID"));
        tcLecturerId.setCellValueFactory(new PropertyValueFactory("year"));
        TableView.getSelectionModel().selectedItemProperty().addListener(
                event -> showSelectedEmployee());
    }

    private void showSelectedEmployee() {
        semester employee = TableView.getSelectionModel().getSelectedItem();
        if (employee != null) {
            TextFeiledID.setText(String.valueOf(employee.getID()));
            TextFeiledSemester.setText(employee.getSemester());
            TextFeiledYear.setText(employee.getYear());
            TextFeiledLecturerId.setText(String.valueOf(employee.getLecturer_id()));
        }
    }
    ResultSet rs = null;

    public TableViewController() {
    }

    @FXML
    private void buttonShowHandle(ActionEvent event) throws Exception {
        ResultSet rs = this.statement.executeQuery("Select * From semester");
        while (rs.next()) {
            semester employee = new semester();
            employee.setID(rs.getString("sem_id"));
            employee.setSemester(rs.getString("semester"));
            employee.setYear(rs.getString("year"));
            employee.setLecturer_id(rs.getString("lecturer_id"));
            TableView.getItems().add(employee);
        }
    }

    @FXML
    private void buttonAddHandle(ActionEvent event) throws Exception {
        Integer id = Integer.parseInt(TextFeiledID.getText());
        String Semester = TextFeiledSemester.getText();
        String year = TextFeiledYear.getText();
        Integer LecturerId = Integer.parseInt(TextFeiledLecturerId.getText());
        String sql = "Insert Into semester values(" + id + ",'" + Semester + "','"
                + year + "'," + LecturerId + ")";
        this.statement.executeUpdate(sql);

    }

    @FXML
    private void buttonUpdateHandle(ActionEvent event) throws Exception {

        Integer id = Integer.parseInt(TextFeiledID.getText());
        String semester = TextFeiledSemester.getText();
        String year = TextFeiledYear.getText();
        Integer lecturerId = Integer.parseInt(TextFeiledLecturerId.getText());
        String sql = "Update semester Set semester='" + semester + "', year='"
                + year + "', sem_id=" + id + " Where lecturer_id=" + lecturerId;
        this.statement.executeUpdate(sql);
    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event) throws Exception {

        Integer id = Integer.parseInt(TextFeiledID.getText());
        String name = TextFeiledSemester.getText();
        String major = TextFeiledYear.getText();
        Double grade = Double.parseDouble(TextFeiledLecturerId.getText());
        String sql = "delete from semester where lecturer_id=" + id;
        this.statement.executeUpdate(sql);

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

    @FXML
    private void buttonResetHandle(ActionEvent event) {
        resetControls();
    }

    private void resetControls() {
        TextFeiledID.setText("");
        TextFeiledSemester.setText("");
        TextFeiledLecturerId.setText("");
        TextFeiledYear.setText("");
        TableView.getItems().clear();
    }

}
