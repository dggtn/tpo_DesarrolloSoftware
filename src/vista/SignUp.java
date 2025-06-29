package vista;

import controlador.RegistroController;
import modelo.jugadores.Jugador;
import modelo.jugadores.Nivel;

import java.util.Map;


public class SignUp extends Pantalla {
    private final RegistroController registro;
    public SignUp(RegistroController registro) {
        this.registro = registro;
    }

    @Override
    public Navegacion mostrar(Navegacion origen) {
        System.out.println("Ingresa tu nombre de usuario:");
        String nombre = teclado.leerLinea();
        registro.setNombre(nombre);

        System.out.println("Ingresa tu correo electrónico:");
        String email = teclado.leerLinea();
        registro.setEmail(email);

        System.out.println("Ingresa tu contrasena:");
        String contrasena = teclado.leerLinea();
        registro.setContrasena(contrasena);

        System.out.println("Ingresa tu deporte favorito:");
        String deporteFavorito = teclado.leerLinea();
        registro.setDeporteFavorito(deporteFavorito);

        System.out.println("Ingresa tu nivel (P para Principiante, I para intermedio y A para Avanzado):");
        String nivel = teclado.leerLinea();
        Nivel nivelJugador;
        switch (nivel) {
            case "P":
                nivelJugador = Nivel.PRINCIPIANTE;
                break;
            case "I":
                nivelJugador = Nivel.INTERMEDIO;
            case "A":
                nivelJugador = Nivel.AVANZADO;
                break;
            default:
                nivelJugador = Nivel.SIN_DEFINIR;
        }
        registro.setNivelJuego(nivelJugador);

        Jugador jugador = registro.finalizarRegistro();

        return Navegacion.navegar(Home.class.getSimpleName(), Map.of("jugadorLogueado", jugador));
    }
}


