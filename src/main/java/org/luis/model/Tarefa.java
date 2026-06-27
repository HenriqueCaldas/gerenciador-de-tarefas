package org.luis.model;

public class Tarefa {

    private String titulo;
    private String descricao;
    private boolean concluida;

    public Tarefa(String titulo, String descricao) {
        if(titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O título não pode ser vazio ou nulo.");
        }
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

}
