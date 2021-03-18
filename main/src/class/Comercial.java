package clases;

import java.io.Serializable;

public class Comercial extends Avion implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private int cantidadAsientosDisponibles;
	private double precio;
	private double kilometrosARecorrer;
	private double duracionVuelo;
	
	//CONSTRUCTOR COMPLETO
	public Comercial(String marca, String modelo, String origen, String destino, int cantidadAsientosDisponibles, double precio, double kilometrosARecorrer, double duracionVuelo) 
	{
		super(marca, modelo, origen, destino);
		this.cantidadAsientosDisponibles = cantidadAsientosDisponibles;
		this.precio = precio;
		this.kilometrosARecorrer = kilometrosARecorrer;
		this.duracionVuelo = duracionVuelo;
	}
	
	//CONSTRUCTOR VACIO
	public Comercial()
	{
		super();
		this.cantidadAsientosDisponibles = 0;
		this.precio = 0;
		this.kilometrosARecorrer = 0;
		this.duracionVuelo = 0;
	}
	
	//GETTERS && SETTERS
	public int getCantidadAsientosDisponibles()
	{
		return cantidadAsientosDisponibles;
	}
	
	public double getPrecio()
	{
		return precio;
	}
	
	public double getKilometrosARecorrer()
	{
		return kilometrosARecorrer;
	}
	
	public double getDuracionVuelo()
	{
		return duracionVuelo;
	}
	
	public void setCantidadAsientosDisponibles(int cantidadAsientosDisponibles)
	{
		this.cantidadAsientosDisponibles = cantidadAsientosDisponibles;
	}
	
	public void setPrecio(double precio)
	{
		this.precio = precio;
	}
	
	public void setKilometrosARecorrer(int kilometrosARecorrer)
	{
		this.kilometrosARecorrer = kilometrosARecorrer;
	}
	
	public void setDuracionVuelo(int duracionVuelo)
	{
		this.duracionVuelo = duracionVuelo;
	}

	//METODOS
	@Override
	public String toString() {
		return super.toString()+"Comercial [cantidadAsientos=" + getCantidadAsientosDisponibles() + ", precio=" + getPrecio() + ", kilometrosARecorrer="
				+ getKilometrosARecorrer() + ", duracionVuelo=" + getDuracionVuelo() + "hs" +"]";
	}
		
	/*
	 * alertaVueloErroneo
	 */
	public String alertaVueloErroneo()
	{
		return "No es posible crear un vuelo de cabotaje con esa cantidad de KM";
	}
}
