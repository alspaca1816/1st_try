/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas.vendedor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author lorenamendez
 */
public class RegVendedorController implements Initializable {
    
    @FXML
    public TextField emailVtxt;
    @FXML
    public TextField telefonoVtxt;
    @FXML
    public TextField usrVtxt;
    @FXML
    public PasswordField pswrdVtxt;
    @FXML
    public Button regVbtn;
    @FXML
    public Button ingresarVbtn;
    @FXML
    public Button comprasbtn;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
