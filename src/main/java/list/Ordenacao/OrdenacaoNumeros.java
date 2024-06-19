package main.java.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> numeros;

    public OrdenacaoNumeros() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numeros.add(numero);
    }

    public void ordenarAscendente() {
        Collections.sort(numeros);
    }

    public void ordenarDescendente() {
        Collections.sort(numeros, Collections.reverseOrder());
    }

    public List<Integer> getNumeros() {
        return numeros;
    }
    public static void main(String[] args) {
        // Criando um objeto de OrdenacaoNumeros
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();

        // Adicionando alguns números à lista
        ordenacaoNumeros.adicionarNumero(30);
        ordenacaoNumeros.adicionarNumero(10);
        ordenacaoNumeros.adicionarNumero(20);

        // Ordenando em ordem ascendente
        System.out.println("Ordenado em ordem ascendente:");
        ordenacaoNumeros.ordenarAscendente();
        System.out.println(ordenacaoNumeros.getNumeros());

        // Ordenando em ordem descendente
        System.out.println("Ordenado em ordem descendente:");
        ordenacaoNumeros.ordenarDescendente();
        System.out.println(ordenacaoNumeros.getNumeros());
    }
}
