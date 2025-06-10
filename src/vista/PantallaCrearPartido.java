package vista;

import modelo.Partido;
import modelo.Teclado;
import modelo.Ubicacion;
import java.time.LocalDate;


public class PantallaCrearPartido {

    private final Teclado teclado;

    public  PantallaCrearPartido(Teclado teclado) {
        this.teclado = teclado;
    }
    public void crearPartido() {

        System.out.println("Ingresa tipo de deporte:");
        String tipo = teclado.leerLinea();
        System.out.println("Ingresa cantidad de jugadores requeridos:");
        int cantidad =this.teclado.leerNumeroEntero("Ingresa duración encuentro:","debe ser un numero entero");;
        double duracion =this.teclado.leerNumeroEntero("Ingresa duración encuentro:","debe ser un numero entero");
        System.out.println("Ubicación");
        LocalDate horario =this.teclado.leerFecha("Ingresa fecha del  encuentro:","error,ingresa en este formato: dd/mm/yyy")

        int numero = this.teclado.leerNumeroEntero(" Ingresa ubicación:", "El numero de domicilio debe ser un numero entero");
        String calle = teclado.leerTexto(" Ingresa calle:");

        Ubicacion ubicacion = new Ubicacion(numero, calle);
        return new Partido("Inicial",tipo,cantidad,duracion,horario,ubicacion);
    }
}
