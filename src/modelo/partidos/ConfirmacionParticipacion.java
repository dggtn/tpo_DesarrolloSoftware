package modelo.partidos;

import modelo.jugadores.Jugador;

public class ConfirmacionParticipacion {
    private final Partido partido;
    private final Jugador jugador;

    private boolean confirmado;

    public ConfirmacionParticipacion(Jugador jugador, Partido partido) {
        this.jugador = jugador;
        this.partido = partido;
        this.confirmado = false;
    }

    public Partido getPartido() {
        return this.partido;
    }

    public void confirmar() {
        this.confirmado = true;
        partido.participacionAceptada();
    }

    public boolean estaPendiente() {
        return !this.confirmado;
    }
}
