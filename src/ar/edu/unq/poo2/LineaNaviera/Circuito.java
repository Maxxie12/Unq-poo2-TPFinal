package ar.edu.unq.poo2.LineaNaviera;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import ar.edu.unq.poo2.Terminal.Terminal;

public class Circuito {
	
	private Terminal terminalIncio;
	private Terminal terminalFinal;
	private List<Tramo> tramosDelCircuito;
	
	
	public Circuito(List<Tramo> tramos) {
        
        exepcionCircuitoInvalido(tramos);
        
        this.terminalIncio = tramos.get(0).getTerminalInicio();
        this.terminalFinal = tramos.get(tramos.size()-1).getTerminalDestino();        
        this.tramosDelCircuito = tramos;
	
}

	private void exepcionCircuitoInvalido(List<Tramo> tramos) {
		//Es invalido si los tramos no estan en orden de terminales 
		if (!this.esValidoParaUnCircuito(tramos)) {
            throw new IllegalArgumentException("Esta lista de tramos es invalida.");
        }
	}
	
	private boolean esValidoParaUnCircuito(List<Tramo> tramos) {
		     
		if (tramos.isEmpty()) {
		// Si la lista está vacía, no puede ser un circuito válido
			return false;
	    }

	   // Verificar que la terminal de destino de cada tramo coincide con la terminal de inicio del siguiente
		for (int i = 0; i < tramos.size() - 1; i++) {
			String terminalDestinoActual = tramos.get(i).getTerminalDestino().getNombre();
			String terminalInicioSiguiente = tramos.get(i + 1).getTerminalInicio().getNombre();

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
        		.orElseThrow(() -> new IllegalArgumentException("No hay siguiente tramo."));
	}
	
	public void agregarTramo(Tramo t) {
		exepcionTramoNoContinuaElCircuito(t);
		this.terminalFinal = t.getTerminalDestino();
		this.tramosDelCircuito.add(t);
	}

	private void exepcionTramoNoContinuaElCircuito(Tramo t) {
		if (!t.getTerminalInicio().getNombre().equals(this.terminalFinal.getNombre())) {
			throw new IllegalArgumentException("Este tramo no continua el circuito actual.");
		}
	}
	
	
	public boolean esteCircuitoVaALaTerminal(String terminalDestino) {
		   return this.tramosDelCircuito.stream()
		            .anyMatch(tramo -> tramo.getTerminalDestino().getNombre().equals(terminalDestino));
		}

	

	public LocalDate fechaFinDelCircuitoAPartir(LocalDate fechaDeInicio) {
		int cantidadDeDiasQueSeTardaEnRecorrer = this.tramosDelCircuito.stream()
			   .mapToInt(t -> t.getTiempoQueTardaEnRecorrer())
			   .sum();
		return fechaDeInicio.plusDays(cantidadDeDiasQueSeTardaEnRecorrer);
			   
	}
	
	public List<LocalDate> fechasLlegadaATerminales(LocalDate fechaSalida) {
        List<LocalDate> fechasLlegada = new ArrayList<LocalDate>();

        for (Tramo tramo : tramosDelCircuito) {
            fechaSalida = fechaSalida.plusDays(tramo.getTiempoQueTardaEnRecorrer());
            fechasLlegada.add(fechaSalida);
        }

        return fechasLlegada;
    }

	public boolean llegaAUnPuertoEstaFecha(LocalDate fechaDeInico, LocalDate fechaDeLlegada) {
		return this.fechasLlegadaATerminales(fechaDeInico).stream()
				.anyMatch(f -> f.equals(fechaDeLlegada));
	}


    public LocalDate fechaDeLLegadaA(Terminal terminal, LocalDate fecha) {
        LocalDate fechaLlegada = fecha;
            
        noTieneEsTerminalExepcion(terminal);
        
        for (Tramo tramo : this.tramosDelCircuito) {
            // Verificar si el tramo incluye la terminal de destino
        	
            if (tramo.getTerminalDestino().getNombre().equals(terminal.getNombre())) {
                // Calcular la fecha de llegada acumulada sumando el tiempo que tarda en recorrer en días
                return fechaLlegada = fechaLlegada.plusDays(tramo.getTiempoQueTardaEnRecorrer());
            }
            	
            fechaLlegada = fechaLlegada.plusDays(tramo.getTiempoQueTardaEnRecorrer());
            
            
        }
		return fecha; 

        
    }

	private void noTieneEsTerminalExepcion(Terminal terminal) {
		if(!this.esteCircuitoVaALaTerminal(terminal.getNombre()) && !estaTerminalIniciaDeEstaTerminal(terminal)) {
        	 throw new IllegalArgumentException("El Cicuito no pasa por esa terminal");
        }
	}

	private boolean estaTerminalIniciaDeEstaTerminal(Terminal terminal) {
		return this.terminalIncio.getNombre() == terminal.getNombre();
	}

	//GETTERS

	public double getCostoTotal() {
		
		return this.tramosDelCircuito.stream()
				   .mapToDouble(t -> t.getPrecio())
				   .sum();
	}
	public double getCostoADestino(Terminal terminalDestino) {
		double costoHastaLaTerminal = 0;
        
        noTieneEsTerminalExepcion(terminalDestino);
        
        for (Tramo tramo : this.tramosDelCircuito) {
        	
            if (tramo.getTerminalDestino().getNombre().equals(terminalDestino.getNombre())) {
                return costoHastaLaTerminal = costoHastaLaTerminal + (tramo.getPrecio());
            }
            	
            costoHastaLaTerminal = costoHastaLaTerminal + (tramo.getPrecio());
            
            
        }
		return costoHastaLaTerminal; 

        
	}
    
	public int getTiempoTotalEnDias() {
		return this.tramosDelCircuito.stream()
				   .mapToInt(t -> t.getTiempoQueTardaEnRecorrer())
				   .sum();
	}
	
	public Terminal getTerminalIncio() {
		return terminalIncio;
	}

	public Terminal getTerminalFinal() {
		return terminalFinal;
	}

	public List<Tramo> getTramosDelCircuito() {
		return tramosDelCircuito;
	}

	public int getDiasHastaTerminal(Terminal terminalDestino) {
		int diasHastaTerminal = 0;
        
        noTieneEsTerminalExepcion(terminalDestino);
        
        for (Tramo tramo : this.tramosDelCircuito) {
        	
            if (tramo.getTerminalDestino().getNombre().equals(terminalDestino.getNombre())) {
                return diasHastaTerminal = diasHastaTerminal + (tramo.getTiempoQueTardaEnRecorrer());
            }
            	
            diasHastaTerminal = diasHastaTerminal + (tramo.getTiempoQueTardaEnRecorrer());
            
            
        }
		return diasHastaTerminal; 

        
	}
	
	
	
	
	
}

	
