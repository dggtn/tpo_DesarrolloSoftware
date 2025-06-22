import Repository.JugadorRepositorio;
import controlador.RegistroController;
import controlador.TecladoController;
import vista.*;

import java.util.HashMap;
import java.util.Map;

public class Aplicacion {
    public static void main(String[] args) {
        Aplicacion aplicacion = new Aplicacion();
        aplicacion.iniciar("Inicio");
    }

    private Map<String ,Pantalla> pantallas = new HashMap<>();

    public Aplicacion() {
        JugadorRepositorio repoJugador = new JugadorRepositorio();
        TecladoController teclado = new TecladoController();
        RegistroController regisController = new RegistroController(repoJugador);
        Pantalla inicio = new Inicio(teclado);
        Pantalla registro = new SignUp(teclado,regisController);
        Pantalla login = new Login(teclado);

        pantallas.put("Inicio", inicio);
        pantallas.put("Login", login);
        pantallas.put("SignUp", registro);
    }

    public void iniciar(String pantallaInicial){
        String siguiente = pantallaInicial;

        do {
            Pantalla pantalla = this.pantallas.get(siguiente);
            if (pantalla == null){
                throw new RuntimeException("No existe la vista " + siguiente);
            }

            siguiente = pantalla.mostrar();

        } while(!"Fin".equals(siguiente));

        System.out.println("Finalizando aplicación");


//        JugadorRepositorio repojugador = new JugadorRepositorio();
//
//        RegistroController registro = new RegistroController(repojugador);
//        Pantalla ptregistro =new PantallaRegistro(registro,teclado);
//
//        String pantallaSiguiente = ptregistro.mostrar();
//
//        while(pantallaSiguiente != "fin"){
//
//        }
    }


}
//tener todas las pantallas
//usar map de pantallas donde la clave es el nombre de la pantalla y el valor es la instancia
//cd pantalla debe devolver a cual va ir despues
//app agarra string lo busca en el mapa y pide mostrar

//mapa de <String pantalla>