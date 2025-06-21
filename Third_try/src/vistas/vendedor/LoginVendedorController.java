/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Vendedor;
import vistas.tiendaV.VistaCatalogoVController;

/**
 * FXML Controller class
 *
 * @author lorenamendez
 */
public class LoginVendedorController implements Initializable {
    
    @FXML
    public TextField correoVtxt; //V de vendedor xdxdxd
    
    @FXML
    public PasswordField pswrdVtxt;
    @FXML
    public Button ingresarVbtn;
    @FXML
    public Button regVbtn;
    @FXML
    public Button comprasbtn;
    
    @FXML
    private void handleIngresar(ActionEvent event){
        String usuario = correoVtxt.getText();
        String contrasena = pswrdVtxt.getText();
        Vendedor vendedor = DatosEnlazados.listaVendedores.buscarVendedor(usuario);
        
        try{
            DatosEnlazados.vendedorAct = vendedor;
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/tiendaV/vistaCatalogo.fxml"));
            Parent root = loader.load();
            
            VistaCatalogoVController control = loader.getController();
            control.initData();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Bienvenido");
            stage.show();
            
            Node source = (Node) event.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comprasbtn.setOnAction(this::handleComprador);
        regVbtn.setOnAction(this::handleRegistroV);
    }    
    
    private void handleComprador(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/projfx/vista.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Ingreso como Usuario");
            stage.show();
            Node source = (Node) event.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    private void handleRegistroV(ActionEvent event1){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/vendedor/RegVendedor.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Registro como Vendedor");
            stage.show();
            Node source = (Node) event1.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
