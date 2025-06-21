
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
    private TableColumn<Usuario, String> userVCol;        
    @FXML
    private TableColumn<Usuario, String> correoVCol;
    @FXML
    private TableColumn<Usuario, String> telefonoVCol;
    @FXML
    private TableColumn<Usuario, String> passVCol;
    @FXML
    private TableColumn<Usuario, String> tipoVCol;
    @FXML
    private TableColumn<Usuario, String> idCol;
    
    private void handleReg(ActionEvent event){
        String usuario = userAd.getText();
        String contrasena = pswrdAd.getText();
        String correo = emailAd.getText();
        String telefono = telAd.getText();
        LocalDate fecha = LocalDate.parse(edadAd.getText());
        int salario = Integer.parseInt(salarioAd.getText());
        String sex = sexo.getText();
        char sexx = sex.charAt(0);
        char tipo = 'A';
        
        if (!usuario.isEmpty() && !contrasena.isEmpty() && !correo.isEmpty() && !telefono.isEmpty()){
            if(!DatosEnlazados.listaUsuarios.existeUsuario(usuario)){
                DatosEnlazados.listaUsuarios.aggFinal(usuario, correo, contrasena, telefono, tipo);
                DatosEnlazados.listaAdministradores.aggFinal(fecha, sexx, salario, usuario, correo, contrasena, telefono, tipo);
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registro Exitoso");
                alert.setHeaderText(null);
                alert.setContentText("El usuario fue registrado correctamente. Gracias por registrarte! :D");
                alert.showAndWait();
                
                userAd.setText("");
                pswrdAd.setText("");
                emailAd.setText("");
                telAd.setText("");
            }
            }
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
    
    /* public void datosUser() {
    ObservableList<Usuario> datosUS = DatosEnlazados.listaUsuarios.obtenerListaUsuarios();
    userstbl.setItems(datosUS);
}
     @FXML
     private void handleRefresh(ActionEvent event1){
         datosUser();
     }
    
    @FXML
    private void mostrarCompradores(ActionEvent e) {
        
    // Llenar la tabla
        ObservableList<Usuario> listaCompradores = FXCollections.observableArrayList();
        for (Usuario u : DatosEnlazados.listaCompradores.obtenerListaUsuarios()) {
            listaCompradores.add(u);
            
            //if(idCol == null){
                
            
    }
    userstbl.setItems(listaCompradores);
}
    
    @FXML
    private void mostrarVendedores(ActionEvent e) {
        
    // Llenar la tabla
        ObservableList<Usuario> listaVendedores = FXCollections.observableArrayList();
        for (Usuario u : DatosEnlazados.listaVendedores.obtenerListaUsuarios()) {
            listaVendedores.add(u);
            
            //if(idCol == null){
                
            
    }
    userstbl.setItems(listaVendedores);
}*/
     
     
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
        idCol.setCellValueFactory(cellData -> {
    if (cellData.getValue() instanceof Vendedor) {
        int codigo = ((Vendedor) cellData.getValue()).getCodigo();
        return new SimpleStringProperty(String.valueOf(codigo));
    } else {
        return new SimpleStringProperty("—");
    }
});
        
        //datosUser();
    }    
    
}
