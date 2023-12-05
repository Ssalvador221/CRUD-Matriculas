package View.Form;

import View.BaseLayout;
import View.Header.Header;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Arrays;

public class FormPanel extends JPanel {
    private BorderLayout layout;
    private EstudanteForm estudanteForm;
    private BaseLayout baseLayout;

    public FormPage(BaseLayout baseLayout) {
        this.baseLayout = baseLayout;
        setBackground(Color.decode("#8C8C8C"));
        layout = new BorderLayout(5,5);
        setLayout(layout);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                verificarSeNovoOuEditar();
            }
        });

        initialize();
    }

    public EstudanteForm getEstudanteForm() {
        return estudanteForm;
    }

    private void initialize() {
        estudanteForm = new EstudanteForm(baseLayout);

        add(estudanteForm,BorderLayout.CENTER);

        header = new Header("Cadastrar Novo Estudante");
        add(header, BorderLayout.NORTH);
    }

    public void verificarSeNovoOuEditar() {
        if (estudanteForm.getRegistrationModel() == null) {
            estudanteForm.getNomeCompleto().setText("");
            estudanteForm.getIdade().setText("");
            estudanteForm.getEmail().setText("");
            estudanteForm.getEndereco().setText("");
            estudanteForm.getCep().setText("");
            estudanteForm.getTelefone().setText("");
            estudanteForm.getUsuario().setText("");
            estudanteForm.getSenha().setText("");
            estudanteForm.getCurso().setSelectedIndex(0);
            estudanteForm.getObservacoes().setText("");
            estudanteForm.getAtivo().setEnabled(true);
        } else {
            estudanteForm.getNomeCompleto().setText(estudanteForm.getEstudante().getNomeCompleto());
            estudanteForm.getIdade().setText(Integer.toString(estudanteForm.getEstudante().getIdade()));
            estudanteForm.getEmail().setText(estudanteForm.getEstudante().getEmail());
            estudanteForm.getEndereco().setText(estudanteForm.getEstudante().getEndereco());
            estudanteForm.getCep().setText(estudanteForm.getEstudante().getCep());
            estudanteForm.getTelefone().setText(estudanteForm.getEstudante().getTelefone());
            estudanteForm.getUsuario().setText(estudanteForm.getEstudante().getUsuario());
            estudanteForm.getSenha().setText(estudanteForm.getEstudante().getSenha());
            estudanteForm.getCurso().setSelectedIndex(Arrays.asList(estudanteForm.getCursos()).indexOf(estudanteForm.getEstudante().getCurso()));
            estudanteForm.getObservacoes().setText(estudanteForm.getEstudante().getObservacoes());
            estudanteForm.getAtivo().setEnabled(estudanteForm.getEstudante().getAtivo());
        }
    }
}
