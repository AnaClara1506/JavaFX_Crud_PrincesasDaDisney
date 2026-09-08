package com.template.validator;

public class TextValidator implements Validator<String> {
    private String valor;
    private String mensagemErro;

    public TextValidator(String valor) {
        this.valor = valor;
    }

    @Override
    public boolean validar(String valor) {
        String valorParaValidar = (valor != null) ? valor : this.valor;

        if (valorParaValidar == null || valorParaValidar.trim().isEmpty()) {
            this.mensagemErro = "O campo de texto não pode ser vazio";
            return false;
        }

        if (!valorParaValidar.matches("^[\\p{L} ]+$")) {
            this.mensagemErro = "O campo deve conter apenas letras e espaços";
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