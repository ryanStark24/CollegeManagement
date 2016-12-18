/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegemgt;

import ECUtils.ECConst;
import colg.bean.admin;
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
public class FXMLstudentController implements Initializable {

    @FXML
    private Button cse;
    @FXML
    private Button mech;
    @FXML
    private Button civil;
    @FXML
    private Button it;
    @FXML
    private Button eee;
    @FXML
    private Button etc;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void he(ActionEvent event) {
       
        if(event.getSource()==cse)
        {
            admin.BRANCH="cse";
        }
        else if(event.getSource()==eee)
        {
            admin.BRANCH="eee";
        }else if(event.getSource()==etc)
        {
            admin.BRANCH="etc";
        }else if(event.getSource()==mech)
        {
            admin.BRANCH="mech";
        }else if(event.getSource()==civil)
        {
            admin.BRANCH="civil";
        }else if(event.getSource()==it)
        {
            admin.BRANCH="it";
        }
        
        try {
            Parent root=FXMLLoader.load(getClass().getResource("FXMLs_start1.fxml"));
        Stage stage=(Stage)cse.getScene().getWindow();
        Scene scene = new Scene(root);
                           
         stage.setScene(scene);
                      stage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        
    }

    @FXML
    private void he1(ActionEvent event) {
       
                Parent  root =null;        
                          
        if(event.getSource()==btnback)
        {
            try {
              root=  FXMLLoader.load(getClass().getResource("FXMLst_main.fxml"));
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
