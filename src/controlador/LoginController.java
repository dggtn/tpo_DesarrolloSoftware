package controlador;

import Repository.JugadorRepositorio;
import modelo.Jugador;
import modelo.Usuario;

import java.util.Optional;

public class LoginController {

    private final JugadorRepositorio repositorioDeJugadores;

    public LoginController(JugadorRepositorio repositorioDeJugadores) {
        this.repositorioDeJugadores = repositorioDeJugadores;
    }

    public boolean autenticar(String email, String password) {

        Optional<Jugador> jugadorOptional = this.repositorioDeJugadores.buscarPorEmailYPassword(email, password);

        if (jugadorOptional.isPresent()) {
            Jugador jugador = jugadorOptional.get();
            Usuario.logear(jugador.getNombre(), jugador.getEmail());
            return true;
        }

        return false;
    }
}
