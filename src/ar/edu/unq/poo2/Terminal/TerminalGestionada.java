package ar.edu.unq.poo2.Terminal;

import java.util.List;

import ar.edu.unq.poo2.BuscadorDeViajes.IBuscadorViajes;
import ar.edu.unq.poo2.LineaNaviera.LineaNaviera;
import ar.edu.unq.poo2.Orden.Orden;
import ar.unq.edu.poo2.Common.Cliente;
import ar.unq.edu.poo2.Common.EmpresaTransportista;

public class TerminalGestionada extends Terminal {
		
	
	private List<LineaNaviera>         lineasNavierasRegistradas;
	private List<EmpresaTransportista> empresasRegistradas;
	private List<Cliente> 			   clientesRegistrados;
	private List<Orden>				   ordenesDeImportacion;
	private List<Orden>				   ordenesDeExportacion;
	private List<Orden>				   ordenesFinalizadas;
	private IBuscadorViajes			   motorDeLaTerminal;
	
	public TerminalGestionada(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	public List<LineaNaviera> getLineasNavierasRegistradas() {
		return lineasNavierasRegistradas;
	}
	
	public List<EmpresaTransportista> getEmpresasRegistradas() {
		return empresasRegistradas;
	}

	public List<Cliente> getClientesRegistrados() {
		return clientesRegistrados;
	}

	public List<Orden> getOrdenesDeImportacion() {
		return ordenesDeImportacion;
	}

	public List<Orden> getOrdenesDeExportacion() {
		return ordenesDeExportacion;
	}

	public List<Orden> getOrdenesFinalizadas() {
		return ordenesFinalizadas;
	}

	public IBuscadorViajes getMotorDeLaTerminal() {
		return motorDeLaTerminal;
	}
}
