package modelo;

import java.util.List;

public class Vendedor extends Usuario{
    private String codigo;
    private List<Producto> ofertados;

    public Vendedor(String codigo,List<Producto> ofertados, String usuario, String correo, String contrasena, String telefono, char tipo) {
        super(usuario, correo, contrasena, telefono, tipo);
        
        this.codigo = codigo;
        this.ofertados = ofertados;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public List<Producto> getOfertados() {
        return ofertados;
    }

    public void setOfertados(List<Producto> ofertados) {
        this.ofertados = ofertados;
    }
}