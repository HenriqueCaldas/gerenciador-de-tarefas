package org.luis.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TarefaTest {

    @Test
    public void deveCriarTarefaComStatusNaoConcluidoPorPadrao() {
        Tarefa tarefa = new Tarefa("Estudar Java", "Entender Orientacao a Objetos");
        assertFalse(tarefa.isConcluida(),"A tarefa deveria iniciar como não concluída!");
    }

    @Test
    public void naoDeveCriarTarefaComTituloVazio(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            {new Tarefa("", "Descrição Teste");
        });

        assertEquals("O título não pode ser vazio ou nulo.", exception.getMessage());
    }
}
