package model.entities;

public abstract class Cliente {

    private String nome;

    public Cliente (String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract String getDocumento();

    public abstract void setDocumento(String documento);
}
