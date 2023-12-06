package Frames;
import javax.swing.JButton;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Estudante;
import Model.EstudanteStorage;

public class EstudanteListTable  extends JPanel {
    private AppFrame frame;
    private JTable table;
    private EstudentTableModel eTableModel;
	private JButton newStudentButton;
	private JButton editarStudentBtn;
	private JButton removerStudentBtn;

    public EstudanteListTable(AppFrame appFrame){
        frame = appFrame;
        setLayout(new BorderLayout(10, 10));
        criarEstudanteTable();
		criarComandosPanel();
    }


    public void recarregarEstudante(){
        eTableModel.carregarEstudante(EstudanteStorage.listarEstudante());
    }


    private void criarEstudanteTable() {
		JPanel panel = new JPanel();

		eTableModel = new EstudentTableModel(EstudanteStorage.listarEstudante());
		table = new JTable(eTableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (table.getSelectedRow() >= 0) {
						habilitarBotoes();
					} else {
						desabilitarBotoes();
					}
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane);

		add(panel, BorderLayout.CENTER);
	}

    private void criarComandosPanel() {
        JPanel panel = new JPanel();
        FlowLayout layout = (FlowLayout) panel.getLayout();
        layout.setAlignment(FlowLayout.CENTER);

        newStudentButton = new JButton("Novo Estudante");
        newStudentButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mostrarFormEstudante(null);
            }
        });
        panel.add(newStudentButton);

        editarStudentBtn = new JButton("Editar");
        editarStudentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mostrarFormEstudante(eTableModel.getEstudante(table.getSelectedRow()));
            }
        });
        panel.add(editarStudentBtn);

        removerStudentBtn = new JButton("Remover");
        removerStudentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Estudante estudante = eTableModel.getEstudante(table.getSelectedRow());
                int resposta = JOptionPane.showConfirmDialog(EstudanteListTable.this, "Deseja realmente remover?",
                        AppFrame.TITULO, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (resposta == JOptionPane.YES_OPTION) {
                    EstudanteStorage.removerEstudante(estudante);
                    eTableModel.removerEstudante(estudante);
                }
            }
        });
        panel.add(removerStudentBtn);

        add(panel, BorderLayout.NORTH);

        desabilitarBotoes();
    }

        public void habilitarBotoes() {
            editarStudentBtn.setEnabled(true);
            removerStudentBtn.setEnabled(true);
        }
    
        public void desabilitarBotoes() {
            editarStudentBtn.setEnabled(false);
            removerStudentBtn.setEnabled(false);
        }
}
