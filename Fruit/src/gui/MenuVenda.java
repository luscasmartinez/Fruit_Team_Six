package gui;

import java.awt.Cursor;
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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import cadastros.CadProduto;
import construtores.Produto;

public class MenuVenda extends JFrame {

    private CadProduto listaProdutos;

    private JPanel contentPane;
    private JTextField textQtdAtual;
    private JTextField textQtdPedido;

    /**
     * Create the frame.
     */
    public MenuVenda(CadProduto listaProdutos) {
        this.listaProdutos = listaProdutos;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 902, 551);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnFinalizar = new JButton("");
        btnFinalizar.setBorder(null);
        btnFinalizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnFinalizar.setContentAreaFilled(false);
        btnFinalizar.setBorderPainted(false);
        btnFinalizar.setBounds(55, 433, 135, 41);
        contentPane.add(btnFinalizar);

        JButton btnAddPedido = new JButton("");
        btnAddPedido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAddPedido.setBorder(null);
        btnAddPedido.setContentAreaFilled(false);
        btnAddPedido.setBorderPainted(false);
        btnAddPedido.setBounds(208, 432, 135, 40);
        contentPane.add(btnAddPedido);

        JButton btnNotaFiscal = new JButton("");
        btnNotaFiscal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNotaFiscal.setBorder(null);
        btnNotaFiscal.setBorderPainted(false);
        btnNotaFiscal.setContentAreaFilled(false);
        btnNotaFiscal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNotaFiscal.setBounds(375, 435, 135, 38);
        contentPane.add(btnNotaFiscal);

        // Combo Box com produtos

        System.out.println("Teste");
        JComboBox<String> comboProdutos = new JComboBox();
        comboProdutos.setFont(new Font("Tahoma", Font.PLAIN, 20));
        comboProdutos.setBounds(193, 93, 318, 41);

        String[] produtos = listaProdutos.getProdutos();

        for (String p : produtos) {
            comboProdutos.addItem(p);
            System.out.println(p);
        }
        contentPane.add(comboProdutos);

        JTextPane qtdAtual = new JTextPane();
        qtdAtual.setBounds(330, 229, 180, 38);
        contentPane.add(qtdAtual);
        qtdAtual.setEditable(false);

        comboProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // código a ser executado quando o usuário selecionar um item na combobox
                try {
                    Produto p = listaProdutos.getProduto(comboProdutos.getSelectedIndex()+1);
                    qtdAtual.setText(p.getQuantidade() + "");
                } catch (Exception e1) {
                }
            }
        });

        textQtdPedido = new JTextField();
        textQtdPedido.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textQtdPedido.setBounds(330, 328, 180, 38);
        contentPane.add(textQtdPedido);
        textQtdPedido.setColumns(10);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        btnVoltar.setBounds(423, 11, 89, 23);
        contentPane.add(btnVoltar);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(
                "Fruit\\src\\img\\MenuVenda.png"));
        lblNewLabel.setBounds(0, 0, 544, 512);
        contentPane.add(lblNewLabel);

        JList list = new JList();
        list.setBounds(540, 0, 346, 512);
        contentPane.add(list);
    }
}
