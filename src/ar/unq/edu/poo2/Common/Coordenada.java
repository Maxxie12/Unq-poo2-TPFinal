package ar.unq.edu.poo2.Common;

public class Coordenada {

    private double longitud;
    private double latitud;
    
    public Coordenada(double longitud, double latitud) {
        this.longitud = longitud;
        this.latitud  = latitud;
    }

    
    public double getLongitud() {
		return longitud;
	}
    
    public double getLatitud() {
		return latitud;
	}
    
    
    
	
    public double distanciaALaCoordenda(Coordenada coordenada) {
    	double longitudDistancia = coordenada.getLongitud() - this.getLongitud();
		double latitudDistancia = coordenada.getLatitud() - this.getLatitud();
		return Math.sqrt(longitudDistancia * longitudDistancia + latitudDistancia * latitudDistancia); 	
    }

	


}
