package Repository;

import modelo.Estado;
import modelo.Partido;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PartidoRepositorio {
    List<Partido> listaPartidos;

    public PartidoRepositorio() {
        this.listaPartidos = new ArrayList<>();
    }

    public void guardarPartido(Partido partido){
        this.listaPartidos.add(partido);
    }

    public List<Partido> obtenerPartidosPorEstado (String nombreEstado){
        return listaPartidos.stream().filter(partido -> partido.getEstado().getNombre().equals(nombreEstado)).collect(Collectors.toList());

    }
}

