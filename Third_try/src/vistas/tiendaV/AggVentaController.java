package vistas.tiendaV;

import controlador.DatosEnlazados;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Producto;


public class AggVentaController implements Initializable {

    @FXML
    public Button aggbtn;    
    @FXML
    public TextField nameLtxt;
    @FXML
    public TextField priceLtxt;
    @FXML
    public TextField dateLtxt;
    @FXML
    public TextField autorLtxt;
    @FXML
    public TextField cantidadLtxt;
    @FXML
    public TextField descLtxt;
    
        private ObservableList<Producto> Catalogo;

    
    @FXML
    public void HandleAgg(ActionEvent event){
        String nombre = nameLtxt.getText();
        int precio = Integer.parseInt(priceLtxt.getText());
        String autor = autorLtxt.getText();
        String desc = descLtxt.getText();
        int cantidad = Integer.parseInt(cantidadLtxt.getText());
        LocalDate fecha = LocalDate.parse(dateLtxt.getText());
        
        
        if(!nombre.isEmpty() /*&& precio>0*/ && !autor.isEmpty() /*&& cantidad>0 || priceLtxt == null || fecha == null */){
            //if(DatosEnlazados.listaProductos.existeLibro(nombre)){
                DatosEnlazados.listaProductos.registrarLibro(nombre, precio, desc, autor, fecha, desc, cantidad);
                DatosEnlazados.listaProductos.registrarLibro(nombre, precio, desc, autor, fecha, desc, cantidad);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registro Exitoso");
                alert.setHeaderText(null);
                alert.setContentText("El item fue registrado correctamente. Gracias por vender con nosotros! :D");
                alert.showAndWait();
                
                try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/tiendaV/vistaCatalogo.fxml"));
                Parent root = loader.load();

                
                VistaCatalogoVController control = loader.getController();
                control.aggItem();
                
                } catch(IOException e) {
            e.printStackTrace();
        }
                
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Algo falló :(");
                alert.setHeaderText(null);
                alert.setContentText("Ya existe un Item con estas credenciales.");
                alert.showAndWait();
        }}
        
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
