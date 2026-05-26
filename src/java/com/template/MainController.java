package com.template;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class MainController
{
    @FXML private Button btnSalvarAction;
    @FXML private Button btnAltualizarAction;
    @FXML private Button btnDeletarAction;
    @FXML private Button btnLimparAction;
    @FXML private TextField txtNome;
    @FXML private TextField txtID;
    @FXML private TextField txtCorVestido;
    @FXML private TextField txtNomeFilme;
    @FXML private TextField txtAnoFilme;
    @FXML private TableView<PrincesasDaDisneyDTO> tbrPrincesasDaDisney;
    @FXML private TableColumn<PrincesasDaDisneyDTO, Integer> colID;
    @FXML private TableColumn<PrincesasDaDisneyDTO, String> colNome;
    @FXML private TableColumn<PrincesasDaDisneyDTO, String> colCorVestido;
    @FXML private TableColumn<PrincesasDaDisneyDTO, String> colNomeFilme;
    @FXML private TableColumn<PrincesasDaDisneyDTO, Integer> colAnoFilme;

    @FXML
    private void btnSalvarAction(ActionEvent event){
        String nome = txtNome.getText();
        int id = Integer.parseInt(txtID.getText());
        String cor_vestido = txtCorVestido.getText();
        String nome_filme = txtNomeFilme.getText();
        int ano_filme = Integer.parseInt(txtAnoFilme.getText());

        PrincesasDaDisneyDTO objsaudedto = new PrincesasDaDisneyDTO();
        objsaudedto.setNome(nome);
        objsaudedto.setId(id);
        objsaudedto.setCor_vestido(cor_vestido);
        objsaudedto.setNome_filme(nome_filme);
        objsaudedto.setAno_filme(ano_filme);

        PrincesasDaDisneyDAO objsaudedao = new PrincesasDaDisneyDAO();
        objsaudedao.cadastrarPrincesa(objsaudedto);

        carregarPrincesas();
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
    private void carregarPrincesa() {

    }

    @FXML
    private void initialize()
    {
        System.out.println("FXML loaded successfully!");
    }
}
}
