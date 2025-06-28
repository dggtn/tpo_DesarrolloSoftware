package modelo.partidos.estados;

import modelo.partidos.Partido;

public class Finalizado extends EstadoPartido {

    public Finalizado(Partido partido) {
        super(partido);
    }

    @Override
    public String nombre() {
        return "Finalizado";
    }
}
