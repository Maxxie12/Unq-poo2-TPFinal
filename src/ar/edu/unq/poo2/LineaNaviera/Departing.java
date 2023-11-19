package ar.edu.unq.poo2.LineaNaviera;

public class Departing implements IFaseBuque {

	@Override
	public void pasarDeFase(Buque b) {
			b.cambiarFase(new Outbound());
			b.avisarDepart();

	}

}
