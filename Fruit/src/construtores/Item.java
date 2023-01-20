package construtores;

public class Item {

    private Produto produto;
    private int quantidade;

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
}

    public Produto getProduto() {return this.produto;}
    public void setProduto(Produto produto) {this.produto = produto;}

    public int getQuantidade() {return this.quantidade;}
    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}

    public double getPreco() {return this.produto.getPreco();}
    public double getPrecoTotal() {return this.produto.getPreco() * this.quantidade;}

    @Override
    public String toString() {
        return "Produto: " + produto.getNome() + 
        ", Quantidade: " + quantidade + 
        ", Preço: " + getPreco();
    }
}