package Frames;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Estudante;

public class EstudentTableModel extends AbstractTableModel {
    private List<Estudante> estudantes = new ArrayList<>();
    private String[] columnNames = {"Id", "Nome completo", "Idade", "Email", "Endereço", "Cep", "Telefone", "Usuario", "Senha", "Curso", "Observaçoes", "Ativo"};

    public EstudentTableModel(List<Estudante> estudantes){
        this.estudantes = estudantes;
    }

    @Override
    public int getRowCount() {
        return estudantes.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex){
        String columnName = null;

        if(columnIndex >= 0 && columnIndex < columnNames.length){
            columnName = columnNames[columnIndex];
        }
        return columnName;
    }



    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String values = null;
    
        if(rowIndex >= 0 && rowIndex < estudantes.size()){
            Estudante estudante = estudantes.get(rowIndex);    
        
            switch (columnIndex) {
                case 0:
                    values = Integer.toString(estudante.getId());
                break;
                case 1: 
                    values = estudante.getNomeCompleto();
                    break;
                case 2: 
                    values = Integer.toString(estudante.getIdade());
                    break;
                case 3: 
                    values = estudante.getEmail();
                    break;
                case 4: 
                    values = estudante.getEndereco();
                    break;
                case 5: 
                    values = estudante.getCep();
                    break;
                case 6:
                    values = estudante.getTelefone();
                    break;
                case 7:
                    values = estudante.getUsuario();
                    break;
                case 8:
                    values = estudante.getSenha();
                    break;
                case 9:
                    values = estudante.getCurso();
                    break;
                case  10:
                    values = estudante.getObservacoes();
                    break;
                case 11:
                    values = Boolean.toString(estudante.getAtivo());
                    break;
                default:
                    System.out.println("Algo deu Errado!");
                    break;
            }   
        }

        return values;
    }


    public void carregarEstudante(List<Estudante> estudante){
        this.estudantes = estudante;
        fireTableDataChanged();
    }

    public Estudante getEstudante(int rowIndex) {
        Estudante estudante = null;

        if (rowIndex >= 0 && rowIndex < estudantes.size()) {
            estudante = estudantes.get(rowIndex);
        }

        return estudante;
    }
    
    public void remove(Estudante estudante) {
        estudantes.remove(estudante);
        fireTableDataChanged();
    }
    public void removerEstudante(Estudante estudante){
        estudantes.remove(estudante);
        fireTableDataChanged();
    }
}
