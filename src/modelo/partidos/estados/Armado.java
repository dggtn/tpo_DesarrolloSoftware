package modelo.partidos.estados;

import modelo.partidos.Partido;

public class Armado extends EstadoPartido {

    public Armado(Partido partido) {
        super(partido);
    }

    @Override
    public String nombre() {
        return "Armado";
    }
}
