package ar.unq.edu.poo2.Common;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransportista {
	
	private String nombreEmpresa;
	private List<Camion> camionesRegistrados;
	private List<Conductor> conductoresRegistrados;
	
	 public EmpresaTransportista(String nombreEmpresa) {
	        this.nombreEmpresa = nombreEmpresa;
	        this.camionesRegistrados = new ArrayList<>();
	        this.conductoresRegistrados = new ArrayList<>();
	    }
	
	
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public List<Camion> getCamionesRegistrados() {
		return camionesRegistrados;
	}
	public List<Conductor> getConductoresRegistrados() {
		return conductoresRegistrados;
	}
	
	public void registrarConductor (Conductor conductor) {
		conductoresRegistrados.add(conductor);
	}
	
	public void registrarCamion (Camion camion) {
		camionesRegistrados.add(camion);
	}
	
	public void removeConductor (Conductor conductor) {
		conductoresRegistrados.remove(conductor);
	}
	
	public void removeCamion (Camion camion) {
		camionesRegistrados.remove(camion);
	}
	
	

}
