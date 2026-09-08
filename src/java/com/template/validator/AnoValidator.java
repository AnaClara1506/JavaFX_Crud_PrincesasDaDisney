package com.template.validator;

public class AnoValidator implements Validator<String> {
    private String valor;
    private String mensagemErro;

    public AnoValidator(String valor) {
        this.valor = valor;
    }

    @Override
    public boolean validar(String valor) {
        String valorParaValidar = (valor != null) ? valor : this.valor;

        if (valorParaValidar == null || valorParaValidar.trim().isEmpty()) {
            this.mensagemErro = "O ano do filme não pode ser vazio";
            return false;
        }

        try {
            int ano = Integer.parseInt(valorParaValidar.trim());
            if (ano < 1937 || ano > 2026) {
                this.mensagemErro = "O ano do filme deve estar entre 1937 e 2026";
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            this.mensagemErro = "O ano do filme deve conter apenas números";
            return false;
        }
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