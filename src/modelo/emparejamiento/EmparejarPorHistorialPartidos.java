package modelo.emparejamiento;

import modelo.jugadores.Jugador;

public class EmparejarPorHistorialPartidos implements EstrategiaDeEmparejamiento {
    @Override
    public boolean pueddeUnirse(Jugador jugador) {
        return false;
    }
}
