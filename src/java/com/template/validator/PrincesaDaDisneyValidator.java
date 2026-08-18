package com.template.validator;

public class PrincesaDaDisneyValidator {
    public static String validarPrincesa(String nome, String cor_vestido, String nome_filme, String ano_filme ){
        if (nome.isEmpty() || cor_vestido.isEmpty() || nome_filme.isEmpty() || ano_filme.isEmpty()) {
            return "Preencha todos os campos!";
        }

        try {
            Integer.parseInt(nome);
            return "O campo 'Nome' deve conter letras!";
        } catch (NumberFormatException e) {
        }

        try {
            Integer.parseInt(cor_vestido);
            return "O campo 'Cor do Vestido' deve conter letras!";
        } catch (NumberFormatException e) {
        }

        try {
            Integer.parseInt(nome_filme);
            return "O campo 'Nome do filme' deve conter letras!";
        } catch (NumberFormatException e) {
        }

        try {
            int ano = Integer.parseInt(ano_filme);
            if (ano < 1937 || ano > 2026) {
                return "O ano do filme deve estar en]'tre 1937 e 2026";
            }
        } catch (NumberFormatException e) {
            return "O ano do filme deve conter apenas números";
        }

        return null;
    }
}
