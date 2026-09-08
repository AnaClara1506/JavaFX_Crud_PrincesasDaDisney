package com.template.model.dao;

import com.template.model.Conexao;
import com.template.model.dto.PrincesasDaDisneyDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.template.util.DialogUtil.showError;

public class PrincesasDaDisneyDAO implements IPrincesasDaDisneyDAO {
    private static final Logger logger = Logger.getLogger(PrincesasDaDisneyDAO.class.getName());

    private static final String SQL_INSERT = "INSERT INTO princesas_da_disney (nome, cor_vestido, nome_filme, ano_filme) VALUES (?, ?, ?, ?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM princesas_da_disney";
    private static final String SQL_UPDATE = "UPDATE princesas_da_disney SET nome = ?, cor_vestido = ?, nome_filme = ?, ano_filme = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM princesas_da_disney WHERE id = ?";

    @Override
    public void cadastrarPrincesa(PrincesasDaDisneyDTO princesa) {
        try (Connection c = new Conexao().conectaBD();
             PreparedStatement ps = c.prepareStatement(SQL_INSERT)) {
            ps.setString(1, princesa.getNome());
            ps.setString(2, princesa.getCorVestido());
            ps.setString(3, princesa.getNomeFilme());
            ps.setInt(4, princesa.getAnoFilme());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao cadastrar princesa", e);
            showError("Erro ao cadastrar princesa");
        }
    }

    @Override
    public ArrayList<PrincesasDaDisneyDTO> visualizarPrincesa() {
        ArrayList<PrincesasDaDisneyDTO> listaPrincesas = new ArrayList<>();
        try (Connection c = new Conexao().conectaBD();
             PreparedStatement ps = c.prepareStatement(SQL_SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                PrincesasDaDisneyDTO princesa = new PrincesasDaDisneyDTO();
                princesa.setId(rs.getInt("id"));
                princesa.setNome(rs.getString("nome"));
                princesa.setCorVestido(rs.getString("cor_vestido"));
                princesa.setNomeFilme(rs.getString("nome_filme"));
                princesa.setAnoFilme(rs.getInt("ano_filme"));
                listaPrincesas.add(princesa);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao listar princesa", ex);
            showError("Erro ao listar princesa");
        }
        return listaPrincesas;
    }

    @Override
    public void atualizarPrincesa(PrincesasDaDisneyDTO princesa) {
        try (Connection c = new Conexao().conectaBD();
             PreparedStatement ps = c.prepareStatement(SQL_UPDATE)) {
            ps.setString(1, princesa.getNome());
            ps.setString(2, princesa.getCorVestido());
            ps.setString(3, princesa.getNomeFilme());
            ps.setInt(4, princesa.getAnoFilme());
            ps.setInt(5, princesa.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao atualizar princesa", ex);
            showError("Erro ao atualizar princesa");
        }
    }

    @Override
    public void excluirPrincesa(int id) {
        try (Connection c = new Conexao().conectaBD();
             PreparedStatement ps = c.prepareStatement(SQL_DELETE)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao excluir princesa", ex);
            showError("Erro ao excluir princesa");
        }
    }
}