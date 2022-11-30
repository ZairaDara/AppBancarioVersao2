package service.conta;

import model.entities.Conta;
import model.exception.SaldoInvalidoException;

import java.math.BigDecimal;

public class GerirContaInvestimentoPF extends GerirContas implements GerirConta {
    @Override
    public void depositar(Conta conta, BigDecimal valor) {
        BigDecimal rendimento;
        rendimento = valor.multiply(ParametrosConta.TX_RENDIMENTO_CI_PF).divide(new BigDecimal(100));

        valor = valor.add(rendimento);

        super.depositar(conta,valor);
    }

    public void sacar(Conta conta, BigDecimal valor) throws SaldoInvalidoException {
        super.sacar(conta, valor);
    }

    @Override
    public void transferir(Conta conta, BigDecimal valor) {

    }
}
