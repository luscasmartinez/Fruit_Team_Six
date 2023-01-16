package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import cadastros.CadProduto;
import construtores.Produto;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MenuCadastro {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private CadProduto listaProduto;
    private ObservableList<Produto> produtoObs;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> boxUnKg;

    private String[] unidade = { "KG", "UN" };

    @FXML
    private ListView<Produto> produtos;

    @FXML
    private TextField txtDescricao;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPreco;

    @FXML
    private TextField txtQuantidade;

    static int cod = 1;

    @FXML
    void cadastrarProduto(ActionEvent event) throws Exception {
        if (txtNome.getText().isEmpty() || txtPreco.getText().isEmpty() || txtQuantidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Os campos Nome, Preço e Quantidade \n são obrigatórios!");

        } else {
            if (boxUnKg.getValue() == "KG") {
                String qtd = txtQuantidade.getText().replaceAll(",", ".");
                String preco = txtPreco.getText().replaceAll(",", ".");
                // Produto por Kilo (double)
                Produto novoProduto = new Produto(txtNome.getText(), txtDescricao.getText(), cod,
                        Double.parseDouble(qtd), Double.parseDouble(preco));
                cod++;

                listaProduto.addProduto(novoProduto);
                produtoObs.add(novoProduto);

                JOptionPane.showMessageDialog(null,
                        "Produto por Kilo: " + txtNome.getText() + ", cadastrado com sucesso!");

                txtDescricao.clear();
                txtNome.clear();
                txtPreco.clear();
                txtQuantidade.clear();
                txtNome.requestFocus();

            } else if (boxUnKg.getValue() == "UN") {
                String preco = txtPreco.getText().replaceAll(",", ".");
                // Produto por Unidade (int)
                Produto novoProduto = new Produto(txtNome.getText(), txtDescricao.getText(), cod,
                        Integer.parseInt(txtQuantidade.getText()), Double.parseDouble(preco));
                cod++;

                JOptionPane.showMessageDialog(null,
                        "Produto por Unidade: " + txtNome.getText() + ", cadastrado com sucesso!");

                listaProduto.addProduto(novoProduto);
                produtoObs.add(novoProduto);

                txtDescricao.clear();
                txtNome.clear();
                txtPreco.clear();
                txtQuantidade.clear();
                txtNome.requestFocus();

            } else {
                JOptionPane.showMessageDialog(null,
                        "Informe a Unidade de medida do Produto!");
            }
        }
    }

    @FXML
    void alterar(ActionEvent event) {

    }

    @FXML
    void cancelar(ActionEvent event) throws IOException {
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

        boxUnKg.getItems().addAll(unidade);

        produtos.setItems(produtoObs);
    }
}