package graphic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.Administrador;
import obclass.Aerolinea;
import obclass.Aeropuerto;
import obclass.Comercial;
import obclass.VueloDeCabotaje;
import obclass.VueloInternacional;
import resources.manejoDeArchivos;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AgregarAviCabotaje extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel txDurac;

	VueloInternacional avion = null;
	
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textAsientosDisp;
	private JTextField textDistanciaEnKm;
	private JTextField textDestino;
	private JTextField textOrigen;
	private JTextField textPrecio;
	private JTextField textDuracionVuelo;
	
	public AgregarAviCabotaje(int idAdmin, Aerolinea aero)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon(getClass().getResource("/recursos/Avion.png")).getImage());
		setBounds(100, 100, 450, 200);
		txDurac = new JPanel();
		txDurac.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(txDurac);
		txDurac.setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca :");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMarca.setBounds(14, 17, 50, 14);
		txDurac.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo :");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModelo.setBounds(14, 55, 55, 14);
		txDurac.add(lblModelo);
		
		JLabel lblOrigen = new JLabel("Origen :");
		lblOrigen.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOrigen.setBounds(237, 17, 60, 14);
		txDurac.add(lblOrigen);
		
		JLabel lblDestino = new JLabel("Destino :");
		lblDestino.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDestino.setBounds(237, 55, 60, 14);
		txDurac.add(lblDestino);
		
		JLabel lblAsDisp = new JLabel("Asientos Disp :");
		lblAsDisp.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAsDisp.setBounds(14, 90, 97, 14);
		txDurac.add(lblAsDisp);
		
		JLabel lblPrecio = new JLabel("Precio : ");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecio.setBounds(237, 85, 54, 14);
		txDurac.add(lblPrecio);
		
		JLabel lblDistEnKm = new JLabel("Distancia en Km :");
		lblDistEnKm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDistEnKm.setBounds(14, 130, 110, 14);
		txDurac.add(lblDistEnKm);
		
		JLabel lblDuracionVuelo = new JLabel("Duracion :");
		lblDuracionVuelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDuracionVuelo.setBounds(237, 110, 105, 14);
		txDurac.add(lblDuracionVuelo);
		
		textMarca = new JTextField();
		textMarca.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textMarca.getText().equals("Marca"))
				{
					textMarca.setText("");
				}
				else
				{
					textMarca.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(textMarca.getText().equals(""))
					textMarca.setText("Marca");
			}
		});
		textMarca.setText("Marca");
		textMarca.setBounds(124, 15, 86, 20);
		txDurac.add(textMarca);
		textMarca.setColumns(10);
		
		textModelo = new JTextField();
		textModelo.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textModelo.getText().equals("Modelo"))
				{
					textModelo.setText("");
				}
				else
				{
					textModelo.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(textModelo.getText().equals(""))
					textModelo.setText("Modelo");
			}
		});
		textModelo.setText("Modelo");
		textModelo.setBounds(124, 54, 86, 20);
		txDurac.add(textModelo);
		textModelo.setColumns(10);
		
		textAsientosDisp = new JTextField();
		textAsientosDisp.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textAsientosDisp.getText().equals("Disponibilidad"))
				{
					textAsientosDisp.setText("");
				}
				else
				{
					textAsientosDisp.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(textAsientosDisp.getText().equals(""))
					textAsientosDisp.setText("Disponibilidad");
			}
		});
		textAsientosDisp.setText("Disponibilidad");
		textAsientosDisp.setBounds(124, 89, 86, 20);
		txDurac.add(textAsientosDisp);
		textAsientosDisp.setColumns(10);
		
		textDistanciaEnKm = new JTextField();
		textDistanciaEnKm.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textDistanciaEnKm.getText().equals("Distancia"))
				{
					textDistanciaEnKm.setText("");
				}
				else
				{
					textDistanciaEnKm.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(textDistanciaEnKm.getText().equals(""))
					textDistanciaEnKm.setText("Distancia");
			}
		});
		textDistanciaEnKm.setText("Distancia");
		textDistanciaEnKm.setBounds(124, 129, 86, 20);
		txDurac.add(textDistanciaEnKm);
		textDistanciaEnKm.setColumns(10);
		
		textDestino = new JTextField();
		textDestino.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textDestino.getText().equals("Destino"))
				{
					textDestino.setText("");
				}
				else
				{
					textDestino.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(textDestino.getText().equals(""))
					textDestino.setText("Destino");
			}
		});
		textDestino.setText("Destino");
		textDestino.setBounds(326, 53, 86, 20);
		txDurac.add(textDestino);
		textDestino.setColumns(10);
		
		textOrigen = new JTextField();
		textOrigen.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textOrigen.getText().equals("Origen"))
				{
					textOrigen.setText("");
				}
				else
				{
					textOrigen.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(textOrigen.getText().equals(""))
					textOrigen.setText("Origen");
			}
		});
		textOrigen.setText("Origen");
		textOrigen.setBounds(326, 14, 86, 20);
		txDurac.add(textOrigen);
		textOrigen.setColumns(10);
		
		textPrecio = new JTextField();
		textPrecio.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textPrecio.getText().equals("Precio"))
				{
					textPrecio.setText("");
				}
				else
				{
					textPrecio.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(textPrecio.getText().equals(""))
					textPrecio.setText("Precio");
			}
		});
		textPrecio.setText("Precio");
		textPrecio.setBounds(326, 83, 86, 20);
		txDurac.add(textPrecio);
		textPrecio.setColumns(10);
		
		textDuracionVuelo = new JTextField();
		textDuracionVuelo.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textDuracionVuelo.getText().equals("Duracion"))
				{
					textDuracionVuelo.setText("");
				}
				else
				{
					textDuracionVuelo.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(textDuracionVuelo.getText().equals(""))
					textDuracionVuelo.setText("Duracion");
			}
		});
		textDuracionVuelo.setText("Duracion");
		textDuracionVuelo.setBounds(326, 108, 86, 20);
		txDurac.add(textDuracionVuelo);
		textDuracionVuelo.setColumns(10);
		
		JButton btnAgregar = new JButton("Aceptar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				if(textMarca.getText().equalsIgnoreCase("Marca") || (textModelo.getText().equalsIgnoreCase("Modelo")) || (textAsientosDisp.getText().equalsIgnoreCase("Disponibilidad")) || (textDistanciaEnKm.getText().equalsIgnoreCase("Distancia"))|| (textOrigen.getText().equalsIgnoreCase("Origen"))|| (textPrecio.getText().equalsIgnoreCase("Precio"))|| (textDuracionVuelo.getText().equalsIgnoreCase("Duracion")))
				{
					EventQueue.invokeLater(new Runnable() 
					{
						public void run()
						{
							try 
							{
								MsgError frame = new MsgError();
								frame.setVisible(true);
							} 
							catch (Exception e) 
							{
								e.printStackTrace();
							}
						}
					});
				}
				else
					{
							Administrador aux = new Administrador(LogginScreen.aeropuerto.buscaAdminId(idAdmin));
							
							int cantDest = Integer.parseInt(textAsientosDisp.getText().toString());
							double precio = Double.parseDouble(textPrecio.getText().toString());
							double distARec = Double.parseDouble(textDistanciaEnKm.getText().toString());
							double durVuel = Double.parseDouble(textDuracionVuelo.getText().toString());
							Comercial nuevoAvion = new VueloDeCabotaje(textMarca.getText(), textModelo.getText(), textOrigen.getText(), textDestino.getText(), cantDest , precio, distARec , durVuel);

							Aerolinea aAgregar = new Aerolinea(aero, nuevoAvion);
							
							manejoDeArchivos.agregarObjectRep(Aeropuerto.Comercial, nuevoAvion);
							manejoDeArchivos.agregarObjectRep(Aeropuerto.Aerolineas, aAgregar);
	
							manejoDeArchivos.agregarObjectRep(Aeropuerto.Admins, aux);
							app.Main.viewSwitcher("login");
							dispose();
					}
				}
			
		});
		btnAgregar.setBounds(237, 134, 89, 23);
		txDurac.add(btnAgregar);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(337, 134, 89, 23);
		txDurac.add(btnNewButton_1);
	}
}