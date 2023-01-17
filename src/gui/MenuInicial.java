package gui;

import java.io.IOException;

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
import javafx.stage.Stage;

public class MenuInicial {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private static CadProduto listaProduto;
    private static CadNotaFiscal listaNotaFiscal;

    private static ObservableList<Produto> produtoObs;
    private static ObservableList<NotaFiscal> notaFiscalObs;


    @FXML
    void btCadastrar(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MenuCadastro.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btNotas(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MenuNota.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btVender(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MenuVenda.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static CadProduto getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(CadProduto listaProdutoNova) {
        listaProduto = listaProdutoNova;
    }

    public static CadNotaFiscal getListaNotaFiscal() {
        return listaNotaFiscal;
    }

    public void setListaNotaFiscal(CadNotaFiscal listaNotaFiscalNova) {
        listaNotaFiscal = listaNotaFiscalNova;
    }

    public static ObservableList<Produto> getObsListaProduto() {
        return produtoObs;
    }
    
    public static ObservableList<NotaFiscal> getObsListaNotaFiscal() {
        return notaFiscalObs;
    }
    
    public void setObsListaProduto(ObservableList<Produto> produtoObsNova) {
        produtoObs = (ObservableList<Produto>) produtoObsNova;
    }

    public void setObsListaNotaFiscal(ObservableList<NotaFiscal> notaFiscalObsNova) {
        notaFiscalObs = (ObservableList<NotaFiscal>) notaFiscalObsNova;
    }

}
