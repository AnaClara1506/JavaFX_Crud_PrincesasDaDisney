package com.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

public class PrincesasDaDisneyDAO {
    Connection c;
    PreparedStatement ps;
    ResultSet rs;
    private static Logger logger = Logger.getLogger(PrincesasDaDisneyDAO.class.getName());

    ArrayList<PrincesasDaDisneyDTO> listaPrincesas = new ArrayList<>();

    public void cadastrarPrincesa(PrincesasDaDisneyDTO princesa){
        String sql = "INSERT INTO princesas_da_disney (nome, cor_vestido, nome_filme, ano_filme) VALUES (?, ?, ?, ?)";
        ps = null;
        c = new Conexao().conectaBD();
        try{
            ps = c.prepareStatement(sql);
            ps.setString(1, princesa.getNome());
            ps.setString(2, princesa.getCor_vestido());
            ps.setString(3, princesa.getNome_filme());
            ps.setInt(4, princesa.getAno_filme());
            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            try {
                if(ps!= null) ps.close();
                if(c != null) c.close();
            } catch (SQLException ex){
                Logger.getLogger(PrincesasDaDisneyDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<PrincesasDaDisneyDTO> selecionarPrincesa(){
        String sql = "select * from princesas_da_disney";
        try (Connection c = new Conexao().conectaBD(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();){
            while(rs.next())
            {
               PrincesasDaDisneyDTO princesa = new PrincesasDaDisneyDTO();
               princesa.setId(rs.getInt("id"));
               princesa.setNome(rs.getString("nome"));
               princesa.setCor_vestido(rs.getString("cor_vestido"));
               princesa.setNome_filme(rs.getString("nome_filme"));
               princesa.setAno_filme(rs.getInt("ano_filme"));
               listaPrincesas.add(princesa);
            }
        }
        catch (SQLException ex){
            Logger.getLogger(PrincesasDaDisneyDAO.class.getName()).log(Level.SEVERE, "Erro ao listar princesa", ex);
        }

        return listaPrincesas;
    }

    public void atualizarPrincesa(PrincesasDaDisneyDTO princesa){
        String sql = "UPDATE princesas_da_disney SET nome = ?, cor_vestido = ?, nome_filme = ?, ano_filme = ? WHERE id = ?";

        try (Connection c = new Conexao().conectaBD();PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, princesa.getNome());
            ps.setString(2, princesa.getCor_vestido());
            ps.setString(3, princesa.getNome_filme());
            ps.setInt(4, princesa.getAno_filme());
            ps.setInt(5, princesa.getId());
            ps.executeUpdate();
        } catch (SQLException ex){
            Logger.getLogger(PrincesasDaDisneyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluirPrincesa(int id){
        String sql = "DELETE FROM princesas_da_disney WHERE id = ?";

        try (Connection c = new Conexao().conectaBD(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex){
            Logger.getLogger(PrincesasDaDisneyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
