
package vistas.comprador;

import controlador.DatosEnlazados;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


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
        ingresarbtn.setOnAction(this::handleIngreso);
        vendedorbtn.setOnAction(this::handleVendedor);
        registrarbtn.setOnAction(this::handleRegistrar);
    }   
    
    private void handleRegistrar(ActionEvent event2){
        
        String usuario = usertxt.getText();
        String contrasena = pswrdtxt.getText();
        String correo = correotxt.getText();
        String telefono = telefonotxt.getText();
        char tipo = 'C';
        
        if (!usuario.isEmpty() && !contrasena.isEmpty() && !correo.isEmpty() && !telefono.isEmpty()) {
            if (!DatosEnlazados.listaUsuarios.existeUsuario(usuario)) {
                DatosEnlazados.listaUsuarios.aggFinal(usuario, correo, contrasena, telefono, tipo);
                System.out.println("Usuario registrado con éxito.");
                
                usertxt.setText("");
                pswrdtxt.setText("");
                correotxt.setText("");
                telefonotxt.setText("");
                
            } else {
                System.out.println("Usuario ya existe.");
            }
        } else {
            System.out.println("Por favor complete todos los campos.");
        }
    }
    
    private void handleVendedor(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/vendedor/LoginVendedor.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Ingreso como Vendedor");
            stage.show();
            
            Node source = (Node) event.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    private void handleIngreso(ActionEvent event1){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/projfx/vista.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Ingreso como Usuario");
            stage.show();
            Node source = (Node) event1.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
