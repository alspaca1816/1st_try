
package vistas.admin;

import controlador.DatosEnlazados;
import controlador.ListaUsuarios;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Admin;
import modelo.Comprador;
import modelo.Usuario;
import modelo.Vendedor;

public class VistaAdminController implements Initializable {
    
    @FXML
    public Button regAdmin;
    @FXML
    public Button deleteusr;
    @FXML
    public Button sortA;
    @FXML
    public Button sortC;
    @FXML
    public Button sortV;
    @FXML
    public Button refresh;
    @FXML
    public TextField userAd;
    @FXML
    public TextField emailAd;
    @FXML
    public TextField telAd;
    @FXML
    public TextField edadAd;
    @FXML
    public TextField salarioAd;
    @FXML
    public TextField sexo;
    @FXML
    public PasswordField pswrdAd;
    @FXML
    public Label iniciobtn;
    @FXML
    public TableView userstbl;
    @FXML
    private TableColumn<Usuario, String> userCol;        
    @FXML
    private TableColumn<Usuario, String> correoCol;
    @FXML
    private TableColumn<Usuario, String> telefonoCol;
    @FXML
    private TableColumn<Usuario, String> passCol;
    @FXML
    private TableColumn<Usuario, String> tipoCol;
    @FXML
    private TableColumn<Vendedor, String> idCol;
    @FXML
    private TableColumn<Admin, String> SalarioACol;
    @FXML
    private TableColumn<Admin, String> SexoACol;
    @FXML
    private TableColumn<Admin, String> EdadACol;
    
    @FXML
    private void handleReg(ActionEvent event){
        String usuario = userAd.getText();
        String contrasena = pswrdAd.getText();
        String correo = emailAd.getText();
        String telefono = telAd.getText();
        String fecha = edadAd.getText();
        int salario = Integer.parseInt(salarioAd.getText());
        String sex = sexo.getText();
        char sexx = sex.charAt(0);
        char tipo = 'A';
        
        
        if (!usuario.isEmpty() && !contrasena.isEmpty() && !correo.isEmpty() && !telefono.isEmpty()){
            if(!DatosEnlazados.listaUsuarios.existeUsuario(usuario)){
                
                if(DatosEnlazados.listaAdministradores.mayorEdad(fecha)){
                                                       
                DatosEnlazados.listaAdministradores.aggFinal(fecha, sexx, salario, usuario, correo, contrasena, telefono, tipo);
                DatosEnlazados.listaUsuarios.aggFinal(usuario, correo, contrasena, telefono, tipo);
                
                    
                DatosEnlazados.listaUsuarios.aggFinal(usuario, correo, contrasena, telefono, tipo);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registro Exitoso");
                alert.setHeaderText(null);
                alert.setContentText("El usuario fue registrado correctamente. Gracias por registrarte! :D");
                alert.showAndWait();
                
                userAd.setText("");
                pswrdAd.setText("");
                emailAd.setText("");
                telAd.setText("");
                edadAd.setText("");
                salarioAd.setText("");
                sexo.setText("");
            } else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Algo falló :(");
                alert.setHeaderText(null);
                alert.setContentText("Para ser administrador la persona debe que tener mayoría de edad");
                alert.showAndWait();
                }
            }}
        }
    
    @FXML
    private void handleInicio(MouseEvent z){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/projfx/vista.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Ingreso como Usuario");
            stage.show();
            
            Node source = (Node) z.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     public void datosUser() {
    ObservableList<Usuario> listaObservable = FXCollections.observableArrayList();
    Usuario actual = DatosEnlazados.listaUsuarios.cab;

    while (actual != null) {
        listaObservable.add(0, actual);
        actual = actual.getSig();
    }

    userstbl.setItems(listaObservable);
}
     @FXML
     private void handleRefresh(ActionEvent event1){
         datosUser();
     }
    
    @FXML
    private void mostrarCompradores(ActionEvent e) {
        
    ObservableList<Comprador> listaCompradores = FXCollections.observableArrayList();
        Comprador actual = DatosEnlazados.listaCompradores.cab;
        
        while (actual != null) {
        listaCompradores.add(0, actual);
        actual = (Comprador) actual.getSig();
                
            
    }
    userstbl.setItems(listaCompradores);
}
    
    @FXML
    private void mostrarAdmins(ActionEvent z){
        
        SalarioACol.setCellValueFactory(cellData -> {
    if (cellData.getValue() instanceof Admin) {
        int salario = ((Admin) cellData.getValue()).getSalario();
        return new SimpleStringProperty(String.valueOf(salario));
    } else {
        return new SimpleStringProperty("N/A");
    }
});
        SexoACol.setCellValueFactory(cellData -> {
    if (cellData.getValue() instanceof Admin) {
        char sex = ((Admin) cellData.getValue()).getSexo();
        return new SimpleStringProperty(String.valueOf(sex));
    } else {
        return new SimpleStringProperty("N/A");
    }
});
        EdadACol.setCellValueFactory(cellData -> {
    if (cellData.getValue() instanceof Admin) {
        String edad = ((Admin) cellData.getValue()).Edad();
        return new SimpleStringProperty(String.valueOf(edad));
    } else {
        return new SimpleStringProperty("N/A");
    }
});
        
        ObservableList<Admin> listaAdministradores = FXCollections.observableArrayList();
        Admin actual = DatosEnlazados.listaAdministradores.cab;
        
        while (actual != null) {
        listaAdministradores.add(0, actual);
        actual = (Admin) actual.getSig();
    }
        userstbl.setItems(listaAdministradores);
    }
    
    @FXML
    private void mostrarVendedores(ActionEvent e) {
        idCol.setCellValueFactory(cellData -> {
    if (cellData.getValue() instanceof Vendedor) {
        int codigo = ((Vendedor) cellData.getValue()).getCodigo();
        return new SimpleStringProperty(String.valueOf(codigo));
    } else {
        return new SimpleStringProperty("N/A");
    }
});
        
        
        ObservableList<Vendedor> listaVendedores = FXCollections.observableArrayList();
        Vendedor actual = DatosEnlazados.listaVendedores.cab;
        
        while (actual != null) {
        listaVendedores.add(0, actual);
        actual = (Vendedor) actual.getSig();
    }

    userstbl.setItems(listaVendedores);
    
    }
    
     @FXML
     private void handleEliminar(ActionEvent x){
         Usuario seleccionado = (Usuario) userstbl.getSelectionModel().getSelectedItem();
         
         if (seleccionado == null) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ningún libro seleccionado");
        alert.setHeaderText(null);
        alert.setContentText("Por favor selecciona un usuario de la tabla para eliminar de la lista.");
        alert.showAndWait();
        return;} 
    else{
             
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("¡Eliminar!");
        alert.setHeaderText(null);
        alert.setContentText("Estas seguro de eliminar este Usuario?");
        alert.showAndWait();
        
        if(alert.getResult() == ButtonType.OK){
            DatosEnlazados.listaUsuarios.eliminarUsuario(seleccionado.getUsuario());
            
            DatosEnlazados.listaAdministradores.eliminarAdministrador(seleccionado.getUsuario());
            DatosEnlazados.listaCompradores.eliminarComprador(seleccionado.getUsuario());
            DatosEnlazados.listaVendedores.eliminarVendedor(seleccionado.getUsuario());
            
        } else{
            return;
        }
     }
     }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //DatosEnlazados.vendedorAct;
        
        userCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getUsuario()));
        correoCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCorreo()));
        passCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getContrasena()));
        telefonoCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getTelefono()));
        tipoCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(String.valueOf(cellData.getValue().getTipo())));
        //idCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(String.valueOf((DatosEnlazados.vendedorAct.getCodigo()))));
        
        
        //datosUser();
    }    
    
}
