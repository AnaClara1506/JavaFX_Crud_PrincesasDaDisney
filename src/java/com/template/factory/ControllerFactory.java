package com.template.factory;

import com.template.controller.MainController;
import com.template.service.IPrincesaService;
import com.template.service.PrincesaService;
import com.template.validator.IPrincesaDaDisneyValidator;
import com.template.validator.PrincesaDaDisneyValidator;

public class ControllerFactory {

    public Object criarController(Class<?> clazz) {
        if (clazz.equals(MainController.class)) {
            IPrincesaService service = new PrincesaService();
            IPrincesaDaDisneyValidator validador = new PrincesaDaDisneyValidator();

            // Injeta as dependências no construtor da Controller
            return new MainController(service, validador);
        }

        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar controller: " + clazz.getName(), e);
        }
    }
}