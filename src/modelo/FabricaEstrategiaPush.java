package modelo;

public class FabricaEstrategiaPush extends Factory {
    @Override
    public EstrategiaNotificacion crearEstrategiaNotificacion() {
        return new EstrategiaPush();
    }
}
