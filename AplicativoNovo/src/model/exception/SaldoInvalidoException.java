package model.exception;

public class SaldoInvalidoException extends ValidacaoContaBancariaException {

    public SaldoInvalidoException(String msg) {
        super(msg);
    }

}
