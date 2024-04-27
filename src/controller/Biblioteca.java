package controller;

import model.Libro;
import utils.CatalogoException;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private String nombre;
    private String director;
    private Catalogo catalogo;
    Scanner scanner = new Scanner(System.in);


    public Biblioteca() {
    }

    public Biblioteca(String nombre, String director) {
        this.nombre = nombre;
        this.director = director;
    }

    public void mostrarDatosBiblioteca() {
        System.out.println("***** BIENVENID@ A LA BIBLIOTECA VIRTUAL *****");
        System.out.println("Nombre: " + nombre);
        System.out.println("Directora asignada: " + director);

    }

    public void construirCatalogo(int tamanioCatalogo) {
        this.catalogo = new Catalogo(tamanioCatalogo);
        System.out.println("Creando el CATÁLOGO virtual de libros...");
        System.out.println("Se ha creado un catálogo de " +tamanioCatalogo+ " libros.");
        System.out.println();
    }


    public void numLibrosCatalogo(){
        if(catalogo != null){
            int numLibros = catalogo.getListaLibros().size();
            System.out.println("Actualmente, el número de libros que hay en total en el catálogo es de "+numLibros+ " libros.");

        }else{
            System.out.println("Aún no se ha construido el catálogo.");
        }

    }

    public void agregarLibroCatalogo(Libro libro)throws CatalogoException{

        if(catalogo.getListaLibros().size() >= catalogo.capacidadMax){
            throw new CatalogoException("¡ATENCIÓN! El catálogo se encuentra lleno, no se pueden agregar más libros");
        }else{
            catalogo.agregarLibro(libro);
            System.out.println("Agregando LIBROS al catálogo...");
            System.out.println("Libro agregado correctamente al catálogo.");
        }

    }

    public void sacarLibroCatalogo(String isbn) {
        if (catalogo != null){
            catalogo.eliminarLibro(isbn);

        }else{
            System.out.println("El catálogo aún no se ha construido.");
        }

    }

    public void mostrarLibrosCatalogo() {
        catalogo.mostrarLibros();
    }

    public void buscarInfoLibro() {

        /*System.out.println("Introduce el ISBN del libro para obtener la información");*/
        String isbnDado = scanner.next();
        for (Libro libro : catalogo.getListaLibros()) {
            if (libro.getIsbn().equals(isbnDado)) {
                System.out.println("El libro que buscas tiene los siguientes datos:");
                System.out.println(libro);
                return;

            }
        }
        System.out.println("No existe información para este libro porque no existe en el catálogo.");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    class Catalogo {
        private ArrayList<Libro> listaLibros;
        private int capacidadMax;

        public Catalogo(int capacidadMax) {
            this.listaLibros = new ArrayList<>();
            this.capacidadMax = capacidadMax;
        }

        public void agregarLibro(Libro libro) {
            if (listaLibros.size() < capacidadMax) {
                listaLibros.add(libro);
            }
        }

        public ArrayList<Libro> getListaLibros() {
            return listaLibros;
        }

        public void mostrarLibros() {
            System.out.println();
            System.out.println("Mostrando información de los libros que hay en el catálogo:");
            for (Libro libro : listaLibros) {
                System.out.println(libro);
            }
        }

        public void eliminarLibro(String isbn) {
            for (Libro libro : listaLibros) {
                if (libro.getIsbn().equals(isbn)) {
                    listaLibros.remove(libro);
                    System.out.println("El libro con ISBN " +libro.getIsbn()+ " se ha eliminado del catálogo");
                    return;
                }
            }
            System.out.println("No se ha encontrado ningún libro en el catálogo con el ISBN dado.");

        }
    }
}
