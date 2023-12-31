package ar.edu.unq.poo2.MejorCircuito;

import java.util.ArrayList;

import ar.edu.unq.poo2.LineaNaviera.Circuito;
import ar.edu.unq.poo2.LineaNaviera.Tramo;
import ar.edu.unq.poo2.Terminal.Terminal;
import ar.edu.unq.poo2.Terminal.TerminalGestionada;

public class MenorPrecio implements IMejorCircuito{

	@Override
	public Circuito mejorCircuito(ArrayList<Circuito> circuitosAFiltrar, Terminal terminalDestino,
			TerminalGestionada terminalOrigen) {
		Circuito mejorCircuito = circuitosAFiltrar.get(0);
		for(int i=0;i<circuitosAFiltrar.size();i++) {
			if(circuitosAFiltrar.get(i).getCostoTotal()<mejorCircuito.getCostoTotal()) {
				mejorCircuito=circuitosAFiltrar.get(i);
			}
		}
		
		return mejorCircuito;
		
		
	}

}
