package modelo;

public class EnJuego extends Estado{
    public EnJuego(Partido partido) {
        super(partido);
    }

    @Override
    public String getNombre() {
        return "En Juego";
    }
}
