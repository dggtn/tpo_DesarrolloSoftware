package vista;

import modelo.jugadores.Jugador;
import modelo.partidos.Partido;

import java.util.Map;

public class PantallaDetallePartido extends Pantalla {

    @Override
    public Navegacion mostrar(Navegacion origen) {

        Jugador jugadorLogueado = (Jugador) origen.getContexto().get("jugadorLogueado");
        Partido partidoSeleccionado = (Partido) origen.getContexto().get("partidoSeleccionado");

        mostrarDetallePartido(partidoSeleccionado);

        Navegacion siguiente = Navegacion.navegar(Home.class.getSimpleName(), Map.of("jugadorLogueado", jugadorLogueado));

        if (partidoSeleccionado.obtenerCuantosJugadoresFaltan() > 0) {
            while (true) {

                String opcion = teclado.leerTexto("¿Querés inscribirte a este partido? S/N o F para volver al Home");

                switch (opcion) {
                    case "S":
                        if (partidoSeleccionado.puedeUnirse(jugadorLogueado)) {
                            jugadorLogueado.inscribirsePartido(partidoSeleccionado);
                        } else {
                            System.out.println("No cumplís los requisitos de nivel. Elegí otro partido de la lista.");
                            return Navegacion.navegar(PantallaListaPartidos.class.getSimpleName(), Map.of("jugadorLogueado", jugadorLogueado));
                        }
                    case "N":
                    case "F":
                        return siguiente;
                    default:
                        break;
                }
            }
        }

        return siguiente;
    }

    private void mostrarDetallePartido(Partido partidoSeleccionado) {
        System.out.println("=".repeat(40));
        System.out.println("📋 DETALLE DEL PARTIDO");
        System.out.println("=".repeat(40));
        System.out.println("⚽ Deporte: " + partidoSeleccionado.getTipo());
        System.out.println("📅 Estado: " + partidoSeleccionado.getEstado().nombre());
        System.out.println("⏱️ Duración: " + partidoSeleccionado.getDuracion());
        System.out.println("🕓 Horario: " + partidoSeleccionado.getHorario());
        System.out.println("👤 Organizador: " + partidoSeleccionado.getOrganizador().getEmail());

        System.out.println("\n👥 Jugadores inscriptos (" + partidoSeleccionado.obtenerCuantosJugadoresSeInscribieron() + "/" + partidoSeleccionado.getCantJugadores() + "):");
        for (Jugador jugador : partidoSeleccionado.getJugadoresInscriptos()) {
            System.out.println("   - " + jugador.getNombre() + " (" + jugador.getEmail() + ")");
        }

        int jugadoresFaltantes = partidoSeleccionado.obtenerCuantosJugadoresFaltan();
        if (jugadoresFaltantes > 0) {
            System.out.println("\n⚠️  Faltan " + jugadoresFaltantes + " jugador(es) para completar el partido.");
        } else {
            System.out.println("\n✅ ¡Partido completo!");
        }

        System.out.println("=".repeat(40));
    }

}
