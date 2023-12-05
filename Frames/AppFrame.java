package Frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class AppFrame extends JFrame {
    private PaginaInicial inicial;
	  private JPanel cardsPane;
    private CardLayout layout;
    public static final String TITULO = "CRUD Matrículas";

    public AppFrame(){
        this.setTitle(TITULO);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        layout = new CardLayout();

		    cardsPane = new JPanel();
		    cardsPane.setLayout(layout);
		    add(cardsPane);

        showButton();
    }

    public void showScreen(){
        pack();
		    setLocationRelativeTo(null);
		    setVisible(true);
        setSize(1024, 600);
    }

    private void showButton(){
        inicial = new PaginaInicial(this);
        layout.show(cardsPane, PaginaInicial.class.getName());
    }


}
