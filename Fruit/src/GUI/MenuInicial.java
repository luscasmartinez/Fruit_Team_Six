package GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class MenuInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInicial frame = new MenuInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**spo
	 * Create the frame.
	 */
	public MenuInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastro = new JButton("");
		btnCadastro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Evento aqui
				CadProduto cadProduto = new CadProduto();
				cadProduto.setVisible(true);
			}
		});
		btnCadastro.setContentAreaFilled(false);
		btnCadastro.setBorderPainted(false);
		btnCadastro.setBounds(47, 81, 126, 30);
		contentPane.add(btnCadastro);
		
		JButton btnCompra = new JButton("");
		btnCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Evento aqui
			}
			
		});
		btnCompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCompra.setBorderPainted(false);
		btnCompra.setBorder(null);
		btnCompra.setDefaultCapable(false);
		btnCompra.setContentAreaFilled(false);
		btnCompra.setBounds(46, 243, 132, 30);
		contentPane.add(btnCompra);
		
		JButton btnNotas = new JButton("");
		btnNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Evento aqui
			}
		});
		btnNotas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNotas.setContentAreaFilled(false);
		btnNotas.setBorderPainted(false);
		btnNotas.setBounds(50, 403, 120, 29);
		contentPane.add(btnNotas);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Lucas.LUSCA\\Downloads\\Green Fruit Logo (1).png"));
		lblNewLabel.setBounds(0, 0, 499, 494);
		contentPane.add(lblNewLabel);
	}
}
