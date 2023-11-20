package ar.edu.unq.poo2.LineaNaviera;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.poo2.Terminal.TerminalGestionada;

public class LineaNaviera {
	
	private String         nombre;
	private List<Circuito> circuitosRegistrados;
	private List<Buque> buquesRegistrados;
	private List<Viaje> viajesDisponibles;
	private TerminalGestionada terminalGestionada;
	
	public LineaNaviera(String nombre,List<Circuito> circuitos ,List<Buque> buques,List<Viaje> viajes,TerminalGestionada terminal) {
		
		
		this.nombre 			  = nombre;
		this.circuitosRegistrados = this.borrarCircuitosQueNoIncluyanALaTerminal(circuitos, terminal);;
		this.buquesRegistrados    = buques;
		this.terminalGestionada   = terminal;
		this.viajesDisponibles    = this.viajesQueSePuedenRegistrar(viajes);
	}
	
	
	
	private List<Circuito> borrarCircuitosQueNoIncluyanALaTerminal(List<Circuito> circuitos, TerminalGestionada terminal) {
		return circuitos.stream()
				.filter(c -> c.esteCircuitoVaALaTerminal(terminal.getNombre()))
				.collect(Collectors.toCollection(ArrayList::new));
		
	}

	private List<Viaje> viajesQueSePuedenRegistrar(List<Viaje> viajes){
		return viajes.stream()
				.filter(v -> this.sonCircuitoYBuqueRegistrados(v.getCircuitoARecorrer(), v.getBuqueAsignado()))
				.collect(Collectors.toCollection(ArrayList::new));
		
	}

	public void registrarBuque(Buque b) {
		this.buquesRegistrados.add(b);
	}
	
	public void registrarCircuito(Circuito c) {
		if ((!c.esteCircuitoVaALaTerminal(this.terminalGestionada.getNombre()))) {
			throw new IllegalArgumentException("El circuito no pasa por la terminal Gestionada es inecesario registrarlo.");
		} 
		this.circuitosRegistrados.add(c);
	}

	public void crearViaje(Circuito c, Buque b, LocalDate fecha) {
		
		if (!sonCircuitoYBuqueRegistrados(c, b)) {
	        throw new IllegalArgumentException("El circuito o el buque no están registrados.");
	    }

	    this.viajesDisponibles.add(new Viaje(c, b, fecha, this.terminalGestionada));
	}



	private boolean sonCircuitoYBuqueRegistrados(Circuito c, Buque b) {
		return this.estaRegistradoElCircuito(c) && this.estaRegistradoElCircuito(b);
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
