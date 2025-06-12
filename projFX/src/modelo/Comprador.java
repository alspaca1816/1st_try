package modelo;

import java.util.ArrayList;
import java.util.List;

public class Comprador extends Usuario{
    private List<Producto> deseados;
    private List<Producto> comprados;
    private List<Producto> carrito;

    public Comprador(String usuario, String correo, String contrasena, String telefono, char tipo) {
        super(usuario, correo, contrasena, telefono, tipo);
        
        this.deseados = new ArrayList<>();
        this.comprados = new ArrayList<>();
        this.carrito = new ArrayList<>();
    }

    public List<Producto> getDeseados() {
        return deseados;
    }

    public List<Producto> getComprados() {
        return comprados;
    }

    public List<Producto> getCarrito() {
        return carrito;
    }
    
    public void aggDeseados(Producto libro) {
        deseados.add(libro);
    }
    
    public boolean eliminarDeseados(int codigo) {
        if (deseados == null) return false; // porque no se ha inicializado

        for (int i = 0; i < deseados.size(); i++) {
            if (deseados.get(i).getId() == codigo) {
                deseados.remove(i);
                return true;
            }
        }
        return false; // porque no se encontró el libro
    }
    
    public void aggCarrito(Producto libro) {
        carrito.add(libro);
    }
    
    public boolean eliminarCarrito(int codigo) {
        if (carrito == null) return false; // porque no se ha inicializado

        for (int i = 0; i < carrito.size(); i++) {
            if (carrito.get(i).getId() == codigo) {
                carrito.remove(i);
                return true;
            }
        }
        return false; // porque no se encontró el libro
    }
    
    public void aggComprados(Producto libro) {
        comprados.add(libro);
    }
}