package ar.edu.unq.poo2.LineaNaviera;

import ar.edu.unq.poo2.EstadoBuque.IFaseBuque;
import ar.edu.unq.poo2.EstadoBuque.Outbound;
import ar.edu.unq.poo2.EstadoBuque.Working;
import ar.unq.edu.poo2.Common.Coordenada;
import ar.edu.unq.poo2.EstadoBuque.Arrived;

public class Buque {
	
	private String 	patenteDeBuque;
	private LineaNaviera lineaNavieraALaCualEstaRegistrado;
	private Coordenada	coordenada;
	private boolean	    puedeEmpezarATrabajar;
	private boolean     puedeSalirDeLaTerminal;
	private IFaseBuque  faseDelBuqueActual;
	
	public Buque(String patente) {
		this.patenteDeBuque 		  = patente;
		this.coordenada				  = new Coordenada(0, 0);
		puedeEmpezarATrabajar		  = false;
		puedeSalirDeLaTerminal		  = false;
		this.faseDelBuqueActual 	  = new Outbound();
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
	
	public Coordenada getCoordenda() {
		return coordenada;
	}
		
	public void setLineaNaviera(LineaNaviera lineaN) {
		this.lineaNavieraALaCualEstaRegistrado = lineaN;
	}
	
	private void actualizarEstado() {
		
		noEstaRegistrado();
		this.faseDelBuqueActual.pasarDeFase(this);
		this.puedeEmpezarATrabajar = false;
		this.puedeSalirDeLaTerminal= false;
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
		this.lineaNavieraALaCualEstaRegistrado.getTerminalGestionada().inminenteArriboDelBuque(this);
		
	}
	
	public void avisarDepart() {
		lineaNavieraALaCualEstaRegistrado.getTerminalGestionada().elBuqueAbandonoLasCercanias(this);	
	}

	public void setCoordenadaDelBuqueActual(Coordenada coordenada) {
		this.coordenada 	= coordenada;
		this.actualizarEstado();
	}

	

	public void iniciarTrabajo() {
		this.puedeEmpezarATrabajar  = true;
		this.actualizarEstado();
	}
	
	public void libertadDeDepart() {
		this.puedeSalirDeLaTerminal  = true;
		this.actualizarEstado();
	}

	public boolean getPuedeEmpezarATrabajar() {
		return puedeEmpezarATrabajar;
	}

	public boolean getPuedeSalirDeLaTerminal() {
		return puedeSalirDeLaTerminal;
	}
	
	public boolean seEncuentraA50kmDeLaTerminal() {
		return this.getLineaNaviera().getTerminalGestionada().elBuqueEstaARangoCercanoDeLaTerminal(this.getCoordenda());
	}

	public boolean seEncuentraEnLaTerminal() {
		return this.getLineaNaviera().getTerminalGestionada().elBuqueSeEncuentraEnLaTerminal(this.getCoordenda());
	}
	
	public boolean FueraDelRangoDeLaTerminal() {
		return this.getLineaNaviera().getTerminalGestionada().elBuqueSeEncuentraFueraDelRangoDeLaTerminal(this.getCoordenda());
	}

	public boolean isEsperandoIniciarTrabajo() {
		return this.faseDelBuqueActual.getClass().equals(Arrived.class);
	}
	
	public boolean isEsperandoDepart() {
		return this.faseDelBuqueActual.getClass().equals(Working.class);
	}

	
	

	
	
	
}
	