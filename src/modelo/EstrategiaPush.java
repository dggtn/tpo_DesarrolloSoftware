package modelo;

public class EstrategiaPush implements EstrategiaNotificacion {
    @Override
    public void enviar(Notificacion notificacion) {
        System.out.println("Enviando notificación Push a: "+ notificacion.getJugador().getEmail() +" "+ notificacion.getMensaje());
    }
}
