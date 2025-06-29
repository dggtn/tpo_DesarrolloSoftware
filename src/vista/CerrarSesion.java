package vista;
public class CerrarSesion extends Pantalla {

    @Override
    public Navegacion mostrar(Navegacion origen) {
        return Navegacion.navegar(Inicio.class.getSimpleName());
    }
}
