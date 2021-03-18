package clases;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import app.Administrador;
import app.Cliente;
import app.ListadoAdmin;
import app.ListadoCliente;
import recursos.manejoDeArchivos;

public class Aeropuerto implements Serializable
{
	private String nombre;
	private String paisOrigen;
	private String direccion;
	ListadoAdmin admins;
	ListadoCliente clientes;
	
	/*
	 * declaracion archivos
	 */
	public static final File Admins = new File("Admins.dat"); 
	public static final File Clientes = new File("Clientes.dat");
	public static final File Aerolineas = new File("Aerolineas.dat");
	public static final File Boleto = new File("Boletos.dat");
	public static final File Comercial = new File("Comerciales.dat");
	public static final File CARGA = new File("Carga.dat");
	public static final File MILITAR = new File("Militares.dat");

	//CONSTRUCTOR COMPLETO
	public Aeropuerto(String nombre, String paisOrigen, String direccion)
	{
		super();
		this.setNombre(nombre);
		this.setPaisOrigen(paisOrigen);
		this.setDireccion(direccion);
		admins = new ListadoAdmin();
		clientes = new ListadoCliente();
	}
	
	//CONSTRUCTOR VACIO
	public Aeropuerto()
	{
		super();
		nombre = "";
		paisOrigen = "";
		direccion = "";
		admins = null;
		clientes = null;
	}
	
	//GETTERS && SETTERS
	public String getNombre()
	{
		return nombre;
	}

	public String getPaisOrigen() 
	{
		return paisOrigen;
	}

	public String getDireccion() 
	{
		return direccion;
	}

	public void setDireccion(String direccion) 
	{
		this.direccion = direccion;
	}


	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public void setPaisOrigen(String paisOrigen) 
	{
		this.paisOrigen = paisOrigen;
	}
	
	//METODOS

	/*
	 * adquirimos listado de los admin disponibles
	 */
	public void importarDesdeArchivoAdmins(File file)
	{
		Object aux;
		String nombreDelArchivo = file.getName();
		
		try	{
			
			FileInputStream bn = new FileInputStream(nombreDelArchivo);
			ObjectInputStream fobj = new ObjectInputStream(bn);
			aux = fobj.readObject();
	
			while(aux!=null)
			{ 
				if(aux instanceof Administrador)
				{
					Administrador adm = (Administrador) aux;
					Administrador nuevoAdmin = new Administrador(adm);
					admins.agregarAdministrador(nuevoAdmin);
				}
				aux = fobj.readObject();
			}
			fobj.close();
		}catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}catch (IOException e) {
		}
	}
	
	/*
	 * adquirimos listado de los usuarios disponibles
	 */
	public void importarDesdeArchivoUsuariosCreados(File file)
	{
		Object aux;
		String nombreDelArchivo = file.getName();
		
		try	{
			
			FileInputStream bn = new FileInputStream(nombreDelArchivo);
			ObjectInputStream fobj = new ObjectInputStream(bn);
			aux = fobj.readObject();
	
			while(aux!=null)
			{ 
				if(aux instanceof Cliente)
				{
					Cliente elem = (Cliente) aux;
					clientes.agregarCliente(elem);
				}
				aux = fobj.readObject();
			}
			fobj.close();
		}catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}catch (IOException e) {
		}
	}
	
	/*
	 * adquirimos listado de los admin disponibles
	 */
	public void importarDesdeArchivoAerolineas(File file, Administrador adm)
	{
		Object aux;
		String nombreDelArchivo = file.getName();
		
		try	{
			
			FileInputStream bn = new FileInputStream(nombreDelArchivo);
			ObjectInputStream fobj = new ObjectInputStream(bn);
			aux = fobj.readObject();
	
			while(aux!=null)
			{ 
				if(aux instanceof Aerolinea)
				{
					Aerolinea aero = (Aerolinea) aux;
					Aerolinea aIngresar = new Aerolinea(aero);
					adm.asigarAerolineaAAdmin(aIngresar);
				}
				aux = fobj.readObject();
			}
			fobj.close();
		}catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}catch (IOException e) {
		}
	}
	
	public String recorrerYMostrarAdmins()
	{
		return admins.listarAdmins();
	}
	
	public String recorrerYMostrarClientes()
	{
		return clientes.listarClientes();
	}
	
	/*
	 * recorre el listado de Admins, en busca de usuario y contrase�a
	 */
	public int buscaAdmin(String User, String Password)
	{
		int rta = -1;

		ArrayList<Administrador> auxi = admins.getListadoAdm();

		for(int i = 0; i<admins.getTamañoLista(); i++)
		{
			if((auxi.get(i).getNombre().equalsIgnoreCase(User)) && (auxi.get(i).getContrasenia().equalsIgnoreCase(Password)))
			{
				rta = auxi.get(i).getIdAdmin();
			}
		}
		return rta;
	}
	/*
	 * recorre el listado de Clientes, en busca de usuario y contrase�a
	 */
	public boolean buscaClientes(String User, String Password)
	{
		boolean rta = false;

		ArrayList<Cliente> auxi = clientes.getListadoClientes();

		for(int i = 0; i<clientes.getTama�oLista(); i++)
		{
			if((auxi.get(i).getUsuario().equalsIgnoreCase(User)) && (auxi.get(i).getContrase�a().equalsIgnoreCase(Password)))
			{
				return true;
			}
		}
		return rta;
	}
	
	/*
	 *  Busca dentro del Listado de admins en busca del mismo, y lo retorna
	 * @param recibe el id del admins,
	 */
	public Administrador buscaAdminId(int idAdmin)
    {
        Administrador rta1 = null;
        ArrayList<Administrador> auxi = admins.getListadoAdm();
 
        for(int i = 0; i<auxi.size(); i++)
 
            {
            if(auxi.get(i).getIdAdmin()==idAdmin) {
                Administrador rta= (Administrador)auxi.get(i);
                 rta1=new Administrador(rta);
            }
        }
        return rta1;
    }
		
	/*
	 * Utilizamos la funcion que nos retorna el Admin, mediante el param que traemos y mostramos los nombres de la Aerolienea
	 */
     public ArrayList<String> retornaListado(int idAdmin)
     {
 
            Administrador aux= buscaAdminId(idAdmin);
            ArrayList<String>aux2=aux.obtenerNombresAerolineas(idAdmin) ;
 
 
            return aux2;
      }
     

	
}
