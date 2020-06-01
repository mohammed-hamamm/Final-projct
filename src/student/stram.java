/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Extreme
 */
public class stram extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        
         Pane TableView  = FXMLLoader.load(getClass().getResource("TableView.fxml"));
        Map<String,Pane> mapPanes  = new TreeMap<>();
          mapPanes.put("TableView", TableView);
         Scene scene  = new Scene(mapPanes.get("TableView"));
         primaryStage.setTitle("Stream App");
         primaryStage.setScene(scene);
         primaryStage.show();
         
         
    }
    
    public static void main(String [] args){
        
        launch(args);
        
    }
    
    
}
