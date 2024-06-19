package main.java.set.Ordenacao;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {

    private Set<Produto> produtos;

    public CadastroProdutos() {
        // Utilizamos TreeSet com comparadores para manter a ordenação
        this.produtos = new TreeSet<>(Comparator.comparing(Produto::getNome));
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
        Produto novoProduto = new Produto(cod, nome, preco, quantidade);
        produtos.add(novoProduto);
    }

    public void exibirProdutosPorNome() {
        System.out.println("Produtos ordenados por nome:");
        for (Produto produto : produtos) {
            System.out.println("Código: " + produto.getCod() + ", Nome: " + produto.getNome() +
                    ", Preço: " + produto.getPreco() + ", Quantidade: " + produto.getQuantidade());
        }
    }

    public void exibirProdutosPorPreco() {
        // Utilizamos TreeSet com comparadores para manter a ordenação
        Set<Produto> produtosPorPreco = new TreeSet<>(Comparator.comparingDouble(Produto::getPreco));
        produtosPorPreco.addAll(produtos);

        System.out.println("Produtos ordenados por preço:");
        for (Produto produto : produtosPorPreco) {
            System.out.println("Código: " + produto.getCod() + ", Nome: " + produto.getNome() +
                    ", Preço: " + produto.getPreco() + ", Quantidade: " + produto.getQuantidade());
        }
    }

    public static void main(String[] args) {
        CadastroProdutos cadastro = new CadastroProdutos();

        cadastro.adicionarProduto(1, "Mouse", 25.50, 100);
        cadastro.adicionarProduto(2, "Teclado", 80.00, 50);
        cadastro.adicionarProduto(3, "Monitor", 450.00, 20);

        cadastro.exibirProdutosPorNome();

        System.out.println("\nExibindo produtos por ordem de preço:");
        cadastro.exibirProdutosPorPreco();
    }
}