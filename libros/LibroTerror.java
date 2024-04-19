package libros;

public class LibroTerror extends Libro{
    public LibroTerror(String titulo, String autor, String isbn, String editorial, int yearPublication, double precio) {
        super(titulo, autor, isbn, editorial, yearPublication, precio);
    }

    @Override
    public String obtenerGenero() {
        return "Terror";
    }

}