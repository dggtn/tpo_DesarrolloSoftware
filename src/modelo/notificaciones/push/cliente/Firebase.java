package modelo.notificaciones.push.cliente;

public class Firebase {

    public void enviarNotificacionPush(NotificacionFirebase notificacionFirebase) {
        System.out.printf("Enviando notificación push utilizando Firebase con token: %s, con titulo: %s y cuerpo: %s%n",
                notificacionFirebase.getToken(),
                notificacionFirebase.getTitulo(),
                notificacionFirebase.getCuerpo());
    }
}
