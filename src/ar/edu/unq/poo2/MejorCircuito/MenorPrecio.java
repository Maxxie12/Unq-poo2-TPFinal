package ar.edu.unq.poo2.MejorCircuito;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.LineaNaviera.Circuito;
import ar.edu.unq.poo2.LineaNaviera.Tramo;
import ar.edu.unq.poo2.Terminal.Terminal;
import ar.edu.unq.poo2.Terminal.TerminalGestionada;

public class MenorPrecio implements IMejorCircuito{

	@Override
	public Circuito mejorCircuito(List<Circuito> circuitosAFiltrar, Terminal terminalDestino) {
		Circuito mejorCircuito = circuitosAFiltrar.get(0);
		
		for(int i=0;i<circuitosAFiltrar.size();i++) {
			if(circuitosAFiltrar.get(i).getCostoADestino(terminalDestino)<mejorCircuito.getCostoADestino(terminalDestino)) {
				mejorCircuito=circuitosAFiltrar.get(i);
			}
		}
		return mejorCircuito;
	}

}
