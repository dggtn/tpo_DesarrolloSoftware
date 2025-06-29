package vista;

import java.util.Map;

public class Navegacion {

    private String nombreVista;
    private Map<String, Object> contexto;

    public Navegacion(String nombreVista, Map<String, Object> contexto) {
        this.nombreVista = nombreVista;
        this.contexto = contexto;
    }

    public static Navegacion navegar(String nombreVista, Map<String, Object> contexto) {
        return new Navegacion(nombreVista, contexto);
    }

    public static Navegacion navegar(String nombreVista) {
        return new Navegacion(nombreVista, null);
    }

    public static Navegacion finalizar() {
        return new Navegacion("Fin", null);
    }

    public String getNombreVista() {
        return nombreVista;
    }

    public Map<String, Object> getContexto() {
        return contexto;
    }

    public Object obtenerDelContexto(String clave) {
        return this.contexto.get(clave);
    }
}
