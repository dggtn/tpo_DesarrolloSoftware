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
        System.err.println("Ya no se aceptan jugadores para este partido");
    }
}
