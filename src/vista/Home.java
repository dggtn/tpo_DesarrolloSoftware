package vista;
import modelo.jugadores.Jugador;

import java.util.Map;

public class Home extends Pantalla {

    @Override
    public Navegacion mostrar(Navegacion origen) {

        Jugador jugadorLogueado = (Jugador) origen.obtenerDelContexto("jugadorLogueado");

        String mensajeBienvenida = String.format("""
        Te damos la bienvenida %s
        Tu nivel de juegos es %s
        """, jugadorLogueado.getEmail(), jugadorLogueado.getNivelJuego());

        String menu = """
            A - Crear partido
            B - Buscar partidos dónde falten jugadores
            C - Revisar confirmaciones pedientes
            D - Cerrar sesión
            E - Salir
            """;
        Map<Character, String> opciones = Map.of(
                'A', PantallaCrearPartido.class.getSimpleName(),
                'B', PantallaListaPartidos.class.getSimpleName(),
                'C', PantallaConfirmacionesPendientes.class.getSimpleName(),
                'D', CerrarSesion.class.getSimpleName(),
                'E', "Fin"
        );
        String destino = Menu.mostrarMenu(mensajeBienvenida, menu, opciones, teclado);
        return Navegacion.navegar(destino, origen.getContexto());
    }
}
