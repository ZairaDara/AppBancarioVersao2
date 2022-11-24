package model.entities;

public class ClientePJ extends Cliente {

    private String cnpj;

    public ClientePJ (String nome, String cnpj){
        super(nome);
        this.cnpj = cnpj;
    }

    @Override
    public String getDocumento() {
        return cnpj;
    }

    @Override
    public void setDocumento(String documento) {
        this.cnpj = documento;
    }
}
