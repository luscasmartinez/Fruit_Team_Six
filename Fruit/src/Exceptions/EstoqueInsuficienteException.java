package Exceptions;

public class EstoqueInsuficienteException extends Exception {
    public EstoqueInsuficienteException(){
        super("Quantidade em estoque insuficiente.");
    }
}
