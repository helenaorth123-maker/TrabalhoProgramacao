package model;

import java.time.LocalDate;

public class Partida {

    private LocalDate data;
    private int pontuacao;
    private int duracao;

    public Partida(LocalDate data, int pontuacao, int duracao) {
        this.data = data;
        this.pontuacao = pontuacao;
        this.duracao = duracao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void finalizar() {
        System.out.println("Partida finalizada.");
    }
}