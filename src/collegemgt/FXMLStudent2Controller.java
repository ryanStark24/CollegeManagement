/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegemgt;

import ECUtils.MyUtils;
import colg.bean.admin;
import colg.bean.student;
import colg.dao.StudentDao;
import com.sun.javafx.scene.control.skin.TableViewSkinBase;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author SARITA
 */
public class FXMLStudent2Controller implements Initializable {
     student s1=new student();
    @FXML
    private TextField txtsearch;
    @FXML
    private Button btnback;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
    @FXML
    private Button btnexit;
    @FXML
    private TableView<?> tblstudent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  s1.setId("");
        refreshTb();
      
    }    

    @FXML
    private void he(ActionEvent event) {
        Parent root=null;
         if(event.getSource()==btnback)
        {
            try {
              root=  FXMLLoader.load(getClass().getResource("FXMLs_start1.fxml"));
              Stage stage=(Stage)btnexit.getScene().getWindow();
        Scene scene = new Scene(root);
                          
         stage.setScene(scene);
                      stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
  
     else if(event.getSource()==btnupdate)
        {
            try {
                String id=MyUtils.getSelColValue("id", tblstudent);
                if(id!=null&&!"".equals(id))
                {
                    FXMLs_updateController.id=id;
              root=  FXMLLoader.load(getClass().getResource("FXMLs_update.fxml"));
              Stage stage=(Stage)btnexit.getScene().getWindow();
        Scene scene = new Scene(root);
                          
         stage.setScene(scene);
                      stage.show();
            }
                else
                {
                        JOptionPane.showMessageDialog(null, "Please Select A Row");
                        }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
     else if(event.getSource()==btndelete)
        {
            try {
                String id=MyUtils.getSelColValue("id", tblstudent);
                if(id!=null&&!"".equals(id))
                {
                    int ch= JOptionPane.showConfirmDialog(null,"Are You Sure Want To Delete");
                    if(ch==0)
                    {
                    student s1=new student();
                    s1.setId(id);
                    StudentDao.delete(s1, admin.BRANCH);
                    refreshTb();
                    JOptionPane.showMessageDialog(null,"Data Deleted Success");
                    }
                    
                    
                    
                    
                }
                else
                {
                        JOptionPane.showMessageDialog(null, "Please Select A Row");
                        }
             
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
     
         else
     {
         System.exit(0);
     }
         
    
    }

    @FXML
    private void kr(KeyEvent event) {
       s1.setId(txtsearch.getText());
       refreshTb();
    }
    private void refreshTb()
    {
        LinkedList<student> rs=StudentDao.search(s1, admin.BRANCH);
        MyUtils.populateTable(tblstudent, rs, student.class);
    }
}
