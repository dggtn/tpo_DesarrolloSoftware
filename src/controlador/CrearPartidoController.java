package controlador;

import Repository.JugadorRepositorio;
import Repository.PartidoRepositorio;
import modelo.*;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class CrearPartidoController {

    private final Notificador notificador;
    private final JugadorRepositorio repositorioDeJugadores;
    private final PartidoRepositorio repositorioDePartido;

    String tipo;
    private int cantidadDeJugadores;
    private String duracion;
    Ubicacion ubicacion;
    Jugador organizador;
    EstrategiaDeEmparejamiento estrategia;

    private String tipoDeDeporte;
    private LocalTime horaInicio;

    public CrearPartidoController(Notificador notificador, JugadorRepositorio repositorioDeJugadores, PartidoRepositorio repositorioDePartido) {
        this.notificador = notificador;
        this.repositorioDeJugadores = repositorioDeJugadores;
        this.repositorioDePartido = repositorioDePartido;
    }

    public void setTipoDeDeporte(String tipoDeDeporte) {
        this.tipoDeDeporte = tipoDeDeporte;
    }

    public void setCantidadDeJugadores(int cantidadDeJugadores) {
        this.cantidadDeJugadores = cantidadDeJugadores;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void crearPartido() {

        Partido partido = new Partido( tipo,  cantidadDeJugadores, duracion, horaInicio,Usuario.usuarioLogueado);

        repositorioDePartido.guardarPartido(partido);

        // Obtener jugadores

        List<Jugador> interesados = repositorioDeJugadores.buscarPorDeporteFavorito(tipoDeDeporte);
        interesados = interesados.stream().filter(jugador -> !jugador.getEmail().equals(Usuario.usuarioLogueado.getEmail())).collect(Collectors.toList());

        // Notificar a los jugadores
        notificador.notificar(interesados, "Se creó un partido de tu deporte favorito: " + tipoDeDeporte);

    }
}
