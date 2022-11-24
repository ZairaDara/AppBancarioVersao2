package service.cliente;

import model.entities.Cliente;
import model.entities.ClientePF;
import model.entities.ClientePJ;
import model.exception.ValidacaoException;
import service.validation.cliente.ValidacaoCliente;

public class OperacaoGerirClienteService {

    private ValidacaoCliente validacaoCliente;

    public Cliente criarCliente(String nome, String documento) throws ValidacaoException {

        Cliente cliente = null;

        if (documento.length() == 11) {
            cliente = new ClientePF(nome, documento);

        } else if (documento.length() == 14) {
            cliente = new ClientePJ(nome, documento);
        }else {
            throw new ValidacaoException("Documento inválido.");
        }

        return cliente;

    }


}
