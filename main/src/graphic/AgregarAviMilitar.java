package graphic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.Administrador;
import obclass.Aerolinea;
import obclass.Aeropuerto;
import obclass.Militar;
import resources.manejoDeArchivos;;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarAviMilitar extends JFrame {

	private JPanel contentPane;
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textOrigen;
	private JTextField textDestino;

	public AgregarAviMilitar(int idAdmin, Aerolinea aero) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon(getClass().getResource("/recursos/Avion.png")).getImage());
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca :");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMarca.setBounds(30, 45, 46, 14);
		contentPane.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo :");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModelo.setBounds(30, 85, 55, 14);
		contentPane.add(lblModelo);
		
		JLabel lblOrigen = new JLabel("Origen :");
		lblOrigen.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOrigen.setBounds(215, 45, 55, 14);
		contentPane.add(lblOrigen);
		
		JLabel lblDestino = new JLabel("Destino :");
		lblDestino.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDestino.setBounds(215, 85, 55, 14);
		contentPane.add(lblDestino);

	
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
		textMarca.setBounds(102, 44, 86, 20);
		contentPane.add(textMarca);
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
		textModelo.setBounds(102, 84, 86, 20);
		contentPane.add(textModelo);
		textModelo.setColumns(10);
		
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
		textOrigen.setBounds(285, 44, 86, 20);
		contentPane.add(textOrigen);
		textOrigen.setColumns(10);
		
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
		textDestino.setBounds(285, 84, 86, 20);
		contentPane.add(textDestino);
		textDestino.setColumns(10);
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textMarca.getText().equalsIgnoreCase("Marca") || (textModelo.getText().equalsIgnoreCase("Modelo")) || (textOrigen.getText().equalsIgnoreCase("Origen")) || (textDestino.getText().equalsIgnoreCase("Destino")))
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
					
					Militar nuevoAvion = new Militar(textMarca.getText(), textModelo.getText(), textOrigen.getText(), textDestino.getText());
					
					Aerolinea aAgregar = new Aerolinea(aero, nuevoAvion);
					
					manejoDeArchivos.agregarObjectRep(Aeropuerto.MILITAR, nuevoAvion);
					manejoDeArchivos.agregarObjectRep(Aeropuerto.Aerolineas, aAgregar);

					manejoDeArchivos.agregarObjectRep(Aeropuerto.Admins, aux);
					app.Main.viewSwitcher("login");
					dispose();
				}
			}
		});
		
		btnAgregar.setBounds(115, 127, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(218, 127, 89, 23);
		contentPane.add(btnCancelar);
	}
}
