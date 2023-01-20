package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuNota extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public MenuNota() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1018, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboItens = new JComboBox();
		comboItens.setBounds(10, 85, 284, 52);
		contentPane.add(comboItens);
		
		JList listProdutos = new JList();
		listProdutos.setBounds(605, 0, 397, 603);
		contentPane.add(listProdutos);
		
		JButton btnNewButton = new JButton("Menu Nostas Fiscais");
		btnNewButton.setBorder(null);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 35));
		btnNewButton.setBounds(256, 0, 339, 74);
		contentPane.add(btnNewButton);
		
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
		lblNewLabel.setBounds(0, 0, 1002, 603);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel);
	}
}
