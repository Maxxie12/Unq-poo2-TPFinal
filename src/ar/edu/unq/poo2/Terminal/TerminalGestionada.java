package ar.edu.unq.poo2.Terminal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ar.edu.unq.poo2.BuscadorDeViajes.IBuscadorViajes;
import ar.edu.unq.poo2.Container.Container;
import ar.edu.unq.poo2.LineaNaviera.Buque;
import ar.edu.unq.poo2.LineaNaviera.Circuito;
import ar.edu.unq.poo2.LineaNaviera.LineaNaviera;
import ar.edu.unq.poo2.LineaNaviera.Viaje;
import ar.edu.unq.poo2.MejorCircuito.IMejorCircuito;
import ar.edu.unq.poo2.MejorCircuito.MenorPrecio;
import ar.edu.unq.poo2.Orden.Orden;
import ar.edu.unq.poo2.Orden.OrdenExportacion;
import ar.edu.unq.poo2.Orden.OrdenImportacion;
import ar.edu.unq.poo2.Orden.Turno;
import ar.edu.unq.poo2.Servicios.Servicio;
import ar.unq.edu.poo2.Common.Camion;
import ar.unq.edu.poo2.Common.Cliente;
import ar.unq.edu.poo2.Common.Conductor;
import ar.unq.edu.poo2.Common.EmpresaTransportista;

public class TerminalGestionada extends Terminal {
		
	
	private List<LineaNaviera>         lineasNavierasRegistradas;
	private List<EmpresaTransportista> empresasRegistradas;
	private List<Cliente> 			   clientesRegistrados;
	private List<Orden>				   ordenesRegistradas;
	private List<Orden>				   ordenesFinalizadas;
	private IMejorCircuito			   mejorCircuito;
	
	
	public TerminalGestionada(String nombre,List<LineaNaviera> lineasNavierasRegistradas,
							  List<EmpresaTransportista> empresasRegistradas,
							  List<Cliente> clientesRegistrados) {
		super(nombre);
		this.lineasNavierasRegistradas = lineasNavierasRegistradas;
		this.empresasRegistradas       = empresasRegistradas;
		this.clientesRegistrados       = clientesRegistrados;
		this.mejorCircuito			   = new MenorPrecio();
		this.ordenesRegistradas        = new ArrayList<Orden>();
		this.ordenesFinalizadas		   = new ArrayList<Orden>();
	}
	
	//Registros
	public void registrarLineaNaviera(LineaNaviera linea) {
		this.lineasNavierasRegistradas.add(linea);
	}
	
	public void registrarEmpresaTransportista(EmpresaTransportista emp) {
		this.empresasRegistradas.add(emp);
	}
	
	public void registrarCliente(Cliente cliente) {
		this.clientesRegistrados.add(cliente);
	}
	
	public void crearOrdenImportacion(Cliente cliente ,
									  Container datosDeLaCarga,List<Servicio> serviciosContratados,
									  Conductor conductor,Camion camion,Viaje viajeSeleccionado,Terminal terminalOrigen,
									  LocalTime horaDelTurno) {
		
		LocalDateTime fechaDelTurno = viajeSeleccionado.getFechaDeLlegadaALaTerminalGestionada().atTime(horaDelTurno);
		Turno turno            = new Turno(camion,conductor,fechaDelTurno);
		Orden ordenImportacion = new OrdenImportacion(viajeSeleccionado.getFechaDeInicio(), 
													  viajeSeleccionado.getFechaDeLlegadaALaTerminalGestionada(), 
													  cliente,viajeSeleccionado, 
													  serviciosContratados, datosDeLaCarga, turno, terminalOrigen, this);
		ordenesRegistradas.add(ordenImportacion);
	}
	
	public void crearOrdenExportacion(Cliente cliente ,
			  Container datosDeLaCarga,List<Servicio> serviciosContratados,
			  Conductor conductor,Camion camion,Viaje viajeSeleccionado,Terminal terminalDestino,
			  LocalTime horaDelTurno) {
		
		LocalDate fechaDeLLegadaALaTerminal = viajeSeleccionado.getFechaDeLlegadaALaTerminalGestionada();
		
		Turno turno            = new Turno(camion,conductor,fechaDeLLegadaALaTerminal.atTime(horaDelTurno));
		
		Orden ordenImportacion = new OrdenImportacion(fechaDeLLegadaALaTerminal, 
													  viajeSeleccionado.getFechaDeLlegadaA(terminalDestino), 
													  cliente, viajeSeleccionado, 
													  serviciosContratados, datosDeLaCarga, turno,this,terminalDestino);
		
		ordenesRegistradas.add(ordenImportacion);
		
	}
	
	public Circuito devolverMejorCircuitoA(Terminal terminalDestino) {
		return this.mejorCircuito.mejorCircuito(this.getTodosLosCircuito(), terminalDestino);
	}
	
	// getters
	public List<LineaNaviera> getLineasNavierasRegistradas() {
		return lineasNavierasRegistradas;
	}
	
	public List<EmpresaTransportista> getEmpresasRegistradas() {
		return empresasRegistradas;
	}

	public List<Cliente> getClientesRegistrados() {
		return clientesRegistrados;
	}

	public List<Orden> getOrdenesRegistradas() {
		return ordenesRegistradas;
	}

	public List<Orden> getOrdenesFinalizadas() {
		return ordenesFinalizadas;
	}

	public List<Circuito> getTodosLosCircuito(){
		 return this.lineasNavierasRegistradas.stream()
		            .flatMap(lineaNaviera -> lineaNaviera.getCircuitosRegistrados().stream())
		            .collect(Collectors.toList());
	}
	
	public List<Viaje> getTodosLosViajes(){
		return this.lineasNavierasRegistradas.stream()
	            .flatMap(lineaNaviera -> lineaNaviera.getViajesDisponibles().stream())
	            .collect(Collectors.toList());

	}
		
	//otros
	
	public void inminenteArriboDelBuque(Buque buque) {	
		List<Orden> lista = this.getOrdenesDeImportacionQueEsperan(buque);
			lista.stream()
			.forEach(o -> o.mandarEmailACliente());
		
	} 
	
	private List<Orden> getOrdenesDeImportacionQueEsperan(Buque buque) {
	    return this.ordenesRegistradas.stream()
	            .filter(o -> o.getViajeSeleccionado().getBuqueAsignado().equals(buque))
	            .filter(o -> o instanceof OrdenImportacion)
	            .collect(Collectors.toList());
	}

	public void elBuqueAbandonoLasCercanias(Buque buque) {
		List<Orden> lista = this.getOrdenesDeExportacionQueEsperan(buque);
		lista.stream()
		.forEach(o -> o.mandarEmailACliente());
		this.mandarFacturasPorEl(buque);
	}
	
	private List<Orden> getOrdenesDeExportacionQueEsperan(Buque buque) {
		return this.ordenesRegistradas.stream()
	            .filter(o -> o.getViajeSeleccionado().getBuqueAsignado().equals(buque))
	            .filter(o -> o instanceof OrdenImportacion)
	            .collect(Collectors.toList());
				
	}
	
	private void mandarFacturasPorEl(Buque buque) {
		List<Orden> lista = this.getOrdenesConEl(buque);
		lista.stream()
		.forEach(o -> o.mandarFacturaACliente());
		
	}
	
	
	private List<Orden> getOrdenesConEl(Buque buque) {
		return this.ordenesRegistradas.stream()
				   .filter(o -> o.RelacionadaA(buque))
				   .toList();
	}
	
	public List<Orden> ordenesActualesRelacionadasAlCliente(Cliente cliente){
		return this.ordenesRegistradas.stream()
				.filter(o -> o.getCliente().equals(cliente))
				.toList();
	}
	
	public Circuito devolverMejorCircuito(Terminal terminalDestino) {
		return mejorCircuito.mejorCircuito(getTodosLosCircuito(), terminalDestino);
		
	}
	
	public Optional<LocalDate> devolverFechaProximaHacia(Terminal terminalDestino) {
	        return this.lineasNavierasRegistradas.stream()
	                .map(l -> l.proximaSalidaA(terminalDestino))
	                .min(LocalDate::compareTo);
	                
	    }
	
	
	
	//setters
	public void setMejorCircuito(IMejorCircuito mejorCircuito) {
		this.mejorCircuito = mejorCircuito;
	}
	
	
	
} 
