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

import Exceptions.CamposEmBrancoException;
import Exceptions.ProdutoNaoAdcionadoAListaException;
import cadastros.CadProduto;
import construtores.Produto;

/**
 * Janela de cadastro de produtos
 */
public class MenuCadProduto extends JFrame implements ActionListener {

	private CadProduto listaProdutos;

	private static int cod = 1;
	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField textDescricao;
	private JFormattedTextField textPreco;
	private JTextField textQuantidade;
	private JList<Produto> listProdutos;

	private JButton btnVoltar;
	private JButton btnConfirmarCadastro;

	private JRadioButton btnQuantidade;
	private JRadioButton btnKg;

	private DefaultListModel<Produto> model;
	private double quantidade;

	public MenuCadProduto(CadProduto listaProdutos) {
		this.listaProdutos = listaProdutos;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
//7
		textDescricao = new JTextField();
		textDescricao.setFont(new Font("Arial", Font.PLAIN, 25));
		textDescricao.setBounds(273, 221, 171, 29);
		contentPane.add(textDescricao);
		textDescricao.setColumns(10);

		textPreco = new JFormattedTextField();
		formatarValor(textPreco);
		textPreco.setFont(new Font("Arial", Font.PLAIN, 25));
		textPreco.setBounds(273, 296, 171, 29);
		contentPane.add(textPreco);
		textPreco.setColumns(10);

		listProdutos = new JList<Produto>();
		model = new DefaultListModel<Produto>();
		listProdutos.setModel(model);
		listProdutos.setBounds(537, 0, 261, 540);
		contentPane.add(listProdutos);

		textQuantidade = new JTextField();
		textQuantidade.setBounds(273, 368, 171, 29);
		textQuantidade.setFont(new Font("Arial", Font.PLAIN, 25));
		contentPane.add(textQuantidade);
		textQuantidade.setColumns(10);

		btnQuantidade = new JRadioButton("Unidade");
		btnQuantidade.setBounds(273, 418, 78, 23);
		contentPane.add(btnQuantidade);
		btnQuantidade.addActionListener(this);

		btnKg = new JRadioButton("Kg");
		btnKg.setBounds(402, 417, 42, 23);
		contentPane.add(btnKg);
		btnKg.addActionListener(this);

		btnConfirmarCadastro = new JButton("");
		btnConfirmarCadastro.addActionListener(this);
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

		btnVoltar = new JButton("");
		btnVoltar.addActionListener(this);
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

	@Override
	public void actionPerformed(ActionEvent ev) {
		
		if(ev.getSource() == btnConfirmarCadastro ){

			try{
				if(!verificarCamposEmBranco()){
					
					if(btnKg.isSelected()){
						quantidade = Double.parseDouble(textQuantidade.getText());
					} else if(btnQuantidade.isSelected()){
						quantidade = Integer.parseInt(textQuantidade.getText());
					}	

					Produto novoProduto = new Produto(textNome.getText(),
					textDescricao.getText(), cod, quantidade,
					Double.parseDouble(textPreco.getText()));
					
					cod++;
					listaProdutos.addProduto(novoProduto);
					textCodigo.setText(Integer.toString(cod));
					limparCampos();
				}

			} catch (CamposEmBrancoException | ProdutoNaoAdcionadoAListaException e){
				JOptionPane.showMessageDialog(null, e);
			}

			adicionarNaListaLateral();

		}

		if(ev.getSource() == btnVoltar){
			setVisible(false);
		}

		if(ev.getSource() == btnKg){
			btnKg.setSelected(true);
			btnQuantidade.setSelected(false);
		}

		if(ev.getSource() == btnQuantidade){
			btnQuantidade.setSelected(true);
			btnKg.setSelected(false);
		}
	}

	public void limparCampos(){
		textDescricao.setText("");
		textNome.setText("");
		textPreco.setText("");
		textQuantidade.setText("");
		textNome.requestFocus();
		btnKg.setSelected(false);
		btnQuantidade.setSelected(false);
	}

	public boolean verificarCamposEmBranco() throws CamposEmBrancoException{
		if (textCodigo.getText().isEmpty() || textDescricao.getText().isEmpty()
			|| textNome.getText().isEmpty() || textPreco.getText().equals("  .  ")
			|| textQuantidade.getText().equals("      "))
				throw new CamposEmBrancoException();
			return false;
	}

	public void formatarValor(JFormattedTextField text) {
		try {
			MaskFormatter mask = new MaskFormatter("##.##");
			mask.install(text);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar texto", "ERRO", JOptionPane.ERROR);
		}
	}

	public void adicionarNaListaLateral(){
		for (Produto p : listaProdutos.listaProdutos) {
			if (p.getCodigo() == cod - 1)
				model.addElement(p);
		}
	}
}