package vista;

import controlador.ControladorDeLogin;

public class Login extends Pantalla {

    private final ControladorDeLogin controladorDeLogin;
    public Login(ControladorDeLogin controladorDeLogin) {
        this.controladorDeLogin = controladorDeLogin;
    }

    @Override
    public String mostrar() {

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

        return loginExitoso ? "Home" : "Inicio";
    }
}
