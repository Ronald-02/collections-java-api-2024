package main.java.list.OperacaoBasica.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class OrdenacaoPessoa {
    private List<Pessoa> pessoas;

    public OrdenacaoPessoa() {
        this.pessoas = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        Pessoa pessoa = new Pessoa(nome, idade, altura);
        pessoas.add(pessoa);
    }

    public void ordenarPorIdade() {
        Collections.sort(pessoas);
    }

    public void ordenarPorAltura() {
        Collections.sort(pessoas, new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa pessoa1, Pessoa pessoa2) {
                return Double.compare(pessoa1.getAltura(), pessoa2.getAltura());
            }
        });
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }
    public static void main(String[] args) {
        // Criando um objeto de OrdenacaoPessoas
        OrdenacaoPessoa ordenacaoPessoa = new OrdenacaoPessoa();

        // Adicionando algumas pessoas à lista
        ordenacaoPessoa.adicionarPessoa("Alice", 25, 1.70);
        ordenacaoPessoa.adicionarPessoa("Bob", 30, 1.65);
        ordenacaoPessoa.adicionarPessoa("Charlie", 20, 1.80);

        // Ordenando por idade
        System.out.println("Ordenado por idade:");
        ordenacaoPessoa.ordenarPorIdade();
        for (Pessoa pessoa : ordenacaoPessoa.getPessoas()) {
            System.out.println(pessoa);
        }

        // Ordenando por altura
        System.out.println("\nOrdenado por altura:");
        ordenacaoPessoa.ordenarPorAltura();
        for (Pessoa pessoa : ordenacaoPessoa.getPessoas()) {
            System.out.println(pessoa);
        }
    }

}

