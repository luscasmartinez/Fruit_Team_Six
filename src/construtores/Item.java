package construtores;

public class Item {

    private Produto produto;

    public Item (Produto produto){
        this.produto = produto;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Item [produto=" + produto + "]";
    }
}