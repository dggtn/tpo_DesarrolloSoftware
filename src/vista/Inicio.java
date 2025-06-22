package vista;

import controlador.TecladoController;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Inicio extends Pantalla {
    public Inicio(TecladoController teclado) {
        super(teclado);
    }

    @Override
    public String mostrar() {
        String opcionesValidas = "ABC";
        String resultado = "";
        System.out.println("Bienevenido al gestor de partidos");
        char opcion = 'z';
        while (!opcionesValidas.contains(String.valueOf(opcion))) {
            var menu = """
                    A - Registrarse
                    B - Iniciar Sesión
                    C - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.leerTexto("Opcion a elegir: ").charAt(0);
            switch (opcion) {
                case 'A':
                    resultado = "SignUp";
                    break;
                case 'B':
                    resultado = "Login";
                    break;
                case 'C':
                    resultado = "Fin";
                    break;
                default:
                    System.out.println("Opción inválida");
                    return "";
            }

        }

        System.out.println("Yendo a " + resultado);

        return resultado;
    }
}
    //redirige a login o registro
    //lee entrada usuario
