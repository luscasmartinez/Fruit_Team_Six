package Exceptions;

public class ProdutoInexistenteException extends Exception {
    public ProdutoInexistenteException(){
        super("Produto Inexistente.");
    }
}
