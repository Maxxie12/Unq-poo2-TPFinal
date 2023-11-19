package ar.edu.unq.poo2.BuscadorDeViajes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.poo2.LineaNaviera.Viaje;

public class BuscadorFechaDeLlegada implements IBuscadorViajes {
	
	private LocalDate fechaDeLlegada;

	public void setfechaDeLlegada(LocalDate fechaDeLlegada) {
	    this.fechaDeLlegada = fechaDeLlegada;
	}

	public List<Viaje> filtrar(List<Viaje> viajesAFiltrar) {
		
	    List<Viaje> resultado = viajesAFiltrar.stream()
	            .filter(viaje -> viaje.getFechaDeFin() == fechaDeLlegada)
	            .collect(Collectors.toList());
	    return resultado;
	}
}
