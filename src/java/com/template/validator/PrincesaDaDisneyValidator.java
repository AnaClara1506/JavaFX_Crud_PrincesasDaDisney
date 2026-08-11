package com.template.validator;

public class PrincesaDaDisneyValidator {
    public static boolean validarPrincesa(String nome, String cor_vestido, String nome_filme, String ano_filme ){
        if (nome.isEmpty() || cor_vestido.isEmpty() || nome_filme.isEmpty() || ano_filme.isEmpty()) {
            return false;
        }
        return true;
    }
}
