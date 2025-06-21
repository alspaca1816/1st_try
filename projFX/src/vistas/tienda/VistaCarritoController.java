package vistas.tienda;

import controlador.DatosEnlazados;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Producto;


public class VistaCarritoController implements Initializable {

    @FXML
    public Button WishList;
    @FXML
    public Button salirbtn;
    @FXML
    public Button historialbtn; 
    @FXML
    public ImageView pagarbtn;
    @FXML
    public Label inicio;
    @FXML
    public Button eliminarbtn;
    @FXML
    public TableView itemstbl;
    @FXML
    private TableColumn<Producto, String> nombreCol;        
    @FXML
    private TableColumn<Producto, Number> precioCol;
    @FXML
    private TableColumn<Producto, String> autorCol;
    @FXML
    private TableColumn<Producto, String> fechaCol;
    @FXML
    private TableColumn<Producto, String> itemCol;
    @FXML
    private TableColumn<Producto, String> calificacionCol;
    
    @FXML
    private void handleInicio(MouseEvent z){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/tienda/vistaCatalogo.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Cátalogo");
            stage.show();
            
            Node source = (Node) z.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
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
    
    @FXML
    private void handleEliminar(ActionEvent e){
        Producto seleccionado = (Producto) itemstbl.getSelectionModel().getSelectedItem();

    if (seleccionado == null) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ningún libro seleccionado");
        alert.setHeaderText(null);
        alert.setContentText("Por favor selecciona un libro de la tabla para eliminar de tu carrito.");
        alert.showAndWait();
        return;} 
    else{
        
        DatosEnlazados.compradorAct.eliminarCarrito(seleccionado.getId());
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("¡Eliminado!");
        alert.setHeaderText(null);
        alert.setContentText("Producto eliminado de tu Carrito de la compra.");
        alert.showAndWait();
        
        refresh();
    }    
    }
    
    @FXML
    private void handlePagar(MouseEvent z){
        Producto seleccionado = (Producto) itemstbl.getSelectionModel().getSelectedItem();

    if (seleccionado == null) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ningún libro seleccionado");
        alert.setHeaderText(null);
        alert.setContentText("Por favor selecciona un libro de la tabla para proceder con el pago.");
        alert.showAndWait();
        return;} 
    
    else{
              
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar la compra?");
        alert.setHeaderText(null);
        alert.setContentText("Deseas pagar por el articulo seleccionado?");
        alert.showAndWait();
        
        if(alert.getResult()== ButtonType.OK){
            DatosEnlazados.compradorAct.eliminarCarrito(seleccionado.getId());
            DatosEnlazados.compradorAct.aggComprados(seleccionado);
        } else{
            return;
        }
        
        refresh();
    }    }
    
    
    
    
    private ObservableList<Producto> datosCarro;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        salirbtn.setOnAction(this::handleSalir);
        historialbtn.setOnAction(this::handleHistorial);
        //WishList.setOnAction(this::handleWishList);
        
        nombreCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNombre()));
        precioCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getPrecio()));
        autorCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getAutor()));
        fechaCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getFecha().toString()));
        itemCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDesc()));
        
        
    }
    
    public void cargarCarrito(List<Producto> carrito){
        datosCarro = FXCollections.observableArrayList(carrito);
        itemstbl.setItems(datosCarro);
    }
    
    public void refresh(){
        cargarCarrito(datosCarro);
    }
    
    private void handleHistorial(ActionEvent event1){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/tienda/vistaHistorial.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Historial de Compras");
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