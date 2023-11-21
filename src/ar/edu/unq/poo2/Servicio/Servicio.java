package ar.edu.unq.poo2.Servicio;

import ar.edu.unq.poo2.Container.Container;

public abstract class Servicio {

private	double precioDeServicio;
private Container container;

 public	Servicio(double precioDeServicio, Container container) {
	this.precioDeServicio = precioDeServicio;
	this.container = container;
}
	
	public double getPrecioDeServicio() {
		return precioDeServicio;
	}
	

	public Container getContainer() {
		return container;
	}
	

	
	public abstract double calcularPrecioDelServicio();
	
	
	
}
