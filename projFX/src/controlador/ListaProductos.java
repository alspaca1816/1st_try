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
    
    public boolean registrarLibro(String nombre, int precio, String desc, String autor, LocalDate fecha, String vendedor) {
        if (existeLibro(nombre)) {
            return false;
        }
        
        Producto nuevoNodo = new Producto(nombre, precio, desc, autor, fecha, vendedor);
        
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
    
    public Producto eliminarLibro() {
        if (estaVacia()) {
            return null;
        }
        
        Producto nodoAtendido = frente;
        
        frente = frente.getSig();
        
        if (frente == null) {
            fin = null;
        } else {
            frente.setAnt(null);
        }
        
        nodoAtendido.setSig(null);
        nodoAtendido.setAnt(null);
     
        return nodoAtendido;
    }
}