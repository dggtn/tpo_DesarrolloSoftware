package vista;

import modelo.Partido;

public class PantallaDetallePartido extends Pantalla {
    @Override
    public Navegacion mostrar(Navegacion origen) {

        Partido partidoSeleccionado = (Partido) origen.getContexto().get("partidoSeleccionado");

        System.out.println(partidoSeleccionado);

        return Navegacion.finalizar();
    }
}
