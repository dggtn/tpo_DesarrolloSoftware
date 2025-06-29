package modelo.emparejamiento;

import modelo.jugadores.Jugador;
import modelo.jugadores.Nivel;

public class EmparejarPorNivel implements EstrategiaDeEmparejamiento {

    private Nivel nivelMinimo;
    private Nivel nivelMaximo;

    public EmparejarPorNivel(Nivel nivelMinimo, Nivel nivelMaximo) {
        this.nivelMinimo = nivelMinimo;
        this.nivelMaximo = nivelMaximo;
    }

    @Override
    public boolean pueddeUnirse(Jugador jugador) {

        Nivel nivelJugador = jugador.getNivelJuego();
        return nivelJugador.ordinal() >= this.nivelMinimo.ordinal() && nivelJugador.ordinal() <= this.nivelMaximo.ordinal();
    }
}
