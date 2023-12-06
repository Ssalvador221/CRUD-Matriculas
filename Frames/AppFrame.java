package Frames;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Estudante;

import java.awt.CardLayout;

public class AppFrame extends JFrame {
    private PaginaInicial paginaInicial;
	private JPanel cardsPane;
    private CardLayout layout;
    private FormPanel formPanel;
    private EstudanteListTable estudanteListTable;
    public static final String TITULO = "CRUD Matrículas";

    public AppFrame(){
        this.setTitle(TITULO);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		layout = new CardLayout();

		cardsPane = new JPanel();
		cardsPane.setLayout(layout);
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
        paginaInicial = new PaginaInicial(this);
        layout.show(cardsPane, PaginaInicial.class.getName());
    }

	public void mostrarFormEstudante(Estudante estudante) {
		formPanel.getEstudanteForm().setEstudante(estudante);
		layout.show(cardsPane, EstudanteForm.class.getName());
	} 

    public void showEstudentTable(){
        estudanteListTable.recarregarEstudante();
        layout.show(cardsPane, EstudanteListTable.class.getName());    
    }

    private void criarCards() {
		paginaInicial = new PaginaInicial(this);
		cardsPane.add(paginaInicial, PaginaInicial.class.getName());

        estudanteListTable = new EstudanteListTable(this);
        cardsPane.add(estudanteListTable, EstudanteListTable.class.getName());

		formPanel = new FormPanel(this);
		cardsPane.add(formPanel, FormPanel.class.getName());
	}

}
