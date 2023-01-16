package construtores;

public class Produto {
    private int codigo;
    private String nome;
    private String descricao;
    private double preco;
    private double quantidade;

    // Produto vendido por KG
    public Produto(String nome, String descricao, int codigo, double quantidade, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // Produto vendido por UN
    public Produto(String nome, String descricao, int codigo, int quantidade, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Object getCodigo() {
        return null;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(double nova) {
        this.quantidade = nova;
    }

    @Override
    public String toString() {
        return "Cód: " + codigo +
                ", Nome: " + nome +
                ", Descricao: " + descricao +
                ", Preco: R$" + preco +
                ", Quantidade: " + quantidade;
    }
}