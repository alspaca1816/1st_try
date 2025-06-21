package controlador;

import modelo.Usuario;

public class ListaUsuarios {
    public Usuario cab;
    
    public ListaUsuarios() {
        cab = null;
    }
    
    public boolean ifVacia() {
        return cab==null?true:false;
    }
    
    public Usuario buscarUsuario(String usuario) {
        if(cab==null)
            return null;
        else{
            Usuario p = cab;
            while(p!=null){
                if((p.getUsuario()).equals(usuario))
                    return p;
                else
                    p = p.getSig();
            }
            return null;
        }
    }
    
    public boolean existeUsuario(String usuario) {
        if (ifVacia()) {
            return false;
        }
        
        Usuario actual = cab;
        
        while (actual != null) {
            if (actual.getUsuario().equals(usuario)) {
                return true;
            }
            actual = actual.getSig();
        }
        return false;
    }
    
    public int sizeLista() {
        int cont = 0;
        Usuario p = null;
        
        if(cab == null)
            return 0;
        else{
            p = cab;
            while(p != null){
                cont++;
                p = p.getSig();
            }
            return cont;
        }
    }
    
    public Usuario crearUsuario(
        String usuario, 
        String correo, 
        String contrasena, 
        String telefono, 
        char tipo) {
        
        Usuario buscar = null;
        
        try {
            buscar = buscarUsuario(usuario);
            
            if (buscar != null) {              
                return null;
            }
            
            Usuario info = new Usuario(usuario, correo, contrasena, telefono, tipo);
            
            return info;
        }catch (Exception e) {            
            return null;
        }
    }
    
    public Usuario ultimo(){
        if(cab==null)
            return null;
        else{
            Usuario p = cab;
            while (p.getSig() != null) {
                p = p.getSig();
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
        
        Usuario info = crearUsuario(usuario, correo, contrasena, telefono, tipo);
        
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
    
    public void aggFinal(String usuario, 
        String correo, 
        String contrasena, 
        String telefono, 
        char tipo) {
        
        Usuario info = crearUsuario(usuario, correo, contrasena, telefono, tipo);
        
        Usuario p;
        if (info != null) {
            if (cab == null) {
                cab = info;
            }
                else {  
                Usuario ult = ultimo();
                ult.setSig(info);
                }
        }
            else {            
            }
    }
    
    public Usuario anterior(Usuario actual){
        Usuario anterior = null;
        if(ifVacia())
            return null;
        else{
            anterior = cab;
            while(anterior.getSig() != actual)
                anterior = anterior.getSig();
            return anterior;
        }
    }
    
    public void eliminarUsuario(String usuario){
        Usuario p, q, ant = null;            
        p = buscarUsuario(usuario);
            
        if(p != null) {
            if((p == cab) && (cab.getSig() == null)){
                cab=null;
            }
            else if((p == cab) && (cab.getSig() != null)){
                cab = cab.getSig();
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