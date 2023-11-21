package ar.edu.unq.poo2.BuscadorDeViajes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import ar.edu.unq.poo2.LineaNaviera.Viaje;

public class BuscadorCompuesto implements IBuscadorViajes {
	
	private List<IBuscadorViajes> buscadoresDeViajes = new ArrayList<>();

    @Override
    public List<Viaje> filtrar(List<Viaje> viajesAFiltrar) {

        return (buscadoresDeViajes.stream()
                .flatMap(buscador -> buscador.filtrar(viajesAFiltrar).stream())
                .distinct()
                .collect(Collectors.toList()));
    }

    public void addBuscador(IBuscadorViajes buscadorViajes) {
        buscadoresDeViajes.add(buscadorViajes);
    }

    public void removeBuscador(IBuscadorViajes buscadorViajes ) {
        buscadoresDeViajes.remove(buscadorViajes);
    }


}
