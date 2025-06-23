package modelo;

public class Usuario {

    public static Usuario usuarioLogueado;
    private String nombre;
    private String email;
    private Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    public static void logear(String nombre, String email) {
        usuarioLogueado = new Usuario(nombre, email);
    }
    public String getEmail() {
        return this.email;
    }
}
