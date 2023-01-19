package gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import cadastros.CadProduto;
import construtores.Produto;

public class MenuCadProduto extends JFrame {

	private CadProduto listaProdutos;
	
	private static int cod = 1;
	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField textDescricao;
	private JTextField textPreco;
	private JTextField textQuantidade;
	private JList<Produto> listProdutos;

	/**
	 * Cria a Janela.
	 */
	public MenuCadProduto(CadProduto listaProdutos) {
		this.listaProdutos = listaProdutos;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Campos de texto abaixo ->

		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setText(Integer.toString(cod));

		textCodigo.setFont(new Font("Arial", Font.PLAIN, 25));
		textCodigo.setBounds(273, 91, 171, 29);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);

		textNome = new JTextField();
		textNome.setFont(new Font("Arial", Font.PLAIN, 25));
		textNome.setBounds(273, 149, 171, 29);
		contentPane.add(textNome);
		textNome.setColumns(10);

		textDescricao = new JTextField();
		textDescricao.setFont(new Font("Arial", Font.PLAIN, 25));
		textDescricao.setBounds(273, 221, 171, 29);
		contentPane.add(textDescricao);
		textDescricao.setColumns(10);

		try {
			MaskFormatter mf = new MaskFormatter("##.##");
			textPreco = new JFormattedTextField(mf);
			textPreco.setFont(new Font("Arial", Font.PLAIN, 25));
			textPreco.setBounds(273, 296, 171, 29);
			contentPane.add(textPreco);
			textPreco.setColumns(10);
		} catch (ParseException | NumberFormatException e ) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos");
		}

		listProdutos = new JList<Produto>();
		DefaultListModel<Produto> model = new DefaultListModel<Produto>();
		listProdutos.setModel(model);
		listProdutos.setBounds(537, 0, 261, 540);
		contentPane.add(listProdutos);

		try {
			MaskFormatter mf = new MaskFormatter("######");
			textQuantidade = new JFormattedTextField(mf);
			textQuantidade.setBounds(273, 368, 171, 29);
			textQuantidade.setFont(new Font("Arial", Font.PLAIN, 25));
			contentPane.add(textQuantidade);
			textQuantidade.setColumns(10);
		} catch (ParseException | NumberFormatException e ) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos");
			
		}

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
				if (textCodigo.getText().isEmpty() ||
						textDescricao.getText().isEmpty() ||
						textNome.getText().isEmpty() ||
						textPreco.getText().equals("  .  ") ||
						textQuantidade.getText().equals("      ") ) {

					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos");

				} else if (btnKg.isSelected()) {
					Produto novoProduto = new Produto(textNome.getText(),
							textDescricao.getText(),
							cod,
							Double.parseDouble(textQuantidade.getText()),
							Double.parseDouble(textPreco.getText()));
					cod++;

					try {
						listaProdutos.addProduto(novoProduto);
					} catch (Exception e1) {
						System.out.println("Ocorreu o erro: " + e1);
						e1.printStackTrace();
					}
					for (Produto p : listaProdutos.listaProdutos) {
						if (p.getCodigo() == cod - 1)
							model.addElement(p);
					}
					textCodigo.setText(Integer.toString(cod));
					textDescricao.setText("");
					textNome.setText("");
					textPreco.setText("");
					textQuantidade.setText("");
					textNome.requestFocus();
				} else if (btnQuantidade.isSelected()) {
					Produto novoProduto = new Produto(textNome.getText(),
							textDescricao.getText(),
							cod,
							Integer.parseInt(textQuantidade.getText()),
							Double.parseDouble(textPreco.getText()));
					cod++;

					try {
						listaProdutos.addProduto(novoProduto);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					for (Produto p : listaProdutos.listaProdutos) {
						if (p.getCodigo() == cod - 1)
							model.addElement(p);
					}
					textCodigo.setText(Integer.toString(cod));
					textDescricao.setText("");
					textNome.setText("");
					textPreco.setText("");
					textQuantidade.setText("");
					textNome.requestFocus();
				} else {

					JOptionPane.showMessageDialog(null, "Selecione uma das opções \n Kg ou Unidade");
				}

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