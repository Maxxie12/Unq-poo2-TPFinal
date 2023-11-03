package ar.unq.edu.poo2.Common;

public class Cliente {
	
	private int dni;
	private String nombreCliente;
	
	public int getDni() {
		return dni;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	
	public Cliente (int dni, String nombreCliente) {
		this.dni 		   = dni;
		this.nombreCliente = nombreCliente;
	}

}
