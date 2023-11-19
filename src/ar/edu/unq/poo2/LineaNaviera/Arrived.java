package ar.edu.unq.poo2.LineaNaviera;

public class Arrived implements IFaseBuque {

	@Override
	public void pasarDeFase(Buque b) {
		b.cambiarFase(new Working());

	}

}
