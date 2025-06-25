import Repository.JugadorRepositorio;
import Repository.PartidoRepositorio;
import controlador.LoginController;
import controlador.CrearPartidoController;
import controlador.RegistroController;
import modelo.*;
import vista.*;

import java.util.HashMap;
import java.util.Map;

public class Aplicacion {
    public static void main(String[] args) {
        Aplicacion aplicacion = new Aplicacion();
        Usuario.logear("ezegiorgi", "eze.giorgi@gmail.com");
        aplicacion.iniciar("Inicio");
    }

    private Map<String ,Pantalla> pantallas = new HashMap<>();

    public Aplicacion() {
        JugadorRepositorio repositorioDeJugadores = new JugadorRepositorio();
        PartidoRepositorio repositorioDePartidos = new PartidoRepositorio();

        Factory fabricaDeNotificadores= new FabricaEstrategiaPush();
        Factory fabricaDeNotificador= new FabricaEstrategiaEmail();
        Notificador notificador = new Notificador();
        notificador.agregarEstrategia(fabricaDeNotificadores.crearEstrategiaNotificacion());
        notificador.agregarEstrategia(fabricaDeNotificador.crearEstrategiaNotificacion());



        RegistroController controladorDeRegistro = new RegistroController(repositorioDeJugadores);
        LoginController controladorDeLogin = new LoginController(repositorioDeJugadores);
        CrearPartidoController crearPartidoController = new CrearPartidoController(notificador, repositorioDeJugadores,repositorioDePartidos);

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