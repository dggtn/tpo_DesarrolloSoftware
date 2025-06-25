package vista;

import controlador.InscripcionController;

public class PantallaInscribirseAPartido extends Pantalla{
    private final InscripcionController inscripcion;

    public PantallaInscribirseAPartido(InscripcionController inscripcion) {
        this.inscripcion = inscripcion;
    }

    @Override
    public Navegacion mostrar(Navegacion origen) {
        return Navegacion.finalizar();
    }
}
