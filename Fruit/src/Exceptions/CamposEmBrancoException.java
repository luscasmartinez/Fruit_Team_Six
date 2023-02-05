package Exceptions;

public class CamposEmBrancoException extends Exception {
    
    public CamposEmBrancoException(){
        super("Por favor, preencha todos os campos");
    }
}
