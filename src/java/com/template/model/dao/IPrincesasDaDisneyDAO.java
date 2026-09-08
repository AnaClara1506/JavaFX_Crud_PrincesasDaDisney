package com.template.model.dao;

import com.template.model.dto.PrincesasDaDisneyDTO;
import java.util.ArrayList;

public interface IPrincesasDaDisneyDAO {
    void cadastrarPrincesa(PrincesasDaDisneyDTO princesa);
    ArrayList<PrincesasDaDisneyDTO> visualizarPrincesa();
    void atualizarPrincesa(PrincesasDaDisneyDTO princesa);
    void excluirPrincesa(int id);
}