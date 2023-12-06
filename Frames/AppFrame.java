package Frames;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Estudante;

import java.awt.CardLayout;

public class AppFrame extends JFrame {
    private PaginaInicial inicial;
	private JPanel cardsPane;
    private CardLayout layout;
    private FormPanel formPanel;
    public static final String TITULO = "CRUD Matrículas";

    public AppFrame(){
        this.setTitle(TITULO);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        layout = new CardLayout();
		cardsPane = new JPanel();
		setLayout(layout);
		add(cardsPane);
        showButton();
        criarCards();
    }

    public void showScreen(){
        pack();
		    setLocationRelativeTo(null);
		    setVisible(true);
        setSize(1024, 600);
    }

    private void showButton(){
        inicial = new PaginaInicial(this);
        cardsPane.add(inicial, PaginaInicial.class.getName());
    }

	public void mostrarFormEstudante(Estudante estudante) {
		formPanel.getEstudanteForm().setEstudante(estudante);
		layout.show(cardsPane, EstudanteForm.class.getName());
	}

    private void criarCards() {
		inicial = new PaginaInicial(this);
		cardsPane.add(inicial, PaginaInicial.class.getName());

		formPanel = new FormPanel(inicial);
		cardsPane.add(formPanel, FormPanel.class.getName());
	}

}
