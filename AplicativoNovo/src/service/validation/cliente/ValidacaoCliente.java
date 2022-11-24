package service.validation.cliente;

import model.entities.Cliente;
import model.exception.ValidacaoException;

public interface ValidacaoCliente<T extends Cliente> {

    void valida(T cliente) throws ValidacaoException;

}
