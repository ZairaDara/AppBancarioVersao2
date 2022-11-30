package service.conta;

import model.entities.Conta;
import model.exception.SaldoInvalidoException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GerirContaCorrentePJ implements GerirConta {

    public void sacar(Conta conta, BigDecimal valor) throws SaldoInvalidoException {
        BigDecimal tarifaOperacao;
        BigDecimal valorTarifado;

        tarifaOperacao = valor.multiply(ParametrosConta.TX_TRANSACAO_PJ).divide(new BigDecimal(100));
        valorTarifado = valor.add(tarifaOperacao);

        GerirConta.super.sacar(conta, valorTarifado);
    }

    @Override
    public void transferir(Conta conta, BigDecimal valor, Conta contaFavorecido) throws SaldoInvalidoException {

        //Calcula Taxa da Transferência
        BigDecimal taxaTransferencia = new BigDecimal("0.005");
        BigDecimal valorTaxaCalculada = valor.multiply(taxaTransferencia).setScale(4, RoundingMode.HALF_EVEN);

        //Calcula montante do débito  da transferência
        BigDecimal valorTotalTransferencia = valorTaxaCalculada.add(valor);

        GerirConta.super.transferir(conta,valorTotalTransferencia,contaFavorecido);
        System.out.println("Valor da Taxa de Transaferência Cobrada: R$ " +valorTaxaCalculada.setScale(2, RoundingMode.HALF_EVEN));

    }
}
