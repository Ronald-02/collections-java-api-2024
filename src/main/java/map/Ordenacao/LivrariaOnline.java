package main.java.map.Ordenacao;

import java.util.*;

public class LivrariaOnline {

    private Map<String, Livro> livros;

    public LivrariaOnline() {
        this.livros = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco) {
        Livro livro = new Livro(titulo, autor, preco);
        livros.put(link, livro);
    }

    public void removerLivro(String titulo) {
        Iterator<Map.Entry<String, Livro>> iterator = livros.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Livro> entry = iterator.next();
            if (entry.getValue().getTitulo().equals(titulo)) {
                iterator.remove();
            }
        }
    }

    public void exibirLivrosOrdenadosPorPreco() {
        List<Livro> listaOrdenada = new ArrayList<>(livros.values());
        listaOrdenada.sort(Comparator.comparingDouble(Livro::getPreco));

        System.out.println("Livros Ordenados por Preço:");
        for (Livro livro : listaOrdenada) {
            System.out.println(livro);
        }
    }

    public List<Livro> pesquisarLivrosPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        for (Livro livro : livros.values()) {
            if (livro.getAutor().equals(autor)) {
                livrosPorAutor.add(livro);
            }
        }
        return livrosPorAutor;
    }

    public Livro obterLivroMaisCaro() {
        Livro maisCaro = null;
        double maxPreco = Double.MIN_VALUE;
        for (Livro livro : livros.values()) {
            if (livro.getPreco() > maxPreco) {
                maxPreco = livro.getPreco();
                maisCaro = livro;
            }
        }
        return maisCaro;
    }

    public Livro obterLivroMaisBarato() {
        Livro maisBarato = null;
        double minPreco = Double.MAX_VALUE;
        for (Livro livro : livros.values()) {
            if (livro.getPreco() < minPreco) {
                minPreco = livro.getPreco();
                maisBarato = livro;
            }
        }
        return maisBarato;
    }

    public static void main(String[] args) {
        LivrariaOnline livraria = new LivrariaOnline();

        livraria.adicionarLivro("https://www.amazon.com/livro1", "Java Fundamentals", "John Doe", 50.0);
        livraria.adicionarLivro("https://www.amazon.com/livro2", "Python Basics", "Jane Smith", 35.0);
        livraria.adicionarLivro("https://www.amazon.com/livro3", "JavaScript for Beginners", "John Doe", 45.0);

        livraria.exibirLivrosOrdenadosPorPreco();

        System.out.println("\nPesquisando livros por autor 'John Doe':");
        List<Livro> livrosJohnDoe = livraria.pesquisarLivrosPorAutor("John Doe");
        for (Livro livro : livrosJohnDoe) {
            System.out.println(livro);
        }

        Livro maisCaro = livraria.obterLivroMaisCaro();
        System.out.println("\nLivro mais caro:");
        if (maisCaro != null) {
            System.out.println(maisCaro);
        } else {
            System.out.println("Nenhum livro encontrado.");
        }

        Livro maisBarato = livraria.obterLivroMaisBarato();
        System.out.println("\nLivro mais barato:");
        if (maisBarato != null) {
            System.out.println(maisBarato);
        } else {
            System.out.println("Nenhum livro encontrado.");
        }

        livraria.removerLivro("Java Fundamentals");

        System.out.println("\nApós remover 'Java Fundamentals':");
        livraria.exibirLivrosOrdenadosPorPreco();
    }
}
