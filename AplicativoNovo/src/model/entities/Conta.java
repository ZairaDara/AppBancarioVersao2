package model.entities;

import java.math.BigDecimal;

public abstract class Conta {

    private Integer numeroDaConta;
    private Cliente cliente;
    private BigDecimal saldo;

    public Conta (Integer numeroDaConta, Cliente cliente){
        this.numeroDaConta = numeroDaConta;
        this.cliente = cliente;
        this.saldo = BigDecimal.ZERO;
    }

    public Integer getNumeroDaConta() {
        return numeroDaConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
