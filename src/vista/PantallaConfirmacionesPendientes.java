package vista;

import modelo.jugadores.Jugador;
import modelo.partidos.ConfirmacionParticipacion;
import modelo.partidos.Partido;

import java.util.List;
import java.util.stream.Collectors;

public class PantallaConfirmacionesPendientes extends Pantalla {

    @Override
    public Navegacion mostrar(Navegacion origen) {

        Jugador jugadorLogueado = (Jugador) origen.obtenerDelContexto("jugadorLogueado");

        List<ConfirmacionParticipacion> confirmacionesPendientes = jugadorLogueado.obtenerConfirmacionesPendientes()
                .stream()
                .filter(ConfirmacionParticipacion::estaPendiente)
                .collect(Collectors.toList());

        if (!confirmacionesPendientes.isEmpty()) {

            this.mostrarConfirmacionesPendintes(confirmacionesPendientes);

            while (true) {
                int opcion = teclado.leerNumeroEntero(
                        "Seleccioná el número de confirmación para aceptar tu participación:",
                        "Ingresá un número entero"
                );

                if (opcion < 1 || opcion > confirmacionesPendientes.size()) {
                    String entrada = teclado.leerTexto("Número inválido. Presioná cualquier tecla para continuar o 'F' para volver al home:");
                    if (entrada.equalsIgnoreCase("F")) {
                        return Navegacion.navegar(Home.class.getSimpleName(), origen.getContexto());
                    }

                } else {
                    ConfirmacionParticipacion confirmacionParticipacion = confirmacionesPendientes.get(opcion - 1);
                    confirmacionParticipacion.confirmar();
                    return Navegacion.navegar(Home.class.getSimpleName(), origen.getContexto());
                }
            }

        } else {
            System.out.println("¡No tienes confirmaciones pendients!");
            return Navegacion.navegar(Home.class.getSimpleName(), origen.getContexto());
        }
    }

    private void mostrarConfirmacionesPendintes(List<ConfirmacionParticipacion> confirmacionesPendientes) {
        System.out.printf("Tienes (%d) conformaciones pendientes... %n", confirmacionesPendientes.size());
        System.out.println("#".repeat(50));
        int i = 1;
        for (ConfirmacionParticipacion confirmacionPendiente :confirmacionesPendientes) {
            Partido partido = confirmacionPendiente.getPartido();
            System.out.printf(
                    "%d - Nombre: %s | Duración: %s | Hora: %s | Organizador: %s%n",
                    i++,
                    partido.getTipo(),
                    partido.getDuracion(),
                    partido.getHorario(),
                    partido.getOrganizador().getEmail()
            );
        }
        System.out.println();
    }
}
