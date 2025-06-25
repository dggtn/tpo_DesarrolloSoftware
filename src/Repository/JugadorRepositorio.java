package Repository;

import modelo.Jugador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JugadorRepositorio {
   List<Jugador> listaJugadores;

   public JugadorRepositorio() {
       this.listaJugadores = new ArrayList<>();
       this.listaJugadores.add(new Jugador("danigtn", "dgtn@gmail.com", "123456789","Futbol"));
   }

    public void guardarJugador(Jugador jugador){

       this.listaJugadores.add(jugador);
    }

    public Optional<Jugador> buscarPorEmailYPassword(String email, String password) {
       return this.listaJugadores.stream()
               .filter((jugador -> jugador.getEmail().equals(email) && jugador.getContrasena().equals(password)))
               .findFirst();
    }

    public List<Jugador> buscarPorDeporteFavorito(String tipoDeDeporte) {
       List<Jugador> jugadoresPorDeporte = new ArrayList<>();
        for (Jugador jugador : listaJugadores){
            if(jugador.getDeporteFavorito().equals(tipoDeDeporte)){
                jugadoresPorDeporte.add(jugador);
            }
        }
        return jugadoresPorDeporte;
    }
}
