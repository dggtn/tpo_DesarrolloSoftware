package modelo;

import java.util.ArrayList;
import java.util.List;

public class Notificador {

    private List<EstrategiaNotificacion> estrategiasDeNotificacion;

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
}
