package com.template.controller;

import com.template.model.dto.PrincesasDaDisneyDTO;
import com.template.service.IPrincesaService;
import com.template.service.PrincesaService;
import com.template.validator.IPrincesaDaDisneyValidator;
import com.template.validator.PrincesaDaDisneyValidator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import static com.template.util.DialogUtil.showInfo;

public class MainController {

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

    // Injeção / Instanciação baseada em Interfaces (DIP)
    private final IPrincesaService princesaService = new PrincesaService();
    private final IPrincesaDaDisneyValidator princesaValidator = new PrincesaDaDisneyValidator();

    private boolean conferenciaDados() {
        String erro = princesaValidator.validarPrincesa(
                txtNome.getText().trim(),
                txtCorVestido.getText().trim(),
                txtNomeFilme.getText().trim(),
                txtAnoFilme.getText().trim()
        );

        if (!erro.isEmpty()) {
            lblErro.setText(erro);
            return false;
        }
        lblErro.setText("");
        return true;
    }

    @FXML
    private void carregarPrincesas() {
        tblPrincesasDaDisney.setItems(FXCollections.observableArrayList(princesaService.listarPrincesas()));
        limparCampos();
    }

    @FXML
    private void btnSalvarAction(ActionEvent event) {
        if (conferenciaDados()) {
            PrincesasDaDisneyDTO princesaDTO = criarPrincesaDTO(null);
            princesaService.salvarPrincesa(princesaDTO);
            carregarPrincesas();
            showInfo("Princesa salva com sucesso");
        }
    }

    @FXML
    private void btnAtualizarAction(ActionEvent event) {
        PrincesasDaDisneyDTO princesaSelecionada = tblPrincesasDaDisney.getSelectionModel().getSelectedItem();
        if (princesaSelecionada != null && conferenciaDados()) {
            PrincesasDaDisneyDTO princesaDTO = criarPrincesaDTO(princesaSelecionada.getId());
            princesaService.atualizarPrincesa(princesaDTO);
            carregarPrincesas();
            showInfo("Princesa atualizada com sucesso");
        }
    }

    @FXML
    private void btnDeletarAction(ActionEvent event) {
        PrincesasDaDisneyDTO princesaSelecionada = tblPrincesasDaDisney.getSelectionModel().getSelectedItem();
        if (princesaSelecionada != null) {
            princesaService.excluirPrincesa(princesaSelecionada.getId());
            carregarPrincesas();
            showInfo("Princesa excluída com sucesso");
        }
    }

    @FXML
    private void btnLimparAction(ActionEvent event) {
        limparCampos();
    }

    @FXML
    private void carregarCampos() {
        PrincesasDaDisneyDTO princesaDTO = tblPrincesasDaDisney.getSelectionModel().getSelectedItem();
        if (princesaDTO != null) {
            txtID.setText(String.valueOf(princesaDTO.getId()));
            txtNome.setText(princesaDTO.getNome());
            txtCorVestido.setText(princesaDTO.getCorVestido());
            txtNomeFilme.setText(princesaDTO.getNomeFilme());
            txtAnoFilme.setText(String.valueOf(princesaDTO.getAnoFilme()));
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

    private PrincesasDaDisneyDTO criarPrincesaDTO(Integer id) {
        PrincesasDaDisneyDTO princesaDTO = new PrincesasDaDisneyDTO();
        if (id != null) {
            princesaDTO.setId(id);
        }
        princesaDTO.setNome(txtNome.getText());
        princesaDTO.setCorVestido(txtCorVestido.getText());
        princesaDTO.setNomeFilme(txtNomeFilme.getText());
        princesaDTO.setAnoFilme(Integer.parseInt(txtAnoFilme.getText()));
        return princesaDTO;
    }

    @FXML
    public void initialize() {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colCorVestido.setCellValueFactory(new PropertyValueFactory<>("corVestido"));
        colNomeFilme.setCellValueFactory(new PropertyValueFactory<>("nomeFilme"));
        colAnoFilme.setCellValueFactory(new PropertyValueFactory<>("anoFilme"));
        carregarPrincesas();
    }
}