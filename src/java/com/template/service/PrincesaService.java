package com.template.service;

import com.template.model.dao.PrincesasDaDisneyDAO;
import com.template.model.dto.PrincesasDaDisneyDTO;

import java.util.ArrayList;

public class PrincesaService {
    private static PrincesasDaDisneyDAO princesaDAO = new PrincesasDaDisneyDAO();

    public static ArrayList<PrincesasDaDisneyDTO> listarPrincesas() {
        return princesaDAO.visualizarPrincesa();
    }

    public static void salvarPrincesa(PrincesasDaDisneyDTO princesaDTO) {
        princesaDAO.cadastrarPrincesa(princesaDTO);
    }

    public static void atualizarPrincesa(PrincesasDaDisneyDTO princesaDTO) {
        princesaDAO.atualizarPrincesa(princesaDTO);
    }

    public static void excluirPrincesa(int id) {
        princesaDAO.excluirPrincesa(id);
    }
}
