
package vistas.tienda;

import controlador.DatosEnlazados;
import controlador.ListaProductos;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import static javafx.fxml.FXMLLoader.load;
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
import modelo.Resena;
import vistas.tiendaV.VistaCatalogoVController;
//import vistas.tiendaV.VistaCatalogoController;



public class VistaCatalogoController implements Initializable {

    @FXML
    public Button WishList;
    @FXML
    public Button historialbtn;
    @FXML
    public Button salirbtn;
    @FXML
    public Button aggWLbtn;
    @FXML
    public Button aggCarbtn;
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
    
    
    
    @FXML
    private void handleWishList(ActionEvent event1){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/tienda/WishList.fxml"));
            Parent root = loader.load();
            
            VistaWishListController control = loader.getController();
            control.cargarWL(DatosEnlazados.compradorAct.getDeseados());
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Lista de Deseados");
            stage.show();
            
            Node source = (Node) event1.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }}
    
    @FXML
    private void handleHistorial(ActionEvent event3){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/tienda/vistaHistorial.fxml"));
            Parent root = loader.load();
            
            VistaHistorialController control = loader.getController();
            control.cargarH(DatosEnlazados.compradorAct.getComprados());
            control.initData();
            
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
    
    @FXML
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
    
    @FXML
    private void handleAggWL(ActionEvent event){
        
    Producto seleccionado = (Producto) itemstbl.getSelectionModel().getSelectedItem();

    if (seleccionado == null) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ningún libro seleccionado");
        alert.setHeaderText(null);
        alert.setContentText("Por favor selecciona un libro de la tabla para agregar a tu lista de deseos.");
        alert.showAndWait();
        return;} 
    else{
        
        DatosEnlazados.compradorAct.aggDeseados(seleccionado);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("¡Agregado!");
        alert.setHeaderText(null);
        alert.setContentText("Producto agregado a tu lista de deseos.");
        alert.showAndWait();
    }}
    
    @FXML
    private void handleAggCar(ActionEvent event){
        
    Producto seleccionado = (Producto) itemstbl.getSelectionModel().getSelectedItem();

    if (seleccionado == null) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ningún libro seleccionado");
        alert.setHeaderText(null);
        alert.setContentText("Por favor selecciona un libro de la tabla para agregar a tu carrito de compras.");
        alert.showAndWait();
        return;} 
    else{
        
        DatosEnlazados.compradorAct.aggCarrito(seleccionado);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("¡Agregado!");
        alert.setHeaderText(null);
        alert.setContentText("Producto agregado a tu carrito de compras.");
        alert.showAndWait();
    }}
    
    public void aggItem(){
        ObservableList<Producto> listaObservable = FXCollections.observableArrayList();
        Producto actual = DatosEnlazados.listaProductos.fin;

        while (actual != null) {
            listaObservable.add(0, actual);
            actual = actual.getAnt();
    }

    itemstbl.setItems(listaObservable);
        
    }
   
    public void initData(){
        aggItem();
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        salirbtn.setOnAction(this::handleSalir);
        //WishList.setOnAction(this::handleWishList);
        //carritobtn.setOnMouseClicked(this::handleCarrito);
        //historialbtn.setOnAction(this::handleHistorial);
        
        nombreCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNombre()));
        precioCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getPrecio()));
        autorCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getAutor()));
        fechaCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getFecha().toString()));
        itemCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDesc()));
        //calificacionCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().));

   initData();       
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
        
    }}
    
    
    
    
    
    
