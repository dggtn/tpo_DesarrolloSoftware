package controlador;

import Repository.JugadorRepositorio;
import modelo.Deporte;
import modelo.Jugador;
import modelo.Nivel;
import modelo.Usuario;

public class RegistroController {

    private String nombre;
    private String email;
    private String contrasena;
    private Deporte deporteFavorito;
    private  Nivel nivelJuego;
    private JugadorRepositorio repositorio;

    public RegistroController(JugadorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void finalizarRegistro(){
        Jugador jugador = new Jugador(nombre, email, contrasena);
        repositorio.guardarJugador(jugador);
        Usuario.logear(nombre, email);
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

    public void setDeporteFavorito(Deporte deporteFavorito) {
        this.deporteFavorito = deporteFavorito;
    }

    public void setNivelJuego(Nivel nivelJuego) {
        this.nivelJuego = nivelJuego;
    }
}
