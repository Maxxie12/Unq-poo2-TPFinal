package ar.edu.unq.poo2.EstadoBuque;

import ar.edu.unq.poo2.LineaNaviera.Buque;

public class Outbound implements IFaseBuque {

	

	@Override
	public void pasarDeFase(Buque b) {
		if(b.seEncuentraA50kmDeLaTerminal()) {
			b.setFase(new Inbound());
			b.avisarTerminalDeInminenteArribo();	
		}
	}
}
