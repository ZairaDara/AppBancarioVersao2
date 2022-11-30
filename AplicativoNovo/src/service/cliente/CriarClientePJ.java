package service.cliente;

import model.entities.Cliente;
import model.entities.ClientePF;
import model.entities.ClientePJ;

public class CriarClientePJ implements CriarCliente{
    @Override
    public Cliente criar(String nome, String documento) {
        return new ClientePJ(nome, documento);
    }
}
