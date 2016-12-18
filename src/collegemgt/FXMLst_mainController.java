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
public class FXMLst_mainController implements Initializable {

    @FXML
    private Button btnteachers;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnstudents;

    /**
     * Initializes the controller class.
     * 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void he(ActionEvent event) {
        
                Parent  root =null;        
                          
        if(event.getSource()==btnteachers)
        {
            try {
              root=  FXMLLoader.load(getClass().getResource("FXMLt_start.fxml"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(event.getSource()==btnstudents)
        {
            try {
              root=  FXMLLoader.load(getClass().getResource("FXMLstudent1.fxml"));
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
