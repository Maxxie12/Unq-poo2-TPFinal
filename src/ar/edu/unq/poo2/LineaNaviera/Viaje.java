package ar.edu.unq.poo2.LineaNaviera;

import java.time.LocalDate;

import ar.edu.unq.poo2.Terminal.Terminal;
import ar.edu.unq.poo2.Terminal.TerminalGestionada;

public class Viaje {

	private Circuito 	 circuitoARecorrer;
	private Buque 		 buqueAsignado;
	private LocalDate 	 fechaDeInicio;
	private LocalDate    fechaDeLLegadaAlaTerminalGestionada;
	
	
	
	public Viaje(Circuito circuito, Buque buque, LocalDate fecha, Terminal terminalGestionada) {
		
		this.circuitoARecorrer 					 = circuito;
		this.buqueAsignado	  					 = buque;
		this.fechaDeInicio	   					 = fecha;
		this.fechaDeLLegadaAlaTerminalGestionada = circuito.fechaDeLLegadaA(terminalGestionada,fecha);
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

	public LocalDate getFechaDeLlegadaALaTerminalGestionada(){
		return this.fechaDeLLegadaAlaTerminalGestionada;
	}

	public boolean llegaAUnPuertoEnEstaFecha(LocalDate fechaDeLlegada) {
		return this.circuitoARecorrer.llegaAUnPuertoEstaFecha(this.fechaDeInicio, fechaDeLlegada);
	}



	public boolean llegaA(String puertoDestino) {
		return this.circuitoARecorrer.esteCircuitoVaALaTerminal(puertoDestino);
	}



	public boolean saleDeLaTerminalGestionadaEn(LocalDate fechaDeSalida) {
		return this.fechaDeLLegadaAlaTerminalGestionada.equals(fechaDeSalida);
	}



	public LocalDate getFechaDeLlegadaADesdeLaTerminal(TerminalGestionada terminalGestionada,
			Terminal terminalDestino) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
