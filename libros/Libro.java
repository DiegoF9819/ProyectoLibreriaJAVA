package libros;

public abstract class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private String editorial;
    private int yearPublication;
    private double precio;

    public Libro(String titulo, String autor, String isbn, String editorial, int yearPublication, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.editorial = editorial;
        this.yearPublication = yearPublication;
        this.precio = precio;
    }

    // Métodos getter y setter para los atributos del libro
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    // Método abstracto para obtener el género del libro
    public abstract String obtenerGenero();

}
