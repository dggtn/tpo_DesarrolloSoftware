package modelo;

public class FabricaEstrategiaEmail extends Factory{
    @Override
    public EstrategiaNotificacion crearEstrategiaNotificacion() {
        return new NotificacionEmail();
    }
}
