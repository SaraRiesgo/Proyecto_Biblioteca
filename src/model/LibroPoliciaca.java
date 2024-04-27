package model;

import java.util.Arrays;

public final class LibroPoliciaca extends Libro{
    private String[]personajes;
    private Trama trama;

    public LibroPoliciaca() {
    }

    public LibroPoliciaca(String autor, int numPaginas, String isbn,String[]personajes, Trama trama) {
        super(autor, numPaginas, isbn);
        this.trama = trama;
        this.personajes = personajes;

    }

    @Override
    public String toString() {
        return "Libro Policiaca: " + super.toString() +
                ", Personajes: " + Arrays.toString(personajes) +
                ", Trama: " + trama.getDescripcion();
    }


    public String[] getPersonajes() {
        return personajes;
    }

    public void setPersonajes(String[] personajes) {
        this.personajes = personajes;
    }
}
