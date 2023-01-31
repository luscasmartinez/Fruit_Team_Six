package construtores;

import java.util.Date;
import java.util.LinkedList;

import interfaces.INotasFiscais;

public class NotaFiscal implements INotasFiscais {

    public LinkedList<Item> listaItens;
    private LinkedList<NotaFiscal> listaNotaFiscal;

    private int codigo;
    private Date dataEmissao;

    public NotaFiscal(int codigo, Date dataEmissao) {
        this.codigo = codigo;
        this.dataEmissao = dataEmissao;
        listaItens = new LinkedList<>();
        listaNotaFiscal = new LinkedList<>();
    }

    public NotaFiscal() {
        listaItens = new LinkedList<>();
        listaNotaFiscal = new LinkedList<>();
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataEmissao() {
        return this.dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Item getItem() {
        return this.listaItens.get(0);
    }

    public void setItem(Item item) {
        listaItens.add(item);
    }

    @Override
    public String toString() {
        String dado = "";
        dado += "NotaFiscal: " + codigo
                + ", Emissão: " + dataEmissao
                + ", Itens: ";
        for (Item item : listaItens) {
            dado += item.toString() + " ";
        }
        return dado;
    }

    @Override
    public void addNotaFiscal(NotaFiscal nf) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeNotaFiscal(int codigo) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public NotaFiscal getNotaFiscal(int codigo) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getTotal(int codigo) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void addItem(int codigo, Item item) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeItem(int codigo, Item item) throws Exception {
        // TODO Auto-generated method stub

    }

    public String[] getDados() {
        String[] notas = new String[listaNotaFiscal.size()];
        for (int i = 0; i < listaNotaFiscal.size(); i++) {
            notas[i] = listaNotaFiscal.get(i).toString();
        }
        return notas;
    }
}