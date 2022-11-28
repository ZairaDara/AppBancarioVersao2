package service.conta;

import model.entities.Cliente;
import model.entities.Conta;

import java.math.BigDecimal;

public interface GerirConta {

    void depositar(Conta conta, BigDecimal valor);

    void sacar(Conta conta, BigDecimal valor);

    void transferir (Conta conta, BigDecimal valor);

}
