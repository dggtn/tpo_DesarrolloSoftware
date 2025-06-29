package modelo.emparejamiento;

import modelo.jugadores.Jugador;

public class EmparejamientoSinRestricciones implements EstrategiaDeEmparejamiento {
    @Override
    public boolean pueddeUnirse(Jugador jugador) {
        return true;
    }
}
