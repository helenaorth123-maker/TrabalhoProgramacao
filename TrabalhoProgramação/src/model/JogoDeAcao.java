package model;

public class JogoDeAcao extends Jogo {
	
	private int dificuldade;

    public JogoDeAcao(String titulo, String genero, String plataforma, int dificuldade) {
        super(titulo, genero, plataforma);
        this.dificuldade = dificuldade;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public void atacar() {
        System.out.println("Ataque realizado!");
    }
}

