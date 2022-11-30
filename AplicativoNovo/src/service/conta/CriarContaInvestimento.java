package service.conta;

import model.entities.Cliente;
import model.entities.Conta;
import model.entities.ContaCorrente;
import model.entities.ContaInvestimento;

public class CriarContaInvestimento implements CriarConta{
    @Override
    public Conta criar(Cliente cliente) {
        String numeroConta = "";

        numeroConta = String.valueOf(System.currentTimeMillis());
        Conta conta = new ContaInvestimento(numeroConta, cliente);

        return conta;
    }
}
