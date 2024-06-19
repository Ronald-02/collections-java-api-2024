package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> listaTarefas;

    public ListaTarefas() {
        this.listaTarefas = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(descricao);
        listaTarefas.add(novaTarefa);
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaRemover = null;
        for (Tarefa tarefa : listaTarefas) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefaRemover = tarefa;
                break;
            }
        }
        if (tarefaRemover != null) {
            listaTarefas.remove(tarefaRemover);
        } else {
            System.out.println("Tarefa com descrição '" + descricao + "' não encontrada.");
        }
    }

    public void exibirTarefas() {
        System.out.println("Lista de Tarefas:");
        for (Tarefa tarefa : listaTarefas) {
            System.out.println("Descrição: " + tarefa.getDescricao() + " | Concluída: " + (tarefa.isConcluida() ? "Sim" : "Não"));
        }
    }

    public int contarTarefas() {
        return listaTarefas.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for (Tarefa tarefa : listaTarefas) {
            if (tarefa.isConcluida()) {
                tarefasConcluidas.add(tarefa);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        for (Tarefa tarefa : listaTarefas) {
            if (!tarefa.isConcluida()) {
                tarefasPendentes.add(tarefa);
            }
        }
        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao) {
        boolean encontrada = false;
        for (Tarefa tarefa : listaTarefas) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefa.setConcluida(true);
                encontrada = true;
                break;
            }
        }
        if (!encontrada) {
            System.out.println("Tarefa com descrição '" + descricao + "' não encontrada.");
        }
    }

    public void marcarTarefaPendente(String descricao) {
        boolean encontrada = false;
        for (Tarefa tarefa : listaTarefas) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefa.setConcluida(false);
                encontrada = true;
                break;
            }
        }
        if (!encontrada) {
            System.out.println("Tarefa com descrição '" + descricao + "' não encontrada.");
        }
    }

    public void limparListaTarefas() {
        listaTarefas.clear();
    }

    public static void main(String[] args) {
        ListaTarefas lista = new ListaTarefas();

        lista.adicionarTarefa("Estudar Java");
        lista.adicionarTarefa("Fazer compras");
        lista.adicionarTarefa("Lavar o carro");

        lista.exibirTarefas();

        System.out.println("\nMarcando 'Estudar Java' como concluída.");
        lista.marcarTarefaConcluida("Estudar Java");

        lista.exibirTarefas();

        System.out.println("\nTarefas pendentes:");
        Set<Tarefa> tarefasPendentes = lista.obterTarefasPendentes();
        for (Tarefa tarefa : tarefasPendentes) {
            System.out.println(tarefa.getDescricao());
        }
    }
}
