package vista;
import modelo.Usuario;

import java.util.Map;

public class Home extends Pantalla {
    @Override
    public String mostrar() {

        String mensajeBienvenida = "Te damos la bienvenida " + Usuario.usuarioLogueado.getEmail();
        String menu = """
            A - Crear partido
            B - Buscar partidos dónde falten jugadores
            Z - Salir
            """;
        Map<Character, String> opciones = Map.of(
                'A', "CreacionDePartido",
                'B', "ListaDePartidos",
                'Z', "Fin"
        );
        return Menu.mostrarMenu(mensajeBienvenida, menu, opciones, teclado);
    }
}
