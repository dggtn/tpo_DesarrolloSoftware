package controlador;

import Repository.JugadorRepositorio;
import modelo.Deporte;
import modelo.Jugador;
import modelo.Nivel;

public class IniciarSesionController {
    private String email;
    private String contrasena;
    private Deporte deporteFavorito;
    private Nivel nivelJuego;
    private JugadorRepositorio repositorio;

    public IniciarSesionController(JugadorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void finalizarInicio(){
        Jugador jugador = new Jugador(contrasena,email);
        repositorio.guardarJugador(jugador);


    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }
}
