package controlador;

import Repository.JugadorRepositorio;
import modelo.*;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class CrearPartidoController {

    private final Notificador notificador;
    private final JugadorRepositorio repositorioDeJugadores;

    Deporte tipo;
    private int cantidadDeJugadores;
    private String duracion;
    Ubicacion ubicacion;
    Jugador organizador;
    EstrategiaDeEmparejamiento estrategia;
    private String tipoDeDeporte;
    private LocalTime horaInicio;

    public CrearPartidoController(Notificador notificador, JugadorRepositorio repositorioDeJugadores) {
        this.notificador = notificador;
        this.repositorioDeJugadores = repositorioDeJugadores;
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

        // Crear el partido

        // Guardar partido

        // Obtener jugadores
        List<Jugador> interesados = repositorioDeJugadores.buscarPorDeporteFavorito(tipoDeDeporte);

        // Notificar a los jugadores
        notificador.notificar(interesados, "Se creó un partido de tu deporte favorito: " + tipoDeDeporte);

    }
}
