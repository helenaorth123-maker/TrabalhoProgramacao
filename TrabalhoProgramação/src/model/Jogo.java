package model;

public class Jogo {
	
	private String titulo;
    private String genero;
    private String plataforma;

    public Jogo(String titulo, String genero, String plataforma) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public void iniciar() {
        System.out.println("Jogo iniciado.");
    }

    public void pausar() {
        System.out.println("Jogo pausado.");
    }
}

