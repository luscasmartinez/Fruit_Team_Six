package gui;

import java.net.URL;
import java.util.Optional;

import cadastros.CadNotaFiscal;
import cadastros.CadProduto;
import construtores.NotaFiscal;
import construtores.Produto;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        URL xmlURL = getClass().getResource("MenuInicial.fxml");
        loader.setLocation(xmlURL);

        Parent parent = loader.load();

        Scene scene = new Scene(parent);

        CadProduto listaProduto = new CadProduto();
        CadNotaFiscal listaNotaFiscal = new CadNotaFiscal();

        ObservableList<Produto> produtoObs = FXCollections.observableArrayList();
        ObservableList<NotaFiscal> obsNotaFiscal = FXCollections.observableArrayList();

        MenuInicial controller = loader.getController();

        // Listas comuns
        controller.setListaProduto(listaProduto);
        controller.setListaNotaFiscal(listaNotaFiscal);

        // Listas Obs
        controller.setObsListaProduto(produtoObs);
        controller.setObsListaNotaFiscal(obsNotaFiscal);

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

        primaryStage.setOnCloseRequest(event -> {
            if (sairDaAplicacao())
                System.exit(0);
            event.consume();
        });
    }

    public Boolean sairDaAplicacao() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Alerta");
        alerta.setHeaderText("Tem Certeza que Deseja Sair?");
        ButtonType botaoNao = ButtonType.NO;
        ButtonType botaoSim = ButtonType.YES;
        alerta.getButtonTypes().setAll(botaoSim, botaoNao);
        Optional<ButtonType> resultado = alerta.showAndWait();

        return resultado.get() == botaoSim ? true : false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}