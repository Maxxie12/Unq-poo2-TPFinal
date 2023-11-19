package ar.edu.unq.poo2.LineaNaviera;

import java.time.LocalDate;

public class Viaje {

	private Circuito 	 circuitoARecorrer;
	private Buque 		 buqueAsignado;
	private LocalDate 	 fechaDeInicio;
	
	
	
	public Viaje(Circuito circuito, Buque buque, LocalDate fecha) {
		this.circuitoARecorrer = circuito;
		this.buqueAsignado	   = buque;
		this.fechaDeInicio	   = fecha;
	}



	public Circuito getCircuitoARecorrer() {
		return this.circuitoARecorrer;
	}



	public Buque getBuqueAsignado() {
		return this.buqueAsignado;
	}



	public LocalDate getFechaDeInicio() {
		return this.fechaDeInicio;
	}
	
	public LocalDate getFechaDeFin() {
		return this.circuitoARecorrer.fechaFinDelCircuitoAPartir(this.fechaDeInicio);
	}
	
	
	
	
}
