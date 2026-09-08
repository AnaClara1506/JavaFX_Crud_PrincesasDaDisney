package com.template.service;

import com.template.model.dao.IPrincesasDaDisneyDAO;
import com.template.model.dao.PrincesasDaDisneyDAO;
import com.template.model.dto.PrincesasDaDisneyDTO;

import java.util.ArrayList;

public class PrincesaService implements IPrincesaService {

    private final IPrincesasDaDisneyDAO princesaDAO;

    public PrincesaService() {
        this.princesaDAO = new PrincesasDaDisneyDAO();
    }

    public PrincesaService(IPrincesasDaDisneyDAO princesaDAO) {
        this.princesaDAO = princesaDAO;
    }

    @Override
    public void salvarPrincesa(PrincesasDaDisneyDTO princesa) {
        princesaDAO.cadastrarPrincesa(princesa);
    }

    @Override
    public ArrayList<PrincesasDaDisneyDTO> listarPrincesas() {
        return princesaDAO.visualizarPrincesa();
    }

    @Override
    public void atualizarPrincesa(PrincesasDaDisneyDTO princesa) {
        princesaDAO.atualizarPrincesa(princesa);
    }

    @Override
    public void excluirPrincesa(int id) {
        princesaDAO.excluirPrincesa(id);
    }
}