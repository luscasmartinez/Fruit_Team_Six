package gui;

import java.awt.Cursor;
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

    private JList<Produto> list;

    /**
     * Create the frame.
     */
    public MenuVenda(CadProduto listaProdutos) {
        this.listaProdutos = listaProdutos;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1006, 551);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

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
                    Produto p = listaProdutos.getProduto(comboProdutos.getSelectedIndex() + 1);
                    qtdAtual.setText(p.getQuantidade() + "");
                } catch (Exception e1) {

                }
            }
        });

        list = new JList<Produto>();
        DefaultListModel<Produto> model = new DefaultListModel<Produto>();
        list.setModel(model);
        list.setBounds(540, 0, 450, 512); 
        contentPane.add(list);

        JButton btnAddPedido = new JButton("");
        btnAddPedido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAddPedido.setBorder(null);
        btnAddPedido.setContentAreaFilled(false);
        btnAddPedido.setBorderPainted(false);
        btnAddPedido.setBounds(208, 432, 135, 40);
        contentPane.add(btnAddPedido);

        // Botão add pedido
        btnAddPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ao clicar
                try {
                    Produto p = listaProdutos.getProduto(comboProdutos.getSelectedIndex() + 1);

                    listaProdutos.subQuantidade(p.getCodigo(), Double.parseDouble(textQtdPedido.getText()));

                    if (Double.parseDouble(qtdAtual.getText()) >= Double.parseDouble(textQtdPedido.getText())) {

                        model.addElement(p);
                        
                        qtdAtual.setText(p.getQuantidade() + "");
                    }

                } catch (Exception e1) {
                }
            }
        });

        // Botão finalizar venda
        JButton btnFinalizar = new JButton("");
        btnFinalizar.setBorder(null);
        btnFinalizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnFinalizar.setContentAreaFilled(false);
        btnFinalizar.setBorderPainted(false);
        btnFinalizar.addActionListener(new ActionListener() {
            // Ação
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < model.getSize(); i++) {
                    Produto p = model.get(i);
                    System.out.println(p.toString());
                }
            }
        });
        btnFinalizar.setBounds(55, 433, 135, 41);
        contentPane.add(btnFinalizar);

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
    }
}
