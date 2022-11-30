package model.exception;

import model.entities.Conta;

public class SaldoInvalidoException extends ValidacaoContaBancariaException {

    public SaldoInvalidoException(Conta conta) {
        super("Saldo insuficiente para a conta: " + conta.getNumeroDaConta());
    }

}
