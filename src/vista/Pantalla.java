package vista;

import controlador.TecladoController;

public abstract class Pantalla {
    protected final TecladoController teclado;

    protected Pantalla(TecladoController teclado) {
        this.teclado = teclado;
    }
    public abstract String mostrar();
}
