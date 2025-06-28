package vista;

import controlador.CrearPartidoController;
import modelo.jugadores.Jugador;

import java.time.LocalTime;

public class PantallaCrearPartido extends Pantalla {

    private final CrearPartidoController crearPartidoController;

    public PantallaCrearPartido(CrearPartidoController crearPartidoController) {
        this.crearPartidoController = crearPartidoController;
    }

    @Override
    public Navegacion mostrar(Navegacion origen) {
        System.out.println("Creación de partido");
        System.out.println("-".repeat(10));

        String tipoDeDeporte = teclado.leerTexto("Ingresa tipo de deporte:");
        crearPartidoController.setTipoDeDeporte(tipoDeDeporte);

        int cantidadDeJugadores = teclado.leerNumeroEntero("Ingresa cantidad de jugadores requeridos:","debe ser un numero entero");
        crearPartidoController.setCantidadDeJugadores(cantidadDeJugadores);

        String duracion = teclado.leerTexto("Ingresá duración del partido:");
        crearPartidoController.setDuracion(duracion);

        // PENDIENTE UBICACION

        LocalTime horaInicio = teclado.leerHora(
                "Ingresá la hora de inicio (HH:mm):",
                "Formato incorrecto. Intentá nuevamente (ej: 09:45)"
        );
        crearPartidoController.setHoraInicio(horaInicio);

        Jugador jugadorLogueado = (Jugador) origen.obtenerDelContexto("jugadorLogueado");

        crearPartidoController.crearPartido(jugadorLogueado);

        return Navegacion.navegar(Home.class.getSimpleName(), origen.getContexto());
    }
}
