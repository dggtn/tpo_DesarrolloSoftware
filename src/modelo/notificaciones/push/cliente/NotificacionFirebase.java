package modelo.notificaciones.push.cliente;

public class NotificacionFirebase {
    private final String token;
    private final String titulo;
    private String cuerpo;

    public NotificacionFirebase(String token, String titulo, String cuerpo) {
        this.token = token;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getToken() {
        return token;
    }

    public String getCuerpo() {
        return cuerpo;
    }
}
