package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cadastros.CadNotaFiscal;

public class MenuNota extends JFrame {

	private JPanel contentPane;

	private CadNotaFiscal listaNotaFiscal;

	/**
	 * Create the frame.
	 */
	public MenuNota(CadNotaFiscal listaNotaFiscal) {
		this.listaNotaFiscal = listaNotaFiscal;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1018, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Lista de Notas
		JComboBox<String> comboNotas = new JComboBox();
		comboNotas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboNotas.setBounds(157, 117, 304, 52);

		String[] notas = listaNotaFiscal.getDados();

		for (String nf : notas) {
			comboNotas.addItem(nf);
			System.out.println(nf);
		}
		contentPane.add(comboNotas);

		JList listProdutos = new JList();
		listProdutos.setBounds(605, 0, 397, 603);
		contentPane.add(listProdutos);

		JButton btnVoltar = new JButton(" Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVoltar.setFont(new Font("Ink Free", Font.PLAIN, 20));
		btnVoltar.setBounds(10, 535, 192, 57);
		contentPane.add(btnVoltar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setFont(new Font("Ink Free", Font.PLAIN, 20));
		btnExcluir.setBounds(10, 462, 190, 58);
		contentPane.add(btnExcluir);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Fruit\\src\\img\\MenuNota.png"));
		lblNewLabel.setBounds(0, 0, 608, 603);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel);
	}
}
