package ar.edu.unq.poo2.Terminal;

import ar.edu.unq.poo2.LineaNaviera.Buque;

public abstract class Terminal {
	private String nombreDeLaTermianl;
	
	public Terminal(String nombre) {
		this.nombreDeLaTermianl=nombre;
	}
	
	
	public String getNombre() {
		return this.nombreDeLaTermianl;
	}
	
	public void inminenteArriboDelBuque(Buque buque) {	
	}
	
	public void elBuqueAbandonoLasCercanias(Buque buque) {
	}

	

}
