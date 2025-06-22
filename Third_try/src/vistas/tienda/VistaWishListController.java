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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Producto;
import modelo.Comprador;


public class VistaWishListController implements Initializable {

    @FXML
    public Button historialbtn;
    @FXML
    public Button salirbtn;
    @FXML
    public Button eliminarbtn;
    @FXML
    public Button aggCarrito;
    @FXML
    public ImageView carritobtn; 
    @FXML
    public TableView itemstbl;
    @FXML
    public Label inicio;
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
    
    private ObservableList<Producto> datosWL;
    
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
    private void handleEliminar(ActionEvent e){
        Producto seleccionado = (Producto) itemstbl.getSelectionModel().getSelectedItem();

    if (seleccionado == null) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ningún libro seleccionado");
        alert.setHeaderText(null);
        alert.setContentText("Por favor selecciona un libro de la tabla para eliminar de tu lista de deseos.");
        alert.showAndWait();
        return;} 
    else{
        
        DatosEnlazados.compradorAct.eliminarDeseados(seleccionado.getId());
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("¡Eliminado!");
        alert.setHeaderText(null);
        alert.setContentText("Producto eliminado de tu lista de deseos.");
        alert.showAndWait();
        
        refresh();
    }    }
    
    @FXML
    private void handleAggCarro(ActionEvent event4){
        Producto seleccionado = (Producto) itemstbl.getSelectionModel().getSelectedItem();

    if (seleccionado == null) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ningún libro seleccionado");
        alert.setHeaderText(null);
        alert.setContentText("Por favor selecciona un libro de la tabla para agregar a tu carrito de la compra.");
        alert.showAndWait();
        return;} 
    else{
        
        DatosEnlazados.compradorAct.eliminarDeseados(seleccionado.getId());
        DatosEnlazados.compradorAct.aggCarrito(seleccionado);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("¡Agregado!");
        alert.setHeaderText(null);
        alert.setContentText("Producto agregado a tu carrito.");
        alert.showAndWait();
        
        refresh();
    }    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        salirbtn.setOnAction(this::handleSalir);
        carritobtn.setOnMouseClicked(this::handleCarrito);
        historialbtn.setOnAction(this::handleHistorial);
        
       nombreCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNombre()));
        precioCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getPrecio()));
        autorCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getAutor()));
        fechaCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getFecha().toString()));
        itemCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDesc()));
    }
    
    public void cargarWL(List<Producto> deseados){
        datosWL = FXCollections.observableArrayList(deseados);
        itemstbl.setItems(datosWL);
    }
    
    public void refresh(){
        cargarWL(datosWL);
    }
    
    @FXML
    private void handleHistorial(ActionEvent event3){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/tienda/vistaHistorial.fxml"));
            Parent root = loader.load();
            
            VistaCarritoController control = loader.getController();
            control.cargarCarrito(DatosEnlazados.compradorAct.getComprados());
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Historial de Compras");
            stage.show();
            
            Node source = (Node) event3.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    private void handleCarrito(MouseEvent event2){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/tienda/vistaCarrito.fxml"));
            Parent root = loader.load();
            
            VistaCarritoController control = loader.getController();
            control.cargarCarrito(DatosEnlazados.compradorAct.getCarrito());
            
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