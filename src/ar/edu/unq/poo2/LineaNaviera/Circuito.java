package ar.edu.unq.poo2.LineaNaviera;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import ar.edu.unq.poo2.Terminal.Terminal;

public class Circuito {
	
	private Terminal terminalIncio;
	private Terminal terminalFinal;
	private List<Tramo> tramosDelCircuito;
	
	
	public Circuito(List<Tramo> tramos) {
        
        if (!this.esValidoParaUnCircuito(tramos)) {
            throw new IllegalArgumentException("Esta lista de tramos es invalida.");
        }
        this.terminalIncio = tramos.get(0).getTerminalInicio();
        this.terminalFinal = tramos.get(tramos.size()-1).getTerminalDestino();        
        this.tramosDelCircuito = tramos;
	
}
	
	private boolean esValidoParaUnCircuito(List<Tramo> tramos) {
		     
		if (tramosDelCircuito == null || tramosDelCircuito.isEmpty()) {
		// Si la lista está vacía, no puede ser un circuito válido
			return false;
	    }

	   // Verificar que la terminal de destino de cada tramo coincide con la terminal de inicio del siguiente
		for (int i = 0; i < tramosDelCircuito.size() - 1; i++) {
			String terminalDestinoActual = tramosDelCircuito.get(i).getTerminalDestino().getNombre();
			String terminalInicioSiguiente = tramosDelCircuito.get(i + 1).getTerminalInicio().getNombre();

		            if (!terminalDestinoActual.equals(terminalInicioSiguiente)) {
		                return false;
		            }
		        }		        
		        return true;
		    }
		 
	
	public Tramo siguienteTramoA(Tramo t) {          
        String terminalDestino = t.getTerminalDestino().getNombre();
        return this.tramosDelCircuito.stream()
                .filter(tramo -> tramo.getTerminalInicio().getNombre().equals(terminalDestino))
                .findFirst()
        		.orElseThrow(() -> new NoSuchElementException("No hay siguiente tramo."));
	}
	
	public void agregarTramo(Tramo t) {
		if (!t.getTerminalInicio().getNombre().equals(this.terminalFinal.getNombre())) {
			throw new IllegalArgumentException("Este tramo no continua el circuito actual.");
		}
		this.terminalFinal = t.getTerminalDestino();
		this.tramosDelCircuito.add(t);
	}
	
	
	public boolean esteCircuitoVaALaTerminal(Terminal t) {
		   return this.tramosDelCircuito.stream()
		            .anyMatch(tramo -> tramo.getTerminalDestino().equals(t));
		}

	public LocalDate fechaFinDelCircuitoAPartir(LocalDate fechaDeInicio) {
		int cantidadDeDiasQueSeTardaEnRecorrer = this.tramosDelCircuito.stream()
			   .mapToInt(t -> t.getTiempoQueTardaEnRecorrer())
			   .sum();
		return fechaDeInicio.plusDays(cantidadDeDiasQueSeTardaEnRecorrer);
			   
	}
}
	
	
	
	
