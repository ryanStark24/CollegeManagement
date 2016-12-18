/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegemgt;

import ECUtils.GUIValidator;
import colg.bean.admin;
import colg.dao.logic;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author SARITA
 */
public class FXMLrecreateController implements Initializable {
    GUIValidator v1=new GUIValidator();
    @FXML
    private Button btnexit;
    @FXML
    private PasswordField txtreenter;
    @FXML
    private Button btngo;
    @FXML
    private PasswordField txtcreate;
    @FXML
    private Button btnback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        v1.addRequiredValidator(txtcreate);
        v1.addRequiredValidator(txtreenter);
        v1.addPassValidator(txtcreate);
        v1.addPassValidator(txtreenter);
        
    }    

    @FXML
    private void he(ActionEvent event) {
         if(event.getSource()==btngo)
        {
            try {
                if(v1.validateAll())
                {
                    
                   
                   
                    if(txtcreate.getText().equals(txtreenter.getText()))
                    {
                        admin a=new admin();
                    a.setPassword(txtcreate.getText());
                        logic.updatepass(a);
                        Stage stage=(Stage)btnback.getScene().getWindow();
                       Parent  root = FXMLLoader.load(getClass().getResource("FXMLst_main.fxml"));
                          Scene scene = new Scene(root);
                          
                      stage.setScene(scene);
                      stage.show();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Input Does Not Match");
                    }
                   
                }
                
            } catch (Exception e) {
                e.printStackTrace();;
            }
            
        }
        else if(event.getSource()==btnback)
        {
            try {
               
                        Stage stage=(Stage)btnback.getScene().getWindow();
                       Parent  root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
                          Scene scene = new Scene(root);
                          
                      stage.setScene(scene);
                      stage.show();
                    
                
                
            } catch (Exception e) {
                e.printStackTrace();;
            }
            
        }
        else
        {
           System.exit(0);
        }
    }
    
}
