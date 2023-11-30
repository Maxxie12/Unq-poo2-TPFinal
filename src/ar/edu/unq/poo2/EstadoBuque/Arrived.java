package ar.edu.unq.poo2.EstadoBuque;

import ar.edu.unq.poo2.LineaNaviera.Buque;

public class Arrived implements IFaseBuque {

	@Override
	public void pasarDeFase(Buque b) {
		if(b.getPuedeEmpezarATrabajar()) {
		b.setFase(new Working());

		}
	}
}
