package modelo;

import java.time.LocalDate;

public class Producto {
    private String nombre;
    private int precio;
    private String desc;
    private String autor;
    private LocalDate fecha;
    private String vendedor; // codigo del vendedor para relacionar con ListaVendedores
    
    Producto sig, ant;

    public Producto(String nombre, int precio, String desc, String autor, LocalDate fecha, String vendedor) {
        this.nombre = nombre;
        this.precio = precio;
        this.desc = desc;
        this.autor = autor;
        this.fecha = fecha;
        this.vendedor = vendedor;
        
        this.sig = null;
        this.ant = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public Producto getSig() {
        return sig;
    }

    public void setSig(Producto sig) {
        this.sig = sig;
    }

    public Producto getAnt() {
        return ant;
    }

    public void setAnt(Producto ant) {
        this.ant = ant;
    }
    
    public String fecha() {
        return getFecha().toString();
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
}