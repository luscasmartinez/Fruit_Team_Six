package App;

import java.awt.EventQueue;

import gui.MenuInicial;
/**
* 7 Inicia a Aplicação
*/
public class App {

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