/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegemgt;

import ECUtils.GUIValidator;
import colg.bean.admin;
import colg.bean.student;
import colg.dao.StudentDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author SARITA
 */
public class FXMLs_addController implements Initializable {
    GUIValidator v1=new GUIValidator();
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
    @FXML
    private Button btnsubmit;
    @FXML
    private TextField txtsem;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtmob;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        v1.addRequiredValidator(txtid);
        v1.addRequiredValidator(txtemail);
        v1.addRequiredValidator(txtmob);
        v1.addRequiredValidator(txtname);
        v1.addRequiredValidator(txtsem);
        v1.addPNValidator(txtmob);
        v1.addEmailValidator(txtemail);
        
    }    

    @FXML
    private void he(ActionEvent event) {
        Parent root=null;
         if(event.getSource()==btnback)
        {
            try {
              root=  FXMLLoader.load(getClass().getResource("FXMLs_start1.fxml"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    else if(event.getSource()==btnsubmit)
        {
            if(v1.validateAll())
            {
            try {
                student s1=new student();
                s1.setEmail(txtemail.getText());
                s1.setId(txtid.getText());
                s1.setName(txtname.getText());
                s1.setP_no(txtmob.getText());
                s1.setSem(txtsem.getText());
                StudentDao.insert(s1,admin.BRANCH);
              root=  FXMLLoader.load(getClass().getResource("FXMLstudent1.fxml"));
                JOptionPane.showMessageDialog(null, "data added success");
            } catch (Exception e) {
                e.printStackTrace();
            }
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
