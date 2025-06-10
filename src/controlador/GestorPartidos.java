package controlador;

import modelo.Partido;
import modelo.Teclado;
import modelo.Ubicacion;
import modelo.Usuario;
import vista.PantallaCrearPartido;
import vista.PantallaRegistro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorPartidos {
    private final Teclado teclado;
    private List<Partido> partidos;
    private List<Usuario> usuarios;
    private PantallaRegistro pantallaRegistro;
    private PantallaCrearPartido pantallaCrearPartido;


    public GestorPartidos() {
        this.teclado = new Teclado();
        this.partidos = new ArrayList<>();
        this.pantallaRegistro = new PantallaRegistro(this.teclado);
        this.pantallaCrearPartido = new PantallaCrearPartido(this.teclado);

        //para iniciar ya con un ejemplo
        Ubicacion ubicacion = new Ubicacion(87, "calle");
        Partido partido = new Partido("Confirmado", "Descripción de prueba", 1);
        this.partidos.add(partido);
    }

    public static void main(String[] args) {
        GestorPartidos gde = new GestorPartidos();
        gde.comenzarAplicacion();
    }

    public void comenzarAplicacion() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Bienevenido al gestor de partidos");
        char opcion = 'z';
        while (opcion != '0') {
            mostrarPartidos();
            var menu = """
                    a - Registrarse
                    b - Crear Partido
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = this.teclado.leerTexto("Opcion a elegir: ").charAt(0);

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

    }

    private void mostrarPartidos() {
    }


}

