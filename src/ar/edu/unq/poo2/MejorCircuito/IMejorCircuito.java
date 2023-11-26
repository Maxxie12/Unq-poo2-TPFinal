package ar.edu.unq.poo2.MejorCircuito;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.poo2.LineaNaviera.Circuito;
import ar.edu.unq.poo2.Terminal.Terminal;

public interface IMejorCircuito {
	public Circuito mejorCircuito( List<Circuito> circuitosAFiltrar,Terminal terminal);
}
