package Exceptions;

public class NotaNaoAdicionadaException extends Exception {
    public NotaNaoAdicionadaException(){
        super("Não foi possivel adicionar a nota fiscal.");
    }
}
