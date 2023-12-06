package Frames;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.Dimension;
import Model.Estudante;
import Model.EstudanteStorage;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaInicial extends JPanel{

    private AppFrame frame;
    private JPanel panel;
    private JTable table;
    private JButton adicionar;
    private EstudentTableModel estudentTableModel;
    private JButton editar;
    private JButton remover;
    private FlowLayout flow;

    public PaginaInicial(AppFrame frame){
        flow = new FlowLayout();
        panel = new JPanel();
        table = new JTable();
        mostrarBotoes();
    }

        private void mostrarBotoes() {

            adicionar = new JButton("Adicionar");
            adicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.mostrarFormEstudante(null);
            }
            });
            add(adicionar);
    
            editar = new JButton("Editar");
            editar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.mostrarFormEstudante(estudentTableModel.getEstudante(table.getSelectedRow()));
                }
            });
            add(editar);
    
            remover = new JButton("Remover");
            remover.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int dialogobutton = 0;
                    dialogobutton = JOptionPane.showConfirmDialog(null, "Deseja realmente remover?", "Cadastro de Matricula",
                            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null);
                    if (dialogobutton == JOptionPane.YES_OPTION) {
                        EstudanteStorage.removerEstudante((estudentTableModel.getEstudante(table.getSelectedRow())));
                        estudentTableModel.remove(estudentTableModel.getEstudante(table.getSelectedRow()));
                    }
                    if (dialogobutton == JOptionPane.NO_OPTION) {
                        //Redirecionar para pagina incial
                    }
                }
            });
            add(remover);
    
            desabilitarBotoes();
        }

        public void habilitarBotoes() {
            editar.setEnabled(true);
            remover.setEnabled(true);
        }
    
        public void desabilitarBotoes() {
            editar.setEnabled(false);
            remover.setEnabled(false);
        }
}
