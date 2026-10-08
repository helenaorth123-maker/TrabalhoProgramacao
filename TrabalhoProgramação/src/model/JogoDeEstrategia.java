package model;

public class JogoDeEstrategia extends Jogo{
	
	private int numUnidades;

    public JogoDeEstrategia(String titulo, String genero, String plataforma, int numUnidades) {
        super(titulo, genero, plataforma);
        this.numUnidades = numUnidades;
    }

    public int getNumUnidades() {
        return numUnidades;
    }

    public void setNumUnidades(int numUnidades) {
        this.numUnidades = numUnidades;
    }

    public void planejar() {
        System.out.println("Planejando estratégia...");
    }
    @Override
    public void iniciar() {
        System.out.println("Jogo de estratégia iniciado.");
    }
}
	
