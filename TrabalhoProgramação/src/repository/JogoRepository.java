package repository;
	
	import java.util.ArrayList;
	import model.Jogo;

	public class JogoRepository {

	    private ArrayList<Jogo> jogos = new ArrayList<>();

	    public void inserir(Jogo jogo) {
	        jogos.add(jogo);
	    }

	    public ArrayList<Jogo> listar() {
	        return jogos;
	    }

	    public Jogo buscarPorTitulo(String titulo) {

	        for (Jogo jogo : jogos) {
	            if (jogo.getTitulo().equalsIgnoreCase(titulo)) {
	                return jogo;
	            }
	        }

	        return null;
	    }

	    public boolean atualizar(String titulo, String novoGenero, String novaPlataforma) {

	        Jogo jogo = buscarPorTitulo(titulo);

	        if (jogo != null) {
	            jogo.setGenero(novoGenero);
	            jogo.setPlataforma(novaPlataforma);
	            return true;
	        }

	        return false;
	    }

	    public boolean remover(String titulo) {

	        Jogo jogo = buscarPorTitulo(titulo);

	        if (jogo != null) {
	            jogos.remove(jogo);
	            return true;
	        }

	        return false;
	    }
	}

