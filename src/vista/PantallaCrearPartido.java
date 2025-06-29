package vista;

import controlador.CrearPartidoController;
import modelo.emparejamiento.EmparejamientoSinRestricciones;
import modelo.emparejamiento.EmparejarPorNivel;
import modelo.emparejamiento.EstrategiaDeEmparejamiento;
import modelo.jugadores.Jugador;
import modelo.jugadores.Nivel;

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

        EstrategiaDeEmparejamiento estrategiaDeEmparejamiento = leerEstrategiaDeEmparejamiento();
        crearPartidoController.setEstrategiaElegida(estrategiaDeEmparejamiento);

        Jugador jugadorLogueado = (Jugador) origen.obtenerDelContexto("jugadorLogueado");

        crearPartidoController.crearPartido(jugadorLogueado);

        return Navegacion.navegar(Home.class.getSimpleName(), origen.getContexto());
    }

    private EstrategiaDeEmparejamiento leerEstrategiaDeEmparejamiento() {

        String opcion = teclado.leerTexto("¿Querés definir un método de emparejamiento? S/N");

        if (!opcion.equals("S")) {
            return new EmparejamientoSinRestricciones();
        }

        // Por ahora por nivel
        Nivel nivelMinimo = leerNivel("Nivel Mínimo requerido");
        Nivel nivelMaximo = leerNivel("Nivel máximo requerido");
        return new EmparejarPorNivel(nivelMinimo, nivelMaximo);
    }

    private Nivel leerNivel(String mensaje) {
        System.out.println("#".repeat(50));
        System.out.println(mensaje);
        while (true) {

            String texto = teclado.leerTexto("Ingresá P para Principiante o I para Intermedio o A para avanzado");

            switch (texto) {
                case "P":
                    return Nivel.PRINCIPIANTE;
                case "I":
                    return Nivel.INTERMEDIO;
                case "A":
                    return Nivel.AVANZADO;
                default:
                    System.out.println("La opción ingresada es incorrecta...");
                    break;
            }
        }
    }
}
