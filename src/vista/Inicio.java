package vista;

import controlador.TecladoController;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.Map;
import java.util.Scanner;

public class Inicio extends Pantalla {
    @Override
    public String mostrar() {
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
        return Menu.mostrarMenu(mensajeBienvenida, menu, opciones, teclado);
    }
}