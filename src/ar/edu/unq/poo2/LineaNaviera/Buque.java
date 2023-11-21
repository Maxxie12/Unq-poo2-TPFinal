package ar.edu.unq.poo2.LineaNaviera;

import ar.edu.unq.poo2.EstadoBuque.IFaseBuque;
import ar.edu.unq.poo2.EstadoBuque.Outbound;

public class Buque {
	
	private String 	patenteDeBuque;
	private LineaNaviera lineaNavieraALaCualEstaRegistrado;
	private IFaseBuque  faseDelBuqueActual;
	
	public Buque(String patente) {
		this.patenteDeBuque = patente;
		this.faseDelBuqueActual = new Outbound();
	}
	
	public String getPatenteDeBuque() {
		return this.patenteDeBuque;
	}

	
	public IFaseBuque getFaseDelBuqueActual() {
		return this.faseDelBuqueActual;
	}
	
	public LineaNaviera getLineaNaviera() {
		noEstaRegistrado();
		return this.lineaNavieraALaCualEstaRegistrado;
	}
	
	public void setLineaNaviera(LineaNaviera lineaN) {
		this.lineaNavieraALaCualEstaRegistrado = lineaN;
	}
	
	public void actualizarEstado() {
		noEstaRegistrado();
		this.faseDelBuqueActual.pasarDeFase(this);
	}

	private void noEstaRegistrado() {
		if (this.lineaNavieraALaCualEstaRegistrado == null) {
			throw new IllegalArgumentException("No tenemos acceso a la informacion de este buque ya que no esta registrado a niguna Linea Naviera");
		}
	}
	
	public void setFase(IFaseBuque faseSiguiente) {
		this.faseDelBuqueActual = faseSiguiente;
	}
	
		
	public void avisarTerminalDeInminenteArribo() {
		this.lineaNavieraALaCualEstaRegistrado.getTerminal().inminenteArriboDelBuque(this);
		
	}
	
	public void avisarDepart() {
		lineaNavieraALaCualEstaRegistrado.getTerminal().elBuqueAbandonoLasCercanias(this);	
	}

	
	
	
}
	