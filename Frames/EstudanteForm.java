package Frames;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer.Form;

import javax.print.DocFlavor.SERVICE_FORMATTED;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.swing.JLabel;

import Model.Estudante;
import Model.EstudanteStorage;

public class EstudanteForm extends JPanel {

    private static final Insets FIELD_INSETS = new Insets(5, 10, 0, 0);
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private Estudante estudante;
    private PaginaInicial paginaInicial;

    private JTextField nomeCompleto;
    private JTextField idade;
    private JTextField email;
    private JTextField endereco;
    private JTextField cep;
    private JTextField telefone;
    private JTextField usuario;
    private JPasswordField senha;
    private JComboBox<String> curso;
    private JTextArea observacoes;
    private JCheckBox ativo;
    private String[] cursos = {"Selecione uma opção", "Administração", "ADS", "Medicina", "Direito", "Design", "Psicologia", "Física"};

    public EstudanteForm(PaginaInicial paginaInicial) {
        this.estudante = null;
        this.paginaInicial = paginaInicial;
        layout = new GridBagLayout();
        setLayout(layout);
        constraints = new GridBagConstraints();

        criarForm();
    }

    public JTextField getNomeCompleto() {
        return nomeCompleto;
    }

    public JTextField getIdade() {
        return idade;
    }

    public JTextField getEmail() {
        return email;
    }

    public JTextField getEndereco() {
        return endereco;
    }

    public JTextField getCep() {
        return cep;
    }

    public JTextField getTelefone() {
        return telefone;
    }

    public JTextField getUsuario() {
        return usuario;
    }

    public JPasswordField getSenha() {
        return senha;
    }

    public JComboBox<String> getCurso() {
        return curso;
    }

    public JTextArea getObservacoes() {
        return observacoes;
    }

    public JCheckBox getAtivo() {
        return ativo;
    }

    public String[] getCursos() {
        return cursos;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public void criarForm() {
        JLabel label;

        label = new JLabel("Nome Completo *");
        addFormComponents(label, 0, 0);
        nomeCompleto = new JTextField(45);
        addFormComponents(nomeCompleto, 0, 1);

        label = new JLabel("Idade *");
        addFormComponents(label, 1, 0);
        idade = new JTextField(3);
        addFormComponents(idade, 1, 1);

        label = new JLabel("E-mail *");
        addFormComponents(label, 2, 0);
        email = new JTextField(45);
        addFormComponents(email, 2, 1);

        label = new JLabel("Endereço *");
        addFormComponents(label, 3, 0);
        endereco = new JTextField(100);
        addFormComponents(endereco, 3, 1);

        label = new JLabel("CEP");
        addFormComponents(label, 4, 0);
        cep = new JTextField(15);
        addFormComponents(cep, 4, 1);

        label = new JLabel("Telefone");
        addFormComponents(label, 5, 0);
        telefone = new JTextField(45);
        addFormComponents(telefone, 5, 1);

        label = new JLabel("Usuário *");
        addFormComponents(label, 6, 0);
        usuario = new JTextField(45);
        addFormComponents(usuario, 6, 1);

        label = new JLabel("Senha *");
        addFormComponents(label, 7, 0);
        senha = new JPasswordField(45);
        addFormComponents(senha, 7, 1);

        label = new JLabel("Curso *");
        addFormComponents(label, 8, 0);
        curso = new JComboBox(cursos);
        addFormComponents(curso, 8, 1);

        JScrollPane scrollPane;
        label = new JLabel("Observações");
        addFormComponents(label, 9, 0);
        observacoes = new JTextArea(3, 25);
        scrollPane = new JScrollPane(observacoes);
        addFormComponents(scrollPane, 9, 1, 3, 3);

        label = new JLabel("Ativo *");
        addFormComponents(label, 12, 0);
        ativo = new JCheckBox();
        addFormComponents(ativo, 12, 1);

        addFormComponents(mountFormButtons(), 13, 0, 2, 0);

    }

    private JPanel mountFormButtons() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        jPanel.add(createAddNewButton());
        jPanel.add(createCancelButton());

        return jPanel;
    }

    private JButton createAddNewButton() {
        JButton addNew = new JButton("Adicionar");
        addNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (estudante == null) {

                    if (verifyFields()) {
                        estudante = new Estudante();

                        insertModelData(estudante, true);

                        JOptionPane.showMessageDialog(EstudanteForm.this, "Estudante adicionado com sucesso!", "Cadastro de Matrícula",
                                JOptionPane.INFORMATION_MESSAGE);
                                //Redireciona para a home
                    } else {
                        JOptionPane.showMessageDialog(EstudanteForm.this, "Houve alguma falha na verificação dos campos.\n Por favor verifique: \n Se os campos marcados com '*' estão preenchidos \n Se o campo Idade contém um número \n Se foi selecionado algum curso.", "Cadastro de Matrícula",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    if (verifyFields()) {
                        insertModelData(estudante, false);
                        JOptionPane.showMessageDialog(EstudanteForm.this, "Atualizado com sucesso!", "Cadastro de Matrícula",
                                JOptionPane.INFORMATION_MESSAGE);
                                //Redireciona para a home
                    } else {
                        JOptionPane.showMessageDialog(EstudanteForm.this, "Oops, houve alguma falha na verificação dos campos. :( \n Por favor verifique: \n Se os campos marcados com '*' estão preenchidos \n Se o campo Idade contém um número \n Se foi selecionado algum curso.", "Cadastro de Matrícula",
                                                        JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        return addNew;
    }

    private JButton createCancelButton() {
        JButton cancel = new JButton("Cancelar");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogoButton = 0;
                dialogoButton = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar?", "Cadastro de Matricula",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (dialogoButton == JOptionPane.YES_OPTION) {
                    //Redireciona para a home
                }
                if (dialogoButton == JOptionPane.NO_OPTION) {
                    //paginaInicial.showFormPage(null);
                    //retorna o formulário limpo
                }

            }
        });

        return cancel;
    }

    private void insertModelData(Estudante estudante, boolean isNew) {
        estudante.setNomeCompleto(nomeCompleto.getText());
        estudante.setIdade(Integer.parseInt(idade.getText()));
        estudante.setEmail(email.getText());
        estudante.setEndereco(endereco.getText());
        estudante.setCep(cep.getText());
        estudante.setTelefone(telefone.getText());
        estudante.setUsuario(usuario.getText());
        estudante.setSenha(senha.getPassword().toString());
        estudante.setCurso(curso.getSelectedItem().toString());
        estudante.setObservacoes(observacoes.getText());
        estudante.setAtivo(ativo.isSelected());

        if (isNew == true) {
            EstudanteStorage.inserirEstudante(estudante);
        } else {
            EstudanteStorage.updateEstudante(estudante);
        }
    }

    public boolean verifyFields() {
        if (nomeCompleto.getText().isEmpty() || idade.getText().isEmpty() || email.getText().isEmpty() || endereco.getText().isEmpty() || usuario.getText().isEmpty() || senha.getText().isEmpty() || curso.getSelectedItem().toString().isEmpty() || curso.getSelectedItem().toString().equals("Selecione uma opção")) {
            return false;
        }

        if (!idade.getText().isEmpty()) {
            try {
                Integer.parseInt(idade.getText());
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public void addFormComponents(JComponent component, int row, int column) {
        addFormComponents(component, row, column, 1, 1);
    }

    public void addFormComponents(JComponent component, int row, int column, int width, int height) {
        constraints.gridx = column;
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = FIELD_INSETS;
        layout.setConstraints(component, constraints);
        add(component);
    }
}