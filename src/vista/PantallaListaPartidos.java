package vista;

import controlador.BusquedaController;
import modelo.Jugador;
import modelo.Partido;

import java.util.List;
import java.util.Map;

public class PantallaListaPartidos extends Pantalla {
    private final BusquedaController busquedaController;

    public PantallaListaPartidos(BusquedaController busquedaController) {
        this.busquedaController = busquedaController;
    }

    @Override
    public Navegacion mostrar(Navegacion origen) {
        Jugador jugadorLogueado = (Jugador) origen.obtenerDelContexto("jugadorLogueado");

        List<Partido> partidosDisponibles = busquedaController.buscarPartidosQueNecesitanJugadores(jugadorLogueado);

        if (partidosDisponibles.isEmpty()) {
            System.out.println("No hay partidos disponibles por el momento. Revisá más tarde.");
            return Navegacion.navegar(Home.class.getSimpleName(), origen.getContexto());
        }

        mostrarListadoDePartidos(partidosDisponibles);

        while (true) {
            int opcion = teclado.leerNumeroEntero(
                    "Seleccioná el número de partido para ver más detalle:",
                    "Ingresá un número entero"
            );

            if (opcion < 1 || opcion > partidosDisponibles.size()) {
                String entrada = teclado.leerTexto("Número inválido. Presioná cualquier tecla para continuar o 'F' para cancelar:");
                if (entrada.equalsIgnoreCase("F")) {
                    return Navegacion.finalizar();
                }

            } else {
                Partido partidoSeleccionado = partidosDisponibles.get(opcion - 1);
                return Navegacion.navegar(
                        PantallaDetallePartido.class.getSimpleName(),
                        Map.of("partidoSeleccionado", partidoSeleccionado,
                                "jugadorLogueado", jugadorLogueado)
                );
            }
        }
    }

    private void mostrarListadoDePartidos(List<Partido> lista) {
        System.out.println("Partidos disponibles");
        System.out.println("#".repeat(50));
        int i = 1;
        for (Partido partido : lista) {
            System.out.printf(
                    "%d - Nombre: %s | Duración: %s | Jugadores: %d | Faltan: %d | Organizador: %s%n",
                    i++,
                    partido.getTipo(),
                    partido.getDuracion(),
                    partido.getCantJugadores(),
                    partido.obtenerCuantosJugadoresFaltan(),
                    partido.getOrganizador().getEmail()
            );
        }
        System.out.println();
    }
}
