package com.trabalho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SistemaAcademico {
    private final Map<Integer, Aluno> alunos = new HashMap<>();

    public void cadastrarAluno(int matricula, String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do aluno não pode ser vazio.");
        }

        if (alunos.containsKey(matricula)) {
            throw new IllegalArgumentException("Já existe um aluno com essa matrícula.");
        }

        alunos.put(matricula, new Aluno(matricula, nome));
    }

    public Optional<Aluno> buscarAluno(int matricula) {
        return Optional.ofNullable(alunos.get(matricula));
    }

    public List<Aluno> listarTodos() {
        return new ArrayList<>(alunos.values());
    }

    public void adicionarNota(int matricula, double nota) {
        Aluno aluno = alunos.get(matricula);

        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não encontrado.");
        }

        aluno.adicionarNota(nota);
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        for (Aluno aluno : alunos.values()) {
            System.out.println(aluno);
        }
    }

    public double calcularMediaAluno(int matricula) {
        return buscarAluno(matricula)
                .map(Aluno::calcularMedia)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado."));
    }

    public boolean existeAluno(int matricula) {
        return alunos.containsKey(matricula);
    }
}
