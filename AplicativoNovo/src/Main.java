import model.entities.*;
import model.exception.EntradaContaInvalidaException;
import model.exception.EntradaTipoPessoaException;
import model.exception.ValidacaoContaBancariaException;
import service.cliente.CriarClientePF;
import service.cliente.CriarClientePJ;
import service.conta.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        new Main().iniciarMenu(null, null);

    }

    private void iniciarMenu(Cliente cliente, Conta conta) {

        System.out.println("= \uD83D\uDCB0 = \uD83D\uDCB8 =\uD83E\uDD11 = \uD83C\uDFE6 =");

        try {
            if (Objects.isNull(cliente)) {
                cliente = recuperarDadosCliente();
            }
            if (Objects.isNull(conta)) {
                conta = criarConta(cliente);
            }


            if (cliente instanceof ClientePF) {
                operacaoContaPF(conta,cliente);
            } if (cliente instanceof ClientePJ) {
                operacaoContaPJ(conta, cliente);
            }



        } catch (EntradaTipoPessoaException e) {
            System.out.println(e.getMessage());
            iniciarMenu(cliente, conta);
        } catch (EntradaContaInvalidaException e) {
            System.out.println(e.getMessage());
            iniciarMenu(cliente, conta);
        } catch (ValidacaoContaBancariaException e) {
            System.out.println(e.getMessage());
            iniciarMenu(cliente, conta);
        }

    }

    private Cliente recuperarDadosCliente() throws EntradaTipoPessoaException {

        System.out.print("\nTipo cliente (F/J): ");
        String tipoPessoa = entrada.next();

        if (tipoPessoa.equalsIgnoreCase("F")) {
            return recuperarDadosPessoaFisica();
        } else if (tipoPessoa.equalsIgnoreCase("J")) {
            return recuperarDadosPessoaJuridica();
        } else {
            throw new EntradaTipoPessoaException("Opcao tipo cliente invalida");
        }

    }

    private Cliente recuperarDadosPessoaFisica() {
        System.out.print("\nNome: ");
        String nome = entrada.next();

        System.out.print("\nCPF: ");
        String cpf = entrada.next();

        return new CriarClientePF().criar(nome, cpf);
    }

    private Cliente recuperarDadosPessoaJuridica() {
        System.out.print("\nNome: ");
        String nome = entrada.next();

        System.out.print("\nCNPJ: ");
        String cnpj = entrada.next();

        return new CriarClientePJ().criar(nome, cnpj);
    }

    private Conta criarConta(Cliente cliente) throws EntradaContaInvalidaException {
        CriarConta criarConta;
        String tipoConta = null;

        if (cliente instanceof ClientePF) {
            System.out.print("\nTipo Conta CC, CP, CI: ");

        } else if (cliente instanceof ClientePJ) {
            System.out.print("\nTipo Conta CC, CI: ");
        }else {
            throw new IllegalArgumentException("Tipo de cliente não esperado.");
        }

        tipoConta = entrada.next().trim();

        if (tipoConta.equalsIgnoreCase("CC")) {
            criarConta = new CriarContaCorrente();
        } else if (tipoConta.equalsIgnoreCase("CP")) {
            criarConta = new CriarContaPoupanca();
        } else if (tipoConta.equalsIgnoreCase("CI")) {
            criarConta = new CriarContaInvestimento();
        } else {
            throw new EntradaContaInvalidaException("Tipo conta invalida");
        }
        return criarConta.criar(cliente);
    }

    private void operacaoContaPF(Conta conta, Cliente cliente) throws ValidacaoContaBancariaException {

        GerirConta gerirConta;

        System.out.print("\nOperaçao:" +
                "\n Sacar (S)" +
                "\n Depositar (D) " +
                "\n Transferir (T) " +
                "\n Saldo (SD) " +
                "\n Dados Conta (DC) " +
                "\n Sair (X)" +
                "\n");
        String operacao = entrada.next().trim();

        if (operacao.equalsIgnoreCase("S")) {
            System.out.print("\nValor saque: ");
            String valorEntrada = entrada.next();
            BigDecimal valor = new BigDecimal(valorEntrada);

            if (conta instanceof ContaCorrente){
                gerirConta = (GerirConta) new GerirContaCorrentePF();
            } else if (conta instanceof  ContaPoupanca) {
                gerirConta = new GerirContaPoupancaPF();
            } else{
                gerirConta = new GerirContaInvestimentoPF();
            }
            gerirConta.sacar(conta, valor);
            imprimirSaldo(conta);

        } else if (operacao.equalsIgnoreCase("D")) {
            System.out.print("\nValor deposito: ");
            String valorEntrada = entrada.next();
            BigDecimal valor = new BigDecimal(valorEntrada);
           // conta.depositar(valor);
            imprimirSaldo(conta);
        } else if (operacao.equalsIgnoreCase("T")) {
            System.out.print("\nValor transferencia: ");
            String valorEntrada = entrada.next();
            BigDecimal valor = new BigDecimal(valorEntrada);

            System.out.print("\nNumero C/C destino: ");
            String numeroContaDestino = entrada.next();

           // conta.transferir(new ContaCorrente(numeroContaDestino), valor);
            imprimirSaldo(conta);
        } else if (operacao.equalsIgnoreCase("SD")) {
            imprimirSaldo(conta);
        } else if (operacao.equalsIgnoreCase("DC")) {
            System.out.println(conta.toString());
        } else if (operacao.equalsIgnoreCase("X")) {
            System.out.print("\n \uD83D\uDC4B \uD83D\uDC4B \uD83D\uDC4B Tchau!! " + conta.getCliente().getNome());
            imprimirSaldo(conta);
            System.exit(0);
        }



    }

    private void operacaoContaPJ(Conta conta, Cliente cliente) throws ValidacaoContaBancariaException {

        GerirConta gerirConta;

        System.out.print("\nOperaçao:" +
                "\n Sacar (S)" +
                "\n Depositar (D) " +
                "\n Transferir (T) " +
                "\n Saldo (SD) " +
                "\n Dados Conta (DC) " +
                "\n Sair (X)" +
                "\n");
        String operacao = entrada.next().trim();

        if (operacao.equalsIgnoreCase("S")) {

            System.out.print("\nValor saque: ");
            String valorEntrada = entrada.next();
            BigDecimal valor = new BigDecimal(valorEntrada);

            if (conta instanceof ContaCorrente) gerirConta = new GerirContaCorrentePF();
            else if (conta instanceof  ContaPoupanca) {
                gerirConta = new GerirContaPoupancaPF();
            } else{
                gerirConta = new GerirContaInvestimentoPF();
            }
            gerirConta.sacar(conta, valor);
            imprimirSaldo(conta);
        } else if (operacao.equalsIgnoreCase("D")) {
            System.out.print("\nValor deposito: ");
            String valorEntrada = entrada.next();
            BigDecimal valor = new BigDecimal(valorEntrada);
            // conta.depositar(valor);
            imprimirSaldo(conta);
        } else if (operacao.equalsIgnoreCase("T")) {
            System.out.print("\nValor transferencia: ");
            String valorEntrada = entrada.next();
            BigDecimal valor = new BigDecimal(valorEntrada);

            System.out.print("\nNumero C/C destino: ");
            String numeroContaDestino = entrada.next();

            // conta.transferir(new ContaCorrente(numeroContaDestino), valor);
            imprimirSaldo(conta);
        } else if (operacao.equalsIgnoreCase("SD")) {
            imprimirSaldo(conta);
        } else if (operacao.equalsIgnoreCase("DC")) {
            System.out.println(conta.toString());
        } else if (operacao.equalsIgnoreCase("X")) {
            System.out.print("\n \uD83D\uDC4B \uD83D\uDC4B \uD83D\uDC4B Tchau!! " + conta.getCliente().getNome());
            imprimirSaldo(conta);
            System.exit(0);
        }

}


    private void imprimirSaldo(Conta conta) {
        System.out.println("\n \uD83D\uDCB0 Saldo: R$ " + conta.getSaldo().setScale(4, RoundingMode.HALF_EVEN));
    }

}