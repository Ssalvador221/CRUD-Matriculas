package Frames;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.Dimension;
import java.awt.FlowLayout;

public class PaginaInicial extends JPanel{

    private JPanel panel;
    //private JTable table;
    private JButton button;
    private JButton button1;
    private JButton button2;
    private FlowLayout flow;
    

    public PaginaInicial(AppFrame frame){
        flow = new FlowLayout();
        panel = new JPanel();
        criarButtons();
    }

    public void criarButtons(){
        
        panel.setLayout(flow);
        flow.setAlignment(FlowLayout.RIGHT);

        button = new JButton("Criar");
        button1 = new JButton("Editar");
        button2 = new JButton("Remover");

        button.setPreferredSize(new Dimension(40, 40));
        button1.setPreferredSize(new Dimension(40, 40));
        button2.setPreferredSize(new Dimension(40, 40));

        panel.add(button);
        panel.add(button1);
        panel.add(button2);

    }



}
