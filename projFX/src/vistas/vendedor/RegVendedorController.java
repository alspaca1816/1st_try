/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas.vendedor;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
        comprasbtn.setOnAction(this::handleComprador);
        ingresarVbtn.setOnAction(this::handleIngresoV);
        regVbtn.setOnAction(this::handleRegistrar);
    }    
    
    private void handleRegistrar(ActionEvent event2){
        
        String usuario = usrVtxt.getText();
        String contrasena = pswrdVtxt.getText();
        String correo = emailVtxt.getText();
        String telefono = telefonoVtxt.getText();
        char tipo = 'V';
        
        if (!usuario.isEmpty() && !contrasena.isEmpty() && !correo.isEmpty() && !telefono.isEmpty()) {
            if (!DatosEnlazados.listaUsuarios.existeUsuario(usuario)) {
                DatosEnlazados.listaUsuarios.aggFinal(usuario, correo, contrasena, telefono, tipo);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registro Exitoso");
                alert.setHeaderText(null);
                alert.setContentText("El usuario fue registrado correctamente. Gracias por registrarte! :D");
                alert.showAndWait();
                
                usrVtxt.setText("");
                pswrdVtxt.setText("");
                emailVtxt.setText("");
                telefonoVtxt.setText("");
                
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Algo falló :(");
                alert.setHeaderText(null);
                alert.setContentText("El usuario o correo ya están vinculados a una cuenta ya existente.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Algo falló :(");
                alert.setHeaderText(null);
                alert.setContentText("Uno o más campos están vacíos.");
                alert.showAndWait();
        }
    }
    
    private void handleComprador(ActionEvent event1){
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
    
    private void handleIngresoV(ActionEvent event1){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/vendedor/LoginVendedor.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Ingreso como Vendedor");
            stage.show();
            Node source = (Node) event1.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
