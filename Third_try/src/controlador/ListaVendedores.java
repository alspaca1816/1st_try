package controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelo.Usuario;
import modelo.Vendedor;

public class ListaVendedores {
    public Vendedor cab;
    
    public ListaVendedores () {
        cab = null;
    }
    
    public boolean ifVacia() {
        return cab==null?true:false;
    }
    
    public Vendedor buscarVendedor(String usuario) {
        if(cab==null)
            return null;
        else{
            Vendedor p = cab;
            while(p!=null){
                if((p.getUsuario()).equals(usuario))
                    return p;
                else
                    p = (Vendedor) p.getSig();
            }
            return null;
        }
    }
    
    public Vendedor buscarCodigo(int codigo) {
        if(cab==null)
            return null;
        else{
            Vendedor p = cab;
            while(p != null){
                if(p.getCodigo() == codigo)
                    return p;
                else
                    p = (Vendedor) p.getSig();
            }
            return null;
        }
    }
    
    public boolean existeVendedor(String usuario) {
        if (ifVacia()) {
            return false;
        }
        
        Vendedor actual = cab;
        
        while (actual != null) {
            if (actual.getUsuario().equals(usuario)) {
                return true;
            }
            actual = (Vendedor) actual.getSig();
        }
        return false;
    }
    
    public int sizeLista() {
        int cont = 0;
        Vendedor p = null;
        
        if(cab == null)
            return 0;
        else{
            p = cab;
            while(p != null){
                cont++;
                p = (Vendedor) p.getSig();
            }
            return cont;
        }
    }
    
    public Vendedor crearVendedor(  
        String usuario, 
        String correo, 
        String contrasena, 
        String telefono, 
        char tipo) {
        
        Vendedor buscar = null;
        
        try {
            buscar = buscarVendedor(usuario);
            
            if (buscar != null) {              
                return null;
            }
            
            Vendedor info = new Vendedor(usuario, correo, contrasena, telefono, tipo);
            
            return info;
        }catch (Exception e) {            
            return null;
        }
    }
    
    public Vendedor ultimo(){
        if(cab==null)
            return null;
        else{
            Vendedor p = cab;
            while (p.getSig() != null) {
                p = (Vendedor) p.getSig();
            }
        return p;
            }
    }
    
    public void aggInicio(
        String usuario, 
        String correo, 
        String contrasena, 
        String telefono, 
        char tipo) {
        
        Vendedor info = crearVendedor(usuario, correo, contrasena, telefono, tipo);
        
        if (info != null) {
            if (cab == null) {
                cab = info;
            }
                else {
                    info.setSig(cab);
                    cab = info;
            }
        }
    }
    
    public void aggFinal(
        String usuario, 
        String correo, 
        String contrasena, 
        String telefono, 
        char tipo) {
        
        Vendedor info = crearVendedor(usuario, correo, contrasena, telefono, tipo);
        
        Vendedor p;
        if (info != null) {
            if (cab == null) {
                cab = info;
            }
                else {  
                Vendedor ult = ultimo();
                ult.setSig(info);
                }
        }
            else {            
            }
    }
    
    public Vendedor anterior(Vendedor actual){
        Vendedor anterior = null;
        if(ifVacia())
            return null;
        else{
            anterior = cab;
            while(anterior.getSig() != actual)
                anterior = (Vendedor) anterior.getSig();
            return anterior;
        }
    }
    
    public void eliminarVendedor(String usuario){
        Vendedor p, q, ant = null;            
        p = buscarVendedor(usuario);
            
        if(p != null) {
            if((p == cab) && (cab.getSig() == null)){
                cab=null;
            }
            else if((p == cab) && (cab.getSig() != null)){
                cab = (Vendedor) cab.getSig();
                p.setSig(null);
                p = null;
            }
            else if(p.getSig() == null){
                ant = anterior(p);
                ant.setSig(null);
                p = null;
            }else{                    
                ant = anterior(p);
                ant.setSig(p.getSig());
                p.setSig(null);
                p = null;
            }
        }
    }
}