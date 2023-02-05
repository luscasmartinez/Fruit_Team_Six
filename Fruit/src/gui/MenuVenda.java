package gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import Exceptions.NotaNaoAdicionadaException;
import cadastros.CadItem;
import cadastros.CadNotaFiscal;
import cadastros.CadProduto;
import construtores.Item;
import construtores.NotaFiscal;
import construtores.Produto;

/**
 * Janela para cadastro de vendas e emissao de notas
 */
public class MenuVenda extends JFrame implements ActionListener {

    private CadProduto listaProdutos;
    private CadItem listaItens;
    private CadNotaFiscal listaNotaFiscal;

    private JPanel contentPane;
    private JTextField textQtdAtual;
    private JTextField textQtdPedido;
    private JLabel lblNewLabel;
    private JTextPane qtdAtual;

    private JList<Item> list;

    private JComboBox<String> comboProdutos;
    private DefaultListModel<Item> model;
    private JButton btnNotaFiscal;
    private JButton btnAddPedido;
    private JButton btnFinalizar;
    private JButton btnVoltar;
    private JButton btnRemover;

    private String[] produtos;

    private static int codNota = 1;

    /**
     * Create the frame.
     */
    public MenuVenda(CadProduto listaProdutos, CadItem listaItens, CadNotaFiscal listaNotaFiscal) {
        this.listaNotaFiscal = listaNotaFiscal;
        this.listaItens = listaItens;
        this.listaProdutos = listaProdutos;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1006, 551);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnNotaFiscal = new JButton("");
        btnNotaFiscal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNotaFiscal.setBorder(null);
        btnNotaFiscal.setBorderPainted(false);
        btnNotaFiscal.setContentAreaFilled(false);
        btnNotaFiscal.setBounds(375, 435, 135, 38);
        contentPane.add(btnNotaFiscal);
        btnNotaFiscal.addActionListener(this);

        // Combo Box com produtos
        comboProdutos = new JComboBox();
        comboProdutos.setFont(new Font("Tahoma", Font.PLAIN, 20));
        comboProdutos.setBounds(193, 93, 318, 41);
        comboProdutos.addActionListener(this);
        adcionarProdutosAoComboBox();
        contentPane.add(comboProdutos);

        qtdAtual = new JTextPane();
        qtdAtual.setBounds(330, 229, 180, 38);
        contentPane.add(qtdAtual);
        qtdAtual.setEditable(false);

        list = new JList<Item>();
        model = new DefaultListModel<Item>();
        list.setModel(model);
        list.setBounds(540, 0, 450, 512);
        contentPane.add(list);

        btnAddPedido = new JButton("");
        btnAddPedido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAddPedido.setBorder(null);
        btnAddPedido.setContentAreaFilled(false);
        btnAddPedido.setBorderPainted(false);
        btnAddPedido.setBounds(208, 432, 135, 40);
        contentPane.add(btnAddPedido);
        btnAddPedido.addActionListener(this);

        btnFinalizar = new JButton("");
        btnFinalizar.setBorder(null);
        btnFinalizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnFinalizar.setContentAreaFilled(false);
        btnFinalizar.setBorderPainted(false);
        btnFinalizar.setBounds(55, 433, 135, 41);
        contentPane.add(btnFinalizar);
        btnFinalizar.addActionListener(this);

        textQtdPedido = new JTextField();
        textQtdPedido.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textQtdPedido.setBounds(330, 328, 180, 38);
        contentPane.add(textQtdPedido);
        textQtdPedido.setColumns(10);

        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(423, 11, 89, 23);
        contentPane.add(btnVoltar);
        btnVoltar.addActionListener(this);

        btnRemover = new JButton("Remover");
        btnRemover.setBounds(228, 398, 89, 23);
        contentPane.add(btnRemover);
        btnRemover.addActionListener(this);

        lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("Fruit\\src\\img\\MenuVenda.png"));
        lblNewLabel.setBounds(0, 0, 544, 512);
        contentPane.add(lblNewLabel);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
       
        if (ev.getSource() == btnNotaFiscal){
            MenuNota menuNota = new MenuNota(listaNotaFiscal);
            menuNota.setVisible(true);
        }

        if(ev.getSource() == comboProdutos){
            try {
                Produto p = listaProdutos.getProduto(comboProdutos.getSelectedIndex() + 1);
                qtdAtual.setText(p.getQuantidade() + "");
            } catch (Exception e1) {

            }
        }

        if(ev.getSource() == btnAddPedido){
            try {
                Produto p = listaProdutos.getProduto(comboProdutos.getSelectedIndex() + 1);
                listaProdutos.subQuantidade(p.getCodigo(), Double.parseDouble(textQtdPedido.getText()));
                Item item = new Item(p, Integer.parseInt(textQtdPedido.getText()));
                model.addElement(item);

                qtdAtual.setText(p.getQuantidade() + "");
                textQtdPedido.setText("");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

        if(ev.getSource() == btnFinalizar){
            Date data = new Date();
            NotaFiscal nota = new NotaFiscal(codNota, data);
            for (int i = 0; i < model.getSize(); i++) {
                Item item = model.get(i);
                nota.setItem(item);
            }
            codNota++;
            try {
                listaNotaFiscal.addNotaFiscal(nota);
            } catch (NotaNaoAdicionadaException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            System.out.println(nota);
            JOptionPane.showMessageDialog(null, "Nota " + nota.getCodigo() + " Criada!");
            model.clear();
        }
        
        if(ev.getSource() == btnVoltar){
            setVisible(false);
        }

        if(ev.getSource() == btnRemover){
            if (list.isSelectionEmpty()){
                JOptionPane.showMessageDialog(null, "Selecione um produto da lista.");
            } else{
                model = (DefaultListModel<Item>) list.getModel();
                model.remove(list.getSelectedIndex());
            }
        }
    }

    public void adcionarProdutosAoComboBox(){
        produtos = listaProdutos.getProdutos();
        for (String p : produtos) {
            comboProdutos.addItem(p);
            System.out.println(p);
        }
    }
}
