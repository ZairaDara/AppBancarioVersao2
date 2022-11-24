package service.validation.conta;

import model.entities.Conta;
import model.exception.ValidacaoException;

public interface ValidacaoConta <T extends Conta> {

    void valida(T conta) throws ValidacaoException;

}
