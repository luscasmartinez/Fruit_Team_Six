package Exceptions;

public class ProdutoJaCadastradoException extends Exception {
    public ProdutoJaCadastradoException(){
        super("Produto já cadastrado");
    }
}
