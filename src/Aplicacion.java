import Repository.JugadorRepositorio;
import Repository.PartidoRepositorio;
import controlador.*;
import modelo.*;
import vista.*;

import java.util.HashMap;
import java.util.Map;

public class Aplicacion {
    public static void main(String[] args) {
        Aplicacion aplicacion = new Aplicacion();
        aplicacion.iniciar(Navegacion.navegar("Inicio"));
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
        BusquedaController busquedaController = new BusquedaController(repositorioDePartidos);
        InscripcionController inscripcionController = new InscripcionController(repositorioDePartidos);
        Pantalla inicio = new Inicio();
        Pantalla registro = new SignUp(controladorDeRegistro);
        Pantalla login = new Login(controladorDeLogin);
        Pantalla home = new Home();
        Pantalla creacionDePartido = new PantallaCrearPartido(crearPartidoController);
        Pantalla pantallaListaPartidos =  new PantallaListaPartidos(busquedaController);
        Pantalla pantallaInscribirseAPartido =  new PantallaInscribirseAPartido(inscripcionController);
        Pantalla pantallaDetallePartido = new PantallaDetallePartido();

        pantallas.put("Inicio", inicio);
        pantallas.put("Login", login);
        pantallas.put("SignUp", registro);
        pantallas.put("Home", home);
        pantallas.put("CreacionDePartido", creacionDePartido);
        pantallas.put("ListaDePartidos", pantallaListaPartidos);
        pantallas.put("DetallePartido", pantallaDetallePartido);
        pantallas.put("Inscripcion", pantallaInscribirseAPartido);

    }

    public void iniciar(Navegacion navegacion){

        Navegacion siguiente = navegacion;

        do {

            Pantalla pantalla = this.pantallas.get(siguiente.getNombreVista());

            if (pantalla == null) {
                throw new RuntimeException("No existe la pantalla " + siguiente.getNombreVista());
            }

            siguiente = pantalla.mostrar(siguiente);
            pantalla.limpiar();

        } while(!"Fin".equals(siguiente.getNombreVista()));

        System.out.println("Finalizando aplicación");
    }
}

//Se enviarán notificaciones push a través de Firebase y correos electrónicos (aún no se conoce
//la librería a utilizar, inicialmente puede usar JavaMail) a los jugadores cuando:
//Se cree un partido nuevo para su deporte favorito.
//Se unan suficientes jugadores y el partido pase a estado "Partido armado".
//Se confirme el partido.
//El partido cambie a estado "En juego", "Finalizado" o “Cancelado”