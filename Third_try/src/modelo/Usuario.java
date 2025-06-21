    package modelo;

public class Usuario {
    private String usuario;
    private String correo;
    private String contrasena;
    private String telefono;
    private char tipo; // C para comprador, V para vendedor y A para administrativo
    
    Usuario sig;

    public Usuario(String usuario, String correo, String contrasena, String telefono, char tipo) {
        this.usuario = usuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.tipo = tipo;
        
        sig = null;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    public Usuario getSig() {
        return sig;
    }

    public void setSig(Usuario sig) {
        this.sig = sig;
    }
}