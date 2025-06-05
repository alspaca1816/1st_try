package modelo;

import java.util.List;

public class Comprador extends Usuario{
    private List<Producto> deseados;
    private List<Producto> comprados;
    private List<Producto> carrito;

    public Comprador(List<Producto> deseados, List<Producto> comprados, List<Producto> carrito, String usuario, String correo, String contrasena, String telefono, char tipo) {
        super(usuario, correo, contrasena, telefono, tipo);
        
        this.deseados = deseados;
        this.comprados = comprados;
        this.carrito = carrito;
    }

    public List<Producto> getDeseados() {
        return deseados;
    }

    public void setDeseados(List<Producto> deseados) {
        this.deseados = deseados;
    }

    public List<Producto> getComprados() {
        return comprados;
    }

    public void setComprados(List<Producto> comprados) {
        this.comprados = comprados;
    }

    public List<Producto> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<Producto> carrito) {
        this.carrito = carrito;
    }
}