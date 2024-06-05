package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    private List<Tarefa> tarefas;

    public ListaTarefa() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(descricao);
        tarefas.add(novaTarefa);
    }

    public void removerTarefa(String descricao) {
        tarefas.removeIf(tarefa -> tarefa.getDescricao().equals(descricao));
    }

    public int obterNumeroTotalTarefa() {
        return tarefas.size();
    }

    public List<String> obterDescricoesTarefa() {
        List<String> descricoes = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            descricoes.add(tarefa.getDescricao());
        }
        return descricoes;
    }

        public static void main(String[] args) {
            // Criando uma lista de tarefas
            ListaTarefa listaTarefas = new ListaTarefa();

            // Adicionando algumas tarefas
            listaTarefas.adicionarTarefa("Fazer compras");
            listaTarefas.adicionarTarefa("Estudar Java");
            listaTarefas.adicionarTarefa("Lavar o carro");

            // Exibindo o número total de tarefas
            System.out.println("Número total de tarefas: " + listaTarefas.obterNumeroTotalTarefa());

            // Exibindo as descrições das tarefas
            System.out.println("Descrições das tarefas:");
            for (String descricao : listaTarefas.obterDescricoesTarefa()) {
                System.out.println(descricao);
            }

            // Removendo uma tarefa
            listaTarefas.removerTarefa("Estudar Java");

            // Exibindo o número total de tarefas após a remoção
            System.out.println("\nNúmero total de tarefas após a remoção: " + listaTarefas.obterNumeroTotalTarefa());
        }
    }


