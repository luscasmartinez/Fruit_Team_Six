package construtores;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class NotaFiscal {

    public LinkedList<Item> listaItens;

    private int codigo;
    private Date dataEmissao;
    private Item item;

    public NotaFiscal(int codigo, Date dataEmissao) {
        this.codigo = codigo;
        this.dataEmissao = dataEmissao;
        this.item = null;
        listaItens = new LinkedList<>();
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

    public LinkedList<Item> getListaItens() {
        return this.listaItens;
    }

    public void setItemNF(Item item){
        this.item = item;
    }

    public Item getItemNF(){
        return this.item;
    }

    public void setItem(Item item) {
        listaItens.add(item);
    }

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
}