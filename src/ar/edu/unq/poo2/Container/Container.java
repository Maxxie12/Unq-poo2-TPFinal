package ar.edu.unq.poo2.Container;

public abstract class Container {
	
	private double ancho;
	private double largo;
	private double altura;
	private String tipoContainer;
	private int	   id;
	
	
	public double getAncho() {
		return ancho;
	}
	public double getLargo() {
		return largo;
	}
	public double getAltura() {
		return altura;
	}
	public String getTipoContainer() {
		return tipoContainer;
	}
	public int getId() {
		return id;
	}

	public Container(double ancho, double largo, double altura, String tipoContainer, int id) {
		this.ancho		   = ancho;
		this.largo	       = largo;
		this.altura 	   = altura;
		this.tipoContainer = tipoContainer;
		this.id 		   = id;
	}
	
	
}
