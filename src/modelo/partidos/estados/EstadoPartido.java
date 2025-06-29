package modelo.partidos.estados;

import modelo.jugadores.Jugador;
import modelo.partidos.Partido;

public abstract class EstadoPartido {

    protected final Partido partido;

    public EstadoPartido(Partido partido) {
        this.partido = partido;
    }

    public abstract String nombre();
    public void inscribirJugador(Jugador jugador) {
        System.err.println("No se aceptan jugadores para este partido");
    }

    public void participacionAceptada() {
        System.err.println("No se aceptan participaciones para este partido");
    }

    public void actualizar() {
        // Nada
    }
}
