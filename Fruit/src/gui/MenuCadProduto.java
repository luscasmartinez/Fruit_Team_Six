package gui;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import cadastros.CadProduto;
import construtores.Produto;

public class MenuCadProduto extends JFrame {

	CadProduto novoCadProduto = new CadProduto();
	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField textDescricao;
	private JTextField textPreco;
	private JTextField textQuantidade;

	/**
	 * Cria a Janela.
	 */
	public MenuCadProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Campos de texto abaixo ->

		try {
			MaskFormatter mf = new MaskFormatter("##");
			textCodigo = new JFormattedTextField(mf);
			textCodigo.setFont(new Font("Arial", Font.PLAIN, 25));
			textCodigo.setBounds(273, 91, 171, 29);
			contentPane.add(textCodigo);
			textCodigo.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textNome = new JTextField();
		textNome.setBounds(273, 149, 171, 29);
		contentPane.add(textNome);
		textNome.setColumns(10);

		
		textDescricao = new JTextField();
		textDescricao.setBounds(273, 221, 171, 29);
		contentPane.add(textDescricao);
		textDescricao.setColumns(10);

		try{
			MaskFormatter mf = new MaskFormatter("###.##");
			textPreco = new JFormattedTextField(mf);
			textPreco.setBounds(273, 296, 171, 29);
			contentPane.add(textPreco);
			textPreco.setColumns(10);
		}catch(ParseException e){
			e.printStackTrace();
		}

		
		textQuantidade = new JTextField();
		textQuantidade.setBounds(273, 368, 171, 29);
		contentPane.add(textQuantidade);
		textQuantidade.setColumns(10);

		// <- Fim dos campo de texto

		// Inicio dos botões Radio ->

		JRadioButton btnQuantidade = new JRadioButton("Unidade");
		btnQuantidade.setBounds(273, 418, 78, 23);
		contentPane.add(btnQuantidade);

		JRadioButton btnKg = new JRadioButton("Kg");
		btnKg.setBounds(402, 417, 42, 23);
		contentPane.add(btnKg);
		// <- Fim dos botões Radio

		// Desmarcda aopção Kg.
		btnQuantidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnKg.setSelected(false);
			}
		});

		// Desmarca a opção Unidade
		btnKg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnQuantidade.setSelected(false);
			}
		});

		// Botão de cadastro

		JButton btnConfirmarCadastro = new JButton("");
		btnConfirmarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto novoProduto = new Produto(textNome.getText(),
						textDescricao.getText(),
						Integer.parseInt(textCodigo.getText()),
						Double.parseDouble(textQuantidade.getText()),
						Double.parseDouble(textPreco.getText()));

						try {
							novoCadProduto.addProduto(novoProduto);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						for(Produto p: novoCadProduto.listaProdutos){
							System.out.println(p);
						}

						setVisible(false);
			}
		});
		btnConfirmarCadastro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmarCadastro.setContentAreaFilled(false);
		btnConfirmarCadastro.setBorderPainted(false);
		btnConfirmarCadastro.setBounds(196, 466, 146, 41);
		contentPane.add(btnConfirmarCadastro);

		btnConfirmarCadastro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmarCadastro.setContentAreaFilled(false);
		btnConfirmarCadastro.setBorderPainted(false);
		btnConfirmarCadastro.setBounds(196, 466, 146, 41);
		contentPane.add(btnConfirmarCadastro);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVoltar.setBorder(null);
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setDefaultCapable(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorderPainted(false);
		btnVoltar.setBounds(438, 11, 89, 52);
		contentPane.add(btnVoltar);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("Fruit\\src\\IMG\\MenuCadastro.png"));
		lblNewLabel.setBounds(0, 0, 539, 540);
		contentPane.add(lblNewLabel);
	}
}
