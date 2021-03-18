package clases;

import java.io.Serializable;

public abstract class Avion extends Aerolinea implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private int idAvion ; 
	private String marca;
	private String modelo;
	private String origen;
	private String destino;
	
	//CONSTRUCTOR COMPLETO
	public Avion(String nombre, String cuit, String marca, String modelo, String origen, String destino) 
	{
		super(nombre,cuit);
		generarIdAvion();
		this.marca = marca;
		this.modelo = modelo;
		this.origen = origen;
		this.destino = destino;
	}
	
	//CONSTRUCTOR SIN DATOS PADRE
	public Avion(String marca, String modelo, String origen, String destino) 
	{
		super();
		generarIdAvion();
		this.marca = marca;
		this.modelo = modelo;
		this.origen = origen;
		this.destino = destino;
	}
	//CONSTRUCTOR VACIO
	public Avion()
	{
		super();
		generarIdAvion();
		marca = "";
		modelo = "";
		origen = "";
		destino = "";
	}
	
	
	//GETTERS && SETTERS
	
	public String getMarca()
	{
		return marca;
	}
	
	public String getModelo()
	{
		return modelo;
	}
	
	public String getOrigen()
	{
		return origen;
	}
	
	public String getDestino()
	{
		return destino;
	}
	
	public int getIDAvion()
	{
		return idAvion;
	}

	public void setMarca(String marca)
	{
		this.marca = marca;
	}
	
	public void setModelo(String modelo)
	{
		this.modelo = modelo;
	}
	
	public void setOrigen(String origen)
	{
		this.origen = origen;
	}
	
	public void setDestino(String destino)
	{
		this.destino = destino;
	}
	
	public void setIDAvion(int id)
	{
		this.idAvion = id;
	}
	//METODOS 
	/*
	 *generaIdRandom 
	 */
	public void generarIdAvion()
	{
		int nRandom;
		
		nRandom=((int)(Math.random()*100+1));
		
		setIDAvion(nRandom);	
	}
	

	@Override
	public String toString() {
		return super.toString()+ "Avion [idAvion=" + idAvion + ", marca=" + marca + ", modelo=" + modelo + ", origen=" + origen
				+ ", destino=" + destino + "]";
	}

	@Override
	public boolean equals(Object obj) 
	{
		boolean encontrado = false;
		
		if(obj != null)
		{
			if(obj instanceof Avion)
			{
				Avion aux = (Avion) obj;
				if(aux.getIDAvion() == getIDAvion())
				{
					encontrado = true;
				}
			}
		}
		
		return encontrado;
	}
	
	@Override
	public int hashCode() 
	{
		return 1;
	}
}
	
