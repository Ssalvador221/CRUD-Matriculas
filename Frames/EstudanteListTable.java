package Frames;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.BorderLayout;

import Model.EstudanteStorage;

public class EstudanteListTable  extends JPanel {
    private AppFrame frame;
    private JTable table;
    private EstudentTableModel eTableModel;

    public EstudanteListTable(AppFrame appFrame){
        frame = new AppFrame();
        setLayout(new BorderLayout(10, 10));

        criarEstudanteTable();
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
						
					} else {
						
					}
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane);

		add(panel, BorderLayout.CENTER);
	}



}
