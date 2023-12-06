package Frames;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import Model.Estudante;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaInicial extends JPanel{

    private AppFrame frame;
    private JPanel panel;
    private JTable table;
    private JButton button;
    private JButton button1;
    private JButton button2;
    private FlowLayout flow;
    

    public PaginaInicial(AppFrame frame){

        flow = new FlowLayout();
    }

    public void criarButtons(){
        panel = new JPanel();
        panel.setLayout(flow);
        flow.setAlignment(FlowLayout.RIGHT);
        button = new JButton("Criar");
        button1 = new JButton("Editar");
        button2 = new JButton("Remover");


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.mostrarFormEstudante(null);
            }
        });

        panel.add(button);
        panel.add(button1);
        panel.add(button2);

        panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

    }


}
