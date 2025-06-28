package modelo.partidos;

import modelo.*;
import modelo.emparejamiento.EstrategiaDeEmparejamiento;
import modelo.jugadores.Jugador;
import modelo.partidos.estados.EstadoPartido;
import modelo.partidos.estados.Inicial;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Partido {
    private EstadoPartido estado;
    private String tipo;
    private int cantJugadores;
    private String duracion;
    private Ubicacion ubicacion;
    private LocalTime horario;
    private Usuario organizador;
    private EstrategiaDeEmparejamiento estrategia;
    private List<Jugador> jugadoresInscriptos;
    private List<ObservadorDePartido> observadores;

    public Partido(String tipo, int cantJugadores, String duracion, LocalTime horario, Usuario organizador) {
        this.tipo = tipo;
        this.cantJugadores = cantJugadores;
        this.duracion = duracion;
        this.horario = horario;
        this.organizador = organizador;
        this.jugadoresInscriptos = new ArrayList<>();
        this.estado = new Inicial(this);
        this.observadores = new ArrayList<>();
    }

    public void configurarPartido(){

     }

    public void cambiarEstado(EstadoPartido nuevoEstado) {
        this.estado = nuevoEstado;
        for(ObservadorDePartido observador: observadores) {
            observador.notificarCambioDeEstado(this, nuevoEstado.nombre());
        }
    }

    public EstadoPartido getEstado() {
          return estado;
     }

     public void setEstado(EstadoPartido estado) {
          this.estado = estado;
     }

     public String getTipo() {
          return tipo;
     }

     public void setTipo(String tipo) {
          this.tipo = tipo;
     }

     public int getCantJugadores() {
          return cantJugadores;
     }

     public void setCantJugadores(int cantJugadores) {
          this.cantJugadores = cantJugadores;
     }

     public String getDuracion() {
          return duracion;
     }

     public void setDuracion(String duracion) {
          this.duracion = duracion;
     }

     public Ubicacion getUbicacion() {
          return ubicacion;
     }

     public void setUbicacion(Ubicacion ubicacion) {
          this.ubicacion = ubicacion;
     }

     public LocalTime getHorario() {
          return horario;
     }

     public void setHorario(LocalTime horario) {
          this.horario = horario;
     }

     public Usuario getOrganizador() {
          return organizador;
     }

     public void setOrganizador(Usuario organizador) {
          this.organizador = organizador;
     }

     public void notificar(){

     }

     public void agregarJugador(Jugador jugador) {
        this.jugadoresInscriptos.add((jugador));
     }

     @Override
     public String toString() {
          return "Partido{" +
                  "estado=" + estado +
                  ", tipo=" + tipo +
                  ", cantJugadores=" + cantJugadores +
                  ", duracion=" + duracion +
                  ", ubicacion=" + ubicacion +
                  ", horario=" + horario +
                  ", organizador=" + organizador +
                  '}';
     }

    public List<Jugador> getJugadoresInscriptos() {
        return jugadoresInscriptos;
    }

    public int obtenerCuantosJugadoresSeInscribieron() {
        return jugadoresInscriptos.size();
    }

    public int obtenerCuantosJugadoresFaltan() {
        return this.cantJugadores - this.jugadoresInscriptos.size();
    }

    public void inscribirJugador(Jugador jugador) {
        this.estado.inscribirJugador(jugador);
    }

    public void agregarObservador(ObservadorDePartido observador) {
        this.observadores.add(observador);
    }
}


