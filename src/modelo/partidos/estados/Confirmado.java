package modelo.partidos.estados;

import modelo.partidos.Partido;

public class Confirmado extends EstadoPartido {

    public Confirmado(Partido partido) {
        super(partido);
    }

    @Override
    public String nombre() {
        return "Confirmado";
    }
}
