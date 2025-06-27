package controlador;

import Repository.PartidoRepositorio;
import modelo.Jugador;
import modelo.Partido;
import java.util.List;
import java.util.stream.Collectors;

public class BusquedaController {
    private final PartidoRepositorio partidos;

    public BusquedaController(PartidoRepositorio partidos) {
        this.partidos = partidos;
    }

    public List<Partido> buscarPartidosQueNecesitanJugadores(Jugador jugadorLogueado){

        List<Partido> partidosQueNecesitanJugadores = partidos.obtenerPartidosPorEstado("Necesitamos Jugadores");
        return partidosQueNecesitanJugadores.stream()
                .filter(partido -> !partido.getOrganizador().getEmail().equals(jugadorLogueado.getEmail()))
                .collect(Collectors.toList());
    }
}
