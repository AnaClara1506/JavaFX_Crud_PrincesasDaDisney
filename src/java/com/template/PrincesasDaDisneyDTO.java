package com.template;

public class PrincesasDaDisneyDTO {
    private int id;
    private String nome;
    private String cor_vestido;
    private String nome_filme;
    private int ano_filme;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCorVestido() {
        return cor_vestido;
    }

    public void setCorVestido(String cor_vestido) {
        this.cor_vestido = cor_vestido;
    }

    public String getNomeFilme() {
        return nome_filme;
    }

    public void setNomeFilme(String nome_filme) {
        this.nome_filme = nome_filme;
    }

    public int getAnoFilme() {
        return ano_filme;
    }

    public void setAnoFilme(int ano_filme) {
        this.ano_filme = ano_filme;
    }
}
