package com.template.validator;

public class TextValidator implements Validator<String>{
    private String valor;
    private String mensagemErro;

    @Override
    public boolean validar(String valor) {
        this.valor = valor;

        if (!valor.matches("^[\\p{L} ]+$")) {
            mensagemErro = "O campo deve conter apenas letras.";
            return false;
        }

        return true;
    }

    @Override
    public String getMessagemErro() {
        return mensagemErro;
    }

    @Override
    public String getValor() {
        return valor;
    }
}
