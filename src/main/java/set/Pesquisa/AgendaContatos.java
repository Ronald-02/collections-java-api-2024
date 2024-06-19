package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {

    private Set<Contato> agenda;

    public AgendaContatos() {
        this.agenda = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        Contato novoContato = new Contato(nome, numero);
        agenda.add(novoContato);
    }

    public void exibirContatos() {
        System.out.println("Lista de Contatos:");
        for (Contato contato : agenda) {
            System.out.println("Nome: " + contato.getNome() + ", Número: " + contato.getNumero());
        }
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosEncontrados = new HashSet<>();
        for (Contato contato : agenda) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contatosEncontrados.add(contato);
            }
        }
        return contatosEncontrados;
    }

    public void atualizarNumeroContato(String nome, int novoNumero) {
        boolean encontrado = false;
        for (Contato contato : agenda) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contato.setNumero(novoNumero);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Contato com nome " + nome + " não encontrado.");
        }
    }

    public static void main(String[] args) {
        AgendaContatos agenda = new AgendaContatos();

        agenda.adicionarContato("Ana", 123456789);
        agenda.adicionarContato("João", 987654321);
        agenda.adicionarContato("Maria", 111222333);

        agenda.exibirContatos();

        System.out.println("\nPesquisa por nome 'ana':");
        Set<Contato> resultadosPesquisa = agenda.pesquisarPorNome("ana");
        for (Contato contato : resultadosPesquisa) {
            System.out.println("Nome: " + contato.getNome() + ", Número: " + contato.getNumero());
        }

        agenda.atualizarNumeroContato("João", 555555555);
        agenda.exibirContatos();
    }
}