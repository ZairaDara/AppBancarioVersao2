package service.conta;

import model.entities.Conta;
import model.exception.SaldoInvalidoException;

import java.math.BigDecimal;

public class GerirContaInvestimentoPJ extends GerirContas implements GerirConta   {
    @Override
    public void depositar(Conta conta, BigDecimal valor) {
        BigDecimal rendimento;
        rendimento = valor.multiply(ParametrosConta.TX_RENDIMENTO_CI_PJ).divide(new BigDecimal(100));

        valor = valor.add(rendimento);

        super.depositar(conta,valor);
    }

    public void sacar(Conta conta, BigDecimal valor) throws SaldoInvalidoException {
        BigDecimal tarifaOperacao;
        BigDecimal valorTarifado;

        tarifaOperacao = valor.multiply(ParametrosConta.TX_TRANSACAO_PJ).divide(new BigDecimal(100));
        valorTarifado = valor.add(tarifaOperacao);

        super.sacar(conta, valorTarifado);
    }

    @Override
    public void transferir(Conta conta, BigDecimal valor, Conta contaFavorecido) {

    }
}
