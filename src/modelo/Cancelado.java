package modelo;

public class Cancelado extends Estado {

    public Cancelado(Partido partido) {
        super(partido);
    }

    @Override
    public String getNombre() {
        return "Cancelado";
    }
}
