package modelo;

public class Inicial extends Estado {

    public Inicial(Partido partido) {
        super(partido);
    }

    @Override
    public String getNombre() {
        return "Necesitamos Jugadores";
    }

}
