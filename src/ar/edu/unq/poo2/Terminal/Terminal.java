package ar.edu.unq.poo2.Terminal;

public abstract class Terminal {
	private String nombreDeLaTermianl;
	private int	   latitud;
	private int    longitud;
	
	public Terminal(String nombre, int latitud, int longitud) {
		this.nombreDeLaTermianl=nombre;
		this.latitud  = latitud ;
		this.longitud = longitud;
	}
	
	
	public String getNombre() {
		return this.nombreDeLaTermianl;
	}


	public int getLongitud() {
		return longitud;
	}


	public int getLatitud() {
		return latitud;
	}


	
	
	

	

}
