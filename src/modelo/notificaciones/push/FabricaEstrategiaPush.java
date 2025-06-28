package modelo.notificaciones.push;

import modelo.notificaciones.EstrategiaNotificacion;
import modelo.notificaciones.Factory;
import modelo.notificaciones.push.cliente.Firebase;

public class FabricaEstrategiaPush extends Factory {
    @Override
    public EstrategiaNotificacion crearEstrategiaNotificacion() {
        return new AdaptadorFirebase(new Firebase());
    }
}
