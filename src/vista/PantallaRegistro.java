package vista;

import controlador.RegistroController;
import controlador.TecladoController;


public class PantallaRegistro extends Pantalla {
    private final RegistroController registro;
    public PantallaRegistro( RegistroController registro,TecladoController teclado) {
        super(teclado);
        this.registro = registro;

    }

   public void registrarse() {
    System.out.println("Ingresa tu nombre de usuario:");
    String nombre = teclado.leerLinea();
    registro.setNombre(nombre);
    System.out.println("Ingresa tu correo electrónico:");
    String email = teclado.leerLinea();
    registro.setNombre(email);
    System.out.println("Ingresa tu contrasena:");
       String contrasena = teclado.leerLinea();
    registro.setContrasena(contrasena);
    registro.finalizarRegistro();
    }


    @Override
    public String mostrar() {
        System.out.println("Ingresa tu nombre de usuario:");
        String nombre = teclado.leerLinea();
        registro.setNombre(nombre);
        System.out.println("Ingresa tu correo electrónico:");
        String email = teclado.leerLinea();
        registro.setNombre(email);
        System.out.println("Ingresa tu contrasena:");
        String contrasena = teclado.leerLinea();
        registro.setContrasena(contrasena);
        registro.finalizarRegistro();
        return "fin";
    }
}


