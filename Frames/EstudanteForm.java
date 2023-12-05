package Frames;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import Model.Estudante;

public class EstudanteForm extends JPanel {

    private Estudante estudante;

    private static final Insets FIELD_INSETS = new Insets(5, 10, 0, 0);
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private RegistrationModel estudante;
    private BaseLayout baseLayout;

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

    public EstudanteForm(BaseLayout baseLayout) {
        this.estudante = null;
        this.baseLayout = baseLayout;
        layout = new GridBagLayout();
        setLayout(layout);
        constraints = new GridBagConstraints();

        mountFormFields();
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

    public RegistrationModel getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public void mountFormFields() {
        JLabel fieldLabel;

        fieldLabel = new JLabel("Nome Completo *");
        addFormComponents(fieldLabel, 0, 0);
        nameTxt = new JTextField(45);
        addFormComponents(nomeCompleto, 0, 1);

        fieldLabel = new JLabel("Idade *");
        addFormComponents(fieldLabel, 1, 0);
        fullAge = new JTextField(3);
        addFormComponents(idade, 1, 1);

        fieldLabel = new JLabel("E-mail *");
        addFormComponents(fieldLabel, 2, 0);
        email = new JTextField(45);
        addFormComponents(email, 2, 1);

        fieldLabel = new JLabel("Endereço *");
        addFormComponents(fieldLabel, 3, 0);
        adress = new JTextField(100);
        addFormComponents(endereco, 3, 1);

        fieldLabel = new JLabel("CEP");
        addFormComponents(fieldLabel, 4, 0);
        cep = new JTextField(15);
        addFormComponents(cep, 4, 1);

        fieldLabel = new JLabel("Telefone");
        addFormComponents(fieldLabel, 5, 0);
        phone = new JTextField(45);
        addFormComponents(telefone, 5, 1);

        fieldLabel = new JLabel("Usuário *");
        addFormComponents(fieldLabel, 6, 0);
        user = new JTextField(45);
        addFormComponents(usuario, 6, 1);

        fieldLabel = new JLabel("Senha *");
        addFormComponents(fieldLabel, 7, 0);
        password = new JPasswordField(45);
        addFormComponents(senha, 7, 1);

        fieldLabel = new JLabel("Curso *");
        addFormComponents(fieldLabel, 8, 0);
        course = new JComboBox(courses);
        addFormComponents(curso, 8, 1);

        JScrollPane scrollPane;
        fieldLabel = new JLabel("Observações");
        addFormComponents(fieldLabel, 9, 0);
        obs = new JTextArea(3, 25);
        scrollPane = new JScrollPane(observacoes);
        addFormComponents(scrollPane, 9, 1, 3, 3);

        fieldLabel = new JLabel("Ativo *");
        addFormComponents(fieldLabel, 12, 0);
        active = new JCheckBox();
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
                        estudante = new RegistrationModel();

                        insertModelData(estudante, true);

                        JOptionPane.showMessageDialog(RegisterForm.this, "Estudante adicionado com sucesso!", "Cadastro de Matrícula",
                                JOptionPane.INFORMATION_MESSAGE);
                                //Redireciona para a home
                    } else {
                        JOptionPane.showMessageDialog(RegisterForm.this, "Houve alguma falha na verificação dos campos. 
                            \n Por favor verifique: \n Se os campos marcados com '*' estão preenchidos \n Se o campo Idade contém um número 
                            \n Se foi selecionado algum curso.", "Cadastro de Matrícula",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    if (verifyFields()) {
                        insertModelData(estudante, false);
                        JOptionPane.showMessageDialog(RegisterForm.this, "Atualizado com sucesso!", "Cadastro de Matrícula",
                                JOptionPane.INFORMATION_MESSAGE);
                                //Redireciona para a home
                    } else {
                        JOptionPane.showMessageDialog(RegisterForm.this, "Oops, houve alguma falha na verificação dos campos. :( \n Por favor verifique: \n Se os campos marcados com '*' estão preenchidos \n Se o campo Idade contém um número \n Se foi selecionado algum curso.", "Cadastro de Matrícula",
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
                    //baseLayout.showFormPage(null);
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
        estudante.setSenha(senha.getText());
        estudante.setCurso(curso.getSelectedItem().toString());
        estudante.setObservacoes(observacoes.getText());
        estudante.setAtivo(ativo.isSelected());

        if (isNew == true) {
            RegistrationStorage.create(estudante);
        } else {
            RegistrationStorage.update(estudante);
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