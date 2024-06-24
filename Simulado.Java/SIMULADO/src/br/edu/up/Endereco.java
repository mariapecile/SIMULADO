package br.edu.up;

public class Endereco {
    int id;
    String rua;
    String cidade;

    public Endereco(int id, String rua, String cidade) {
        this.id = id;
        this.rua = rua;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco [id=" + id + ", rua=" + rua + ", cidade=" + cidade + "]";
    }
}
