package modelo.notificaciones;

import modelo.jugadores.Jugador;
import modelo.partidos.ObservadorDePartido;
import modelo.partidos.Partido;

import java.util.ArrayList;
import java.util.List;

public class Notificador implements ObservadorDePartido {

    private final List<EstrategiaNotificacion> estrategiasDeNotificacion;

    public Notificador() {
        this.estrategiasDeNotificacion = new ArrayList<>();
    }

    public void agregarEstrategia(EstrategiaNotificacion estrategiaNotificacion) {
        this.estrategiasDeNotificacion.add(estrategiaNotificacion);
    }

    public void notificar(List<Jugador> jugadores, String mensaje) {
        for(Jugador jugador: jugadores) {
            Notificacion notificacion = new Notificacion(jugador, mensaje);
            for (EstrategiaNotificacion estrategiaNotificacion: this.estrategiasDeNotificacion) {
                estrategiaNotificacion.enviar(notificacion);
            }
        }
    }

    @Override
    public void notificarCambioDeEstado(Partido partido, String estadoNuevo) {
        String mensaje = String.format("El partido de %s organizado al que estás inscripto, organizado por %s, cambió a estado %s%n",
                partido.getTipo(),
                partido.getOrganizador().getEmail(),
                estadoNuevo);
        this.notificar(partido.getJugadoresInscriptos(), mensaje);
    }
}
