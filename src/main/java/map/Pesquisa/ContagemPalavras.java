package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> contagemPalavras;

    public ContagemPalavras() {
        this.contagemPalavras = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        contagemPalavras.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        contagemPalavras.remove(palavra);
    }

    public void exibirContagemPalavras() {
        System.out.println("Contagem de Palavras:");
        for (Map.Entry<String, Integer> entry : contagemPalavras.entrySet()) {
            System.out.println("Palavra: " + entry.getKey() + ", Contagem: " + entry.getValue());
        }
    }

    public Map.Entry<String, Integer> encontrarPalavraMaisFrequente() {
        Map.Entry<String, Integer> palavraMaisFrequente = null;
        for (Map.Entry<String, Integer> entry : contagemPalavras.entrySet()) {
            if (palavraMaisFrequente == null || entry.getValue() > palavraMaisFrequente.getValue()) {
                palavraMaisFrequente = entry;
            }
        }
        return palavraMaisFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavras contador = new ContagemPalavras();

        contador.adicionarPalavra("java", 10);
        contador.adicionarPalavra("python", 5);
        contador.adicionarPalavra("javascript", 8);
        contador.adicionarPalavra("java", 15); // Atualiza a contagem de "java"

        contador.exibirContagemPalavras();

        Map.Entry<String, Integer> maisFrequente = contador.encontrarPalavraMaisFrequente();
        System.out.println("\nPalavra mais frequente:");
        if (maisFrequente != null) {
            System.out.println("Palavra: " + maisFrequente.getKey() + ", Contagem: " + maisFrequente.getValue());
        } else {
            System.out.println("Nenhuma palavra encontrada.");
        }

        contador.removerPalavra("python");

        System.out.println("\nApós remover 'python':");
        contador.exibirContagemPalavras();
    }
}
