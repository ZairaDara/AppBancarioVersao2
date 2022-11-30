package service.conta;

import model.entities.Cliente;
import model.entities.Conta;
import model.exception.SaldoInvalidoException;

import java.math.BigDecimal;

public interface GerirConta {

    void depositar(Conta conta, BigDecimal valor) ;

    default void sacar(Conta conta, BigDecimal valor) throws SaldoInvalidoException {

    }

    void transferir (Conta conta, BigDecimal valor, Conta contaFavorecido) throws SaldoInvalidoException;

}
