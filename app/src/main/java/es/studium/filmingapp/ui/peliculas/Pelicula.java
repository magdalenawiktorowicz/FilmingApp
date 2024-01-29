package es.studium.filmingapp.ui.peliculas;

public class Pelicula {
    private final int imagen;
    private final int titulo;

    public Pelicula(int imagen, int titulo) {
        this.imagen = imagen;
        this.titulo = titulo;
    }

    public int getImagen() {
        return imagen;
    }

    public int getTitulo() {
        return titulo;
    }
}
