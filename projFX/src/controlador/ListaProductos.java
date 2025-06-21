package controlador;

import java.time.LocalDate;
import modelo.Producto;

public class ListaProductos {
    private Producto frente;
    private Producto fin;
    
    public ListaProductos() {
    this.frente = null;
    this.fin = null;
    }
    
    public boolean estaVacia() {
        return frente == null;
    }
    
    public boolean existeLibro(String nombre) {
        if (estaVacia()) {
            return false;
        }
        
        Producto actual = frente;
        
        while (actual != null) {
            if (actual.getNombre().equals(nombre)) {
                return true;
            }
            actual = actual.getSig();
        }
        return false;
    }
    
    public boolean existeLibro(int codigo) {
        if (estaVacia()) {
            return false;
        }
        
        Producto actual = frente;
        
        while (actual != null) {
            if (actual.getId() == codigo) {
                return true;
            }
            actual = actual.getSig();
        }
        return false;
    }
    
    public boolean registrarLibro(String nombre, int precio, String desc, String autor, LocalDate fecha, String vendedor, int cantidad) {
        if (existeLibro(nombre)) {
            return false;
        }
        
        Producto nuevoNodo = new Producto(nombre, precio, desc, autor, fecha, vendedor, cantidad);
        
        if (estaVacia()) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSig(nuevoNodo);
            nuevoNodo.setAnt(fin);
            fin = nuevoNodo;
        }
        
        return true;
    }
    
    public boolean eliminarLibro(int codigo) {
        if (estaVacia()) {
            return false;
        }
        
        Producto actual = frente;
        
        while (actual != null) {
        if (actual.getId() == codigo) {
            if (actual == frente) {
                frente = actual.getSig();
                if (frente != null) frente.setAnt(null);
                else fin = null; // Lista queda vacía
            } else if (actual == fin) {
                fin = actual.getAnt();
                fin.setSig(null);
            } else {
                actual.getAnt().setSig(actual.getSig());
                actual.getSig().setAnt(actual.getAnt());
            }
            return true;
        }
        actual = actual.getSig();
    }

    return false;
}
    
    public boolean editarLibro(int codigo, String nuevoNombre, int nuevoPrecio, String nuevaDesc,
                           String nuevoAutor, LocalDate nuevaFecha, String nuevoVendedor, int nuevaCantidad) {
        if (estaVacia()) {
            return false;
        }

        Producto actual = frente;

        while (actual != null) {
            if (actual.getId() == codigo) {
                actual.setNombre(nuevoNombre);
                actual.setPrecio(nuevoPrecio);
                actual.setDesc(nuevaDesc);
                actual.setAutor(nuevoAutor);
                actual.setFecha(nuevaFecha);
                actual.setVendedor(nuevoVendedor);
                actual.setCantidad(nuevaCantidad);
                return true;
            }
            actual = actual.getSig();
        }

        return false; // No se encontró el producto
    }
}
