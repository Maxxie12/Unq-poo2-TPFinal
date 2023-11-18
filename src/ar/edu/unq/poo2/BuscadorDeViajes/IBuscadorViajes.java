package ar.edu.unq.poo2.BuscadorDeViajes;

import java.util.List;
import ar.edu.unq.poo2.LineaNaviera.Viaje;

public interface IBuscadorViajes {
	
	List<Viaje> filtrar(List<Viaje> viajesAFiltrar);
		
	

}
