package gui;

import java.net.URL;
import java.util.ResourceBundle;

import cadastros.CadNotaFiscal;
import cadastros.CadProduto;
import construtores.NotaFiscal;
import construtores.Produto;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class MenuVenda {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private CadProduto listaProduto;
    private CadNotaFiscal listaNotaFiscal;

    private ObservableList<Produto> produtoObs;
    private ObservableList<NotaFiscal> notaFiscalObs;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<Produto> listaProdutos;

    @FXML
    private ChoiceBox<Produto> produtosChoiceBox;

    @FXML
    private Label quantidadePossui;

    @FXML
    void initialize() {
        listaProduto = MenuInicial.getListaProduto();
        produtoObs = MenuInicial.getObsListaProduto();

        listaNotaFiscal = MenuInicial.getListaNotaFiscal();
        notaFiscalObs = MenuInicial.getObsListaNotaFiscal();


    }

}
