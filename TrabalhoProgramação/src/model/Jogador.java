package model;

public class Jogador {

    private String nome;
    private String email;
    private int nivel;

    public Jogador(String nome, String email, int nivel) {
        this.nome = nome;
        this.email = email;
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void jogar() {
        System.out.println(nome + " começou a jogar.");
    }
}