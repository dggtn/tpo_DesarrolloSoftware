package controlador;

import Repository.JugadorRepositorio;
import modelo.jugadores.Jugador;
import modelo.jugadores.Nivel;

public class RegistroController {

    private String nombre;
    private String email;
    private String contrasena;
    private String deporteFavorito;
    private  Nivel nivelJuego;
    private JugadorRepositorio repositorio;

    public RegistroController(JugadorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Jugador finalizarRegistro(){
        Jugador jugador = new Jugador(nombre, email, contrasena, deporteFavorito, nivelJuego);
        repositorio.guardarJugador(jugador);
        return jugador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setDeporteFavorito(String deporteFavorito) {
        this.deporteFavorito = deporteFavorito;
    }

    public void setNivelJuego(Nivel nivelJuego) {
        this.nivelJuego = nivelJuego;
    }
}
