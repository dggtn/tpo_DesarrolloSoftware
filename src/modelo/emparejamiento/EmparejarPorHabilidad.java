package modelo.emparejamiento;

import modelo.jugadores.Jugador;

public class EmparejarPorHabilidad implements EstrategiaDeEmparejamiento {
    @Override
    public boolean pueddeUnirse(Jugador jugador) {
        return false;
    }
}
