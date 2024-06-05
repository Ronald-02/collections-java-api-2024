package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
        private List<Item> itens;

        public CarrinhoDeCompras() {
            this.itens = new ArrayList<>();
        }

        public void adicionarItem(String nome, double preco, int quantidade) {
            Item novoItem = new Item(nome, preco, quantidade);
            itens.add(novoItem);
        }

        public void removerItem(String nome) {
            itens.removeIf(item -> item.getNome().equals(nome));
        }

        public double calcularValorTotal() {
            double total = 0;
            for (Item item : itens) {
                total += item.getPreco() * item.getQuantidade();
            }
            return total;
        }

        public void exibirItens() {
            for (Item item : itens) {
                System.out.println("Nome: " + item.getNome() + ", Preço: " + item.getPreco() + ", Quantidade: " + item.getQuantidade());
            }
        }

    public static void main(String[] args) {
        // Criando um carrinho de compras
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        // Adicionando alguns itens ao carrinho
        carrinho.adicionarItem("Camisa", 25.0, 2);
        carrinho.adicionarItem("Calça", 50.0, 1);
        carrinho.adicionarItem("Meias", 5.0, 3);

        // Exibindo os itens do carrinho
        System.out.println("Itens no carrinho:");
        carrinho.exibirItens();

        // Calculando o valor total do carrinho
        double valorTotal = carrinho.calcularValorTotal();
        System.out.println("\nValor total do carrinho: R$" + valorTotal);

        // Removendo um item do carrinho
        carrinho.removerItem("Calça");

        // Exibindo os itens do carrinho após a remoção
        System.out.println("\nItens no carrinho após remover uma calça:");
        carrinho.exibirItens();
    }
}
