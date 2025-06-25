package modelo;

import java.time.LocalTime;

public class Partido {
    private Estado estado;
    private  String tipo;
    private  int cantJugadores;
    private  String duracion;
    private  Ubicacion ubicacion;
    private  LocalTime horario;
    private  Usuario organizador;
    private  EstrategiaDeEmparejamiento estrategia;

    public Partido(String tipo, int cantJugadores, String duracion, LocalTime horario, Usuario organizador) {
        this.tipo = tipo;
        this.cantJugadores = cantJugadores;
        this.duracion = duracion;
        this.horario = horario;
        this.organizador = organizador;
        this.estado = new Inicial(this);
    }

    public void configurarPartido(){

     }

    public void cambiarEstado(Estado nuevoEstado) {

        this.estado = nuevoEstado;
    }

    public Estado getEstado() {
          return estado;
     }

     public void setEstado(Estado estado) {
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
}


