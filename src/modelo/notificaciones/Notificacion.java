package modelo.notificaciones;

import modelo.jugadores.Jugador;

public class Notificacion {
    private Jugador jugador;
    private String mensaje;

    public Notificacion(Jugador jugador, String mensaje) {
        this.jugador = jugador;
        this.mensaje = mensaje;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public String getMensaje() {
        return mensaje;
    }
}
