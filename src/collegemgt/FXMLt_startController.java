/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegemgt;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SARITA
 */
public class FXMLt_startController implements Initializable {

    @FXML
    private Button btnback;
    @FXML
    private Button btnadd;
    @FXML
    private Button btnsearch;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
    @FXML
    private Button btnexit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void he(ActionEvent event) {
        
        Parent root=null;
         if(event.getSource()==btnback)
        {
            try {
              root=  FXMLLoader.load(getClass().getResource("FXMLst_main.fxml"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    else if(event.getSource()==btnadd)
        {
            try {
              root=  FXMLLoader.load(getClass().getResource("FXMLt_add.fxml"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
     else if(event.getSource()==btnupdate)
        {
            try {
              root=  FXMLLoader.load(getClass().getResource("FXMLteacher3.fxml"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
     else if(event.getSource()==btndelete)
        {
            try {
              root=  FXMLLoader.load(getClass().getResource("FXMLteacher3.fxml"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
     else if(event.getSource()==btnsearch)
        {
            try {
              root=  FXMLLoader.load(getClass().getResource("FXMLteacher3.fxml"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
         else
     {
         System.exit(0);
     }
         Stage stage=(Stage)btnexit.getScene().getWindow();
        Scene scene = new Scene(root);
                          
         stage.setScene(scene);
                      stage.show();
    }
    }
    

