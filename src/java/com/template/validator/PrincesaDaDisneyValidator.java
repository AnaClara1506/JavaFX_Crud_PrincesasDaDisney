package com.template.validator;

import java.util.ArrayList;
import java.util.List;

public class PrincesaDaDisneyValidator implements IPrincesaDaDisneyValidator {

    @Override
    public String validarPrincesa(String nome, String corVestido, String nomeFilme, String anoFilme) {
        List<Validator<String>> validators = new ArrayList<>();

        // Validadores de campos obrigatórios
        validators.add(new CampoObrigatorioValidator("Nome", nome));
        validators.add(new CampoObrigatorioValidator("Cor do vestido", corVestido));
        validators.add(new CampoObrigatorioValidator("Nome do filme", nomeFilme));
        validators.add(new CampoObrigatorioValidator("Ano do filme", anoFilme));

        // Validadores de tipo
        validators.add(new TextValidator(nome));
        validators.add(new TextValidator(corVestido));
        validators.add(new TextValidator(nomeFilme));
        validators.add(new AnoValidator(anoFilme));

        for (Validator<String> validator : validators) {
            if (!validator.validar(validator.getValor())) {
                return validator.getMensagemErro();
            }
        }

        return "";
    }
}