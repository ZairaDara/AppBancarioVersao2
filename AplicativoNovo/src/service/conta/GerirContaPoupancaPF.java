package service.conta;

import model.entities.Conta;
import model.exception.SaldoInvalidoException;

import java.math.BigDecimal;

public class GerirContaPoupancaPF implements GerirConta {
    @Override
    public void depositar(Conta conta, BigDecimal valor) {
        BigDecimal rendimento;
        rendimento = valor.multiply(ParametrosConta.TX_RENDIMENTO_CP_PF).divide(new BigDecimal(100));

        valor = valor.add(rendimento);

        GerirConta.super.depositar(conta,valor);
    }

}
