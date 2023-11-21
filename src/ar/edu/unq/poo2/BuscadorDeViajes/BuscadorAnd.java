package ar.edu.unq.poo2.BuscadorDeViajes;
import java.util.ArrayList;
import java.util.List;


import ar.edu.unq.poo2.LineaNaviera.Viaje;

public class BuscadorAnd extends BuscadorLogico {
	
	public BuscadorAnd(IBuscadorViajes filtroBusqueda1, IBuscadorViajes filtroBusqueda2) {
		super(filtroBusqueda1, filtroBusqueda2);
	}

	@Override
	public List<Viaje> filtrar(List<Viaje> viajesAFiltrar) {
		
		List<Viaje> viajesAFiltrarPorPrimerBuscador  = new ArrayList<Viaje>();
		List<Viaje> viajesAFiltrarPorSegundoBuscador = new ArrayList<Viaje>();
			
	    viajesAFiltrarPorPrimerBuscador.addAll(this.getFiltroBusqueda1().filtrar(viajesAFiltrar));
	    viajesAFiltrarPorSegundoBuscador.addAll(this.getFiltroBusqueda2().filtrar(viajesAFiltrar));
			
		viajesAFiltrarPorPrimerBuscador.retainAll(viajesAFiltrarPorSegundoBuscador); // Me quedo con las muestras que aparecen en ambas listas
		return(viajesAFiltrarPorPrimerBuscador);
	}

}
