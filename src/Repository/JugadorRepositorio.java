package Repository;

import modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

public class JugadorRepositorio {
   List<Jugador> listaJugadores = new ArrayList<>();

    public void guardarJugador(Jugador jugador){
        listaJugadores.add(jugador);
    }
}
