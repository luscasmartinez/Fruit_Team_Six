package cadastros;

import java.util.LinkedList;

import construtores.Produto;
import interfaces.IProdutos;

public class CadProduto implements IProdutos {

    private LinkedList<Produto> listaProdutos;

    public CadProduto() {
        listaProdutos = new LinkedList<Produto>();
    }

    @Override
    public void addProduto(Produto p) throws Exception {
        listaProdutos.add(p);
    }

    @Override
    public void removeProduto(int codigo) throws Exception {
        listaProdutos.remove(codigo);
    }

    @Override
    public Produto getProduto(int codigo) throws Exception {
        for (Produto p : listaProdutos)
            if (p.getCodigo().equals(codigo))
                return p;
        return null;
    }

    @Override
    public void updateQuantidade(int codigo, double nova) throws Exception {
        for (Produto p : listaProdutos)
            if (p.getCodigo().equals(codigo))
                p.setQuantidade(nova);
    }

    @Override
    public void updatePreco(int codigo, double novo) throws Exception {
        for (Produto p : listaProdutos)
            if (p.getCodigo().equals(codigo))
                p.setPreco(novo);
    }

    @Override
    public void addQuantidade(int codigo, double quantidade) throws Exception {
        for (Produto p : listaProdutos)
            if (p.getCodigo().equals(codigo))
                p.setQuantidade(p.getQuantidade() + quantidade);
    }

    @Override
    public void subQuantidade(int codigo, double quantidade) throws Exception {
        for (Produto p : listaProdutos)
            if (p.getCodigo().equals(codigo))
                p.setQuantidade(p.getQuantidade() - quantidade);
    }

}
