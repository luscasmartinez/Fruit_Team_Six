package construtores;

public class Produto {
    private int codigo;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;

    public void setCodigo(int codigo) { this.codigo = codigo;}
    public Object getCodigo() {return null;}

    public String getNome() {return this.nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getDescricao() {return this.descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public double getPreco() {return this.preco;}
    public void setPreco(double preco) {this.preco = preco;}

    public int getQuantidade() {return this.quantidade;}
    public void setQuantidade(double nova) {this.quantidade = (int) nova;}
}