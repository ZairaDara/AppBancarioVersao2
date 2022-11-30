package service.conta;

import model.entities.Conta;
import model.exception.SaldoInvalidoException;

import java.math.BigDecimal;

public class GerirContaCorrentePF extends GerirContas implements GerirConta {
    @Override
    public void depositar(Conta conta, BigDecimal valor) {
        super.depositar(conta,valor);
    }

    public void sacar(Conta conta, BigDecimal valor) throws SaldoInvalidoException {
        super.sacar(conta, valor);
    }

    @Override
    public void transferir(Conta conta, BigDecimal valor) {

    }
}
