package Exceptions;

public class ProdutoNaoAdcionadoAListaException extends Exception {
    public ProdutoNaoAdcionadoAListaException(){
        super("Não foi possível adcionar o produto à Lista.");
    }
    
}
