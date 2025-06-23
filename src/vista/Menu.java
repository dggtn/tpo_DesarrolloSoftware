package vista;

import controlador.TecladoController;

import java.util.Map;

public class Menu {

    public static String mostrarMenu(
            String mensajeBienvenida,
            String menu,
            Map<Character, String> opciones,
            TecladoController teclado
    ) {
        if (mensajeBienvenida != null && !mensajeBienvenida.isEmpty()) {
            System.out.println(mensajeBienvenida);
        }

        char opcion = ' ';
        String resultado = "";

        while (true) {
            System.out.println(menu);
            opcion = teclado.leerTexto("Opción a elegir: ").charAt(0);
            if (opciones.containsKey(opcion)) {
                resultado = opciones.get(opcion);
                break;
            } else {
                System.out.println("Opción inválida");
            }
        }
        return resultado;
    }
}