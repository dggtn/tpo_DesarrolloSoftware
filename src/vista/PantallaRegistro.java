package vista;

import modelo.Teclado;
import modelo.Ubicacion;
import modelo.Usuario;

import java.time.LocalDate;

public class PantallaRegistro {

    private final Teclado teclado;

    public PantallaRegistro(Teclado teclado) {
        this.teclado = teclado;
    }

   public Usuario registrarse() {
        System.out.println("Ingresa tu nombre de usuario:");
        String nombre = teclado.leerLinea();
        System.out.println("Ingresa tu correo electrónico:");
        String email =this.teclado.leerLinea();
        System.out.println("Ubicación");
        int numero = this.teclado.leerNumeroEntero(" Ingresa ubicación:", "El numero de domicilio debe ser un numero entero");
        String calle = teclado.leerTexto(" Ingresa calle:");

        Ubicacion ubicacion = new Ubicacion(numero, calle);
        return new Usuario(nombre, email, ubicacion);
    }


}


