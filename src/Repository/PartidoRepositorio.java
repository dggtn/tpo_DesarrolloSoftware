package Repository;

import modelo.Partido;

import java.util.ArrayList;
import java.util.List;


public class PartidoRepositorio {
    List<Partido> listaPartidos;

    public PartidoRepositorio() {
        this.listaPartidos = new ArrayList<>();
    }

    public void guardarPartido(Partido partido){
        this.listaPartidos.add(partido);
    }
}

