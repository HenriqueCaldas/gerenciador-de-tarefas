package org.luis.controller;

import org.luis.model.Tarefa;
import org.luis.repository.TarefaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaRepository repository;

    public TarefaController(TarefaRepository repository){
        this.repository = repository;

    }

    @GetMapping
    public List<Tarefa> listar() {
        return repository.buscarTodas();
    }
}
