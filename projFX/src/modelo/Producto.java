package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Producto {
    private static int cont = 10000;
    
    private final int id;
    private String nombre;
    private int precio;
    private String desc;
    private String autor;
    private LocalDate fecha; // fecha de publicación del libro
    private String vendedor; // codigo del vendedor para relacionar con ListaVendedores
    private int cantidad;
    private List<Resena> resenas;
    
    Producto sig, ant;

    public Producto(String nombre, int precio, String desc, String autor, LocalDate fecha, String vendedor, int cantidad) {
        this.id = cont++;
        this.nombre = nombre;
        setPrecio(precio);
        this.desc = desc;
        this.autor = autor;
        this.fecha = fecha;
        this.vendedor = vendedor;
        setCantidad(cantidad);
        this.resenas = new ArrayList<>();
        
        this.sig = null;
        this.ant = null;
    }
    
    public int getId() {
        return id;
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
        if (precio > 0) {
            this.precio = precio;
        } else {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad >= 0) {
            this.cantidad = cantidad;
        } else {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
    }
    
    public List<Resena> getResenas() {
        return resenas;
    }
    
    public void resenar(Resena resena) {
        resenas.add(resena);
    }
    
    public boolean eliminarResena(int codigo) {
        if (resenas == null) return false; // porque no se ha inicializado

        for (int i = 0; i < resenas.size(); i++) {
            if (resenas.get(i).getId() == codigo) {
                resenas.remove(i);
                return true;
            }
        }
        return false; // porque no se encontró el libro
    }
    
    public boolean modificarReseña(int id, String autorActual, String nuevoContenido, int nuevaCalificacion) {
        for (Resena r : resenas) {
            if (r.getId() == id && r.getAutor().equals(autorActual)) {
                r.setContenido(nuevoContenido);
                r.setCalificacion(nuevaCalificacion);
                return true;
            }
        }
        return false;
    }
    
    public String valoracion(List<Resena> resenas) {
        if (resenas == null || resenas.isEmpty()) {
        return "N/A"; // No hay reseñas, el promedio no existe
        }

        int suma = 0;
        for (Resena r : resenas) {
            suma += r.getCalificacion();
        }

        double promedio = (double) suma / resenas.size(); // Cast a double para evitar división entera
        return String.format("%.2f", promedio);
    }
}