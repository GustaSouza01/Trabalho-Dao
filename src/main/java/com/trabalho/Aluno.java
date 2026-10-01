package com.trabalho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aluno {
    private final int matricula;
    private final String nome;
    private final List<Double> notas;

    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.notas = new ArrayList<>();
    }

    public void adicionarNota(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
        }
        notas.add(nota);
    }

    public double calcularMedia() {
        if (notas.isEmpty()) {
            return 0.0;
        }

        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }

        return soma / notas.size();
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public List<Double> getNotas() {
        return Collections.unmodifiableList(notas);
    }

    @Override
    public String toString() {
        return "Aluno{"
                + "matricula=" + matricula
                + ", nome='" + nome + '\''
                + ", notas=" + notas
                + ", media=" + calcularMedia()
                + '}';
    }
}
