package modelo.partidos;

public interface ObservadorDePartido {
    void notificarCambioDeEstado(Partido partido, String estadoNuevo);
}
