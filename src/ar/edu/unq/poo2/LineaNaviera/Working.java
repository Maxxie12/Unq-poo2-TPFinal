package ar.edu.unq.poo2.LineaNaviera;

public class Working implements IFaseBuque {

	@Override
	public void pasarDeFase(Buque b) {
		b.cambiarFase(new Departing());

	}

}
