package Frames;

import javax.swing.*;

import Model.Estudante;
import Model.EstudanteStorage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class EstudanteFormPanel extends JPanel {
    private static final Insets FIELD_INSETS = new Insets(5, 10, 0, 0);

    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private Estudante estudante;
    private AppFrame appFrame;


    private JButton salvarBtn;
	private JButton cancelarBtn;

    private JTextField id;
    private JTextField nome_completo;
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
    public static final Boolean ATIVADO = true;
    public static final Boolean DESATIVADO = false;
    private String[] cursos = {"Selecione uma opção", "Administração", "ADS", "Medicina", "Direito", "Design", "Psicologia", "Física"};


    public EstudanteFormPanel(AppFrame appFrame) {
        this.appFrame = appFrame;
        estudante = null;

        setBackground(Color.decode("#8C8C8C"));

        layout = new GridBagLayout();
		constraints = new GridBagConstraints();

		setLayout(layout);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                 if (estudante == null) {
                    id.setText("");
                    nome_completo.setText("");
                    email.setText("");
                    endereco.setText("");
                    cep.setText("");
                    telefone.setText("");
                    usuario.setText("");
                    senha.setText("");
                    observacoes.setText("");
                    ativo.setSelected(ATIVADO || DESATIVADO);
                }else{
                    id.setText(Integer.toString(estudante.getId()));
                    nome_completo.setText(estudante.getNomeCompleto());
                    email.setText(estudante.getEmail());
                    endereco.setText(estudante.getEndereco());
                    cep.setText(estudante.getCep());
                    telefone.setText(estudante.getTelefone());
                    usuario.setText(estudante.getUsuario());
                    senha.setText(estudante.getSenha());
                    observacoes.setText("");
                    ativo.setSelected(estudante.getAtivo() ? ATIVADO :  DESATIVADO);
                }
            }
        });

        criarFormEstudante();
    }


    public void setEstudante(Estudante estudante){
        this.estudante = estudante;
    }

    public void criarFormEstudante() {
        JLabel label;

        label = new JLabel("Nome Completo *");
        adicionarComponente(label, 0, 0);
        nome_completo = new JTextField(45);
        adicionarComponente(nome_completo, 0, 1);

        label = new JLabel("Idade *");
        adicionarComponente(label, 1, 0);
        idade = new JTextField(3);
        adicionarComponente(idade, 1, 1);

        label = new JLabel("E-mail *");
        adicionarComponente(label, 2, 0);
        email = new JTextField(45);
        adicionarComponente(email, 2, 1);

        label = new JLabel("Endereço *");
        adicionarComponente(label, 3, 0);
        endereco = new JTextField(100);
        adicionarComponente(endereco, 3, 1);

        label = new JLabel("CEP");
        adicionarComponente(label, 4, 0);
        cep = new JTextField(15);
        adicionarComponente(cep, 4, 1);

        label = new JLabel("Telefone");
        adicionarComponente(label, 5, 0);
        telefone = new JTextField(45);
        adicionarComponente(telefone, 5, 1);

        label = new JLabel("Usuário *");
        adicionarComponente(label, 6, 0);
        usuario = new JTextField(45);
        adicionarComponente(usuario, 6, 1);

        label = new JLabel("Senha *");
        adicionarComponente(label, 7, 0);
        senha = new JPasswordField(45);
        adicionarComponente(senha, 7, 1);

        label = new JLabel("Curso *");
        adicionarComponente(label, 8, 0);
        curso = new JComboBox(cursos);
        adicionarComponente(curso, 8, 1);

        
        label = new JLabel("Observações");
        adicionarComponente(label, 9, 0);
        observacoes = new JTextArea(3, 25);
        JScrollPane scrollPane = new JScrollPane(observacoes);
        adicionarComponente(scrollPane, 9, 1, 3, 3);

        label = new JLabel("Ativo *");
        adicionarComponente(label, 12, 0);
        ativo = new JCheckBox();
        adicionarComponente(ativo, 12, 1);

        criarBotoes();
    }


    private void criarBotoes() {
		JPanel btnPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) btnPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);

        cancelarBtn(btnPanel);
		salvarBtn(btnPanel);
        
        adicionarComponente(btnPanel, 15, 1, 2, 1);
	}

	private void salvarBtn(JPanel panel) {
		salvarBtn = new JButton("Salvar");
		salvarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (estudante == null) {
					estudante = new Estudante();
					estudante.setNomeCompleto(nome_completo.getText());
					estudante.setObservacoes(observacoes.getText());
					EstudanteStorage.inserirEstudante(estudante);
				} else {
					estudante.setId(Integer.parseInt(id.getText()));
					estudante.setNomeCompleto(nome_completo.getText());
					estudante.setObservacoes(observacoes.getText());
					EstudanteStorage.updateEstudante(estudante);
				}

				JOptionPane.showMessageDialog(EstudanteFormPanel.this, "Estudante salvo com sucesso!", AppFrame.TITULO,
						JOptionPane.INFORMATION_MESSAGE);

				appFrame.showEstudentTable();
			}
		});
		panel.add(salvarBtn);
	}


    private void cancelarBtn(JPanel panel) {
		cancelarBtn = new JButton("Cancelar");
		cancelarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				appFrame.showEstudentTable();
			}
		});
		panel.add(cancelarBtn);
	}


    private void adicionarComponente(JComponent componente, int linha, int coluna) {
        adicionarComponente(componente, linha, coluna, 1, 1);
    }

    private void adicionarComponente(JComponent componente, int linha, int coluna, int largura, int altura) {
        constraints.gridx = coluna;
        constraints.gridy = linha;
        constraints.gridwidth = largura;
        constraints.gridheight = altura;

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = FIELD_INSETS;

        layout.setConstraints(componente, constraints);
        add(componente);
    }


}
