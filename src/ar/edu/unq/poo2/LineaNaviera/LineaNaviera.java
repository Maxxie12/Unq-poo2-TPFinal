package ar.edu.unq.poo2.LineaNaviera;

import java.time.LocalDate;
import java.util.List;

import ar.edu.unq.poo2.Terminal.TerminalGestionada;

public class LineaNaviera {
	
	private String         nombre;
	private List<Circuito> circuitosRegistrados;
	private List<Buque> buquesRegistrados;
	private List<Viaje> viajesDisponibles;
	private TerminalGestionada terminalGestionada;
	
	public LineaNaviera(String nombre,List<Circuito> circuitos ,List<Buque> buques,List<Viaje> viajes,TerminalGestionada terminal) {
		
		
		this.nombre 			  = nombre;
		this.circuitosRegistrados = circuitos;
		this.buquesRegistrados    = buques;
		this.viajesDisponibles    = viajes;
		this.terminalGestionada   = terminalGestionada;
	}
	
	
	
	public void registrarBuque(Buque b) {
		this.buquesRegistrados.add(b);
	}
	
	public void registrarCircuito(Circuito c) {
		this.circuitosRegistrados.add(c);
	}

	public void crearViaje(Circuito c, Buque b, LocalDate fecha) {
		
		if (this.estaRegistradoElCircuito(c) && this.estaRegistradoElCircuito(b)) {
			this.viajesDisponibles.add(new Viaje(c,b,fecha,this.terminalGestionada));
		}
		else {
			 throw new IllegalArgumentException("El circuito o el buque no están registrados.");
	    }
	}

	

	private boolean estaRegistradoElCircuito(Buque b) {
		return this.buquesRegistrados.contains(b);
	}

	private boolean estaRegistradoElCircuito(Circuito c) {
		return this.circuitosRegistrados.contains(c);
	}

	public String getNombre() {
		return this.nombre;
	}

	public List<Circuito> getCircuitosRegistrados() {
		return this.circuitosRegistrados;
	}

	public List<Buque> getBuquesRegistrados() {
		return this.buquesRegistrados;
	}

	public List<Viaje> getViajesDisponibles() {
		return this.viajesDisponibles;
	}

	
	
}
