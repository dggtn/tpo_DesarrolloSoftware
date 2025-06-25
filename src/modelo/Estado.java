package modelo;

public abstract class  Estado {

    private Partido partido;

    public Estado(Partido partido) {
        this.partido = partido;
    }
    public abstract String getNombre();
}
