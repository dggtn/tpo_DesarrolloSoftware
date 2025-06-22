package vista;

import controlador.RegistroController;
import controlador.TecladoController;

public class Login extends Pantalla {
    private final IniciarSesionController inicioSesion;
public Login( TecladoController teclado,IniciarSesionController inicioSesion) {
    super(teclado);
    this.inicioSesion = inicioSesion;

}

public void iniciarSesion() {
    System.out.println("Ingresa tu correo electrónico:");
    String email = teclado.leerLinea();
    Login.setEmail(email);
    System.out.println("Ingresa tu contrasena:");
    String contrasena = teclado.leerLinea();
    Login.setContrasena(contrasena);
    Login.finalizarRegistro();
}


@Override
public String mostrar() {
    System.out.println("Ingresa tu correo electrónico:");
    String email = teclado.leerLinea();
    Login.setNombre(email);
    System.out.println("Ingresa tu contrasena:");
    String contrasena = teclado.leerLinea();
    Login.setContrasena(contrasena);
    Login.finalizarRegistro();
    return "Fin";
}
}

