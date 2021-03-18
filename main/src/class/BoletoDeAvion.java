package clases;

import java.io.Serializable;

public class BoletoDeAvion implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idBoleto;
	private String origen;
	private String destino;
	private double precio;
	private double duracionVuelo;
	private int nAsiento;
	private int nPista;
	private boolean disponible; 
	
	public BoletoDeAvion(String origen, String destino, double precio, double duracionVuelo, boolean disponible)
	{
		super();
		generarIdBoleto();
		this.origen = origen;
		this.destino = destino;
		this.precio = precio;
		this.duracionVuelo = duracionVuelo;
		generarNumeroAsiento();
		generarNumeroPista();
		this.disponible= disponible;
		
	}
	
	//CONSTRUCTOR VACIO
	public BoletoDeAvion() 
	{
		super();
		idBoleto = 0;
		origen = "";
		destino = "";
		precio = 0;
		duracionVuelo = 0;
		nAsiento = 0;
		nPista = 0;
		disponible = true;
	}

	//GETERRS && SETTERS
	public Integer getIdBoleto()
	{
		return idBoleto;
	}

	public String getOrigen() 
	{
		return origen;
	}

	public double getPrecio() 
	{
		return precio;
	}
	
	public int getnAsiento() 
	{
		return nAsiento;
	}

	public String getDestino() 
	{
		return destino;
	}
	
	
	public double getDuracionVuelo() 
	{
		return duracionVuelo;
	}

	public int getNPista()
	{
		return nPista;
	}
	
	public void setId(Integer idBoleto)
	{
		this.idBoleto = idBoleto;
	}
	
	public void setDestino(String destino) 
	{
		this.destino = destino;
	}

	public void setDuracionVuelo(double duracionVuelo) 
	{
		this.duracionVuelo = duracionVuelo;
	}


	public void setPrecio(double precio)
	{
		this.precio = precio;
	}

	public void setnAsiento(int nAsiento) 
	{
		this.nAsiento = nAsiento;
	}

	
	public void setnPista(int nPista) 
	{
		this.nPista = nPista;
	}
	
	//METODOS
	public void generarIdBoleto()
	{
		int nRandom;
		nRandom=((int)(Math.random()*10000+1));
		setId(nRandom);	
		
	}
	
	public void generarNumeroPista()
	{
		int nPista;
		
		nPista=((int)(Math.random()*100+1));
		
		setnPista(nPista);	
	}
	
	public void generarNumeroAsiento()
	{
		int nAsiento;
		
		nAsiento=((int)(Math.random()*100+1));
		
		setnAsiento(nAsiento);	
	}

	@Override
	public String toString() {
		return "BoletoDeAvion [idBoleto=" + idBoleto + ", origen=" + origen + ", destino=" + destino + ", precio="
				+ precio + ", duracionVuelo=" + duracionVuelo + ", nAsiento=" + nAsiento + ", nPista=" + nPista + "]";
	}
	
	
	
}
