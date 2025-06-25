package modelo;

public class Confirmado extends Estado {

    public Confirmado(Partido partido) {
        super(partido);
    }

    @Override
    public String getNombre() {
        return "Confirmado";
    }
}
