package ar.edu.unq.poo2.LineaNaviera;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.poo2.Terminal.Terminal;
import ar.edu.unq.poo2.Terminal.TerminalGestionada;

public class LineaNaviera {
	
	private String         nombre;
	private List<Circuito> circuitosRegistrados;
	private List<Buque> buquesRegistrados;
	private List<Viaje> viajesDisponibles;
	private TerminalGestionada terminalGestionada;
	
	public LineaNaviera(String nombre,List<Circuito> circuitos ,List<Buque> buques,List<Viaje> viajes,TerminalGestionada terminal) {
		
		
		this.nombre 			  = nombre;
		//Solo dejamos los circuitos que incluyan a la terminal 
		this.circuitosRegistrados = this.dejarSoloCircuitosQueIncluyanALaTerminal(circuitos, terminal);
		
		this.buquesRegistrados    = buques;
		//Nos registramos en los buques recien agregados
		this.registrarseEnBuques();
		
		this.terminalGestionada   = terminal;
		//Solo dejamos los Viajes que sean validos
		this.viajesDisponibles    = this.dejarSoloViajesQueSeanValidos(viajes);
	}
	
	


	private void registrarseEnBuques() {
		this.buquesRegistrados.stream()
		.forEach(b -> b.setLineaNaviera(this));
		
	}




	private List<Circuito> dejarSoloCircuitosQueIncluyanALaTerminal(List<Circuito> circuitos, Terminal terminal) {
		return circuitos.stream()
				.filter(c -> c.esteCircuitoVaALaTerminal(terminal.getNombre()))
				.collect(Collectors.toCollection(ArrayList::new));
		
	}

	private List<Viaje> dejarSoloViajesQueSeanValidos(List<Viaje> viajes){
		//Un Viaje valido es aquel que su circuito y buque esten registrados en la naviera
		return viajes.stream()
				.filter(v -> this.sonCircuitoYBuqueRegistrados(v.getCircuitoARecorrer(), v.getBuqueAsignado()))
				.collect(Collectors.toCollection(ArrayList::new));
		
	}

	public void registrarBuque(Buque b) {
		//Cuando Registramos un buque lo marcamos que ahora esta trabajando para la naviera
		b.setLineaNaviera(this);
		this.buquesRegistrados.add(b);
	}
	
	public void registrarCircuito(Circuito c) {
		exepcionEsteCircuitoNoPasaPorLaTerminal(c); 
		this.circuitosRegistrados.add(c);
	}




	private void exepcionEsteCircuitoNoPasaPorLaTerminal(Circuito c) {
		if ((!c.esteCircuitoVaALaTerminal(this.terminalGestionada.getNombre()))) {
			throw new IllegalArgumentException("El circuito no pasa por la terminal Gestionada es inecesario registrarlo.");
		}
	}

	public void crearViaje(Circuito c, Buque b, LocalDate fecha) {
		
		exepcionLosArgumentosSonInvalidos(c, b);

	    this.viajesDisponibles.add(new Viaje(c, b, fecha, this.terminalGestionada));
	}




	private void exepcionLosArgumentosSonInvalidos(Circuito c, Buque b) {
		if (!sonCircuitoYBuqueRegistrados(c, b)) {
	        throw new IllegalArgumentException("El circuito o el buque no están registrados.");
	    }
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

	
//  GETTERS	
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

	public TerminalGestionada getTerminalGestionada() {
		return this.terminalGestionada;
	}
	
	public void removeBuque(Buque b) {
		b.setLineaNaviera(null);
		this.buquesRegistrados.remove(b);
	}
	
	public void removeCircuito(Circuito c) {
		this.circuitosRegistrados.remove(c);
	}
	
	public void removeViaje(Viaje v) {
		this.viajesDisponibles.remove(v);
	}
	
}
