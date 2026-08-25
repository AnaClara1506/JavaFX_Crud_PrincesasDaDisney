package com.template.validator;

public class TextValidator implements Validator<String>{
    private String valor;
    private String mensagemErro;

    public TextValidator(String valor) {
        this.valor = valor;
    }

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
    public String getMensagemErro() {
        return mensagemErro;
    }

    @Override
    public String getValor() {
        return valor;
    }
}
