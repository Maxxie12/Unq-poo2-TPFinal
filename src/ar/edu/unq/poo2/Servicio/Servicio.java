package ar.edu.unq.poo2.Servicio;

public abstract class Servicio {

private	double precioDeServicio;

 public	Servicio(double precioDeServicio) {
	this.precioDeServicio = precioDeServicio;
}
	
	public double getPrecioDeServicio() {
		return precioDeServicio;
	}
	
	
}
