package ar.edu.unq.poo2.Orden;

import java.time.Duration;
import java.time.LocalDateTime;

import ar.unq.edu.poo2.Common.Camion;
import ar.unq.edu.poo2.Common.Conductor;

public class Turno {
	private Camion camionEnLaOrden;
	private Conductor conductorEnLaOrden;
	private LocalDateTime hora;
	
	
	
	public boolean verificarTurno(Camion camionQueLlego, Conductor conductorDelCamion, LocalDateTime horaQueLlego) {
		return(this.camionEnLaOrden.equals(conductorDelCamion)&&this.conductorEnLaOrden.equals(conductorDelCamion)&&this.estaDentroDeLaTolerancia(this.hora,horaQueLlego ));
	}



	private boolean estaDentroDeLaTolerancia(LocalDateTime horaDelTurno, LocalDateTime horaQueLlego ) {
		 Duration diferencia = Duration.between(horaDelTurno, horaQueLlego );
		 
	        long diferenciaEnHoras = Math.abs(diferencia.toHours());

	        // Verificar si la diferencia está dentro de las 3 horas
	        return diferenciaEnHoras <= 3;
	}
}
