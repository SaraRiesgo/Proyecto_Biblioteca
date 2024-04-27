package model;

public final class LibroTerror extends Libro{
    private int calificacion;

    public LibroTerror() {
    }

    public LibroTerror(String autor, int numPaginas, String isbn,int calificacion) {
        super(autor, numPaginas, isbn);
        this.calificacion = calificacion;

    }

    @Override
    public String toString() {
        return "Libro Terror: " + super.toString() + ", Calificación: " +calificacion;

    }



    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
