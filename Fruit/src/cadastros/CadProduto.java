package cadastros;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import Exceptions.EstoqueInsuficienteException;
import Exceptions.ProdutoInexistenteException;
import Exceptions.ProdutoNaoAdcionadoAListaException;
import construtores.Produto;
import interfaces.IProdutos;

public class CadProduto implements IProdutos {

    public LinkedList<Produto> listaProdutos;

    public CadProduto() {
        listaProdutos = new LinkedList<Produto>();
    }
//3
    @Override
    public void addProduto(Produto p) throws ProdutoNaoAdcionadoAListaException {
        listaProdutos.add(p);
    }

    @Override
    public void removeProduto(int codigo) throws Exception {
        Produto p = getProduto(codigo);
        if (p != null) {
            listaProdutos.remove(p);
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        }
    }

    @Override
    public Produto getProduto(int codigo) throws ProdutoInexistenteException {
        for (Produto p : listaProdutos)
            if (p.getCodigo() == codigo)
                return p;
        throw new ProdutoInexistenteException();
    }

    @Override
    public void updateQuantidade(int codigo, double nova) throws Exception {
        for (Produto p : listaProdutos)
            if (p.getCodigo() == codigo) {
                p.setQuantidade(nova);
            }
    }

    @Override
    public void updatePreco(int codigo, double novo) throws Exception {
        for (Produto p : listaProdutos)
            if (p.getCodigo() == codigo) {
                p.setPreco(novo);
            }
    }

    @Override
    public void addQuantidade(int codigo, double quantidade) throws Exception {
        for (Produto p : listaProdutos)
            if (p.getCodigo() == codigo) {
                p.setQuantidade(p.getQuantidade() + quantidade);
            }
    }

    @Override
    public void subQuantidade(int codigo, double quantidade) throws EstoqueInsuficienteException {
        for (Produto p : listaProdutos)
            if (p.getCodigo() == codigo) {
                if (p.getQuantidade() - quantidade < 0) {
                    throw new EstoqueInsuficienteException();
                } else {
                    p.setQuantidade(p.getQuantidade() - quantidade);
                }
            }
    }

    public String[] getProdutos() {
        String[] produtos = new String[listaProdutos.size()];
        for (int i = 0; i < listaProdutos.size(); i++) {
            produtos[i] = listaProdutos.get(i).toString();
        }
        return produtos;
    }

    @Override
    public String toString() {
        return "" + listaProdutos;
    }
}