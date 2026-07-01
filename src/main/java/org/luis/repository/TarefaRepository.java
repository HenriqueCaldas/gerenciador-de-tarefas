package org.luis.repository;

import org.luis.model.Tarefa;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TarefaRepository {

    public void salvar(Tarefa tarefa) {
        String sql = "INSERT INTO tarefas (titulo, descricao, concluida) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Substituindo os '?' pelos valores reais do objeto
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setBoolean(3, tarefa.isConcluida());

            stmt.executeUpdate(); // Executa o comando no banco
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar tarefa no banco de dados", e);
        }
    }

    public List<Tarefa> buscarTodas() {
        List<Tarefa> tarefas = new ArrayList<Tarefa>();
        String sql = "SELECT * FROM tarefas";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Enquanto houver linhas no resultado do banco...
            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String descricao = rs.getString("descricao");
                boolean concluida = rs.getBoolean("concluida");

                Tarefa tarefa = new Tarefa(titulo, descricao);

                if (concluida) {
                    tarefa.concluir();
                }

                tarefas.add(tarefa);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar tarefas no banco de dados", e);
        }

        return tarefas;
    }


}
