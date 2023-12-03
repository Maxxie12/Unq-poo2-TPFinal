package ar.edu.unq.poo2.Orden;

import java.time.Duration;
import java.time.LocalDateTime;

import ar.unq.edu.poo2.Common.Camion;
import ar.unq.edu.poo2.Common.Conductor;

public class Turno {
	private Camion camionEnLaOrden;
	private Conductor conductorEnLaOrden;
	private LocalDateTime hora;
	
	
	public Turno(Camion camionEnLaOrden, Conductor conductorDeLaOrden, LocalDateTime hora) {
		this.camionEnLaOrden = camionEnLaOrden;
		this.conductorEnLaOrden = conductorDeLaOrden;
		this.hora				= hora;
	}
	
	public boolean verificarTurno(Camion camionQueLlego, Conductor conductorDelCamion, LocalDateTime horaQueLlego, int tolerancia) {
		return(this.camionEnLaOrden.equals(camionQueLlego )&&this.conductorEnLaOrden.equals(conductorDelCamion)&&this.estaDentroDeLaTolerancia(this.hora,horaQueLlego, tolerancia ));
	}



	public boolean estaDentroDeLaTolerancia(LocalDateTime horaDelTurno, LocalDateTime horaQueLlego, int tolerancia ) {
		 Duration diferencia = Duration.between(horaDelTurno, horaQueLlego );
		 
	        long diferenciaEnHoras = Math.abs(diferencia.toHours());

	        // Verificar si la diferencia está dentro de las 3 horas
	        return diferenciaEnHoras <= tolerancia;
	}
}
