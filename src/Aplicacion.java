import Repository.JugadorRepositorio;
import Repository.PartidoRepositorio;
import controlador.*;
import modelo.*;
import vista.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Aplicacion {
    public static void main(String[] args) {
        Aplicacion aplicacion = new Aplicacion();
        aplicacion.iniciar(Navegacion.navegar("Inicio"));
    }

    private Map<String ,Pantalla> pantallasPorNombre = new HashMap<>();

    public Aplicacion() {

        JugadorRepositorio repositorioDeJugadores = new JugadorRepositorio();
        PartidoRepositorio partidoRepositorio = new PartidoRepositorio();

        this.crearDatosDePrueba(repositorioDeJugadores, partidoRepositorio);

        List<Pantalla> pantallas = this.construirPantallas(repositorioDeJugadores, this.crearNotificador(), partidoRepositorio);
        this.pantallasPorNombre = pantallas.stream().collect(Collectors.toMap(
                pantalla -> pantalla.getClass().getSimpleName(),
                Function.identity()
        ));
    }

    public void iniciar(Navegacion navegacion){

        Navegacion siguiente = navegacion;

        do {

            Pantalla pantalla = this.pantallasPorNombre.get(siguiente.getNombreVista());

            if (pantalla == null) {
                throw new RuntimeException("No existe la pantalla " + siguiente.getNombreVista());
            }

            siguiente = pantalla.mostrar(siguiente);
            pantalla.limpiar();

        } while(!"Fin".equals(siguiente.getNombreVista()));

        System.out.println("Finalizando aplicación");
    }

    private void crearDatosDePrueba(JugadorRepositorio repositorioDeJugadores, PartidoRepositorio partidoRepositorio) {

        // Agregar jugadores
        Jugador jugador1 = new Jugador("danigtn", "dgtn@gmail.com", "123456789", "Futbol", Nivel.INTERMEDIO);
        Jugador jugador2 = new Jugador("maria23", "maria@gmail.com", "clave123", "Voley", Nivel.AVANZADO);
        Jugador jugador3 = new Jugador("lucas_10", "lucas10@hotmail.com", "lucasPass", "Futbol", Nivel.PRINCIPIANTE);
        Jugador jugador4 = new Jugador("sofi.r", "sofi.romero@gmail.com", "sofi2024", "Padel", Nivel.INTERMEDIO);
        Jugador jugador5 = new Jugador("nico_dev", "nico.dev@gmail.com", "devpass", "Basquet", Nivel.AVANZADO);
        Jugador jugador6 = new Jugador("emma", "emma@outlook.com", "emmita", "Futbol", Nivel.INTERMEDIO);

        repositorioDeJugadores.guardarJugador(jugador1);
        repositorioDeJugadores.guardarJugador(jugador2);
        repositorioDeJugadores.guardarJugador(jugador3);
        repositorioDeJugadores.guardarJugador(jugador4);
        repositorioDeJugadores.guardarJugador(jugador5);
        repositorioDeJugadores.guardarJugador(jugador6);

        // Agregar partidos
        Partido partido1 = new Partido("Futbol", 10, "1 hora", LocalTime.of(22, 0), jugador1);
        Partido partido2 = new Partido("Voley", 6, "1 hora y media", LocalTime.of(19, 30), jugador2);
        Partido partido3 = new Partido("Futbol", 8, "45 minutos", LocalTime.of(17, 0), jugador3);
        Partido partido4 = new Partido("Padel", 4, "1 hora", LocalTime.of(18, 15), jugador4);
        Partido partido5 = new Partido("Basquet", 10, "2 horas", LocalTime.of(20, 0), jugador5);

        partidoRepositorio.guardarPartido(partido1);
        partidoRepositorio.guardarPartido(partido2);
        partidoRepositorio.guardarPartido(partido3);
        partidoRepositorio.guardarPartido(partido4);
        partidoRepositorio.guardarPartido(partido5);

        // Partido 4 le falta 1 jugador
        partido4.agregarJugador(jugador4);
        partido4.agregarJugador(jugador2);
        partido4.agregarJugador(jugador6);
    }

    private Notificador crearNotificador() {
        Factory fabricaDeNotificadores= new FabricaEstrategiaPush();
        Factory fabricaDeNotificador= new FabricaEstrategiaEmail();
        Notificador notificador = new Notificador();
        notificador.agregarEstrategia(fabricaDeNotificadores.crearEstrategiaNotificacion());
        notificador.agregarEstrategia(fabricaDeNotificador.crearEstrategiaNotificacion());
        return notificador;
    }

    private List<Pantalla> construirPantallas(JugadorRepositorio repositorioDeJugadores, Notificador notificador, PartidoRepositorio repositorioDePartidos) {
        RegistroController controladorDeRegistro = new RegistroController(repositorioDeJugadores);
        LoginController controladorDeLogin = new LoginController(repositorioDeJugadores);
        CrearPartidoController crearPartidoController = new CrearPartidoController(notificador, repositorioDeJugadores,repositorioDePartidos);
        BusquedaController busquedaController = new BusquedaController(repositorioDePartidos);
        InscripcionController inscripcionController = new InscripcionController(repositorioDePartidos);

        return List.of (
                new Inicio(),
                new SignUp(controladorDeRegistro),
                new Login(controladorDeLogin),
                new Home(),
                new PantallaCrearPartido(crearPartidoController),
                new PantallaListaPartidos(busquedaController),
                new PantallaInscribirseAPartido(inscripcionController),
                new PantallaDetallePartido(),
                new CerrarSesion()
        );
    }
}

//Se enviarán notificaciones push a través de Firebase y correos electrónicos (aún no se conoce
//la librería a utilizar, inicialmente puede usar JavaMail) a los jugadores cuando:
//Se cree un partido nuevo para su deporte favorito.
//Se unan suficientes jugadores y el partido pase a estado "Partido armado".
//Se confirme el partido.
//El partido cambie a estado "En juego", "Finalizado" o “Cancelado”