package service.conta;

import model.entities.Cliente;
import model.entities.Conta;
import model.entities.ContaCorrente;

public class CriarContaCorrente implements CriarConta{
    @Override
    public Conta criar(Cliente cliente) {
        String numeroConta = "";

        numeroConta = String.valueOf(System.currentTimeMillis());
        Conta conta = new ContaCorrente(numeroConta, cliente);

        return null;
    }
}
