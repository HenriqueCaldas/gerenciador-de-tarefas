package org.luis.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GerenciadorTarefas {

    private final List<Tarefa> tarefas = new ArrayList<>();

    public void adicionar(Tarefa tarefa) {
        boolean tituloJaExiste = this.tarefas.stream()
                .anyMatch(t -> t.getTitulo().equalsIgnoreCase(tarefa.getTitulo()));

        if(tituloJaExiste) {
            throw new IllegalArgumentException("Já existe uma tarefa cadastrada com esse título");
        }
        this.tarefas.add(tarefa);
    }

    public List<Tarefa> listarTodas(){
        return Collections.unmodifiableList(this.tarefas);
    }
}
