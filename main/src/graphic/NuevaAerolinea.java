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
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NuevaAerolinea extends JFrame {

	private JPanel contentPane;

	private JTextField txtNombre;
	private JTextField txtCuit;
	/**
	 * Create the frame.
	 */
	public NuevaAerolinea(int idAdmin) {
		Aerolinea aero = new Aerolinea();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon(getClass().getResource("/recursos/Avion.png")).getImage());

		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoAerolinea = new JLabel("Nueva Aerolinea");
		lblNuevoAerolinea.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoAerolinea.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNuevoAerolinea.setBounds(115, 24, 200, 14);
		contentPane.add(lblNuevoAerolinea);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(67, 68, 60, 14);
		contentPane.add(lblNombre);
		
		JLabel lblCuit = new JLabel("Cuit :");
		lblCuit.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCuit.setBounds(67, 110, 105, 14);
		contentPane.add(lblCuit);
		
		txtNombre = new JTextField();
		txtNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(txtNombre.getText().equals("Nombre"))
				{
					txtNombre.setText("");
				}
				else
				{
					txtNombre.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(txtNombre.getText().equals(""))
					txtNombre.setText("Nombre");
			}
		});
		txtNombre.setText("Nombre");
		txtNombre.setColumns(10);
		txtNombre.setBounds(170, 66, 86, 20);
		contentPane.add(txtNombre);
		
		txtCuit = new JTextField();
		txtCuit.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(txtCuit.getText().equals("Cuit"))
				{
					txtCuit.setText("");
				}
				else
				{
					txtCuit.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(txtCuit.getText().equals(""))
					txtCuit.setText("Cuit");
			}
		});
		txtCuit.setText("Cuit");
		txtCuit.setColumns(10);
		txtCuit.setBounds(170, 108, 86, 20);
		contentPane.add(txtCuit);
		
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(txtNombre.getText().equalsIgnoreCase("Nombre") || (txtCuit.getText().equalsIgnoreCase("Cuit")))
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
					LogginScreen.aeropuerto.importarDesdeArchivoAdmins(Aeropuerto.Admins);
					aero.setNombre(txtNombre.getText());
					aero.setCuit(txtCuit.getText());
					manejoDeArchivos.agregarObjectSinRep(Aeropuerto.Aerolineas, aero);
					Administrador aux = new Administrador(LogginScreen.aeropuerto.buscaAdminId(idAdmin));
					aux.asigarAerolineaAAdmin(aero);			
					manejoDeArchivos.agregarObjectRep(Aeropuerto.Admins, aux);
					dispose();
					app.Main.viewSwitcher("login");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		btnAgregar.setBounds(289, 65, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				dispose();
			}
		});
		btnCancelar.setBounds(289, 107, 89, 23);
		contentPane.add(btnCancelar);
		

	}
}
