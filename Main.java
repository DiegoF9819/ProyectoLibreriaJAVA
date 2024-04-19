import libreria.Libreria;
import libros.LibroCienciaFiccion;
import libros.LibroComedia;
import libros.LibroTerror;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de Opciones:");
            System.out.println("1. Agregar Nuevo Libro");
            System.out.println("2. Buscar Libro por Título");
            System.out.println("3. Buscar Libro por Autor");
            System.out.println("4. Mostrar Inventario");
            System.out.println("5. Registrar Usuario");
            System.out.println("6. Realizar Préstamo");
            System.out.println("7. Devolver Libro Prestado");
            System.out.println("8. Salir");

            System.out.print("Por favor, ingrese su opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Elige el Genero");
                    System.out.println("1. Terror");
                    System.out.println("2. Comedia");
                    System.out.println("3. Ciencia Ficción");
                    int generoLibro = sc.nextInt();
                    sc.nextLine();
                    //datos del libro
                    System.out.println("Digite el titulo del libro");
                    String titulo = sc.nextLine();
                    System.out.println("Digite el autor del libro");
                    String autor = sc.nextLine();
                    System.out.println("Digite el isbn del libro");
                    String isbn = sc.nextLine();
                    System.out.println("Digite el editorial del libro");
                    String editorial = sc.nextLine();
                    System.out.println("Digite el año de publicación del libro");
                    int yearPublication = sc.nextInt();
                    System.out.println("Digite precio del libro");
                    double precio = sc.nextDouble();

                    switch (generoLibro){
                        case 1:
                            LibroTerror libroTerror = new LibroTerror(titulo,autor, isbn, editorial, yearPublication, precio);
                            libreria.agregarLibro(libroTerror);
                            break;
                        case 2:
                            LibroComedia libroComedia = new LibroComedia(titulo,autor, isbn, editorial, yearPublication, precio);
                            libreria.agregarLibro(libroComedia);
                            break;
                        case 3:
                            LibroCienciaFiccion libroCienciaFiccion = new LibroCienciaFiccion(titulo,autor, isbn, editorial, yearPublication, precio);
                            libreria.agregarLibro(libroCienciaFiccion);
                            break;
                        default:
                            System.out.println("No valido");
                    }
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Digita el Nombre del Libro");
                    String nombreTitulo = sc.nextLine();
                    libreria.buscarLibroPorTitulo(nombreTitulo);
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Digita el Nombre del Autor del libro");
                    String nombreAutor = sc.nextLine();
                    libreria.buscarLibroPorAutor(nombreAutor);
                    break;
                case 4:
                    libreria.mostrarInventario();
                    break;
                case 5:
                    sc.nextLine();
                    System.out.print("Digita el nombre del usuario: ");
                    String nombreUsuario = sc.nextLine();
                    System.out.print("Digita el numero de cedula: ");
                    int cedula = sc.nextInt();
                    libreria.registrarUsuario(nombreUsuario, cedula);
                    break;
                case 6:
                    sc.nextLine();
                    System.out.println("Digita el nombre del Libro");
                    String nombreLibro = sc.nextLine();
                    System.out.println("Digita el Usuario al que se va a prestar el Libro");
                    String usuario = sc.nextLine();
                    libreria.realizarPrestamo(nombreLibro, usuario);
                    break;
                case 7:
                    sc.nextLine();
                    System.out.print("Digita el Nombre del libro a devolver: ");
                    String nombreLibroDevuelto = sc.nextLine();
                    libreria.devolverLibro(nombreLibroDevuelto);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
            }

        } while (opcion != 8);
    }
}

