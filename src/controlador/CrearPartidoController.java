package controlador;

import Repository.JugadorRepositorio;
import Repository.PartidoRepositorio;
import modelo.*;
import modelo.emparejamiento.EstrategiaDeEmparejamiento;
import modelo.jugadores.Jugador;
import modelo.notificaciones.Notificador;
import modelo.partidos.Partido;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class CrearPartidoController {

    private final Notificador notificador;
    private final JugadorRepositorio repositorioDeJugadores;
    private final PartidoRepositorio repositorioDePartido;

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

    public void crearPartido(Jugador jugadorLogueado) {

        Partido partido = new Partido( tipoDeDeporte,  cantidadDeJugadores, duracion, horaInicio, jugadorLogueado);
        partido.agregarJugador(jugadorLogueado);
        repositorioDePartido.guardarPartido(partido);
        partido.agregarObservador(notificador);

        List<Jugador> interesados = repositorioDeJugadores.buscarPorDeporteFavorito(tipoDeDeporte);
        interesados = interesados.stream().filter(jugador -> !jugador.getEmail().equals(jugadorLogueado.getEmail())).collect(Collectors.toList());

        notificador.notificar(interesados, "Se creó un partido de tu deporte favorito: " + tipoDeDeporte);

    //Configurar partido para que solo puedan inscribirse segun el mismo nivel :
//     Los partidos pueden configurarse para permitir jugadores de cualquier nivel o establecer un
//        mínimo/máximo de nivel requerido.
//                Análisis y Diseño Orientado a Objetos
//        Página 2 de 2
//        d. Se podrá definir diferentes algoritmos de emparejamiento (por cercanía, por nivel de
//                habilidad o por historial de partidos previos).


    }
}
