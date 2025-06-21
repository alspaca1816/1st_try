package libra;

import controlador.DatosEnlazados;
import controlador.ListaProductos;
import java.time.LocalDate;
import modelo.Producto;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Libra extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            
            DatosEnlazados.listaUsuarios.aggInicio("Nigga", "xd@polla", "1234567", "xd", 'A');    DatosEnlazados.listaAdministradores.aggInicio(LocalDate.of(2000,12,12), 'F', 0, "Nigga", "xd@polla.com", "1234567", "xd", 'A');
            DatosEnlazados.listaUsuarios.aggInicio("a", "a", "a", "a", 'C');    DatosEnlazados.listaCompradores.aggInicio("a", "a", "a", "a", 'C');
            DatosEnlazados.listaUsuarios.aggInicio("Vendedor", "vendedor@correo.com", "1234", "asd", 'V');  DatosEnlazados.listaVendedores.aggInicio("Vendedor", "vendedor@correo.com", "1234", "asd", 'V'); 
            
            Parent root = FXMLLoader.load(getClass().getResource("/projfx/vista.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Inicio de Sesión");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}