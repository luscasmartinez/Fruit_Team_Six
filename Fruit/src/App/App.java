package App;

import java.awt.EventQueue;

import construtores.Item;
import construtores.Produto;
import gui.MenuInicial;

public class App {
    /**
     * Inicia a Aplicação
     */
    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuInicial frame = new MenuInicial();
                    frame.setVisible(true);
               
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}