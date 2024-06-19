package main.java.set.Ordenacao;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;


public class GerenciadorAlunos {
    private Set<Aluno> alunos;

    public GerenciadorAlunos() {
        // Utilizamos TreeSet com comparadores para manter a ordenação
        this.alunos = new TreeSet<>(Comparator.comparing(Aluno::getNome));
    }

    public void adicionarAluno(String nome, Long matricula, double media) {
        Aluno novoAluno = new Aluno(nome, matricula, media);
        alunos.add(novoAluno);
    }

    public void removerAluno(Long matricula) {
        Aluno alunoRemover = null;
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                alunoRemover = aluno;
                break;
            }
        }
        if (alunoRemover != null) {
            alunos.remove(alunoRemover);
        } else {
            System.out.println("Aluno com matrícula " + matricula + " não encontrado.");
        }
    }

    public void exibirAlunosPorNome() {
        System.out.println("Alunos ordenados por nome:");
        for (Aluno aluno : alunos) {
            System.out.println("Nome: " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula() + ", Nota: " + aluno.getNota());
        }
    }

    public void exibirAlunosPorNota() {
        // Utilizamos TreeSet com comparadores para manter a ordenação
        Set<Aluno> alunosPorNota = new TreeSet<>(Comparator.comparingDouble(Aluno::getNota));
        alunosPorNota.addAll(alunos);

        System.out.println("Alunos ordenados por nota:");
        for (Aluno aluno : alunosPorNota) {
            System.out.println("Nome: " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula() + ", Nota: " + aluno.getNota());
        }
    }

    public void exibirAlunos() {
        System.out.println("Lista de Alunos:");
        for (Aluno aluno : alunos) {
            System.out.println("Nome: " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula() + ", Nota: " + aluno.getNota());
        }
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciador = new GerenciadorAlunos();

        gerenciador.adicionarAluno("Ana", 123456L, 8.5);
        gerenciador.adicionarAluno("Carlos", 789012L, 7.2);
        gerenciador.adicionarAluno("Zoe", 345678L, 9.0);

        gerenciador.exibirAlunosPorNome();

        System.out.println("\nExibindo alunos por ordem de nota:");
        gerenciador.exibirAlunosPorNota();
    }
}