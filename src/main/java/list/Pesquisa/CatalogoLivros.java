package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> livros;

    public CatalogoLivros() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        Livro novoLivro = new Livro(titulo, autor, anoPublicacao);
        livros.add(novoLivro);
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    public Livro pesquisarPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null; // Retorna null se nenhum livro for encontrado com o título fornecido
    }

    public static void main(String[] args) {
        CatalogoLivros catalogo = new CatalogoLivros();

        // Adicionando alguns livros ao catálogo
        catalogo.adicionarLivro("Java: Como Programar", "Paul Deitel", 2015);
        catalogo.adicionarLivro("Clean Code", "Robert C. Martin", 2008);
        catalogo.adicionarLivro("Design Patterns", "Erich Gamma", 1994);
        catalogo.adicionarLivro("Effective Java", "Joshua Bloch", 2008);

        // Pesquisando livros por autor
        System.out.println("Livros por autor:");
        List<Livro> livrosPorAutor = catalogo.pesquisarPorAutor("Joshua Bloch");
        for (Livro livro : livrosPorAutor) {
            System.out.println(livro.getTitulo() + " - " + livro.getAutor());
        }

        // Pesquisando livros por intervalo de anos
        System.out.println("\nLivros por intervalo de anos:");
        List<Livro> livrosPorAno = catalogo.pesquisarPorIntervaloAnos(2000, 2010);
        for (Livro livro : livrosPorAno) {
            System.out.println(livro.getTitulo() + " - " + livro.getAnoPublicacao());
        }

        // Pesquisando livro por título
        System.out.println("\nLivro por título:");
        Livro livroEncontrado = catalogo.pesquisarPorTitulo("Clean Code");
        if (livroEncontrado != null) {
            System.out.println(livroEncontrado.getTitulo() + " - " + livroEncontrado.getAutor() + " - " + livroEncontrado.getAnoPublicacao());
        } else {
            System.out.println("Livro não encontrado.");
        }
    }
}