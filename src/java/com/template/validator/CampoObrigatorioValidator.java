package com.template.validator;

public class CampoObrigatorioValidator implements Validator<String> {
    private final String nomeCampo;
    private final String valor;

    public CampoObrigatorioValidator(String nomeCampo, String valor) {
        this.nomeCampo = nomeCampo;
        this.valor = valor;
    }

    @Override
    public boolean validar(String valor) {
        String valorParaValidar = (valor != null) ? valor : this.valor;
        return valorParaValidar != null && !valorParaValidar.trim().isEmpty();
    }

    @Override
    public String getMensagemErro() {
        return "O campo " + nomeCampo + " deve ser preenchido";
    }

    @Override
    public String getValor() {
        return valor; // Corrigido: antes retornava ""
    }
}