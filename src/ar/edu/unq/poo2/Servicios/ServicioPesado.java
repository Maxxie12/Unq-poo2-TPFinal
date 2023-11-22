package ar.edu.unq.poo2.Servicios;

public class ServicioPesado implements Servicio{
	
	double precioDelServicio;

	public ServicioPesado(double precioDelServicio) {
		
		this.precioDelServicio = precioDelServicio;
	}

	@Override
	public double calcularPrecioDelServicio() {
		
		return this.precioDelServicio;
	}

	

}
