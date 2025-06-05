
package vistas.comprador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class RegistroController implements Initializable {
    
    @FXML
    public TextField usertxt;
    @FXML
    public PasswordField pswrdtxt;
    @FXML
    public TextField correotxt;
    @FXML
    public TextField telefonotxt;
    @FXML
    public Button registrarbtn;
    @FXML
    public Button ingresarbtn;    
    @FXML
    public Button vendedorbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
