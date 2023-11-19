package ar.edu.unq.poo2.LineaNaviera;

import java.time.LocalDate;

import ar.edu.unq.poo2.Terminal.Terminal;

public class Tramo {
	
	private double precio;
	private int tiempoQueTardaEnRecorrerEnDias;
	private Terminal terminalIncio;
	private Terminal terminalDestino;
	
	
	public Tramo(double precio, int tiempoQueTardaEnRecorrer, Terminal terInc , Terminal terFin) {
		
		 if (terInc.getNombre().equals(terFin.getNombre())) {
	            throw new IllegalArgumentException("Las terminales de inicio y destino no pueden ser iguales.");
	        }
		this.precio 				  = precio;
		this.tiempoQueTardaEnRecorrerEnDias = tiempoQueTardaEnRecorrer;
		this.terminalIncio 			  = terInc;
		this.terminalDestino 		  = terFin;
	}
	
	
	
	public double getPrecio() {
		return this.precio;
	}



	public int getTiempoQueTardaEnRecorrer() {
		return this.tiempoQueTardaEnRecorrerEnDias;
	}

	public Terminal getTerminalInicio() {
		return this.terminalIncio;
	}

	public Terminal getTerminalDestino() {
		return this.terminalDestino;

	}
	
	 public LocalDate calcularFechaDeLLegadaSaliendoAhora() {
	        // Obtén la fecha actual
	        LocalDate fechaActual = LocalDate.now();
	        LocalDate fechaLlegada = fechaActual.plusDays(this.tiempoQueTardaEnRecorrerEnDias);

	        return fechaLlegada;
	    }
	 
	 public LocalDate calcularFechaDeLLegadaSaliendoElDia(LocalDate fecha) {
	        // Obtén la fecha actual
	        
	        LocalDate fechaLlegada = fecha.plusDays(this.tiempoQueTardaEnRecorrerEnDias);

	        return fechaLlegada;
	    }

}
