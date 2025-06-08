package modelo;

public class State {

    Partido partido;
    public void cambiarEstado(Estado estado);

    public State(Partido partido) {
        this.partido = partido;
    }
}
