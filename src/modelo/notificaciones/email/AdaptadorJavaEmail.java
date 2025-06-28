package modelo.notificaciones.email;

import modelo.notificaciones.email.cliente.JavaEmail;
import modelo.notificaciones.EstrategiaNotificacion;
import modelo.notificaciones.Notificacion;
import modelo.notificaciones.email.cliente.Email;

public class AdaptadorJavaEmail implements EstrategiaNotificacion {
    private final JavaEmail cliente;

    public AdaptadorJavaEmail(JavaEmail cliente) {
        this.cliente = cliente;
    }

    @Override
    public void enviar(Notificacion notificacion) {
        Email email = new Email(notificacion.getJugador().getEmail(), "Gestor de encuentros deportivos", notificacion.getMensaje());
        this.cliente.enviarEmail(email);
    }
}
