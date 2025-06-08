package modelo;

import java.util.Date;

public class Partido {
     State estado;
     Deporte tipo;
     int cantJugadores;
     Double duracion;
     Ubicacion ubicacion;
     Date horario;
     Jugador organizador;


     public void configurarPartido(){

     }

     public Partido(State estado, Deporte tipo, int cantJugadores, Double duracion, Ubicacion ubicacion, Date horario, Jugador organizador) {
          this.estado = estado;
          this.tipo = tipo;
          this.cantJugadores = cantJugadores;
          this.duracion = duracion;
          this.ubicacion = ubicacion;
          this.horario = horario;
          this.organizador = organizador;
     }

     public State getEstado() {
          return estado;
     }

     public void setEstado(State estado) {
          this.estado = estado;
     }

     public Deporte getTipo() {
          return tipo;
     }

     public void setTipo(Deporte tipo) {
          this.tipo = tipo;
     }

     public int getCantJugadores() {
          return cantJugadores;
     }

     public void setCantJugadores(int cantJugadores) {
          this.cantJugadores = cantJugadores;
     }

     public Double getDuracion() {
          return duracion;
     }

     public void setDuracion(Double duracion) {
          this.duracion = duracion;
     }

     public Ubicacion getUbicacion() {
          return ubicacion;
     }

     public void setUbicacion(Ubicacion ubicacion) {
          this.ubicacion = ubicacion;
     }

     public Date getHorario() {
          return horario;
     }

     public void setHorario(Date horario) {
          this.horario = horario;
     }

     public Jugador getOrganizador() {
          return organizador;
     }

     public void setOrganizador(Jugador organizador) {
          this.organizador = organizador;
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


