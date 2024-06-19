package main.java.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agenda;

    public AgendaContatos() {
        this.agenda = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        agenda.put(nome, telefone);
    }

    public void removerContato(String nome) {
        agenda.remove(nome);
    }

    public void exibirContatos() {
        System.out.println("Lista de Contatos:");
        for (Map.Entry<String, Integer> entry : agenda.entrySet()) {
            System.out.println("Nome: " + entry.getKey() + ", Telefone: " + entry.getValue());
        }
    }

    public Integer pesquisarPorNome(String nome) {
        return agenda.get(nome);
    }

    public static void main(String[] args) {
        AgendaContatos agenda = new AgendaContatos();

        agenda.adicionarContato("Ana", 123456789);
        agenda.adicionarContato("João", 987654321);
        agenda.adicionarContato("Maria", 111222333);

        agenda.exibirContatos();

        System.out.println("\nPesquisando telefone de 'João':");
        Integer telefoneJoao = agenda.pesquisarPorNome("João");
        if (telefoneJoao != null) {
            System.out.println("Telefone de João: " + telefoneJoao);
        } else {
            System.out.println("Contato 'João' não encontrado.");
        }

        agenda.removerContato("Ana");

        System.out.println("\nApós remover 'Ana':");
        agenda.exibirContatos();
    }
}
