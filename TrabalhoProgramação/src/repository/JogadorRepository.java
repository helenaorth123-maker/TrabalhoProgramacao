package repository;

import java.util.ArrayList;
import model.Jogador;

public class JogadorRepository {

    private ArrayList<Jogador> jogadores = new ArrayList<>();

    // CREATE
    public void inserir(Jogador jogador) {
        jogadores.add(jogador);
    }

    public ArrayList<Jogador> listar() {
        return jogadores;
    }

    public Jogador buscarPorNome(String nome) {

        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equalsIgnoreCase(nome)) {
                return jogador;
            }
        }

        return null;
    }

    public boolean atualizar(String nome, String novoEmail, int novoNivel) {

        Jogador jogador = buscarPorNome(nome);

        if (jogador != null) {
            jogador.setEmail(novoEmail);
            jogador.setNivel(novoNivel);
            return true;
        }

        return false;
    }
    
    public boolean remover(String nome) {

        Jogador jogador = buscarPorNome(nome);

        if (jogador != null) {
            jogadores.remove(jogador);
            return true;
        }

        return false;
    }
}