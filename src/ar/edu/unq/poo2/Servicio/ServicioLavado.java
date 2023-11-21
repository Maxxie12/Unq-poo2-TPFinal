package ar.edu.unq.poo2.Servicio;

import ar.edu.unq.poo2.Container.Container;

public class ServicioLavado extends Servicio{

    
    

	    public ServicioLavado(double precioDeServicio, Container container) {
	        super(precioDeServicio, container);
	    }
	    
	    

	    public double calcularPrecioDelServicio() {
	        if (this.getContainer().getCapacidad() > 70) {
	          return ( this.getPrecioDeServicio() + precioPorCapacidad());
	        } else if(this.getContainer().getCapacidad() < 70) {
	           return( this.getPrecioDeServicio() - precioPorCapacidad());
	        }
	         
	          return ( this.getPrecioDeServicio());
	        }



		private double precioPorCapacidad() {
			return this.getContainer().getCapacidad()*10;
		}

	        
}

  




		
	

}
