package ar.edu.unq.poo2.Servicio;

import ar.edu.unq.poo2.Container.Container;

public class ServicioLavado implements Servicio{

	private double    precioDelServicio;
    private Container container;
    

	    public ServicioLavado(double precioDelServicio, Container container) {
	    	this.precioDelServicio = precioDelServicio;
	    	this.container         = container;
	    	
	    }
	    
	    

	    public double calcularPrecioDelServicio() {
	        if (this.container.getCapacidad() > 70) {
	          return ( this.precioDelServicio + precioPorCapacidad());
	        } else if(this.container.getCapacidad() < 70) {
	           return( this.precioDelServicio - precioPorCapacidad());
	        }
	         
	          return ( this.precioDelServicio);
	        }



		private double precioPorCapacidad() {
			return this.container.getCapacidad()*10;
		}

	        
}

  




		
	


