package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cadastros.CadNotaFiscal;
import construtores.Item;
import construtores.NotaFiscal;

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
		JComboBox<String> comboNotas = new JComboBox<String>();
		comboNotas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboNotas.setBounds(157, 117, 304, 52);

		String[] notas = listaNotaFiscal.getDados();

		for (String nf : notas) {
			comboNotas.addItem(nf);
			System.out.println(nf);
		}
		contentPane.add(comboNotas);

		JList<Item> listItens = new JList<>();
		listItens.setBounds(605, 0, 397, 603);
		DefaultListModel<Item> modelNota = new DefaultListModel<Item>();
		listItens.setModel(modelNota);
		contentPane.add(listItens);

		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Ao clicar
				modelNota.clear();
				try {
					NotaFiscal nf = listaNotaFiscal.getNotaFiscal(listItens.getSelectedIndex() + 1);
					// adiciona a lista
					for (Item i : nf.getListaItens()) {
						modelNota.addElement(i);
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCarregar.setBounds(255, 224, 118, 52);
		contentPane.add(btnCarregar);

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
