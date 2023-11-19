package ar.edu.unq.poo2.EstadoBuque;

import ar.edu.unq.poo2.LineaNaviera.Buque;

public class Departing implements IFaseBuque {

	@Override
	public void pasarDeFase(Buque b) {
			b.cambiarFase(new Outbound());
			b.avisarDepart();

	}

}
