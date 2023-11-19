package ar.edu.unq.poo2.LineaNaviera;

public class Inbound implements IFaseBuque {

	@Override
	public void pasarDeFase(Buque b) {
		b.cambiarFase(new Arrived());

	}

}
