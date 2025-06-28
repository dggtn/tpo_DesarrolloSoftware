package controlador;

import Repository.JugadorRepositorio;
import modelo.jugadores.Jugador;

import java.util.Optional;

public class LoginController {

    private final JugadorRepositorio repositorioDeJugadores;

    public LoginController(JugadorRepositorio repositorioDeJugadores) {
        this.repositorioDeJugadores = repositorioDeJugadores;
    }

    public Optional<Jugador> autenticar(String email, String password) {
        return this.repositorioDeJugadores.buscarPorEmailYPassword(email, password);
    }
}
