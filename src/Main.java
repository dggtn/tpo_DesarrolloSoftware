import Repository.JugadorRepositorio;
import controlador.RegistroController;
import controlador.TecladoController;
import vista.Pantalla;
import vista.PantallaRegistro;

public class Main {
    public static void main(String[] args) {
        JugadorRepositorio repojugador = new JugadorRepositorio();
        TecladoController teclado = new TecladoController();
        RegistroController registro = new RegistroController(repojugador);
        Pantalla ptregistro =new PantallaRegistro(registro,teclado);

        String pantallaSiguiente = ptregistro.mostrar();

        while(pantallaSiguiente != "fin"){

        }
    }


}
//tener todas las pantallas
//usar map de pantallas donde la clave es el nombre de la pantalla y el valor es la instancia
//cd pantalla debe devolver a cual va ir despues
//app agarra string lo busca en el mapa y pide mostrar

//mapa de <String pantalla>