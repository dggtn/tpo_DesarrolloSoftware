package modelo;

public class EstrategiaEmail implements EstrategiaNotificacion {
    @Override
    public void enviar(Notificacion notificacion) {
        System.out.println("Enviando notificación Email a: "+ notificacion.getJugador().getEmail() +" "+ notificacion.getMensaje());
    }
}
