package libros;

public class LibroCienciaFiccion extends Libro{
    public LibroCienciaFiccion(String titulo, String autor, String isbn, String editorial, int yearPublication, double precio) {
        super(titulo, autor, isbn, editorial, yearPublication, precio);
    }

    @Override
    public String obtenerGenero() {
        return "Ciencia Ficción";
    }

}
