package ar.edu.unq.poo2.MejorCircuito;

import java.util.ArrayList;

import ar.edu.unq.poo2.LineaNaviera.Circuito;
import ar.edu.unq.poo2.Terminal.Terminal;
import ar.edu.unq.poo2.Terminal.TerminalGestionada;

public interface IMejorCircuito {
	public Circuito mejorCircuito( ArrayList<Circuito> circuitosAFiltrar,Terminal terminal, TerminalGestionada terminalG);
}
