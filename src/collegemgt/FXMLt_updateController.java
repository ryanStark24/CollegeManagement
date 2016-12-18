/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegemgt;

import ECUtils.GUIValidator;
import colg.bean.admin;
import colg.bean.student;
import colg.bean.teachers;
import colg.dao.StudentDao;
import colg.dao.TeachersDao;
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
public class FXMLt_updateController implements Initializable {
public  static String id;
    GUIValidator v1=new GUIValidator();
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
    @FXML
    private Button btnupdate;
    @FXML
    private TextField txtdeprt;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtmob;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtid;
    @FXML
    private TextField txtquali;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        teachers s1=TeachersDao.searchById(id);
        txtemail.setText(s1.getEmail());
        txtid.setText(s1.getId());
        txtname.setText(s1.getName());
        txtmob.setText(s1.getP_no());
        txtdeprt.setText(s1.getDeprt());
        txtquali.setText(s1.getQuali());
        v1.addRequiredValidator(txtid);
        v1.addRequiredValidator(txtemail);
        v1.addRequiredValidator(txtmob);
        v1.addRequiredValidator(txtname);
        v1.addRequiredValidator(txtdeprt);
        v1.addRequiredValidator(txtquali);
        v1.addPNValidator(txtmob);
        v1.addEmailValidator(txtemail);
        // TODO
    }    

    @FXML
    private void he(ActionEvent event) {
           Parent root=null;
         if(event.getSource()==btnback)
        {
            try {
              root=  FXMLLoader.load(getClass().getResource("FXMLt_start.fxml"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    else if(event.getSource()==btnupdate)
        {
            if(v1.validateAll())
            {
            try {
               teachers s1=new teachers();
                s1.setEmail(txtemail.getText());
                s1.setId(txtid.getText());
                s1.setName(txtname.getText());
                s1.setP_no(txtmob.getText());
                s1.setDeprt(txtdeprt.getText());
                s1.setQuali(txtquali.getText());
                TeachersDao.update(s1);
              root=  FXMLLoader.load(getClass().getResource("FXMLt_start.fxml"));
                JOptionPane.showMessageDialog(null, "data updated success");
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
