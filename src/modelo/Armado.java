package modelo;

public class Armado extends Estado {

    public Armado(Partido partido) {
        super(partido);
    }

    @Override
    public String getNombre() {
        return "Armado";
    }
}
