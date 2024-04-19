package prestamo;

public class Usuario {
    private String nombre;
    private int cedula;

    public Usuario(String nombre, int cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCedula() {
        return cedula;
    }
}
