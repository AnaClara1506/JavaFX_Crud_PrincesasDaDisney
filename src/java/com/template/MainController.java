package com.template;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;


public class MainController
{
    @FXML private TextField txtNome;
    @FXML private TextField txtID;
    @FXML private TextField txtCorVestido;
    @FXML private TextField txtNomeFilme;
    @FXML private TextField txtAnoFilme;
    @FXML private Label lblErro;

    @FXML private TableView<PrincesasDaDisneyDTO> tblPrincesasDaDisney;
    @FXML private TableColumn<PrincesasDaDisneyDTO, Integer> colID;
    @FXML private TableColumn<PrincesasDaDisneyDTO, String> colNome;
    @FXML private TableColumn<PrincesasDaDisneyDTO, String> colCorVestido;
    @FXML private TableColumn<PrincesasDaDisneyDTO, String> colNomeFilme;
    @FXML private TableColumn<PrincesasDaDisneyDTO, Integer> colAnoFilme;

    private boolean conferenciaDados() {
        if (txtNome.getText().trim().isEmpty() ||
                txtCorVestido.getText().trim().isEmpty() ||
                txtNomeFilme.getText().trim().isEmpty() ||
                txtAnoFilme.getText().trim().isEmpty()) {

            lblErro.setText("Por favor, preencha todos os campos obrigatórios!");
            return false;
        }

        try {
            Integer.parseInt(txtNome.getText().trim());
            lblErro.setText("O campo 'Nome' deve conter um texto");
            return false;
        } catch (NumberFormatException e) {
        }

        try {
            Integer.parseInt(txtCorVestido.getText().trim());
            lblErro.setText("O campo 'Cor do Vestido' deve conter um texto");
            return false;
        } catch (NumberFormatException e) {
        }

        try {
            Integer.parseInt(txtNomeFilme.getText().trim());
            lblErro.setText("O campo 'Nome do Filme' deve conter um texto");
            return false;
        } catch (NumberFormatException e) {
        }

        try {
            int ano = Integer.parseInt(txtAnoFilme.getText().trim());
            if (ano < 1937 || ano > 2026) {
                lblErro.setText("Por favor, digite um ano válido entre 1937 (primeiro filme) e 2026.");
                return false;
            }
        } catch (NumberFormatException e) {
            lblErro.setText("O campo 'Ano do Filme' deve conter apenas números.");
            return false;
        }

        lblErro.setText("");
        return true;
    }

    @FXML
    private void carregarPrincesas(){
        PrincesasDaDisneyDAO objPrincesasDAO = new PrincesasDaDisneyDAO();
        ArrayList<PrincesasDaDisneyDTO> listaPrincesas = objPrincesasDAO.visualizarPrincesa();
        tblPrincesasDaDisney.setItems(FXCollections.observableArrayList(listaPrincesas));

        limparCampos();
    }


    @FXML
    private void btnSalvarAction(ActionEvent event){
        if(conferenciaDados()) {
            String nome = txtNome.getText();
            String cor_vestido = txtCorVestido.getText();
            String nome_filme = txtNomeFilme.getText();
            int ano_filme = Integer.parseInt(txtAnoFilme.getText());

            PrincesasDaDisneyDTO objsaudedto = new PrincesasDaDisneyDTO();
            objsaudedto.setNome(nome);
            objsaudedto.setCorVestido(cor_vestido);
            objsaudedto.setNomeFilme(nome_filme);
            objsaudedto.setAnoFilme(ano_filme);

            PrincesasDaDisneyDAO objsaudedao = new PrincesasDaDisneyDAO();
            objsaudedao.cadastrarPrincesa(objsaudedto);

            carregarPrincesas();
        }
    }
    @FXML
    private void btnLimparAction(ActionEvent event){
        txtID.clear();
        txtNome.clear();
        txtCorVestido.clear();
        txtNomeFilme.clear();
        txtAnoFilme.clear();
    }

    @FXML
    private void carregarCampos() {
        PrincesasDaDisneyDTO princesaDto = tblPrincesasDaDisney.getSelectionModel().getSelectedItem();

        if (princesaDto != null) {
            txtID.setText(String.valueOf(princesaDto.getId()));
            txtNome.setText(princesaDto.getNome());
            txtCorVestido.setText(princesaDto.getCorVestido());
            txtNomeFilme.setText(princesaDto.getNomeFilme());
            txtAnoFilme.setText(String.valueOf(princesaDto.getAnoFilme()));
        }
    }

    @FXML
    private void btnAtualizarAction(ActionEvent event) {
        if(conferenciaDados()) {
            PrincesasDaDisneyDTO princesaSelecionada = tblPrincesasDaDisney.getSelectionModel().getSelectedItem();

            if (princesaSelecionada != null) {
                PrincesasDaDisneyDTO princesasDto = new PrincesasDaDisneyDTO();

                princesasDto.setId(princesaSelecionada.getId());
                princesasDto.setNome(txtNome.getText());
                princesasDto.setCorVestido(txtCorVestido.getText());
                princesasDto.setNomeFilme(txtNomeFilme.getText());
                princesasDto.setAnoFilme(Integer.parseInt(txtAnoFilme.getText()));

                PrincesasDaDisneyDAO princesasDao = new PrincesasDaDisneyDAO();

                princesasDao.atualizarPrincesa(princesasDto);

                carregarPrincesas();
            }
        }
    }
    @FXML
    private void btnDeletarAction(ActionEvent event) {
        PrincesasDaDisneyDTO princesaSelecionada = tblPrincesasDaDisney.getSelectionModel().getSelectedItem();
        if (princesaSelecionada != null) {
            PrincesasDaDisneyDAO tourDao = new PrincesasDaDisneyDAO();
            tourDao.excluirPrincesa(princesaSelecionada.getId());

            carregarPrincesas();
        }
    }

    @FXML
    private void limparCampos() {
        txtID.setText("");
        txtNome.setText("");
        txtCorVestido.setText("");
        txtNomeFilme.setText("");
        txtAnoFilme.setText("");
    }

    //Etiquetas para valores das colunas
    public void initialize(){
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colCorVestido.setCellValueFactory(new PropertyValueFactory<>("corVestido"));
        colNomeFilme.setCellValueFactory(new PropertyValueFactory<>("nomeFilme"));
        colAnoFilme.setCellValueFactory(new PropertyValueFactory<>("anoFilme"));
        carregarPrincesas();
    }

}
