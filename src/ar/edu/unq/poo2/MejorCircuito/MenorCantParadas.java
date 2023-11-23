package ar.edu.unq.poo2.MejorCircuito;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.LineaNaviera.Circuito;
import ar.edu.unq.poo2.Terminal.Terminal;
import ar.edu.unq.poo2.Terminal.TerminalGestionada;

public class MenorCantParadas implements IMejorCircuito{

	@Override
	public Circuito mejorCircuito(List<Circuito> circuitosAFiltrar, Terminal terminalDestino) {
		Circuito mejorCircuito = circuitosAFiltrar.get(0);
		
		
		for(Circuito circuito : circuitosAFiltrar) {
			if(circuito.getTramosDelCircuitoHastaTerminal(terminalDestino) < mejorCircuito.getTramosDelCircuitoHastaTerminal(terminalDestino)){
				mejorCircuito = circuito;
			}
		}
		return mejorCircuito;
	}

}
