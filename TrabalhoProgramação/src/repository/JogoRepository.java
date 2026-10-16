
package repository;

import java.util.ArrayList;
import model.Jogo;

public class JogoRepository {

    private ArrayList<Jogo> jogos = new ArrayList<>();

    //inserir um jogo
    public boolean inserir(Jogo jogo) {

        if (jogo == null || jogo.getTitulo() == null
                || jogo.getTitulo().trim().isEmpty()) {
            return false;
        }

        // Evita cadastrar dois jogos com o mesmo título
        if (buscarPorTitulo(jogo.getTitulo()) != null) {
            return false;
        }

        jogos.add(jogo);
        return true;
    }

    // listar todos os jogos
    public ArrayList<Jogo> listar() {
        return new ArrayList<>(jogos);
    }

    // buscar jogo pelo título
    public Jogo buscarPorTitulo(String titulo) {

        if (titulo == null || titulo.trim().isEmpty()) {
            return null;
        }

        for (Jogo jogo : jogos) {
            if (jogo.getTitulo().equalsIgnoreCase(titulo.trim())) {
                return jogo;
            }
        }

        return null;
    }

    //atualizar gênero e plataforma
    public boolean atualizar(String titulo, String novoGenero,
            String novaPlataforma) {

        Jogo jogo = buscarPorTitulo(titulo);

        if (jogo == null || novoGenero == null
                || novoGenero.trim().isEmpty()
                || novaPlataforma == null
                || novaPlataforma.trim().isEmpty()) {
            return false;
        }

        jogo.setGenero(novoGenero);
        jogo.setPlataforma(novaPlataforma);

        return true;
    }

    // remover jogo pelo título
    public boolean remover(String titulo) {

        Jogo jogo = buscarPorTitulo(titulo);

        if (jogo == null) {
            return false;
        }

        jogos.remove(jogo);
        return true;
    }
}
