package modelo.notificaciones.email.cliente;

public class JavaEmail {
    public void enviarEmail(Email email) {
        System.out.printf("Enviando notificación utilizando JavaEmail para: %s, con asunto: %s y cuerpo: %s%n",
                email.getDestinatario(),
                email.getAsunto(),
                email.getCuerpo());
    }
}
