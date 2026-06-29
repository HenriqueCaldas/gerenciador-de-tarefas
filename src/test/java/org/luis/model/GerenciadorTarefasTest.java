package org.luis.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GerenciadorTarefasTest {
    @Test
    public void deveAdicionarUmaTarefaComSucesso(){
        //criar o teste
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        Tarefa tarefa = new Tarefa("Estudar Java", "Estudar emcapsulamento");
        gerenciador.adicionar(tarefa);

        List<Tarefa> listaTarefas = gerenciador.listarTodas();

        assertEquals(1, listaTarefas.size(), "A lista deve ter apenas 1 tarefa cadastrada.");
        assertTrue(listaTarefas.contains(tarefa), "A lista de tarefas deve conter a tarefa adicionada.");

    }

    @Test
    public void naoDeveAddTarefaComTituloDuplicado(){
        Tarefa tarefa1 = new Tarefa("Estudar Java", "Estudar OO");
        Tarefa tarefa2 = new Tarefa("Estudar Java", "Estudar OO");

        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        gerenciadorTarefas.adicionar(tarefa1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->{
            gerenciadorTarefas.adicionar(tarefa2);
        });

        assertEquals("Já existe uma tarefa cadastrada com esse título", exception.getMessage());

    }
}
