package ar.edu.unq.poo2.LineaNaviera;

public class Outbound implements IFaseBuque {

	

	@Override
	public void pasarDeFase(Buque b) {
		b.cambiarFase(new Inbound());
		b.avisarTerminalDeInminenteArribo();

	}
}
