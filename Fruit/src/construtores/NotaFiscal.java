package construtores;

import java.util.Date;

public class NotaFiscal {
    private int codigo;
    private Date dataEmissao;
    private Item item;

    


    public int getCodigo() {return this.codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}

    public Date getDataEmissao() {return this.dataEmissao;}
    public void setDataEmissao(Date dataEmissao) {this.dataEmissao = dataEmissao;}

    public Item getItem() {return this.item;}
    public void setItem(Item item) {this.item = item;}

}