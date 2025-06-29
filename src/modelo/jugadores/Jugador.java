package modelo.jugadores;

import modelo.Suscriber;
import modelo.Ubicacion;
import modelo.Usuario;
import modelo.partidos.ConfirmacionParticipacion;
import modelo.partidos.Partido;
import modelo.partidos.estados.EstadoPartido;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements Suscriber, Usuario {
    private String nombre;
    private String email;
    private String contrasena;
    private String deporteFavorito;
    private Nivel nivelJuego;
    Ubicacion zona;

    private List<Partido> partidosInscriptos;
    private List<ConfirmacionParticipacion> confirmacionesPendientes;

    public Jugador(String nombre, String email, String contrasena,String deporteFavorito, Nivel nivelJuego) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.deporteFavorito = deporteFavorito;
        this.nivelJuego = nivelJuego;
        this.zona = zona;
        this.partidosInscriptos = new ArrayList<>();
        this.confirmacionesPendientes = new ArrayList<>();
    }

    public void buscarPartido(Ubicacion zona){

        System.out.println("partido");

    }
    public Partido crearPartido(Partido partido ){
        return null;

    }

    public void inscribirsePartido(Partido partido){
        this.partidosInscriptos.add(partido);
        partido.inscribirJugador(this);
    }

    public void cancelarPartido(Partido partido){

    }

    public EstadoPartido verEstadoPartido(Partido partido){
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

    public String getDeporteFavorito() {
        return deporteFavorito;
    }

    public void setDeporteFavorito(String deporteFavorito) {
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

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", deporteFavorito=" + deporteFavorito +
                ", nivelJuego=" + nivelJuego +
                ", zona=" + zona +
                '}';
    }

    @Override
    public void actualizarPartido(Partido partido) {

    }

    public void agregarConfirmacionPendiente(ConfirmacionParticipacion confirmacionParticipacion) {
        this.confirmacionesPendientes.add(confirmacionParticipacion);
    }

    public List<ConfirmacionParticipacion> obtenerConfirmacionesPendientes() {
        return confirmacionesPendientes;
    }
}


