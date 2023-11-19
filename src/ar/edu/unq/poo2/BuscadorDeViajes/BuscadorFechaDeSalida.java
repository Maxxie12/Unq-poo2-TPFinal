package ar.edu.unq.poo2.BuscadorDeViajes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.poo2.LineaNaviera.Viaje;

public class BuscadorFechaDeSalida implements IBuscadorViajes {
	
	private LocalDate fechaDeSalida;

	public void setfechaDeSalida(LocalDate fechaDeSalida) {
	    this.fechaDeSalida = fechaDeSalida;
	}

	public List<Viaje> filtrar(List<Viaje> viajesAFiltrar) {
		
	    List<Viaje> resultado = viajesAFiltrar.stream()
	            .filter(viaje -> viaje.getFechaDeInicio() == fechaDeSalida)
	            .collect(Collectors.toList());
	    return resultado;

 }

}
