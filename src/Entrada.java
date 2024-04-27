import controller.Biblioteca;
import model.*;
import utils.CatalogoException;

import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) /*throws CatalogoException*/ {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Libro> libros = new ArrayList<>();

        Biblioteca biblioteca = new Biblioteca("Biblioteca Luis Chamizo", "Sara Riesgo Espinosa");
        biblioteca.mostrarDatosBiblioteca();
        System.out.println();
        biblioteca.construirCatalogo(4);
        Libro libro1 = new LibroComedia("David Safier", 320, "9876A", TipoHumor.absurdo);
        Libro libro2 = new LibroTerror("Antonio Runa", 496, "0432C", 6);
        Libro libro3 = new LibroPoliciaca("Javier Castillo", 448, "6780M", new String[]{"Daniel Miller,Miren Triggs"}, Trama.intriga);
        Libro libro4 = new LibroTerror("Mark Samuels", 288, "2190P", 8);
        Libro libro5 = new LibroComedia("María Dueñas", 224, "8743V", TipoHumor.negro);
        Libro libro6 = new LibroPoliciaca("Carmen Mola", 544, "3457B", new String[]{"Clara,Lucía, Donoso"}, Trama.misterio);
        Libro libro7 = new LibroTerror("Guillermo del Toro", 600, "0932F", 8);
        Libro libro8 = new LibroPoliciaca("Agatha Christie", 430, "0067L", new String[]{"Thomas Harris, Sam Spade"}, Trama.intriga);
        Libro libro9 = new LibroComedia("Anónimo", 180, "1168Z", TipoHumor.absurdo);
        Libro libro10 = new LibroTerror("Isabel Allende", 550, "4558N", 7);
        //Añadir los libros al Arraylist de libros para que aparezcan en un depósito
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro4);
        libros.add(libro5);
        libros.add(libro6);
        libros.add(libro7);
        libros.add(libro8);
        libros.add(libro9);
        libros.add(libro10);

        try {
            biblioteca.agregarLibroCatalogo(libro1);
            biblioteca.agregarLibroCatalogo(libro4);
            biblioteca.agregarLibroCatalogo(libro6);
            biblioteca.agregarLibroCatalogo(libro7);
            //Al intentar agregar el quinto libro, salta la excepción de catálogo lleno
            biblioteca.agregarLibroCatalogo(libro9);
        } catch (CatalogoException e) {
            System.out.println(e.getMessage());
        }
        biblioteca.mostrarLibrosCatalogo();
        System.out.println();
        System.out.println("Lista de libros disponibles en el depósito:");
        for (Libro libro : libros) {
            System.out.println(libro.getAutor() + " " + libro.getIsbn());

        }

        System.out.println("--------------------------------------------------------------");
        int opcion;
        do {
            System.out.println("¿Qué quieres hacer? Selecciona una de las opciones del menú:\n" +
                    "1. Agregar libros al catálogo\n" +
                    "2. Consultar el número de libros que hay en el catálogo\n" +
                    "3. Eliminar libro del catálogo\n" +
                    "4. Buscar información de algún libro del catálogo\n" +
                    /*"4. Buscar información de algún libro del catálogo\n" +*/
                    "5. Mostrar información de los libros que hay actualmente en el catálogo\n" +
                    "6. Salir ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    do {
                        try {
                            System.out.println("Introduce ISBN del libro que quieres agregar:");
                            String isbnAgregar = scanner.next();
                            Libro libroElegido = null;
                            for (Libro libro : libros) {
                                if (libro.getIsbn().equals(isbnAgregar)) {
                                    //biblioteca.agregarLibroCatalogo(libroElegido);
                                    libroElegido = libro;
                                    break;
                                }
                            }
                            if (libroElegido != null) {
                                biblioteca.agregarLibroCatalogo(libroElegido);
                            } else {
                                System.out.println("No se encontró ningún libro con el ISBN dado.");
                                break;
                            }
                        } catch (CatalogoException e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                    } while (false);
                    break;

                case 2:
                    biblioteca.numLibrosCatalogo();
                    break;

                case 3:
                    System.out.println("Introduce el ISBN del libro que quieres eliminar del catálogo:");
                    String isbnEliminar = scanner.next();
                    biblioteca.sacarLibroCatalogo(isbnEliminar);
                    break;

                case 4:
                    System.out.println("Introduce el ISBN del libro para mostrar su información:");
                    String isbnBuscar = scanner.nextLine();
                    biblioteca.buscarInfoLibro();
                    break;

                case 5:
                    biblioteca.mostrarLibrosCatalogo();
                    break;

                case 6:
                    System.out.println("Saliendo de la Biblioteca virtual....");
                    break;
            }
        } while (opcion != 6);
    }
}
