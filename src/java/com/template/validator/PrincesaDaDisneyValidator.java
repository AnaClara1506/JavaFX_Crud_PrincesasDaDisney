package com.template.validator;

import java.util.ArrayList;
import java.util.List;

public class PrincesaDaDisneyValidator {

    public static String validarPrincesa(String nome, String cor_vestido, String nome_filme, String ano_filme) {

        List<Validator<String>> validators = new ArrayList<>();

        validators.add(new CampoObrigatorioValidator("Nome", nome));
        validators.add(new CampoObrigatorioValidator("Cor do vestido", cor_vestido));
        validators.add(new CampoObrigatorioValidator("Nome do filme", nome_filme));
        validators.add(new CampoObrigatorioValidator("Ano do filme", ano_filme));

        validators.add(new TextValidator(nome));
        validators.add(new TextValidator(cor_vestido));
        validators.add(new TextValidator(nome_filme));
        validators.add(new AnoValidator(ano_filme));

        for (Validator<String> validator : validators) {
            if (!validator.validar(validator.getValor())) {
                return validator.getMensagemErro();
            }
        }

        return "";
    }
}