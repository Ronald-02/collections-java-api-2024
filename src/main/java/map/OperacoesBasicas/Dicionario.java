package main.java.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {

    private Map<String, String> dicionario;

    public Dicionario() {
        this.dicionario = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        dicionario.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        dicionario.remove(palavra);
    }

    public void exibirPalavras() {
        System.out.println("Dicionário:");
        for (Map.Entry<String, String> entry : dicionario.entrySet()) {
            System.out.println("Palavra: " + entry.getKey() + ", Definição: " + entry.getValue());
        }
    }

    public String pesquisarPorPalavra(String palavra) {
        return dicionario.get(palavra);
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("Java", "A high-level programming language.");
        dicionario.adicionarPalavra("Python", "A widely used general-purpose, high-level programming language.");
        dicionario.adicionarPalavra("JavaScript", "A high-level, interpreted programming language.");

        dicionario.exibirPalavras();

        System.out.println("\nPesquisando definição de 'Python':");
        String definicaoPython = dicionario.pesquisarPorPalavra("Python");
        if (definicaoPython != null) {
            System.out.println("Definição de Python: " + definicaoPython);
        } else {
            System.out.println("Palavra 'Python' não encontrada no dicionário.");
        }

        dicionario.removerPalavra("JavaScript");

        System.out.println("\nApós remover 'JavaScript':");
        dicionario.exibirPalavras();
    }
}
