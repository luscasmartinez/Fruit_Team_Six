package construtores;

public class Produto {
    private int codigo;
    private String nome;
    private String descricao;
    private double preco;
    private double quantidade;

    public Produto(String nome, String descricao, int codigo, double quantidadeUnd, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.codigo = codigo;
        this.quantidade = quantidadeUnd;
        this.preco = preco;
    }

    public Produto(String nome, String descricao, int codigo, int quantidadeKg, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.codigo = codigo;
        this.quantidade = quantidadeKg;
        this.preco = preco;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
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
                ", Descrição: " + descricao +
                ", Preço: " + preco +
                ", Qtd: " + quantidade;
    }

}