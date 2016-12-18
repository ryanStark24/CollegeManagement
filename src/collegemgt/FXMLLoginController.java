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
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author SARITA
 */
public class FXMLLoginController implements Initializable {
    GUIValidator v1=new GUIValidator();
    
    @FXML
    private TextField txtlname;
    @FXML
    private PasswordField txtlpass;
    @FXML
    private Button btnlogin;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnforgot;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        v1.addRequiredValidator(txtlname);
        v1.addRequiredValidator(txtlpass);
        v1.addPassValidator(txtlpass);
    }    

    @FXML
    private void he(ActionEvent event) {
        if(event.getSource()==btnlogin)
        {
            try {
                if(v1.validateAll())
                {
                    
                    admin a=new admin();
                    a.setUser_name(txtlname.getText());
                    a.setPassword(txtlpass.getText());
                    if(logic.check_pass(a))
                    {
                        Stage stage=(Stage)btnlogin.getScene().getWindow();
                       Parent  root = FXMLLoader.load(getClass().getResource("FXMLst_main.fxml"));
                          Scene scene = new Scene(root);
                          
                      stage.setScene(scene);
                      stage.show();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Wrong Username Or Password");
                    }
                   
                }
                
            } catch (Exception e) {
                e.printStackTrace();;
            }
            
        }
        else if(event.getSource()==btnforgot)
        {
            try {
               
                        Stage stage=(Stage)btnlogin.getScene().getWindow();
                       Parent  root = FXMLLoader.load(getClass().getResource("FXMLforgot.fxml"));
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
