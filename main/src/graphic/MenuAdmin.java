package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.Administrador;
import clases.Aerolinea;
import clases.Aeropuerto;
import recursos.manejoDeArchivos;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.PopupMenu;

import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuAdmin extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMenuAdmin;
	private JLabel lblIngresoAviones;
	
	static final String deCabotaje = "deCabotaje";
	static final String Internacional = "Internacional";
	static final String deCarga = "Carga";
	static final String Miitar = "Militar";

	/**
	 * Create the frame.
	 * @param idAdmin 
	 */
	public MenuAdmin(int idAdmin) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		this.setIconImage(new ImageIcon(getClass().getResource("/recursos/Avion.png")).getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * eleccion de Avion a Ingresar
		 */
		String[] Aviones = {"Seleccionar", "deCabotaje", "Internacional", "Carga", "Militar"} ;		
		JComboBox comboAviones = new JComboBox(Aviones);
		comboAviones.setBounds(232, 33, 80, 20);
		contentPane.add(comboAviones);
		
		/*
		 * eleccion Consulta Listados
		 */
		String[] Consulta = {"Seleccionar", "Aerolineas", "Aviones", "Boletos"} ;		
		JComboBox comboListados = new JComboBox(Consulta);
		comboListados.setBounds(142, 75, 80, 20);
		contentPane.add(comboListados);
		
		lblMenuAdmin = new JLabel("Menu Admin");
		lblMenuAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMenuAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuAdmin.setBounds(47, 3, 321, 28);
		contentPane.add(lblMenuAdmin);
		
		lblIngresoAviones = new JLabel("Ingresar Aviones : ");
		lblIngresoAviones.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngresoAviones.setBounds(15, 35, 125, 14);
		contentPane.add(lblIngresoAviones);
		

		JLabel lblCrearAdmin = new JLabel("Crear Admin");
		lblCrearAdmin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCrearAdmin.setBounds(327, 109, 100, 14);
		contentPane.add(lblCrearAdmin);
		
		JLabel lblListadoAerolineas = new JLabel("Consultar Listados :");
		lblListadoAerolineas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblListadoAerolineas.setBounds(15, 76, 122, 14);
		contentPane.add(lblListadoAerolineas);
		
		JButton btnConsultarAero = new JButton("Consultar");
		btnConsultarAero.setBounds(232, 75, 80, 22);
		contentPane.add(btnConsultarAero);
		
		JButton button = new JButton("Agregar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				try
				{
					app.Main.viewSwitcher("registroAdmin");
						
				}finally
				{
					dispose();
				}
				
			}
		});
		button.setBounds(324, 128, 80, 22);
		contentPane.add(button);
		
		
		JLabel lblNewLabel_1 = new JLabel("Agregar Aerolinea :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(13, 115, 120, 14);
		contentPane.add(lblNewLabel_1);
		
		String[] dePrueba = new String [LogginScreen.aeropuerto.retornaListado(idAdmin).size()];
		
		for (int i = 0; i < LogginScreen.aeropuerto.retornaListado(idAdmin).size(); i++) 
		{
			dePrueba[i] = LogginScreen.aeropuerto.retornaListado(idAdmin).get(i);
		}	
		
		JComboBox comboAerolineas = new JComboBox(dePrueba);
		
		//TODO
//		System.out.println(comboAerolineas.getSelectedItem().toString());
		comboAerolineas.setBounds(142, 33, 80, 20);
		contentPane.add(comboAerolineas);
		
		JButton btnAgregar2 = new JButton("Agregar");
		btnAgregar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				try
				{
					setVisible(false);
					NuevaAerolinea frame = new NuevaAerolinea(idAdmin);
					frame.setVisible(true);
					} catch (Exception ex) 
					{
						ex.printStackTrace();
					}			}
		});
		setVisible(true);

		btnAgregar2.setBounds(142, 110, 80, 22);
		contentPane.add(btnAgregar2);
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{

			try {
				if(manejoDeArchivos.buscarNombre(Aeropuerto.Aerolineas.getName(), comboAerolineas.getSelectedItem().toString()))
				{
					LogginScreen.aeropuerto.importarDesdeArchivoAdmins(Aeropuerto.Admins);

					if(comboAviones.getSelectedItem().toString() == deCabotaje)
					{
						try
						{
							Administrador aux = new Administrador(LogginScreen.aeropuerto.buscaAdminId(idAdmin));
							
							Aerolinea aero = new Aerolinea(aux.obtenerAerolinea(idAdmin, comboAerolineas.getSelectedItem().toString()));
							AgregarAviCabotaje frame = new AgregarAviCabotaje(idAdmin, aero);
							frame.setVisible(true);
							} catch (Exception ex) 
							{
								ex.printStackTrace();
							}
					}
					else if(comboAviones.getSelectedItem().toString() == Internacional)
					{
						try
						{
							Administrador aux = new Administrador(LogginScreen.aeropuerto.buscaAdminId(idAdmin));
							
							Aerolinea aero = new Aerolinea(aux.obtenerAerolinea(idAdmin, comboAerolineas.getSelectedItem().toString()));
							AgregarAviInternacional frame = new AgregarAviInternacional(idAdmin, aero);
							frame.setVisible(true);
							} catch (Exception ex) 
							{
								ex.printStackTrace();
							}
					}
					else if(comboAviones.getSelectedItem().toString() == deCarga)
					{
						try
						{

							Administrador aux = new Administrador(LogginScreen.aeropuerto.buscaAdminId(idAdmin));
							
							Aerolinea aero = new Aerolinea(aux.obtenerAerolinea(idAdmin, comboAerolineas.getSelectedItem().toString()));
							AgregarAviCarga frame = new AgregarAviCarga(idAdmin, aero);
							frame.setVisible(true);
							} catch (Exception ex) 
							{
								ex.printStackTrace();
							}
					}
					else if(comboAviones.getSelectedItem().toString() == Miitar)
					{
						try
						{
							Administrador aux = new Administrador(LogginScreen.aeropuerto.buscaAdminId(idAdmin));
							
							Aerolinea aero = new Aerolinea(aux.obtenerAerolinea(idAdmin, comboAerolineas.getSelectedItem().toString()));
							AgregarAviMilitar frame = new AgregarAviMilitar(idAdmin, aero);
							frame.setVisible(true);
							} catch (Exception ex) 
							{
								ex.printStackTrace();
							}
					}
					else
					{
						app.Main.viewSwitcher("error");
					}
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		});
		btnAgregar.setBounds(327, 32, 80, 22);
		contentPane.add(btnAgregar);
		
	}
}
