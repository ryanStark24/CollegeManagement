/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegemgt;

import static ECUtils.InstallDB.createDB;
import static colg.dao.logic.check;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author SARITA
 */
public class Collegemgt extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root=null;
       createDB();
        if(check())
        {
         root = FXMLLoader.load(getClass().getResource("FXMLsignup.fxml"));
        }
        else
        {
           root = FXMLLoader.load(getClass().getResource("FXMLlogin.fxml"));
          
        }
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
