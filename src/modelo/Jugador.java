package modelo;

public class Jugador implements Suscriber {
    String nombre;
    String email;
    String contrasena;
    Deporte deporteFavorito;
    Nivel nivelJuego;
    Ubicacion zona;
    Partido partido;

    public Jugador(String nombre, String email, String contrasena, Deporte deporteFavorito, Nivel nivelJuego, Ubicacion zona, Partido partido) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.deporteFavorito = deporteFavorito;
        this.nivelJuego = nivelJuego;
        this.zona = zona;
        this.partido = partido;
    }

    public void buscarPartido(Ubicacion zona){

        System.out.println("partido");

    }
    public Partido crearPartido(Partido partido ){
        return null;

    }

    public void inscribirsePartido(Partido partido){

    }

    public void cancelarPartido(Partido partido){

    }

    public State verEstadoPartido(Partido partido){
        return partido.getEstado();
    }

    public void cambiarNivel(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Deporte getDeporteFavorito() {
        return deporteFavorito;
    }

    public void setDeporteFavorito(Deporte deporteFavorito) {
        this.deporteFavorito = deporteFavorito;
    }

    public Nivel getNivelJuego() {
        return nivelJuego;
    }

    public void setNivelJuego(Nivel nivelJuego) {
        this.nivelJuego = nivelJuego;
    }

    public Ubicacion getZona() {
        return zona;
    }

    public void setZona(Ubicacion zona) {
        this.zona = zona;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", deporteFavorito=" + deporteFavorito +
                ", nivelJuego=" + nivelJuego +
                ", zona=" + zona +
                ", partido=" + partido +
                '}';
    }

    @Override
    public void actualizarPartido(Partido partido) {

    }
}


