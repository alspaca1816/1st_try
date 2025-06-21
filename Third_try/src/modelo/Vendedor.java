package modelo;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Usuario{
    private static int cont = 1000;
    
    private final int codigo;
    private List<Producto> ofertados;
    private List<Resena> resenas;

    public Vendedor(String usuario, String correo, String contrasena, String telefono, char tipo) {
        super(usuario, correo, contrasena, telefono, tipo);
        
        this.codigo = cont++;
        this.ofertados = new ArrayList<>();
        this.resenas = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }
    
    public List<Producto> getOfertados() {
        return ofertados;
    }
    
    public List<Resena> getResenas() {
        return resenas;
    }
    
    public void ofertarLibro(Producto libro) {
        ofertados.add(libro);
    }
    
    public boolean eliminarLibro(int codigo) {
        if (ofertados == null) return false; // porque no se ha inicializado

        for (int i = 0; i < ofertados.size(); i++) {
            if (ofertados.get(i).getId() == codigo) {
                ofertados.remove(i);
                return true;
            }
        }
        return false; // porque no se encontró el libro
    }
    
    public boolean modificarLibro(int codigo, Producto libro) {
        for (Producto p : ofertados) {
            if (p.getId() == codigo) {
                p.setNombre(libro.getNombre());
                p.setPrecio(libro.getPrecio());
                p.setDesc(libro.getDesc());
                p.setAutor(libro.getAutor());
                p.setFecha(libro.getFecha());
                p.setVendedor(libro.getVendedor());
                p.setCantidad(libro.getCantidad());
                return true;
            }
        }
        return false;
    }
    
    public void agregarResena(Resena resena) {
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
        return false; // porque no se encontró el vendedor
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