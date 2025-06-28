package modelo.partidos.estados;

import modelo.partidos.Partido;

public class EnJuego extends EstadoPartido {
    public EnJuego(Partido partido) {
        super(partido);
    }

    @Override
    public String nombre() {
        return "En Juego";
    }
}
