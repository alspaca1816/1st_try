package libra;

import controlador.DatosEnlazados;
import controlador.ListaProductos;
import static java.lang.String.format;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import modelo.Producto;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import modelo.Vendedor;

public class Libra extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            
            DatosEnlazados.listaUsuarios.aggInicio("Admin", "ejmpl@noc.com", "1234567", "adm", 'A');    DatosEnlazados.listaAdministradores.aggInicio("12-12-2000", 'F', 1000, "Admin", "ejmpl@noc.com", "1234567", "xd", 'A');
            DatosEnlazados.listaUsuarios.aggInicio("a", "a", "a", "a", 'C');    DatosEnlazados.listaCompradores.aggInicio("a", "a", "a", "a", 'C');
            DatosEnlazados.listaUsuarios.aggInicio("Vendedor", "vendedor@correo.com", "1234", "asd", 'V');  DatosEnlazados.listaVendedores.aggInicio("Vendedor", "vendedor@correo.com", "1234", "asd", 'V'); 
            
            DatosEnlazados.listaProductos.registrarLibro("El Quijote", 200, "Novela clásica", "Cervantes", LocalDate.of(1605, 1, 16), "V001",10);
            DatosEnlazados.listaProductos.registrarLibro("Cien Años de Soledad", 300, "Realismo mágico", "García Márquez", LocalDate.of(1967, 5, 30), "V002",10);
   
            Parent root = FXMLLoader.load(getClass().getResource("/projfx/vista.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Inicio de Sesión");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        new Thread(() -> {
        
 
        Scanner scanner = new Scanner(System.in);
            String input;
            while (true) {
                System.out.println("Admin creado: " + DatosEnlazados.listaAdministradores.existeAdmin("Nigga"));
                System.out.print("Usuario: ");
                input = scanner.nextLine();
                
        Vendedor v = DatosEnlazados.listaVendedores.buscarVendedor(input);
    
        if (v != null) {
            System.out.println(v.getCodigo());
        } 
}
    }).start();}

    public static void main(String[] args) {
        launch(args);
    }
}