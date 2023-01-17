package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import cadastros.CadNotaFiscal;
import cadastros.CadProduto;
import construtores.NotaFiscal;
import construtores.Produto;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuVenda {

    public MenuVenda() {
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    private CadProduto listaProduto;
    private CadNotaFiscal listaNotaFiscal;

    private ObservableList<Produto> produtoObs;
    private ObservableList<NotaFiscal> notaFiscalObs;

    private ObservableList<Produto> tempObs;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<Produto> listaProdutos;

    @FXML
    private ComboBox<Produto> produtosChoiceBox;

    @FXML
    private Label quantidadePossui;

    @FXML
    private TextField quantidadeVendida;

    @FXML
    void selecionaProduto(MouseEvent event) {
        quantidadePossui.setText("" + produtosChoiceBox.getSelectionModel().getSelectedItem().getQuantidade());

        tempObs.add(produtosChoiceBox.getSelectionModel().getSelectedItem());
    }

    public static int cod = 1;

    @FXML
    void adicionarANota(ActionEvent event) {

        tempObs.add(this.produtosChoiceBox.getSelectionModel().getSelectedItem());
    }

    @FXML
    void finalizaVenda(ActionEvent event) {
        NotaFiscal novaNF = new NotaFiscal(cod, null, null);
        cod++;
    }

    @FXML
    void removerDaNota(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MenuInicial.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        listaProduto = MenuInicial.getListaProduto();
        produtoObs = MenuInicial.getObsListaProduto();

        listaNotaFiscal = MenuInicial.getListaNotaFiscal();
        notaFiscalObs = MenuInicial.getObsListaNotaFiscal();

        tempObs = MenuInicial.getObsListaTemp();

        listaProdutos.getItems().addAll(tempObs);

        produtosChoiceBox.getItems().addAll(produtoObs);
    }
}