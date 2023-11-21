package ar.edu.unq.poo2.MejorCircuito;

import java.util.ArrayList;

import ar.edu.unq.poo2.LineaNaviera.Circuito;
import ar.edu.unq.poo2.Terminal.Terminal;
import ar.edu.unq.poo2.Terminal.TerminalGestionada;

public class MenorCantParadas implements IMejorCircuito{

	@Override
	public Circuito mejorCircuito(ArrayList<Circuito> circuitosAFiltrar, Terminal terminalDestino,
			TerminalGestionada terminalOrigen) {
		Circuito mejorCircuito = circuitosAFiltrar.get(0);
		
		
		for(Circuito circuito : circuitosAFiltrar) {
			if(circuito.getTramosDelCircuito().size()< mejorCircuito.getTramosDelCircuito().size()){
				mejorCircuito = circuito;
			}
		}
		return mejorCircuito;
	}

}
