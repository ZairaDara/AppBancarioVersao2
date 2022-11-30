package service.conta;

import model.entities.Cliente;
import model.entities.Conta;
import model.exception.SaldoInvalidoException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface GerirConta {

    default void sacar(Conta conta, BigDecimal valor) throws SaldoInvalidoException {
        BigDecimal saldo;

        saldo = conta.getSaldo();

        if (saldo.compareTo(valor) >= 0) {
            saldo = saldo.subtract(valor);
        } else {
            throw new SaldoInvalidoException(conta);
        }
        conta.setSaldo(saldo);
    }

    default void depositar(Conta conta, BigDecimal valor) {
        BigDecimal saldo;

        saldo = conta.getSaldo();

        saldo = saldo.add(valor);

        conta.setSaldo(saldo);

    }

    default void transferir(Conta conta, BigDecimal valor, Conta contaFavorecido) throws SaldoInvalidoException{

        //Debita Conta Origem
        this.sacar(conta, valor);

        //Credita Conta Favorecido
        this.depositar(contaFavorecido, valor);

        System.out.println("Transferência realizada com sucesso!!");

    }
}
