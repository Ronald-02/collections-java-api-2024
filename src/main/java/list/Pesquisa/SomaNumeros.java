package main.java.list.Pesquisa;

import java.util.ArrayList;

import java.util.List;

public class SomaNumeros {
    private final List<Integer> numeros;

    public SomaNumeros() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numeros.add(numero);
    }

    public int calcularSoma() {
        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }
        return soma;
    }

    public int encontrarMaiorNumero() {
        int maior = Integer.MIN_VALUE;
        for (int numero : numeros) {
            if (numero > maior) {
                maior = numero;
            }
        }
        return maior;
    }

    public int encontrarMenorNumero() {
        int menor = Integer.MAX_VALUE;
        for (int numero : numeros) {
            if (numero < menor) {
                menor = numero;
            }
        }
        return menor;
    }

    public List<Integer> exibirNumeros() {
        return new ArrayList<>(numeros);
    }

    public static void main(String[] args) {
        // Criando uma lista de números
        SomaNumeros somaNumeros = new SomaNumeros();

        // Adicionando alguns números à lista
        somaNumeros.adicionarNumero(10);
        somaNumeros.adicionarNumero(20);
        somaNumeros.adicionarNumero(30);
        somaNumeros.adicionarNumero(40);

        // Calculando a soma dos números
        System.out.println("Soma dos números: " + somaNumeros.calcularSoma());

        // Encontrando o maior número
        System.out.println("Maior número: " + somaNumeros.encontrarMaiorNumero());

        // Encontrando o menor número
        System.out.println("Menor número: " + somaNumeros.encontrarMenorNumero());

        // Exibindo os números da lista
        System.out.println("Números na lista:");
        List<Integer> numeros = somaNumeros.exibirNumeros();
        for (int numero : numeros) {
            System.out.println(numero);
        }
    }
}