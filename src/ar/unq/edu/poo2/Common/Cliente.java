package ar.unq.edu.poo2.Common;

public class Cliente {
	
	private int dni;
	private String nombreCliente;
	private CompaniaDeEmail compania ;
	private String email;
	
	public int getDni() {
		return dni;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	
	public Cliente (int dni, String nombreCliente , String email, CompaniaDeEmail compania) {
		this.dni 		   = dni;
		this.nombreCliente = nombreCliente;
		this.email		   = email;
		this.compania	   = compania;
	}
	public void mandarEmail(String asunto , String contenido) {
		this.compania.enviarEmailA(this.email, asunto, contenido);
	}

}
