package vista;

import controlador.TecladoController;

public abstract class Pantalla {
    protected final TecladoController teclado;

    public Pantalla() {
        this.teclado = new TecladoController();
    }
    public abstract Navegacion mostrar(Navegacion origen);

    public void limpiar() {
        System.out.println();
        System.out.println("#".repeat(50));
    }
}
