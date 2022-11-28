package model.entities;

import java.math.BigDecimal;

public abstract class Conta {

    private String numeroDaConta;
    private Cliente cliente;
    private BigDecimal saldo;

    public Conta (String numeroDaConta, Cliente cliente){
        this.numeroDaConta = numeroDaConta;
        this.cliente = cliente;
        this.saldo = BigDecimal.ZERO;
    }

    public String getNumeroDaConta() {
        return numeroDaConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setNumeroDaConta(String numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
