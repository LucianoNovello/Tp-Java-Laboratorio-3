package obclass;

import java.io.Serializable;
import java.util.ArrayList;



public class ListadoAerolinea implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Aerolinea>ListadoAero;

	//CONSTRUCTOR COMPLETO
	public ListadoAerolinea() 
		{
			ListadoAero = new ArrayList<Aerolinea>();
		}
	
		 
	//METODOS 
	/*
	* agrega
	* @param recibe una nueva aerolinea
	*/
	public boolean agregarAerolinea(Aerolinea nuevaAerolinea)
	{
		return ListadoAero.add(nuevaAerolinea);
	}
	
	/* 
	* retornaElListado
	*/
	
	public ArrayList<Aerolinea> getListadoAerolineas()
	{
		return ListadoAero;
	}
	
	/*
	* retornaElTama�oDelListado
	*/
	public int getTama�oLista()
	{
		return ListadoAero.size();
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
	
	public boolean eliminarAerolinea(Aerolinea aero)
	{
		if(!estaVacia())
		{
			return ListadoAero.remove(aero);
		}
		else
		{
			return false;
		}
	}
	
	/*
	* mostrarListado
	*/
	
	public String listarAerolineas()
	{
		StringBuilder buildi = new StringBuilder();
		
		for (Aerolinea aero : ListadoAero)
		{
			buildi.append(aero.toString()+"\n");
		}
	
		return buildi.toString();
	}	


	/*
	 * retorna el nombre de nuesra Aerolineas
	 */
	
	public ArrayList<String> retornaNombres()
	{
		ArrayList<String> aux = new ArrayList<String>();
		
		for (Aerolinea aerolinea : ListadoAero) 
		{
			aux.add(aerolinea.getNombre());
			
		}
		
		return aux;
	}	
	
}
