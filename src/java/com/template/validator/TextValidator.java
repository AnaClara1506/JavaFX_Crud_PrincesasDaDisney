package com.template.validator;

public class TextValidator implements Validator<String> {
    private String valor;
    private String mensagemErro;

    public TextValidator(String valor) {
        this.valor = valor;
    }

    @Override
    public boolean validar(String valor) {

        if (!valor.matches("^[\\p{L} ]+$")) {
            this.mensagemErro = "Alguns campos devem conter letras";
            return false;
        }

        return true;
    }

    @Override
    public String getMensagemErro() {
        return mensagemErro;
    }

    @Override
    public String getValor() {
        return valor;
    }
}