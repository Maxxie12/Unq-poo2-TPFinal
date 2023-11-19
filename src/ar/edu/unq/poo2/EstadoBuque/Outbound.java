package ar.edu.unq.poo2.EstadoBuque;

import ar.edu.unq.poo2.LineaNaviera.Buque;

public class Outbound implements IFaseBuque {

	

	@Override
	public void pasarDeFase(Buque b) {
		b.cambiarFase(new Inbound());
		b.avisarTerminalDeInminenteArribo();

	}
}
