import Repository.JugadorRepositorio;
import controlador.ControladorDeLogin;
import controlador.CrearPartidoController;
import controlador.RegistroController;
import modelo.Notificador;
import modelo.Usuario;
import vista.*;

import java.util.HashMap;
import java.util.Map;

public class Aplicacion {
    public static void main(String[] args) {
        Aplicacion aplicacion = new Aplicacion();
        Usuario.logear("daniela", "dggtn@gmail.com"); //hardcodeado solo para pruebas
        aplicacion.iniciar("Inicio");
    }

    private Map<String ,Pantalla> pantallas = new HashMap<>();

    public Aplicacion() {
        JugadorRepositorio repositorioDeJugadores = new JugadorRepositorio();
        Notificador notificador = new Notificador();

        RegistroController controladorDeRegistro = new RegistroController(repositorioDeJugadores);
        ControladorDeLogin controladorDeLogin = new ControladorDeLogin(repositorioDeJugadores);
        CrearPartidoController crearPartidoController = new CrearPartidoController(notificador, repositorioDeJugadores);

        Pantalla inicio = new Inicio();
        Pantalla registro = new SignUp(controladorDeRegistro);
        Pantalla login = new Login(controladorDeLogin);
        Pantalla home = new Home();
        Pantalla creacionDePartido = new PantallaCrearPartido(crearPartidoController);

        pantallas.put("Inicio", inicio);
        pantallas.put("Login", login);
        pantallas.put("SignUp", registro);
        pantallas.put("Home", home);
        pantallas.put("CreacionDePartido", creacionDePartido);
    }

    public void iniciar(String pantallaInicial){

        String siguiente = pantallaInicial;

        do {

            Pantalla pantalla = this.pantallas.get(siguiente);

            if (pantalla == null) {
                throw new RuntimeException("No existe la pantalla " + siguiente);
            }

            siguiente = pantalla.mostrar();
            pantalla.limpiar();

        } while(!"Fin".equals(siguiente));

        System.out.println("Finalizando aplicación");
    }
}