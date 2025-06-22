package vista;

import controlador.TecladoController;

public abstract class Pantalla {
    protected final TecladoController teclado;

    public Pantalla(TecladoController teclado) {
        this.teclado = teclado;
    }
    public abstract String mostrar();
}
