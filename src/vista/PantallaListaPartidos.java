package vista;

import controlador.BusquedaController;
import modelo.Partido;

import java.util.List;

public class PantallaListaPartidos extends Pantalla {
    private final BusquedaController busquedaController;

    public PantallaListaPartidos(BusquedaController busquedaController) {
        this.busquedaController = busquedaController;
    }

    @Override
    public String mostrar() {
        System.out.println("Partidos disponibles");
        System.out.println("#".repeat(10));
        List<Partido> lista = busquedaController.buscarPartidosQueNecesitanJugadores();
        for (Partido partido : lista){
            System.out.printf("Nombre: %s Duracion: %s CantJugadores: %d",partido.getTipo(),
            partido.getDuracion(),partido.getCantJugadores());
            System.out.println();
        }

        return "Fin";
    }
}
