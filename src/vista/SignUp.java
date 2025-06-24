package vista;

import controlador.RegistroController;



public class SignUp extends Pantalla {
    private final RegistroController registro;
    public SignUp(RegistroController registro) {
        this.registro = registro;
    }
    @Override
    public String mostrar() {

        System.out.println("Ingresa tu nombre de usuario:");
        String nombre = teclado.leerLinea();
        registro.setNombre(nombre);

        System.out.println("Ingresa tu correo electrónico:");
        String email = teclado.leerLinea();
        registro.setEmail(email);

        System.out.println("Ingresa tu contrasena:");
        String contrasena = teclado.leerLinea();
        registro.setContrasena(contrasena);

        registro.finalizarRegistro();

        return "Home";
    }
}


