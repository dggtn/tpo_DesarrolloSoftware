package modelo.partidos.estados;

import modelo.partidos.Partido;

public class Cancelado extends EstadoPartido {

    public Cancelado(Partido partido) {
        super(partido);
    }

    @Override
    public String nombre() {
        return "Cancelado";
    }
}
