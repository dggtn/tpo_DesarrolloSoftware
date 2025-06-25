package vista;
import java.util.Map;

public class Inicio extends Pantalla {

    @Override
    public Navegacion mostrar(Navegacion origen) {
        String mensajeBienvenida = "Bienvenido al gestor de partidos";
        String menu = """
            A - Registrarse
            B - Iniciar Sesión
            C - Salir
            """;
        Map<Character, String> opciones = Map.of(
                'A', "SignUp",
                'B', "Login",
                'C', "Fin"
        );
        String destino = Menu.mostrarMenu(mensajeBienvenida, menu, opciones, teclado);
        return Navegacion.navegar(destino);
    }
}