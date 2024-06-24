package br.edu.up;

public class Pessoa {
    private int id;
    private String nome;
    private String rua;
    private String cidade;

    public Pessoa(int id, String nome, String rua, String cidade) {
        this.id = id;
        this.nome = nome;
        this.rua = rua;
        this.cidade = cidade;
    }

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }
}
