package main.java.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {

    private Set<Convidado> conjuntoConvidados;

    public ConjuntoConvidados() {
        this.conjuntoConvidados = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        Convidado novoConvidado = new Convidado(nome, codigoConvite);
        conjuntoConvidados.add(novoConvidado);
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        Convidado convidadoRemover = null;
        for (Convidado convidado : conjuntoConvidados) {
            if (convidado.getCodigoConvite() == codigoConvite) {
                convidadoRemover = convidado;
                break;
            }
        }
        if (convidadoRemover != null) {
            conjuntoConvidados.remove(convidadoRemover);
        } else {
            System.out.println("Convidado com código " + codigoConvite + " não encontrado.");
        }
    }

    public int contarConvidados() {
        return conjuntoConvidados.size();
    }

    public void exibirConvidados() {
        System.out.println("Lista de Convidados:");
        for (Convidado convidado : conjuntoConvidados) {
            System.out.println("Nome: " + convidado.getNome() + ", Código do Convite: " + convidado.getCodigoConvite());
        }
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjunto = new ConjuntoConvidados();

        conjunto.adicionarConvidado("Ana", 1);
        conjunto.adicionarConvidado("João", 2);
        conjunto.adicionarConvidado("Maria", 3);

        conjunto.exibirConvidados();

        System.out.println("Total de convidados: " + conjunto.contarConvidados());

        conjunto.removerConvidadoPorCodigoConvite(2);

        conjunto.exibirConvidados();

        System.out.println("Total de convidados: " + conjunto.contarConvidados());
    }
}