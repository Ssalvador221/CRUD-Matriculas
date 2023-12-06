package Frames;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import Model.Estudante;

public class EstudentTableModel extends AbstractTableModel {
    private List<Estudante> estudantes = new ArrayList<>();
    private String[] columnNames = {"Id", "Nome completo", "Idade", "Email", "Endereço", "Cep", "Telefone", "Usuario", "Senha", "Curso", "Observaçoes", "Ativo"};
    private TableModel tableModel;

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
    public Object getValueAt(int rowIndex, int columnIndex) {
        String values = null;
    
        Estudante estudante = estudantes.get(rowIndex);

        switch (columnIndex) {
            case 0:
                    values = Integer.toString(estudante.getId());
                break;
            case 1: 
                    values = estudante.getNomeCompleto();
                break;
             case 2: 
            
                break;
            case 3: 
            
                break;
            case 4: 
            
                break;
            case 5: 
            
                break;
            case 6:
                break;
            case 7:
                break;

            case 8:
                break;
            case 9:
                break;

            case  10:
                break;
            case 11:
                break;
            default:
                break;
        }


        return Integer.valueOf(rowIndex*columnIndex);
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

}
