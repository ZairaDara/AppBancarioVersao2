package model.exception;

public class ValidacaoException extends Exception{

    public ValidacaoException (String msgErro){
        super(msgErro);
    }

    public ValidacaoException (String msgErro, Throwable causa){
        super(msgErro, causa);
    }



}
