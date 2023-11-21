package ar.edu.unq.poo2.Servicio;

import ar.edu.unq.poo2.Container.Container;

public class ServicioPesado extends Servicio{
	

	public ServicioPesado(double precioDeServicio, Container container) {
		super(precioDeServicio, container);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularPrecioDelServicio() {
		
		return this.getPrecioDeServicio();
	}

	

}
