package ar.edu.unq.poo2.BuscadorDeViajes;

import java.util.List;
import ar.edu.unq.poo2.LineaNaviera.Viaje;

public abstract class BuscadorLogico implements IBuscadorViajes  {
		
	private IBuscadorViajes filtroBusqueda1;
	private IBuscadorViajes filtroBusqueda2;

	public BuscadorLogico(IBuscadorViajes filtroBusqueda1, IBuscadorViajes filtroBusqueda2) {
			this.filtroBusqueda1 = filtroBusqueda1;
			this.filtroBusqueda2 = filtroBusqueda2;
		}

	public IBuscadorViajes getFiltroBusqueda1() {
			return filtroBusqueda1;
		}

	public IBuscadorViajes getFiltroBusqueda2() {
			return filtroBusqueda2;
		}

	public abstract List<Viaje> filtrar(List<Viaje> ViajesAFiltrar);

	



}
