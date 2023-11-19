package ar.edu.unq.poo2.LineaNaviera;

import ar.edu.unq.poo2.EstadoBuque.IFaseBuque;
import ar.edu.unq.poo2.EstadoBuque.Outbound;

public class Buque {
	
	private String 	patenteDeBuque;
	private Viaje  	viajeRecorriendoActualmente;
	private Tramo  	tramoRecorriendoActualmente;
	private IFaseBuque  faseDelBuqueActual;
	
	public Buque(String patente) {
		this.patenteDeBuque = patente;
		this.faseDelBuqueActual = new Outbound();
	}
	
	public String getPatenteDeBuque() {
		return this.patenteDeBuque;
	}

	public Viaje getViajeRecorriendoActualmente() {
		return this.viajeRecorriendoActualmente;
	}

	public Tramo getTramoRecorriendoActualmente() {
		return this.tramoRecorriendoActualmente;
	}

	public IFaseBuque getFaseDelBuqueActual() {
		return this.faseDelBuqueActual;
	}
	
	
	
	public void avanzarFase() {
		this.faseDelBuqueActual.pasarDeFase(this);
	}
	
	public void cambiarFase(IFaseBuque faseSiguiente) {
		this.faseDelBuqueActual = faseSiguiente;
	}
	
	
	
	public void setViajeRecorriendoActualmente(Viaje viajeRecorriendoActualmente) {
		this.viajeRecorriendoActualmente = viajeRecorriendoActualmente;
	}

	public void setTramoRecorriendoActualmente(Tramo tramoRecorriendoActualmente) {
		this.tramoRecorriendoActualmente = tramoRecorriendoActualmente;
	}

	
	
	public void avisarTerminalDeInminenteArribo() {
		tramoRecorriendoActualmente.getTerminalDestino().inminenteArriboDelBuque(this);
		
	}
	

	public void avisarDepart() {
		tramoRecorriendoActualmente.getTerminalDestino().elBuqueAbandonoLasCercanias(this);
		this.pasarAlSiguienteTramo();
		
	}

	private void pasarAlSiguienteTramo() {
		this.tramoRecorriendoActualmente = this.viajeRecorriendoActualmente
											.getCircuitoARecorrer()
											.siguienteTramoA(tramoRecorriendoActualmente);
	}
	
	
}
	