package ar.edu.unq.poo2.BuscadorDeViajes;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unq.poo2.LineaNaviera.Viaje;

public class BuscadorOr extends BuscadorLogico {
	
	public BuscadorOr(IBuscadorViajes filtroBusqueda1, IBuscadorViajes filtroBusqueda2) {
		super(filtroBusqueda1, filtroBusqueda2);
	}

	@Override
	public List<Viaje> filtrar(List<Viaje> viajesAFiltrar) {

		List<Viaje> viajesResultantes = new ArrayList <Viaje>();
		
	    viajesResultantes.addAll(this.getFiltroBusqueda1().filtrar(viajesAFiltrar));
	    viajesResultantes.addAll(this.getFiltroBusqueda2().filtrar(viajesAFiltrar));
		
		return viajesResultantes.stream().distinct().toList(); // me quedo con todo lo que está en ambas listas y le saco los duplicados.
	}

}
