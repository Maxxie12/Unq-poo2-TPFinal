package ar.edu.unq.poo2.Container;

public abstract class Container {
	
	private double ancho;
	private double largo;
	private double altura;
	private double capacidad;
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
	public double getCapacidad() {
		return capacidad;
	}
	public String getTipoContainer() {
		return tipoContainer;
	}
	public int getId() {
		return id;
	}

	public Container(double ancho, double largo, double altura, double capacidad, int id) {
		this.ancho		   = ancho;
		this.largo	       = largo;
		this.altura 	   = altura;
		this.capacidad     = capacidad;
		this.id 		   = id;
	}
	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}
	
	
}
