package modelo.notificaciones.push;

import modelo.notificaciones.EstrategiaNotificacion;
import modelo.notificaciones.Notificacion;
import modelo.notificaciones.push.cliente.Firebase;
import modelo.notificaciones.push.cliente.NotificacionFirebase;

public class AdaptadorFirebase implements EstrategiaNotificacion {

    private final Firebase cliente;

    public AdaptadorFirebase(Firebase cliente) {
        this.cliente = cliente;
    }

    @Override
    public void enviar(Notificacion notificacion) {
        NotificacionFirebase notificacionFirebase = new NotificacionFirebase("token", "Gestor de encuentros deportivos", notificacion.getMensaje());
        this.cliente.enviarNotificacionPush(notificacionFirebase);
    }
}
