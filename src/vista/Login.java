package vista;

import controlador.LoginController;
import modelo.Jugador;

import java.util.Map;
import java.util.Optional;

public class Login extends Pantalla {

    private final LoginController controladorDeLogin;
    public Login(LoginController controladorDeLogin) {
        this.controladorDeLogin = controladorDeLogin;
    }

    @Override
    public Navegacion mostrar(Navegacion origen) {

        while(true) {

            String email = teclado.leerTexto("Ingresá tu email");
            String password = teclado.leerTexto("Ingresá tu contraseña");

            Optional<Jugador> jugadorLogueado = controladorDeLogin.autenticar(email, password);

            if (jugadorLogueado.isPresent()) {
                return Navegacion.navegar(Home.class.getSimpleName(), Map.of("jugadorLogueado", jugadorLogueado.get()));
            } else {
                char letra = teclado.leerTexto("Email o contraseña inválido. Ingrese cualquier tecla para continuar o 'F' para cancelar").charAt(0);
                if (letra == 'F') {
                    return Navegacion.navegar(Inicio.class.getSimpleName());
                }
            }

        }
    }
}
