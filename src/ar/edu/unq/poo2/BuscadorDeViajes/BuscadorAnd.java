package ar.edu.unq.poo2.BuscadorDeViajes;
import java.util.List;


import ar.edu.unq.poo2.BuscadorDeViajes.BuscadorLogico;
import ar.edu.unq.poo2.BuscadorDeViajes.IBuscadorViajes;
import ar.edu.unq.poo2.LineaNaviera.Viaje;

public class BuscadorAnd extends BuscadorLogico {
	
	public BuscadorAnd(IBuscadorViajes filtroBusqueda1, IBuscadorViajes filtroBusqueda2) {
		super(filtroBusqueda1, filtroBusqueda2);
	}

	@Override
	public List<Viaje> filtrar(List<Viaje> ViajesAFiltrar) {
		// TODO Auto-generated method stub
		return null;
	}

}
