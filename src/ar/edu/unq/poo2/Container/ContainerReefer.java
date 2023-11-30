package ar.edu.unq.poo2.Container;

public class ContainerReefer extends Container{
	
	private double consumo;

	public ContainerReefer(double ancho, double largo, double altura, double capacidad, int id, String tipoContainer, double consumo) {
		super(ancho, largo, altura, capacidad, id, tipoContainer);
		this.consumo = consumo;
	}
	
	public double getConsumoPorHora() {
		return this.consumo;
	}
	

}
