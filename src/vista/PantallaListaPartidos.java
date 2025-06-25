package vista;

import controlador.BusquedaController;
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

        List<Partido> lista = busquedaController.buscarPartidosQueNecesitanJugadores();
        Navegacion resultado = Navegacion.finalizar();
        boolean cancelarVerDetalle = false;
        boolean hayPartidoSeleccionado = false;

        System.out.println("Partidos disponibles");
        System.out.println("#".repeat(10));

        int n= 0;
        for (Partido partido : lista){
            n+=1;
            System.out.printf("%d - Nombre: %s Duracion: %s CantJugadores: %d",n, partido.getTipo(),
                    partido.getDuracion(),partido.getCantJugadores());
            System.out.println();
        }

        System.out.println();
        do {
            int opcion = this.teclado.leerNumeroEntero("Seleccioná el número de partido para ver mas detalle:", "Ingresá un número entero");

            if (opcion < 0 || opcion > lista.size()) {
                char letra = teclado.leerTexto("Número de partido inválido. Ingrese cualquier tecla para continuar o 'F' para cancelar").charAt(0);
                cancelarVerDetalle = letra == 'F';
            } else {
                Partido partidoSeleccionado = lista.get(opcion - 1);
                hayPartidoSeleccionado = true;
                resultado = Navegacion.navegar("DetallePartido", Map.of("partidoSeleccionado", partidoSeleccionado));
            }

        }while(!hayPartidoSeleccionado && !cancelarVerDetalle);

        return resultado;
    }
}
