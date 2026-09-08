package com.template.service;

import com.template.model.dto.PrincesasDaDisneyDTO;
import java.util.List;

public interface IPrincesaService {
    void salvarPrincesa(PrincesasDaDisneyDTO princesa);
    void atualizarPrincesa(PrincesasDaDisneyDTO princesa);
    void excluirPrincesa(int id);
    List<PrincesasDaDisneyDTO> listarPrincesas();
}