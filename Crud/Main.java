import javax.swing.SwingUtilities;

import Frames.AppFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                exibirTela();
            }
        });
    }

    public static void exibirTela(){
        AppFrame appFrame = new AppFrame();
        appFrame.showScreen();
    }

}