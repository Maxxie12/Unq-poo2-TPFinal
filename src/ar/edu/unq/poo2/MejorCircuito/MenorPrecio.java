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
			if(circuitosAFiltrar.get(i).costoTotalDelCircuito()<mejorCircuito.costoTotalDelCircuito()) {
				mejorCircuito=circuitosAFiltrar.get(i);
			}
		}
		
		return mejorCircuito;
		
		/*
		 * public int cantidadDeTramos() {
		return this.tramosDelCircuito.size();
	}

	public double costoTotalDelCircuito() {
		double result = 0;
		for(Tramo tramo : tramosDelCircuito ) {
			result= result + tramo.getPrecio();
		}
		return result;
	}

		 * 
		 */
	}

}
