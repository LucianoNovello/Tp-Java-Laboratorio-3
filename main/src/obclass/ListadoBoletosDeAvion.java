package obclass;

import java.io.Serializable;
import java.util.ArrayList;

public class ListadoBoletosDeAvion implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<BoletoDeAvion>ListadoBoletos;
	
	public ListadoBoletosDeAvion()
	{
		ListadoBoletos = new ArrayList<BoletoDeAvion>();
	}
	
	//METODOS 
	/*
	* agrega un boleto y lo agrega
	* @param recibe una nueva aerolinea
	*/
	public boolean agregarBoletoAvion(BoletoDeAvion nuevoBoletoDeAvion)
	{
		return ListadoBoletos.add(nuevoBoletoDeAvion);
	}
	
	/* 
	* retornaElListado
	*/
	
	public ArrayList<BoletoDeAvion> getListadoBoletosDeAvion()
	{
		return ListadoBoletos;
	}
	
	/*
	* retornaElTama�oDelListado
	*/
	public int getTama�oLista()
	{
		return ListadoBoletos.size();
	}
	
	/*
	* retornaSiEstaVacia
	*/
	public boolean estaVacia()
	{
		if (getTama�oLista() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*
	* eliminarDelListadoDeAviones
	*/
	
	public boolean eliminarBoletoDeAvion(BoletoDeAvion boletoABorrar)
	{
		if(!estaVacia())
		{
			return ListadoBoletos.remove(boletoABorrar);
		}
		else
		{
			return false;
		}
	}
	
	/*
	* mostrarListado
	*/
	
	public String listarBoletosDeAvion()
	{
		StringBuilder buildi = new StringBuilder();
		
		for (BoletoDeAvion boleto : ListadoBoletos)
		{
			buildi.append(boleto.toString()+"\n");
		}
	
		return buildi.toString();
	}	
}



