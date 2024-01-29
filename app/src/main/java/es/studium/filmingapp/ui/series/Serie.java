package es.studium.filmingapp.ui.series;

public class Serie {
    private final int imagen;
    private final int titulo;

    public Serie(int imagen, int titulo) {
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
