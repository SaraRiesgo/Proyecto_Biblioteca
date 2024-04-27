package model;

public final class LibroComedia extends Libro {
    private TipoHumor tipoHumor;


    public LibroComedia() {
    }

    public LibroComedia(String autor, int numPaginas, String isbn, TipoHumor tipoHumor) {
        super(autor, numPaginas, isbn);
        this.tipoHumor = tipoHumor;


    }

    @Override
    public String toString() {
        return "Libro Comedia:" +super.toString()+
                ", Tipo de humor: " +tipoHumor.getDescripcion();

    }
}




