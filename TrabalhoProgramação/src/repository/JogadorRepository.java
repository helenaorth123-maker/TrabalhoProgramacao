
package repository;

import java.util.ArrayList;
import model.Jogador;

public class JogadorRepository {

    private ArrayList<Jogador> jogadores = new ArrayList<>();

    // inserir jogador
    public boolean inserir(Jogador jogador) {

        if (jogador == null || jogador.getNome() == null
                || jogador.getNome().trim().isEmpty()) {
            return false;
        }

        // Evita nomes repetidos, pois a busca usa o nome
        if (buscarPorNome(jogador.getNome()) != null) {
            return false;
        }

        jogadores.add(jogador);
        return true;
    }

    // listar jogadores
    public ArrayList<Jogador> listar() {
        return new ArrayList<>(jogadores);
    }

    //  buscar jogador pelo nome
    public Jogador buscarPorNome(String nome) {

        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }

        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equalsIgnoreCase(nome.trim())) {
                return jogador;
            }
        }

        return null;
    }

    // atualizar email e nível
    public boolean atualizar(String nome, String novoEmail, int novoNivel) {

        Jogador jogador = buscarPorNome(nome);

        if (jogador == null || novoEmail == null
                || novoEmail.trim().isEmpty()) {
            return false;
        }

        jogador.setEmail(novoEmail);
        jogador.setNivel(novoNivel);

        return true;
    }

    //  remover jogador pelo nome
    public boolean remover(String nome) {

        Jogador jogador = buscarPorNome(nome);

        if (jogador == null) {
            return false;
        }

        jogadores.remove(jogador);
        return true;
    }
}
