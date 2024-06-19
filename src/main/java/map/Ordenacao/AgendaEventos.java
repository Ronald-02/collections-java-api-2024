package main.java.map.Ordenacao;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {

    private Map<LocalDate, Evento> agenda;

    public AgendaEventos() {
        this.agenda = new TreeMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        Evento evento = new Evento(nome, atracao);
        agenda.put(data, evento);
    }

    public void exibirAgenda() {
        System.out.println("Agenda de Eventos:");
        for (Map.Entry<LocalDate, Evento> entry : agenda.entrySet()) {
            LocalDate data = entry.getKey();
            Evento evento = entry.getValue();
            System.out.println("Data: " + data + ", Evento: " + evento.getNome() + ", Atração: " + evento.getAtracao());
        }
    }

    public Evento obterProximoEvento() {
        return agenda.isEmpty() ? null : agenda.entrySet().iterator().next().getValue();
    }

    public static void main(String[] args) {
        AgendaEventos agenda = new AgendaEventos();

        agenda.adicionarEvento(LocalDate.of(2024, 7, 1), "Festival de Verão", "Banda U2");
        agenda.adicionarEvento(LocalDate.of(2024, 7, 15), "Feira Cultural", "Palestra sobre Inovação");
        agenda.adicionarEvento(LocalDate.of(2024, 8, 5), "Show de Lançamento", "Rapper Kendrick Lamar");

        agenda.exibirAgenda();

        Evento proximoEvento = agenda.obterProximoEvento();
        System.out.println("\nPróximo Evento:");
        if (proximoEvento != null) {
            System.out.println(proximoEvento);
        } else {
            System.out.println("Não há eventos agendados.");
        }
    }
}