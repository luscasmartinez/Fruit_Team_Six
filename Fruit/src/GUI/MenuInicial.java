package gui;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cadastros.CadItem;
import cadastros.CadNotaFiscal;
import cadastros.CadProduto;

public class MenuInicial extends JFrame implements ActionListener {

	private JPanel contentPane;

	CadProduto listaProdutos = new CadProduto();
	CadNotaFiscal listaNotaFiscal = new CadNotaFiscal();
	CadItem listaItens = new CadItem();

	private MenuCadProduto menucadProduto;
	private MenuVenda menuVenda;
	private MenuNota menuNotas;

	private JButton btnCadastro;
	private JButton btnCompra;
	private JButton btnNotas;

	/**
	 * 
	 * Create the frame.
	 */
	public MenuInicial() {

		menucadProduto = new MenuCadProduto(listaProdutos);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnCadastro = new JButton("");
		btnCadastro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastro.setContentAreaFilled(false);
		btnCadastro.setBorderPainted(false);
		btnCadastro.setBounds(47, 81, 126, 30);
		contentPane.add(btnCadastro);
		btnCadastro.addActionListener(this);

		btnCompra = new JButton("");
		btnCompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCompra.setBorderPainted(false);
		btnCompra.setBorder(null);
		btnCompra.setDefaultCapable(false);
		btnCompra.setContentAreaFilled(false);
		btnCompra.setBounds(46, 243, 132, 30);
		contentPane.add(btnCompra);
		btnCompra.addActionListener(this);

		btnNotas = new JButton("");
		btnNotas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNotas.setContentAreaFilled(false);
		btnNotas.setBorderPainted(false);
		btnNotas.setBounds(50, 403, 120, 29);
		contentPane.add(btnNotas);
		btnNotas.addActionListener(this);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("Fruit\\src\\IMG\\MenuInicial.png"));
		lblNewLabel.setBounds(0, 0, 499, 494);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		
		if(ev.getSource() == this.btnCadastro){
			menucadProduto.setVisible(true);
		}

		if(ev.getSource() == this.btnCompra){
			menuVenda = new MenuVenda(listaProdutos, listaItens, listaNotaFiscal);
			menuVenda.setVisible(true);
		}

		if(ev.getSource()== this.btnNotas){
			menuNotas = new MenuNota(listaNotaFiscal);
			menuNotas.setVisible(true);
		}
	}
}
