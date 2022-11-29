package service.cliente;

import model.entities.Cliente;
import model.entities.ClientePF;

public class CriarClientePF implements CriarCliente{
    @Override
    public Cliente criar(String nome, String documento) {
        return new ClientePF(nome, documento);
    }
}
