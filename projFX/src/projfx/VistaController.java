package projfx;

import controlador.DatosEnlazados;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;


public class VistaController implements Initializable {

    @FXML
    public TextField usrtxt;

    @FXML
    public PasswordField pswrdtxt;

    @FXML
    public Button ingresarbtn;

    @FXML
    public Button rgstrbtn;

    @FXML
    public Button venderbtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        rgstrbtn.setOnAction(this::handleRegistro);
        venderbtn.setOnAction(this::handleVendedor);
        ingresarbtn.setOnAction(this::handleIngresar);
    }
    
    private void handleIngresar(ActionEvent event2){
        
        String usuario = usrtxt.getText();
        String contrasena = pswrdtxt.getText();
        
        if (!usuario.isEmpty() && !contrasena.isEmpty()){
            if(DatosEnlazados.listaUsuarios.existeUsuario(usuario)) {
                try{            
                    
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/tienda/VistaCatalogo.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Catálogo");
            stage.show();
            Node source = (Node) event2.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ingreso Exitoso");
                alert.setHeaderText(null);
                alert.setContentText("Ingreso Exitoso.");
                alert.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
            }
            
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Algo falló :(");
                alert.setHeaderText(null);
                alert.setContentText("Usuario o Contraseña Incorrectos. Verifica!");
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
    
    private void handleVendedor(ActionEvent event1){
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

    private void handleRegistro(ActionEvent event) {
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/comprador/vistaRegstr.fxml"));
            Parent root = loader.load();

            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Registro de Usuario");
            stage.show();

            
            Node source = (Node) event.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}