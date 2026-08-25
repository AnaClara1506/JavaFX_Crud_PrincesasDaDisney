package com.template.validator;

public class AnoValidator implements Validator<String>{
    private String valor;
    private int ano;
    private String mensagemErro;


    public AnoValidator(String valor) {
        this.valor = valor;
    }

    @Override
    public boolean validar(String valor) {
        this.valor = valor;
        try {
           this.ano = Integer.parseInt(valor);
            if (this.ano < 1937 || this.ano > 2026) {
                mensagemErro = "O ano do filme deve estar entre 1937 e 2026";
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            mensagemErro = "O ano do filme deve conter apenas números";
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
