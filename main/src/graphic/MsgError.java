package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MsgError extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MsgError() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 196, 100);
		this.setIconImage(new ImageIcon(getClass().getResource("/recursos/Avion.png")).getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextArea textError = new JTextArea();
		textError.setForeground(new Color(255, 0, 0));
		textError.setBackground(SystemColor.menu);
		textError.setFont(new Font("Arial", Font.PLAIN, 9));
		textError.setText("Usuario incorrecto/Parametros faltantes");
		contentPane.add(textError, BorderLayout.NORTH);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				setVisible(false);
			}
		});
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnAceptar, BorderLayout.CENTER);
	}

}
