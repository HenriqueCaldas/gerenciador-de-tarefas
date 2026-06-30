package repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.luis.model.Tarefa;
import org.luis.repository.DatabaseConfig;
import org.luis.repository.TarefaRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TerefaRepositoryTest {

    private TarefaRepository repository;

    @BeforeEach
    public void setUp() {
        DatabaseConfig.inicializarBanco();
        repository = new TarefaRepository();

        limparTabela();
    }

    @Test
    public void deveSalvarERecuperarUmaTarefaDobancoDeDados(){
        Tarefa tarefa = new Tarefa("Estudar Java", "Orientação à objetos");
        repository.salvar(tarefa);
        List<Tarefa> listaTarefas = repository.buscarTodas();

        assertEquals(1, listaTarefas.size());
        assertEquals("Estudar Java", listaTarefas.getFirst().getTitulo());
    }


    private void limparTabela() {
        try (var conn = DatabaseConfig.getConnection();
             var stmt = conn.createStatement()) {
            stmt.execute("TRUNCATE TABLE tarefas");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
