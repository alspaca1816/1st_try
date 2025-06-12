package controlador;

import modelo.Comprador;

public class ListaCompradores {
    private Comprador cab;
    
    public ListaCompradores() {
        cab = null;
    }
    
    public boolean ifVacia() {
        return cab==null?true:false;
    }
    
    public Comprador buscarComprador(String usuario) {
        if(cab==null)
            return null;
        else{
            Comprador p = cab;
            while(p!=null){
                if((p.getUsuario()).equals(usuario))
                    return p;
                else
                    p = (Comprador) p.getSig();
            }
            return null;
        }
    }
    
    public boolean existeComprador(String usuario) {
        if (ifVacia()) {
            return false;
        }
        
        Comprador actual = cab;
        
        while (actual != null) {
            if (actual.getUsuario().equals(usuario)) {
                return true;
            }
            actual = (Comprador) actual.getSig();
        }
        return false;
    }
    
    public int sizeLista() {
        int cont = 0;
        Comprador p = null;
        
        if(cab == null)
            return 0;
        else{
            p = cab;
            while(p != null){
                cont++;
                p = (Comprador) p.getSig();
            }
            return cont;
        }
    }
    
    public Comprador crearComprador(
        String usuario, 
        String correo, 
        String contrasena, 
        String telefono, 
        char tipo) {
        
        Comprador buscar = null;
        
        try {
            buscar = buscarComprador(usuario);
            
            if (buscar != null) {              
                return null;
            }
            
            Comprador info = new Comprador(usuario, correo, contrasena, telefono, tipo);
            
            return info;
        }catch (Exception e) {            
            return null;
        }
    }
    
    public Comprador ultimo(){
        if(cab==null)
            return null;
        else{
            Comprador p = cab;
            while (p.getSig() != null) {
                p = (Comprador) p.getSig();
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
        
        Comprador info = crearComprador(usuario, correo, contrasena, telefono, tipo);
        
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
        
        Comprador info = crearComprador(usuario, correo, contrasena, telefono, tipo);
        
        Comprador p;
        if (info != null) {
            if (cab == null) {
                cab = info;
            }
                else {  
                Comprador ult = ultimo();
                ult.setSig(info);
                }
        }
            else {            
            }
    }
    
    public Comprador anterior(Comprador actual){
        Comprador anterior = null;
        if(ifVacia())
            return null;
        else{
            anterior = cab;
            while(anterior.getSig() != actual)
                anterior = (Comprador) anterior.getSig();
            return anterior;
        }
    }
    
    public void eliminarComprador(String usuario){
        Comprador p, q, ant = null;            
        p = buscarComprador(usuario);
            
        if(p != null) {
            if((p == cab) && (cab.getSig() == null)){
                cab=null;
            }
            else if((p == cab) && (cab.getSig() != null)){
                cab = (Comprador) cab.getSig();
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