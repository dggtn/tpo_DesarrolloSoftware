package controlador;

import Repository.PartidoRepositorio;
import modelo.Partido;
import java.util.List;

public class BusquedaController {
    private final PartidoRepositorio partidos;

    public BusquedaController(PartidoRepositorio partidos) {
        this.partidos = partidos;
    }

    public List<Partido> buscarPartidosQueNecesitanJugadores(){
        return partidos.obtenerPartidosPorEstado("Necesitamos Jugadores");
    }
}
