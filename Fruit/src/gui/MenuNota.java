package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cadastros.CadNotaFiscal;
import construtores.Item;
import construtores.NotaFiscal;

public class MenuNota extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JComboBox<NotaFiscal> comboNotas;
	private String[] notas;
	private JList<Item> listItens;
	private DefaultListModel<Item> modelNota;
	private JLabel lblNewLabel;

	private JButton btnCarregar;
	private JButton btnVoltar;
	private JButton btnExcluir;

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

		//comboNotas = new JComboBox<String>();
		comboNotas = new JComboBox<NotaFiscal>();
		comboNotas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboNotas.setBounds(157, 117, 304, 52);
		adcionarNotasAoComboBox();
		contentPane.add(comboNotas);

		listItens = new JList<>();
		listItens.setBounds(605, 0, 397, 603);
		modelNota = new DefaultListModel<Item>();
		listItens.setModel(modelNota);
		contentPane.add(listItens);

		btnCarregar = new JButton("Carregar");
		btnCarregar.setBounds(255, 224, 118, 52);
		contentPane.add(btnCarregar);
		btnCarregar.addActionListener(this);

		btnVoltar = new JButton(" Voltar");
		btnVoltar.setFont(new Font("Ink Free", Font.PLAIN, 20));
		btnVoltar.setBounds(10, 535, 192, 57);
		contentPane.add(btnVoltar);
		btnVoltar.addActionListener(this);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Ink Free", Font.PLAIN, 20));
		btnExcluir.setBounds(10, 462, 190, 58);
		contentPane.add(btnExcluir);
		btnExcluir.addActionListener(this);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Fruit\\src\\img\\MenuNota.png"));
		lblNewLabel.setBounds(0, 0, 608, 603);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {

		if(ev.getSource() == btnCarregar){
			modelNota.clear();
			try {
				NotaFiscal nf = listaNotaFiscal.getNotaFiscal(comboNotas.getSelectedIndex() + 1);
				modelNota.addElement(nf.getItemNF());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
		
		if(ev.getSource() == btnVoltar){
			setVisible(false);
		}

		if(ev.getSource() == btnExcluir){
			
			try {
				NotaFiscal nf = listaNotaFiscal.getNotaFiscal(comboNotas.getSelectedIndex() + 1);
				listaNotaFiscal.removeNotaFiscal(nf.getCodigo());
				comboNotas.remove(listItens.getSelectedIndex());
				modelNota.clear();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}

	public void adcionarNotasAoComboBox(){
		LinkedList<NotaFiscal> notas = listaNotaFiscal.getList();
		for (NotaFiscal nf : notas) {
			comboNotas.addItem(nf);
			System.out.println(nf);
		}
	}
}


