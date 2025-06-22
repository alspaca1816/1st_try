
package vistas.tiendaV;

import controlador.DatosEnlazados;
import controlador.ListaProductos;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Producto;
import modelo.Resena;



public class VistaCatalogoVController implements Initializable {

    @FXML
    public Button resenasbtn;
    @FXML
    public Button historialbtn;
    @FXML
    public Button salirbtn;
    @FXML
    public Button venderbtn; 
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
    
    private ObservableList<Producto> Catalogo;
    
    @FXML
    public void handleSalir(ActionEvent event){
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
    
    @FXML
    private void handleHistorial(ActionEvent event3){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/tienda/vistaHistorial.fxml"));
            Parent root = loader.load();
            
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
    public void handleVender(ActionEvent event2){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/tiendaV/aggVenta.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Agregar Item");
            stage.show();
            
            Node source = (Node) event2.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public void aggItem() {
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
        
        
    
    }
    
    
    
    
    
    
