package controlador;

import java.time.LocalDate;
import modelo.Admin;

public class ListaAdministradores {
    private Admin cab;
    
    public ListaAdministradores () {
        cab = null;
    }
    
    public boolean ifVacia() {
        return cab==null?true:false;
    }
    
    public Admin buscarAdmin(String usuario) {
        if(cab==null)
            return null;
        else{
            Admin p = cab;
            while(p!=null){
                if((p.getUsuario()).equals(usuario))
                    return p;
                else
                    p = (Admin) p.getSig();
            }
            return null;
        }
    }
    
    public boolean existeAdmin(String usuario) {
        if (ifVacia()) {
            return false;
        }
        
        Admin actual = cab;
        
        while (actual != null) {
            if (actual.getUsuario().equals(usuario)) {
                return true;
            }
            actual = (Admin) actual.getSig();
        }
        return false;
    }
    
    public int sizeLista() {
        int cont = 0;
        Admin p = null;
        
        if(cab == null)
            return 0;
        else{
            p = cab;
            while(p != null){
                cont++;
                p = (Admin) p.getSig();
            }
            return cont;
        }
    }
    
    public Admin crearAdmin(
        LocalDate fechaN, 
        char sexo, 
        int salario, 
        String usuario, 
        String correo, 
        String contrasena, 
        String telefono, 
        char tipo) {
        
        Admin buscar = null;
        
        try {
            buscar = buscarAdmin(usuario);
            
            if (buscar != null) {              
                return null;
            }
            
            Admin info = new Admin(fechaN, sexo, salario, usuario, correo, contrasena, telefono, tipo);
            
            return info;
        }catch (Exception e) {            
            return null;
        }
    }
    
    public Admin ultimo(){
        if(cab==null)
            return null;
        else{
            Admin p = cab;
            while (p.getSig() != null) {
                p = (Admin) p.getSig();
            }
        return p;
            }
    }
    
    public void aggInicio(
        LocalDate fechaN, 
        char sexo, 
        int salario,
        String usuario, 
        String correo, 
        String contrasena, 
        String telefono, 
        char tipo) {
        
        Admin info = crearAdmin(fechaN, sexo, salario, usuario, correo, contrasena, telefono, tipo);
        
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
        LocalDate fechaN, 
        char sexo, 
        int salario,
        String usuario, 
        String correo, 
        String contrasena, 
        String telefono, 
        char tipo) {
        
        Admin info = crearAdmin(fechaN, sexo, salario, usuario, correo, contrasena, telefono, tipo);
        
        Admin p;
        if (info != null) {
            if (cab == null) {
                cab = info;
            }
                else {  
                Admin ult = ultimo();
                ult.setSig(info);
                }
        }
            else {            
            }
    }
    
    public Admin anterior(Admin actual){
        Admin anterior = null;
        if(ifVacia())
            return null;
        else{
            anterior = cab;
            while(anterior.getSig() != actual)
                anterior = (Admin) anterior.getSig();
            return anterior;
        }
    }
    
    public void eliminarAdministrador(String usuario){
        Admin p, q, ant = null;            
        p = buscarAdmin(usuario);
            
        if(p != null) {
            if((p == cab) && (cab.getSig() == null)){
                cab=null;
            }
            else if((p == cab) && (cab.getSig() != null)){
                cab = (Admin) cab.getSig();
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