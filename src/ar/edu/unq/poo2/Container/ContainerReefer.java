package ar.edu.unq.poo2.Container;

public class ContainerReefer extends Container{
	
	private double consumo;

	public ContainerReefer(double ancho, double largo, double altura, double capacidad, int id, double consumo) {
		super(ancho, largo, altura, capacidad, id);
		this.consumo = consumo;
	}
	
	public double getConsumoPorHora() {
		return this.consumo;
	}
	

}
