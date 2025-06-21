package controlador;

import modelo.*;

import java.util.Date;

public class CreacionController {
    private final TecladoController teclado;

    private State estado;
    Deporte tipo;
    int cantJugadores;
    Double duracion;
    Ubicacion ubicacion;
    Date horario;
    Jugador organizador;
    EstrategiaDeEmparejamiento estrategia;

    public CreacionController(TecladoController teclado) {
        this.teclado = teclado;
    }
}
