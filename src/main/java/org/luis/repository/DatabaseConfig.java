package org.luis.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConfig {
        // URL de conexão: cria um arquivo "banco_tarefas"
        private static final String URL = "jdbc:h2:./banco_tarefas;DB_CLOSE_DELAY=-1";
        private static final String USER = "sa";
        private static final String PASSWORD = "";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }

    public static void inicializarBanco() {
        String sql = """
            CREATE TABLE IF NOT EXISTS tarefas (
                id INT AUTO_INCREMENT PRIMARY KEY,
                titulo VARCHAR(255) NOT NULL UNIQUE,
                descricao VARCHAR(255),
                concluida BOOLEAN NOT NULL
            );
        """;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inicializar o banco de dados", e);
        }
    }
}
