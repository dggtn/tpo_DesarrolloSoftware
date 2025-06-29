package modelo.partidos.estados;

import modelo.jugadores.Jugador;
import modelo.partidos.ConfirmacionParticipacion;
import modelo.partidos.Partido;

import java.util.List;

public class Inicial extends EstadoPartido {

    public Inicial(Partido partido) {
        super(partido);
    }

    @Override
    public String nombre() {
        return "Necesitamos Jugadores";
    }

    @Override
    public void inscribirJugador(Jugador jugador) {
        this.partido.agregarJugador(jugador);
        if (this.partido.obtenerCuantosJugadoresFaltan() == 0) {

            List<Jugador> inscriptos = partido.getJugadoresInscriptos();
            inscriptos.forEach((jugadorInscripto ->
                    jugadorInscripto.agregarConfirmacionPendiente(new ConfirmacionParticipacion(jugadorInscripto, partido))));

            this.partido.cambiarEstado(new Armado(this.partido));
        }
    }
}
