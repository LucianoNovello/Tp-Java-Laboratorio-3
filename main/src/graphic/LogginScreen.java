package graphic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.Administrador;
import app.ListadoAdmin;
import obclass.Aerolinea;
import obclass.Aeropuerto;
import obclass.Carga;
import obclass.VueloDeCabotaje;
import obclass.VueloInternacional;
import resources.manejoDeArchivos;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.EOFException;
import java.io.IOException;


public class LogginScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JButton btnRegristrarse;
	private JButton btnIngresar;
	private JPasswordField txtPassword;

	static  Aeropuerto aeropuerto = new Aeropuerto("Ezeiza", "Argentina", "Buenos Aires");

	/**
	 * Create the frame.
	 */
	public LogginScreen()
	{
		aeropuerto.importarDesdeArchivoAdmins(Aeropuerto.Admins);
		aeropuerto.importarDesdeArchivoUsuariosCreados(Aeropuerto.Clientes);
		manejoDeArchivos.mostrarArchivo(Aeropuerto.Admins);

		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setForeground(Color.WHITE);
		setBounds(100, 100, 450, 200);
		this.setIconImage(new ImageIcon(getClass().getResource("/resources/Avion.png")).getImage());
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(136, 64, 133, 25);
		txtUsuario.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(txtUsuario.getText().equals("Username"))
				{
					txtUsuario.setText("");
				}
				else
				{
					txtUsuario.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(txtUsuario.getText().equals(""))
					txtUsuario.setText("Username");
			}
		});
		contentPane.setLayout(null);
		txtUsuario.setText("Username");
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUser = new JLabel("User :");
		lblUser.setBounds(68, 68, 46, 14);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUser.setBackground(Color.GRAY);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setBounds(48, 102, 78, 19);
		lblPassword.setBackground(Color.GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblPassword);
		
		JLabel lblTitulo = new JLabel("LOGIN");
		lblTitulo.setBounds(47, 21, 321, 32);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitulo);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				aeropuerto.importarDesdeArchivoAdmins(Aeropuerto.Admins);

				@SuppressWarnings("deprecation")
				String Contraseña = txtPassword.getText().toString();


				int idAdmin = (aeropuerto.buscaAdmin(txtUsuario.getText().toString(), Contraseña));
				if(aeropuerto.buscaAdmin(txtUsuario.getText().toString(), Contraseña) != (-1))
				{
					try
					{
						MenuAdmin frame = new MenuAdmin(idAdmin);
						frame.setVisible(true);
						} catch (Exception e) 
						{
							e.printStackTrace();
						}
					txtUsuario.setText("Username");
					txtPassword.setText("Password");
				}
				else if(aeropuerto.buscaClientes(txtUsuario.getText().toString(), Contraseña))
				{
							try {
								MenuCliente frame = new MenuCliente();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
				}
				else
				{
					try {
						MsgError frame = new MsgError();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		}});
		btnIngresar.setBounds(279, 64, 105, 25);
		contentPane.add(btnIngresar);
				
		btnRegristrarse = new JButton("Registrarse");
		btnRegristrarse.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
					app.Main.viewSwitcher("registroCliente");
				
			}
		}
	);
		btnRegristrarse.setBounds(279, 100, 105, 25);
		contentPane.add(btnRegristrarse);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(136, 100, 133, 25);
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) 
			{
				if(txtPassword.getPassword().equals("Password"))
				{
					txtPassword.setEchoChar('●');
					txtPassword.setText("");
				}
				else
				{
					txtPassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(txtPassword.getPassword().equals(""))
				{
					txtPassword.setText("Password");
					txtPassword.setEchoChar((char)0);
				}
			}
		});
		txtPassword.setText("Password");
		txtPassword.setEchoChar((char)0);
		contentPane.add(txtPassword);
	}
}

