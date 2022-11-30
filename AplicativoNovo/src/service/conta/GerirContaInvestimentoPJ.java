package service.conta;

import model.entities.Conta;
import model.exception.SaldoInvalidoException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GerirContaInvestimentoPJ implements GerirConta   {
    @Override
    public void depositar(Conta conta, BigDecimal valor) {
        BigDecimal rendimento;
        rendimento = valor.multiply(ParametrosConta.TX_RENDIMENTO_CI_PJ).divide(new BigDecimal(100));

        valor = valor.add(rendimento);

        GerirConta.super.depositar(conta,valor);
    }

    public void sacar(Conta conta, BigDecimal valor) throws SaldoInvalidoException {
        BigDecimal tarifaOperacao;
        BigDecimal valorTarifado;

        tarifaOperacao = valor.multiply(ParametrosConta.TX_TRANSACAO_PJ).divide(new BigDecimal(100));
        valorTarifado = valor.add(tarifaOperacao);

        GerirConta.super.sacar(conta, valorTarifado);
    }

    @Override
    public void transferir(Conta conta, BigDecimal valor, Conta contaFavorecido) throws SaldoInvalidoException {
        BigDecimal tarifaOperacao;
        BigDecimal valorTarifado;

        tarifaOperacao = valor.multiply(ParametrosConta.TX_TRANSACAO_PJ).divide(new BigDecimal(100));
        valorTarifado = valor.add(tarifaOperacao);

        GerirConta.super.transferir(conta, valorTarifado, contaFavorecido);
        System.out.println("Valor da Taxa de Transaferência Cobrada: R$ " +tarifaOperacao.setScale(2, RoundingMode.HALF_EVEN));

    }
}
