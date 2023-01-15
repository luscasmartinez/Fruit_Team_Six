package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.security.KeyStore.TrustedCertificateEntry;
import java.awt.event.ActionEvent;

public class CadProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField textDescricao;
	private JTextField textPreco;
	private JTextField textQuantidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadProduto frame = new CadProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Campos de texto abaixo ->
		
		textCodigo = new JTextField();
		textCodigo.setBounds(273, 94, 171, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		textNome = new JTextField();
		textNome.setBounds(273, 154, 171, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textDescricao = new JTextField();
		textDescricao.setBounds(273, 226, 171, 20);
		contentPane.add(textDescricao);
		textDescricao.setColumns(10);
		
		textPreco = new JTextField();
		textPreco.setBounds(273, 304, 171, 20);
		contentPane.add(textPreco);
		textPreco.setColumns(10);
		
		textQuantidade = new JTextField();
		textQuantidade.setBounds(273, 377, 171, 20);
		contentPane.add(textQuantidade);
		textQuantidade.setColumns(10);
		
		//<- Fim dos campo de texto
		
		
		
		//Inicio dos botões Radio ->
		
		JRadioButton btnQuantidade = new JRadioButton("Unidade");
		btnQuantidade.setBounds(273, 418, 78, 23);
		contentPane.add(btnQuantidade);
		
		JRadioButton btnKg = new JRadioButton("Kg");
		btnKg.setBounds(402, 417, 42, 23);
		contentPane.add(btnKg);
		//<- Fim dos botões Radio
		
		
		
		
		
		//Desmarcda aopção Kg.
		btnQuantidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnKg.setSelected(false);}
		});
		
		//Desmarca a opção Unidade
		btnKg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnQuantidade.setSelected(false);}
		});
		
		JButton btnConfirmarCadastro = new JButton("");
		btnConfirmarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnConfirmarCadastro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmarCadastro.setContentAreaFilled(false);
		btnConfirmarCadastro.setBorderPainted(false);
		btnConfirmarCadastro.setBounds(196, 466, 146, 41);
		contentPane.add(btnConfirmarCadastro);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Lucas.LUSCA\\Downloads\\Yellow Mint Minimalist Fruit Instagram Post  (1).png"));
		lblNewLabel.setBounds(0, 0, 539, 540);
		contentPane.add(lblNewLabel);
	}
}
