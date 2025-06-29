package modelo.partidos.estados;

import modelo.partidos.Partido;

public class Armado extends EstadoPartido {

    private int participantesQueAceptaron;

    public Armado(Partido partido) {
        super(partido);
    }

    @Override
    public String nombre() {
        return "Armado";
    }

    @Override
    public void participacionAceptada() {
        this.participantesQueAceptaron++;
        if (participantesQueAceptaron == this.partido.obtenerCuantosJugadoresSeInscribieron()) {
          this.partido.cambiarEstado(new Confirmado(this.partido));
        }
    }
}
