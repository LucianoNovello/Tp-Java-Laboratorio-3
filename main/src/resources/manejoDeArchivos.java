package resources;

import java.io.*;

import app.Administrador;
import app.Cliente;
import obclass.Aerolinea;
import obclass.Avion;
import obclass.BoletoDeAvion;

/*
 * claseConFuncionesEnParteCedidasPorElProfe
 * 
*/

public class manejoDeArchivos extends ObjectOutputStream
{
	private boolean append;
    private boolean initialized;
    private DataOutputStream dout;

    protected manejoDeArchivos(boolean append) throws IOException, SecurityException 
    {
        super();
        this.append = append;
        this.initialized = true;
    }

    public manejoDeArchivos(OutputStream out, boolean append) throws IOException 
    {
        super(out);
        this.append = append;
        this.initialized = true;
        this.dout = new DataOutputStream(out);
        this.writeStreamHeader();
    }

    @Override
    protected void writeStreamHeader() throws IOException 
    {
        if (!this.initialized || this.append) return;
        if (dout != null) {
            dout.writeShort(STREAM_MAGIC);
            dout.writeShort(STREAM_VERSION);
        }
    }
    /*
     * recorre y muestra el archivo
     */
	public static void mostrarArchivo(File file)
	{
		Object aux;
		String nombreDelArchivo = file.getName();
		
		try	{
			
			FileInputStream bn = new FileInputStream(nombreDelArchivo);
			ObjectInputStream fobj = new ObjectInputStream(bn);
			aux = fobj.readObject();
	
			while(aux!=null)
			{ 
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
	 * recorre y devuelve un boolean si se encuentra el id
	 */
	public static boolean buscarID(String nombreDelArchivo, int id) throws IOException, Exception
    {
        int b=0;
        boolean encontrado = false;
        
        Object aux;
        FileInputStream bn = new FileInputStream(nombreDelArchivo);
        ObjectInputStream fobj = new ObjectInputStream(bn);
        aux = fobj.readObject();
        
        while((aux!=null) && (encontrado == false))
        {
            aux = fobj.readObject();

            if(aux instanceof Administrador)
            {
            	Administrador auxi = (Administrador) aux;
	            b = auxi.getIdAdmin();
	            if(b == id)
	            {
	                encontrado = true;
	            }
            }
            else if(aux instanceof Cliente)
            {
            	Cliente auxi = (Cliente) aux;
	            b = auxi.getIdCliente();
	            if(b == id)
	            {
	                encontrado = true;
	            }
            }
            else if(aux instanceof BoletoDeAvion)
            {
                BoletoDeAvion auxi = (BoletoDeAvion) aux;
                b = auxi.getIdBoleto();
                if(b == id)
                {
                    encontrado = true;
                }
            }
        }
 
        fobj.close();
       
       return encontrado;
    }
        
    
    /*
     * metodo para no repetir numeros de asiento, ponelo en manejar archivo

     */
    public static boolean buscarnAsiento(String nombreDelArchivo, int nAsiento) throws IOException, Exception
    {
        int b=0;
        boolean encontrado = false;
       
        Object aux;
        FileInputStream bn = new FileInputStream(nombreDelArchivo);
        ObjectInputStream fobj = new ObjectInputStream(bn);
        aux = fobj.readObject();
       
        while((aux!=null) && (encontrado == false))
        {
            aux = fobj.readObject();
 
           
             if(aux instanceof BoletoDeAvion)
            {
                BoletoDeAvion auxi = (BoletoDeAvion) aux;
                b = auxi.getnAsiento();
                if(b == nAsiento)
                {
                    encontrado = true;
                }
            }
        }
 
        fobj.close();
       
       return encontrado;
    }
    
	/*
	 * retorna true si se encuentra la aerolinea
	 */
	public static boolean buscarNombre(String nombreDelArchivo, String nombre) throws IOException, Exception
    {
        String b;
        boolean encontrado = false;
        
        Object aux;
        FileInputStream bn = new FileInputStream(nombreDelArchivo);
        ObjectInputStream fobj = new ObjectInputStream(bn);
        aux = fobj.readObject();
        
        while((aux!=null) && (encontrado == false))
        {
            aux = fobj.readObject();
            
             if(aux instanceof Aerolinea)
             {
            	 Aerolinea auxi = (Aerolinea) aux;
            	 b = auxi.getNombre();
            	 if(b.equals(nombre))
            	 	{
            		 	encontrado = true;
            	 	}	
            }
        }

        fobj.close();
        
       return encontrado;
    }
	
	/*
	 * agrega objetos pisando parametros 
	 */
	public static void agregarObjectRep(File file,Object obj )
	{
		String nombreDelArchivo = file.getName();
		boolean append = file.exists();
 		try 
		{
 			if(obj instanceof Cliente)
			{
				Cliente aux = (Cliente) obj;
				while(manejoDeArchivos.buscarID(nombreDelArchivo, aux.getIdCliente())) 
				{
					aux.generarIdCliente();
				}
			}
			else if(obj instanceof Administrador)
			{
		        FileOutputStream fout = new FileOutputStream(file, append);
		        @SuppressWarnings("resource")
				manejoDeArchivos oout = new manejoDeArchivos(fout, append);	
				oout.writeObject(obj);	
			}
			else if(obj instanceof Aerolinea)
			{
		        FileOutputStream fout = new FileOutputStream(file, append);
		        @SuppressWarnings("resource")
				manejoDeArchivos oout = new manejoDeArchivos(fout, append);	
				oout.writeObject(obj);	
			}
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}			
        catch (IOException e)
        {
        	try
            {
		        FileOutputStream fout = new FileOutputStream(file, append);
		        @SuppressWarnings("resource")
				manejoDeArchivos oout = new manejoDeArchivos(fout, append);	
				oout.writeObject(obj);				
            }
            catch (FileNotFoundException e1)
            {
    			e1.printStackTrace();
            } catch (IOException e1) 
        	{
            	e1.printStackTrace();
        	}
       }
 		catch (Exception e)
 		{
 			e.printStackTrace();
 		}
	}
	/*
	 * agrega objetos al archivo sin repetidos(Los que necesitemos)
	 */
	public static void agregarObjectSinRep(File file,Object obj )
    {
        String nombreDelArchivo = file.getName();
        boolean append = file.exists();
        try
        {
            if(obj instanceof Cliente)
            {
                Cliente aux = (Cliente) obj;
                while(manejoDeArchivos.buscarID(nombreDelArchivo, aux.getIdCliente()))
                {
                    aux.generarIdCliente();
                }
            }
            else if(obj instanceof Administrador)
            {
                Administrador aux2 = (Administrador) obj;
                while(manejoDeArchivos.buscarID(nombreDelArchivo, aux2.getIdAdmin()))
                {
                    aux2.generarIdAdmin();
                }
            }
            else if (obj instanceof BoletoDeAvion) {
                BoletoDeAvion aux3=(BoletoDeAvion)obj;
                while(manejoDeArchivos.buscarID(nombreDelArchivo, aux3.getIdBoleto()))
                {
                    aux3.generarIdBoleto();
                    while(manejoDeArchivos.buscarnAsiento(nombreDelArchivo, aux3.getnAsiento()))
                    {
                        aux3.generarNumeroAsiento();
                    }
                }
               
            }
            else if (obj instanceof Avion) {
            	Avion aux4=(Avion)obj;
                while(manejoDeArchivos.buscarID(nombreDelArchivo, aux4.getIDAvion()))
                {
                    aux4.generarIdAvion();
                }
               
            }
            else if(obj instanceof Aerolinea)
            {  
                FileOutputStream fout = new FileOutputStream(file, append);
                @SuppressWarnings("resource")
                manejoDeArchivos oout = new manejoDeArchivos(fout, append);
                oout.writeObject(obj); 
            }
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }          
        catch (IOException e)
        {
            try
            {
                FileOutputStream fout = new FileOutputStream(file, append);
                @SuppressWarnings("resource")
                manejoDeArchivos oout = new manejoDeArchivos(fout, append);
                oout.writeObject(obj);             
            }
            catch (FileNotFoundException e1)
            {
                e1.printStackTrace();
            } catch (IOException e1)
            {
                e1.printStackTrace();
            }
       }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}