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
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author SARITA
 */
public class FXMLsignupController implements Initializable {
    GUIValidator v1=new GUIValidator();
   @FXML
    private TextField txtlname;
     @FXML
    private PasswordField txtlpass;
    @FXML
    private Button btnsignup;
    @FXML
    private Button btnexit;
    @FXML
    private PasswordField txtlans;
    @FXML
    private TextField txtlques;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         v1.addRequiredValidator(txtlname);
        v1.addRequiredValidator(txtlpass);
        v1.addRequiredValidator(txtlans);
        v1.addRequiredValidator(txtlques);
        v1.addPassValidator(txtlpass);
    }    

    @FXML
    private void he(ActionEvent event) {
        if(event.getSource()==btnsignup)
        {
            try {
                if(v1.validateAll())
                {
                    
                    admin a=new admin();
                    a.setUser_name(txtlname.getText());
                    a.setPassword(txtlpass.getText());
                    a.setAns(txtlans.getText());
                    a.setQues(txtlques.getText());
                   colg.dao.logic.enter(a);
                        Stage stage=(Stage)btnsignup.getScene().getWindow();
                       Parent  root = FXMLLoader.load(getClass().getResource("FXMLst_main.fxml"));
                          Scene scene = new Scene(root);
                          
                      stage.setScene(scene);
                      stage.show();
                   
                   
                }
                
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
    

