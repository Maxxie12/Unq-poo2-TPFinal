package ar.edu.unq.poo2.BuscadorDeViajes;

import java.util.List;
import java.util.stream.Collectors;
import ar.edu.unq.poo2.LineaNaviera.Viaje;

public class BuscadorPuertoDestino implements IBuscadorViajes {
	
	private String puertoDestino;

	public void setPuertoABuscar(String puertoDestino) {
	    this.puertoDestino = puertoDestino;
	}

	public List<Viaje> filtrar(List<Viaje> viajesAFiltrar) {
		
	    List<Viaje> resultado = viajesAFiltrar.stream()
	            .filter(viaje -> viaje.getPuertoDestino() == puertoDestino)
	            .collect(Collectors.toList());
	    return resultado;

 }
	
}