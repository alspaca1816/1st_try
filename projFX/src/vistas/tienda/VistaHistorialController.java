package vistas.tienda;

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
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class VistaHistorialController implements Initializable {

    @FXML
    public Button WishList;
    @FXML
    public Button salirbtn;
    @FXML
    public ImageView carritobtn; 
    @FXML
    public TableView itemstbl;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        salirbtn.setOnAction(this::handleSalir);
        WishList.setOnAction(this::handleWishList);
        carritobtn.setOnMouseClicked(this::handleCarrito);
    }
    
    private void handleCarrito(MouseEvent event2){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/tienda/vistaCarrito.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Carrito de Compras");
            stage.show();
            
            Node source = (Node) event2.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    private void handleWishList(ActionEvent event1){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/tienda/WishList.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Lista de Deseados");
            stage.show();
            
            Node source = (Node) event1.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    private void handleSalir(ActionEvent event){
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
}    