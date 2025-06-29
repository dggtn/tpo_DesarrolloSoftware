package modelo.emparejamiento;

import modelo.jugadores.Jugador;

public interface EstrategiaDeEmparejamiento {
    boolean pueddeUnirse(Jugador jugador);
}
