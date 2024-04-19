package libreria;

import libros.Libro;
import libros.LibroCienciaFiccion;
import libros.LibroComedia;
import libros.LibroTerror;
import prestamo.Prestamo;
import prestamo.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Libreria {
    private HashMap<String, Libro> inventario;
    private List<Prestamo> prestamos;
    private List<Usuario> usuariosRegistrados;
    public Libreria() {
        inventario = new HashMap<>();
        prestamos = new ArrayList<>();
        usuariosRegistrados = new ArrayList<>();
    }

    // Método para agregar un libro al inventario
    public void agregarLibro(Libro libro) {
        inventario.put(libro.getTitulo(), libro);
    }

    // Método para buscar un libro por su título
    public void buscarLibroPorTitulo(String titulo) {
        boolean encontrado = false;
        for (Libro libro : inventario.values()) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("El libro " + libro.getTitulo() + " del autor " + libro.getAutor()
                                + " publicado en el año " + libro.getYearPublication() +
                                " Pertenece al genero de " + libro.obtenerGenero()
                                );
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron libros con el titulo de " + titulo);
        }
    }

    // Método para buscar libros por autor
    public void buscarLibroPorAutor(String autor) {
        boolean encontrado = false;
        for (Libro libro : inventario.values()) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                System.out.println("El libro " + libro.getTitulo() + " del autor " + libro.getAutor()
                        + " publicado en el año " + libro.getYearPublication() +
                        " Pertenece al genero de " + libro.obtenerGenero()
                );
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron libros del autor " + autor);
        }
    }

    // Método para mostrar el inventario de la librería
    public void mostrarInventario() {
        System.out.println("**********|Inventario|**********");
        boolean hasTerror = false;
        boolean hasComedia = false;
        boolean hasCienciaFiccion = false;

        for (Libro libro : inventario.values()) {
            if(libro instanceof LibroTerror){
                hasTerror = true;
            }else if(libro instanceof LibroComedia) {
                hasComedia = true;
            }else if(libro instanceof LibroCienciaFiccion){
                hasCienciaFiccion = true;
            }
        }

        if(hasTerror){
            System.out.println();
            System.out.println("**********************************************|Genero Terror|****************************************************************");
            for(Libro libro : inventario.values()){
                if(libro instanceof LibroTerror){
                    System.out.println("*" + libro.getTitulo() + " del autor " + libro.getAutor() + " publicado en el año " + libro.getYearPublication() + "*");
                }
            }
            System.out.println("*****************************************************************************************************************************");
        }
        if(hasComedia){
            System.out.println();
            System.out.println("**********************************************|Genero Comedia|***************************************************************");
            for(Libro libro : inventario.values()){
                if(libro instanceof LibroComedia){
                    System.out.println("*" + libro.getTitulo() + " del autor " + libro.getAutor() + " publicado en el año " + libro.getYearPublication() + "*");
                }
            }
            System.out.println("*****************************************************************************************************************************");
        }
        if(hasCienciaFiccion){
            System.out.println();
            System.out.println("**********************************************|Ciencia Ficcion|**************************************************************");
            for(Libro libro : inventario.values()){
                if(libro instanceof LibroCienciaFiccion){
                    System.out.println("*" + libro.getTitulo() + " del autor " + libro.getAutor() + " publicado en el año " + libro.getYearPublication() + "*");
                }
            }
            System.out.println("*****************************************************************************************************************************");
        }

        if(inventario.isEmpty()){
            System.out.println("No hay Libros Registrados aun");
            System.out.println("*******************************");
        }
    }
    // Método para registrar un nuevo usuario
    public void registrarUsuario(String nombre, int cedula) {
        Usuario nuevoUsuario = new Usuario(nombre, cedula);
        usuariosRegistrados.add(nuevoUsuario);
        System.out.println("Usuario registrado con éxito.");
    }

    // Método para realizar un préstamo de un libro a un usuario
    public void realizarPrestamo(String tituloLibro, String nombreUsuario) {
        Libro libro = buscarLibroPorTituloIgnoreCase(tituloLibro);
        Usuario usuario = buscarUsuarioPorNombre(nombreUsuario);

        if (libro != null && usuario != null) {
            if (!estaPrestado(libro)) {
                // Crear un nuevo objeto de Prestamo y agregarlo a la lista de préstamos
                Prestamo prestamo = new Prestamo(new Date(), usuario, libro);
                prestamos.add(prestamo);
                System.out.println("Préstamo realizado con éxito.");
            } else {
                System.out.println("El libro ya ha sido prestado.");
            }
        } else {
            System.out.println("El libro o el usuario no existen en la librería.");
        }
    }

    // Método para devolver un libro prestado
    public void devolverLibro(String tituloLibro) {
        Prestamo prestamo = buscarPrestamoPorTitulo(tituloLibro);
        if (prestamo != null) {
            prestamos.remove(prestamo);
            System.out.println("Libro devuelto con éxito.");
        } else {
            System.out.println("El libro no está prestado o no existe en la librería.");
        }
    }

    // Método para verificar si un libro está prestado
    private boolean estaPrestado(Libro libro) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibro().equals(libro)) {
                return true;
            }
        }
        return false;
    }

    // Método para buscar un préstamo por el título del libro
    private Prestamo buscarPrestamoPorTitulo(String tituloLibro) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibro().getTitulo().equalsIgnoreCase(tituloLibro)) {
                return prestamo;
            }
        }
        return null;
    }

    // Método privado para buscar un usuario por su nombre
    private Usuario buscarUsuarioPorNombre(String nombreUsuario) {
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getNombre().equalsIgnoreCase(nombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }
    // Método para buscar un libro por su título, ignorando las diferencias entre mayúsculas y minúsculas
    private Libro buscarLibroPorTituloIgnoreCase(String tituloLibro) {
        for (Libro libro : inventario.values()) {
            if (libro.getTitulo().equalsIgnoreCase(tituloLibro)) {
                return libro;
            }
        }
        return null;
    }
}
