package ar.edu.unq.poo2.Terminal;

public abstract class Terminal {
	private String nombreDeLaTermianl;
	
	public Terminal(String nombre) {
		this.nombreDeLaTermianl=nombre;
	}
	
	
	public String getNombre() {
		return this.nombreDeLaTermianl;
	}
	
	

	

}
