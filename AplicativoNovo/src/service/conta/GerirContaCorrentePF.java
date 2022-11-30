package service.conta;

import model.entities.Conta;
import model.exception.SaldoInvalidoException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GerirContaCorrentePF extends GerirContas implements GerirConta {
    @Override
    public void depositar(Conta conta, BigDecimal valor) {
        super.depositar(conta,valor);
    }

    public void sacar(Conta conta, BigDecimal valor) throws SaldoInvalidoException {
        super.sacar(conta, valor);
    }

    @Override
    public void transferir(Conta conta, BigDecimal valorTransferencia, Conta contaFavorecido) throws SaldoInvalidoException {
        //Calcula Taxa da Transferência
        BigDecimal taxaTransferencia = new BigDecimal("0.005");
        BigDecimal valorTaxaCalculada = valorTransferencia.multiply(taxaTransferencia).setScale(4, RoundingMode.HALF_EVEN);

        //Calcula montante do débito  da transferência
        BigDecimal valorTotalTransferencia = valorTaxaCalculada.add(valorTransferencia);

        //Debita Conta Origem
        this.sacar(conta, valorTotalTransferencia);

        //Credita Conta Favorecido
        this.depositar(contaFavorecido, valorTransferencia);

        System.out.println("Transferência realizada com sucesso!!");
        System.out.println("Valor da Taxa de Transaferência Cobrada: R$ " +valorTaxaCalculada.setScale(2, RoundingMode.HALF_EVEN));

    }
}
