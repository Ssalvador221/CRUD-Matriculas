package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/crudmilo";
    private static final String USER = "root";
    private static final String SENHA = "senai";
    private static Connection conexao;

    public static Connection getConnection() throws SQLException {
        if (conexao == null) {
            conexao = DriverManager.getConnection(DB_CONNECTION, USER, SENHA);
        }

        return conexao;
    }
}
