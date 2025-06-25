package vista;

import controlador.LoginController;

public class Login extends Pantalla {

    private final LoginController controladorDeLogin;
    public Login(LoginController controladorDeLogin) {
        this.controladorDeLogin = controladorDeLogin;
    }

    @Override
    public Navegacion mostrar(Navegacion origen) {

        boolean loginExitoso, cancelarLogin = false;

        do {

            String email = teclado.leerTexto("Ingresá tu email");
            String password = teclado.leerTexto("Ingresá tu contraseña");

            loginExitoso = controladorDeLogin.autenticar(email, password);

            if (!loginExitoso) {
                char letra = teclado.leerTexto("Email o contraseña inválido. Ingrese cualquier tecla para continuar o 'F' para cancelar").charAt(0);
                cancelarLogin = letra == 'F';
            }
        }while (!loginExitoso && !cancelarLogin);

        String destino = loginExitoso ? "Home" : "Inicio";

        return Navegacion.navegar(destino);
    }
}
