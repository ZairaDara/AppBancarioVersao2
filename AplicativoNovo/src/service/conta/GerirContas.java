package service.conta;

import model.entities.Conta;
import model.exception.SaldoInvalidoException;

import java.math.BigDecimal;

public class GerirContas {
    public void sacar(Conta conta, BigDecimal valor) throws SaldoInvalidoException {
        BigDecimal saldo;

        saldo = conta.getSaldo();

        if (saldo.compareTo(valor) >= 0 ){
                saldo = saldo.subtract(valor);
        }else {
            throw new SaldoInvalidoException(conta);
        }
        conta.setSaldo(saldo);
    }

    public void depositar(Conta conta, BigDecimal valor) {
        BigDecimal saldo;

        saldo = conta.getSaldo();

        saldo = saldo.add(valor);

        conta.setSaldo(saldo);

    };

    public void transferir(Conta conta, BigDecimal valor) {

    };

}
