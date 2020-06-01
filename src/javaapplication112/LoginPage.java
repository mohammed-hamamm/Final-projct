package javaapplication112;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginPage extends Application {

    @Override
    public void start(Stage stage) {
        //creating label email 
        Label text = new Label("Well Come");

        Text text1 = new Text("Username : ");

        //creating label password 
        Text text2 = new Text("Password : ");

        //Creating Text Filed for email        
        TextField textField1 = new TextField();

        //Creating Text Filed for password        
        PasswordField textField2 = new PasswordField();

        //Creating Buttons 
        Button button1 = new Button("Submit");

        //Creating a Grid Pane 
        GridPane gridPane = new GridPane();

        //Setting size for the pane 
        gridPane.setMinSize(400, 200);

        //Setting the padding  
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns 
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //Setting the Grid alignment 
        gridPane.setAlignment(Pos.CENTER);

        //Arranging all the nodes in the grid 
        gridPane.add(text, 1, 1);

        gridPane.add(text1, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(text2, 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(button1, 0, 2);

        //Styling nodes  
        button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        text.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        text1.setStyle("-fx-font: normal bold 20px 'serif' ");
        text2.setStyle("-fx-font: normal bold 20px 'serif' ");
        gridPane.setStyle("-fx-background-color: BEIGE;");

        //Creating a scene object 
        Scene scene = new Scene(gridPane);

        //Setting title to the Stage 
        stage.setTitle("Login form");

        //Adding scene to the stage 
        stage.setScene(scene);

        //Displaying the contents of the stage 
        stage.show();

        //Add Event
        button1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (textField1.getText().equalsIgnoreCase("user") && textField2.getText().equalsIgnoreCase("123456")) {
                    try {
                        Parent blah = FXMLLoader.load(getClass().getResource("..\\course\\TableView.fxml"));
                        Scene scene = new Scene(blah);
                        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        appStage.setScene(scene);
                        appStage.show();
                        text.setText("tgy");
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                } else if (textField1.getText().equalsIgnoreCase("mohammed") && textField2.getText().equalsIgnoreCase("12345"))  {
                      try {
                        Parent blah = FXMLLoader.load(getClass().getResource("..\\student\\TableView.fxml"));
                        Scene scene = new Scene(blah);
                        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        appStage.setScene(scene);
                        appStage.show();
                        text.setText("tgy");
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }else if (textField1.getText().equalsIgnoreCase("admin") && textField2.getText().equalsIgnoreCase("12345678")) {
                     try {
                        Parent blah = FXMLLoader.load(getClass().getResource("..\\semester\\TableView.fxml"));
                        Scene scene = new Scene(blah);
                        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        appStage.setScene(scene);
                        appStage.show();
                        text.setText("tgy");
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }else if (textField1.getText().equalsIgnoreCase("Hamdie") && textField2.getText().equalsIgnoreCase("123456")) {
                    try {
                        Parent blah = FXMLLoader.load(getClass().getResource("..\\lecturers\\TableView.fxml"));
                        Scene scene = new Scene(blah);
                        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        appStage.setScene(scene);
                        appStage.show();
                        text.setText("tgy");
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    } 
                }else{
                    System.out.println("Please try Again !!!!!");
                }
            }
        });

    }

    public static void main(String args[]) {
        launch(args);

    }
}
