package libros;

public class LibroComedia extends Libro{
    public LibroComedia(String titulo, String autor, String isbn, String editorial, int yearPublication, double precio) {
        super(titulo, autor, isbn, editorial, yearPublication, precio);
    }

    @Override
    public String obtenerGenero() {
        return "Comedia";
    }

}
