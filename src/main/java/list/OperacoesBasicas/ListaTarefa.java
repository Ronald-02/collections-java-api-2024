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

    public int obterNumeroTotalTarefas() {
        return tarefas.size();
    }

    public List<String> obterDescricoesTarefas() {
        List<String> descricoes = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            descricoes.add(tarefa.getDescricao());
        }
        return descricoes;
    }

    public static void main(String[] args) {
        // Criando uma instância de ListaTarefas
        ListaTarefa listaTarefas = new ListaTarefa();

        // Adicionando algumas tarefas à lista
        listaTarefas.adicionarTarefa("Ler livro");
        listaTarefas.adicionarTarefa("Fazer exercícios");
        listaTarefas.adicionarTarefa("Limpar a casa");

        // Exibindo o número total de tarefas
        System.out.println("Número total de tarefas: " + listaTarefas.obterNumeroTotalTarefas());

        // Exibindo as descrições das tarefas
        System.out.println("Descrições das tarefas:");
        List<String> descricoes = listaTarefas.obterDescricoesTarefas();
        for (String descricao : descricoes) {
            System.out.println(descricao);
        }

        // Removendo uma tarefa
        listaTarefas.removerTarefa("Fazer exercícios");

        // Exibindo o número total de tarefas após a remoção
        System.out.println("\nNúmero total de tarefas após remoção: " + listaTarefas.obterNumeroTotalTarefas());
    }
}
