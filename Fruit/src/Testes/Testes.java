package Testes;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

import cadastros.CadProduto;
import construtores.Produto;

public class Testes {
    public static void main(String []args) {
        CadProduto cadProduto = new CadProduto();
        Produto p = new Produto("Banana", "Fruta", 1, 10, 50.52);
        try {
            cadProduto.addProduto(p);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1);
        }
        
        try {
            cadProduto.addProduto(p);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1);
        }



        try {
            cadProduto.updateQuantidade(3, 50);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }
}
