package modelo;

public class Resena {
    private static int cont = 1;
    
    private final int id;
    private final String autor; // usuario del comprador que hizo la reseña
    private final int codigo; // id del vendedor o producto a reseñar
    private String contenido;
    private int calificacion; // del 1 al 5
    
    public Resena(String autor, int codigo, String contenido, int calificacion) {
        this.id = cont++;
        this.autor = autor;
        this.codigo = codigo;
        this.contenido = contenido;
        setCalificacion(calificacion);
    }
    
    public int getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        if (calificacion <= 5 && calificacion >= 1) {
            this.calificacion = calificacion;
        } else {
            throw new IllegalArgumentException("Las reseñas van del 1 al 5, intente nuevamente");
        }
    }
    
    @Override
    public String toString() {
        return " " + contenido +
               "Calificación: " + calificacion + "★ "+
               "Comentario:" + contenido +
               "Autor: " + autor;
    }
}