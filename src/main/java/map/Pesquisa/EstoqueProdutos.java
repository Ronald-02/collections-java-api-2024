package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {

    private Map<Long, Produto> estoque;

    public EstoqueProdutos() {
        this.estoque = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        Produto produto = new Produto(nome, quantidade, preco);
        estoque.put(cod, produto);
    }

    public void exibirProdutos() {
        System.out.println("Produtos em Estoque:");
        for (Map.Entry<Long, Produto> entry : estoque.entrySet()) {
            Long codigo = entry.getKey();
            Produto produto = entry.getValue();
            System.out.println("Código: " + codigo + ", Nome: " + produto.getNome() +
                    ", Quantidade: " + produto.getQuantidade() +
                    ", Preço: " + produto.getPreco());
        }
    }

    public double calcularValorTotalEstoque() {
        double valorTotal = 0.0;
        for (Produto produto : estoque.values()) {
            valorTotal += produto.getQuantidade() * produto.getPreco();
        }
        return valorTotal;
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maxPreco = Double.MIN_VALUE;
        for (Produto produto : estoque.values()) {
            if (produto.getPreco() > maxPreco) {
                maxPreco = produto.getPreco();
                produtoMaisCaro = produto;
            }
        }
        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;
        double minPreco = Double.MAX_VALUE;
        for (Produto produto : estoque.values()) {
            if (produto.getPreco() < minPreco) {
                minPreco = produto.getPreco();
                produtoMaisBarato = produto;
            }
        }
        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto produtoMaiorQuantidade = null;
        double maxValorTotal = Double.MIN_VALUE;
        for (Produto produto : estoque.values()) {
            double valorTotalProduto = produto.getQuantidade() * produto.getPreco();
            if (valorTotalProduto > maxValorTotal) {
                maxValorTotal = valorTotalProduto;
                produtoMaiorQuantidade = produto;
            }
        }
        return produtoMaiorQuantidade;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();

        estoque.adicionarProduto(1, "Arroz", 10, 5.0);
        estoque.adicionarProduto(2, "Feijão", 5, 8.0);
        estoque.adicionarProduto(3, "Óleo", 3, 12.0);

        estoque.exibirProdutos();

        System.out.println("\nValor total do estoque: " + estoque.calcularValorTotalEstoque());

        Produto maisCaro = estoque.obterProdutoMaisCaro();
        System.out.println("\nProduto mais caro:");
        if (maisCaro != null) {
            System.out.println(maisCaro);
        } else {
            System.out.println("Estoque vazio.");
        }

        Produto maisBarato = estoque.obterProdutoMaisBarato();
        System.out.println("\nProduto mais barato:");
        if (maisBarato != null) {
            System.out.println(maisBarato);
        } else {
            System.out.println("Estoque vazio.");
        }

        Produto maiorQuantidadeValorTotal = estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
        System.out.println("\nProduto com maior quantidade * valor total:");
        if (maiorQuantidadeValorTotal != null) {
            System.out.println(maiorQuantidadeValorTotal);
        } else {
            System.out.println("Estoque vazio.");
        }
    }
}