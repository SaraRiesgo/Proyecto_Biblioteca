package model;

public abstract class Libro {
    private String autor, isbn;
    private int numPaginas;



    public Libro() {
    }

    public Libro(String autor, int numPaginas, String isbn) {
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Autor:'" + autor + '\'' +
                ", ISBN:'" + isbn + '\'' +
                ", Número de páginas:" + numPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
