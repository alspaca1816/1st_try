package modelo;

import java.util.List;

public class Vendedor extends Usuario{
    private List<Producto> ofertados;

    public Vendedor(List<Producto> ofertados, String usuario, String correo, String contrasena, String telefono, char tipo) {
        super(usuario, correo, contrasena, telefono, tipo);
        
        this.ofertados = ofertados;
    }

    public List<Producto> getOfertados() {
        return ofertados;
    }

    public void setOfertados(List<Producto> ofertados) {
        this.ofertados = ofertados;
    }
}