package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstudanteStorage {


    public static void inserirEstudante(Estudante estudante){
        final String queryInsert = "INSERT INTO estudante(nome_Completo, idade, email, endereco,cep,telefone,usuario,senha,curso,observacoes,ativo VALUES(?,?,?,?,?,?,?,?,?,?,?))";
        

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            dbConnection = ConnectionFactory.getConnection();

            preparedStatement = dbConnection.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, estudante.getNomeCompleto());
            preparedStatement.setInt(2, estudante.getIdade());
            preparedStatement.setString(3, estudante.getEmail());
            preparedStatement.setString(4, estudante.getEndereco());
            preparedStatement.setString(5, estudante.getCep());
            preparedStatement.setString(6, estudante.getTelefone());
            preparedStatement.setString(7, estudante.getUsuario());
            preparedStatement.setString(8, estudante.getSenha());
            preparedStatement.setString(9, estudante.getCurso());
            preparedStatement.setString(10, estudante.getObservacoes());
            preparedStatement.setBoolean(11, estudante.isAtivo());
            preparedStatement.execute();

            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                estudante.setId(resultSet.getInt(1));
            }


        }catch(Exception e){
            e.printStackTrace();
        } finally{
            try{
                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }    
    }


    public static void updateEstudante(Estudante estudante){
        final String queryUpdate = "UPDATE estudante SET nome_completo = ?, idade = ?, email = ?, endereco = ?, cep = ?, telefone = ?, usuario = ?, senha = ?, curso = ?, observacoes = ?, ativo = ? ";
        

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        try{
            dbConnection = ConnectionFactory.getConnection();

            preparedStatement = dbConnection.prepareStatement(queryUpdate);
            preparedStatement.setString(1, estudante.getNomeCompleto());
            preparedStatement.setInt(2, estudante.getIdade());
            preparedStatement.setString(3, estudante.getEmail());
            preparedStatement.setString(4, estudante.getEndereco());
            preparedStatement.setString(5, estudante.getCep());
            preparedStatement.setString(6, estudante.getTelefone());
            preparedStatement.setString(7, estudante.getUsuario());
            preparedStatement.setString(8, estudante.getSenha());
            preparedStatement.setString(9, estudante.getCurso());
            preparedStatement.setString(10, estudante.getObservacoes());
            preparedStatement.setBoolean(11, estudante.isAtivo());
            preparedStatement.execute();


        }catch(Exception e){
            e.printStackTrace();
        } finally{
            try{
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }    
    }


    public static void removerEstudante(Estudante estudante){
        final String queryDelete = "DELETE FROM estudante WHERE id = ?";

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        try{
            dbConnection = ConnectionFactory.getConnection();

            preparedStatement = dbConnection.prepareStatement(queryDelete);
            preparedStatement.setInt(1, estudante.getId());
            preparedStatement.execute();
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            try{
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }    
    }


    public static List<Estudante> listarEstudante(){
        List<Estudante> estudantes = new ArrayList<>();

        final String querySelect = "SELECT e.id, e.nome_completo, e.idade, e.email, e.endereco, e.cep, e.telefone, e.usuario, e.senha, e.curso, e.observacoes, e.ativo FROM estudante e ORDER BY e.id;";
        
        Connection dbConnection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            dbConnection = ConnectionFactory.getConnection();
            
            statement = dbConnection.createStatement();
            resultSet = statement.executeQuery(querySelect);

            while (resultSet.next()) {
                Estudante estudante = new Estudante();
                estudante.setId(resultSet.getInt("id"));
                estudante.setNomeCompleto(resultSet.getString("nome_completo"));
                estudante.setIdade(resultSet.getInt("idade"));
                estudante.setEmail(resultSet.getString("email"));
                estudante.setEndereco(resultSet.getString("endereco"));
                estudante.setCep(resultSet.getString("cep"));
                estudante.setTelefone(resultSet.getString("telefone"));
                estudante.setUsuario(resultSet.getString("usuario"));
                estudante.setSenha(resultSet.getString("senha"));
                estudante.setCurso(resultSet.getString("curso"));
                estudante.setObservacoes(resultSet.getString("observacoes"));
                estudante.setAtivo(resultSet.getBoolean("ativo"));
                estudantes.add(estudante);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try{
                if (statement != null) {
                    statement.close();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return estudantes;
    }
}
