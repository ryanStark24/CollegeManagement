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
public class FXMLforgotController implements Initializable {

    GUIValidator v1 = new GUIValidator();
    admin a;
    @FXML
    private Button btnexit;
    @FXML
    private PasswordField txtans;
    @FXML
    private Button btnnext;
    @FXML
    private TextField txtques;
    @FXML
    private Button btnback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        a = logic.forgot();
        txtques.setText(a.getQues());
        v1.addRequiredValidator(txtans);
    }

    @FXML
    private void he(ActionEvent event) {

        if (event.getSource() == btnnext) {
            try {
                if (v1.validateAll()) {

                    if (a.getAns().equals(txtans.getText())) {
                        Stage stage = (Stage) btnback.getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getResource("FXMLrecreate.fxml"));
                        Scene scene = new Scene(root);

                        stage.setScene(scene);
                        stage.show();
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong Answer");
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();;
            }

        } else if (event.getSource() == btnback) {
            try {

                Stage stage = (Stage) btnback.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLlogin.fxml"));
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();;
            }

        } else {
            System.exit(0);
        }
    }

}
