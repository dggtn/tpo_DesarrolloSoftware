package vista;
public class CerrarSesion extends Pantalla {

    @Override
    public Navegacion mostrar(Navegacion origen) {
        origen.eliminarDelContexto("jugadorLogueado");
        return Navegacion.navegar(Inicio.class.getSimpleName(), origen.getContexto());
    }
}
