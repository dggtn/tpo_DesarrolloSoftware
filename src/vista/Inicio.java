package vista;

import controlador.TecladoController;

import java.util.Scanner;

public class Inicio extends Pantalla {

    protected Inicio(TecladoController teclado) {
        super(teclado);
    }

    public void comenzarAplicacion() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Bienevenido al gestor de partidos");
        char opcion = 'z';
        while (opcion != '0') {
            mostrarPartidos();
            var menu = """
                    a - Registrarse
                    b - Iniciar Sesión
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.leerTexto("Opcion a elegir: ").charAt(0);

            switch (opcion) {
                case 'a':
                    Usuario usuario = this.pantallaRegistro.registrarse();
                    this.usuarios.add(usuario);
                    break;
                case 'b':
                    pantallaCrearPartido.crearPartido();
                    break;
                case '0':
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        }

    //redirige a login o registro
    //lee entrada usuario
}
