package modelo;

public class Finalizado extends Estado {

    public Finalizado(Partido partido) {
        super(partido);
    }

    @Override
    public String getNombre() {
        return "Finalizado";
    }
}
