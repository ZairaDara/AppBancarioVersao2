package service.conta;

import model.entities.*;

public class CriarContaPoupanca implements CriarConta{
    @Override
    public Conta criar(Cliente cliente) {
        String numeroConta = "";

        numeroConta = String.valueOf(System.currentTimeMillis());
        Conta conta = new ContaPoupanca(numeroConta, (ClientePF) cliente);

        return conta;
    }
}
