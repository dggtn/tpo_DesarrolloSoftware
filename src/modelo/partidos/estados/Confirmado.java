package modelo.partidos.estados;

import modelo.partidos.Partido;

import java.time.LocalTime;

public class Confirmado extends EstadoPartido {

    public Confirmado(Partido partido) {
        super(partido);
    }

    @Override
    public String nombre() {
        return "Confirmado";
    }

    @Override
    public void actualizar() {
        if (LocalTime.now().isAfter(partido.getHorario())) {
            this.partido.cambiarEstado(new EnJuego(partido));
        }
    }
}
