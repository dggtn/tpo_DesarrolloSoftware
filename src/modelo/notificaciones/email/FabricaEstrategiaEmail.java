package modelo.notificaciones.email;

import modelo.notificaciones.EstrategiaNotificacion;
import modelo.notificaciones.Factory;
import modelo.notificaciones.email.cliente.JavaEmail;

public class FabricaEstrategiaEmail extends Factory {
    @Override
    public EstrategiaNotificacion crearEstrategiaNotificacion() {
        return new AdaptadorJavaEmail(new JavaEmail());
    }
}

