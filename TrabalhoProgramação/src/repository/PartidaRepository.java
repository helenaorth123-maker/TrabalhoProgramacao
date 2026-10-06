package repository;

import java.util.ArrayList;
import model.Partida;

public class PartidaRepository {

    private ArrayList<Partida> partidas = new ArrayList<>();

    public void inserir(Partida partida) {
        partidas.add(partida);
    }
    
    public ArrayList<Partida> listar() {
        return partidas;
    }

    public Partida buscarPorPontuacao(int pontuacao) {

        for (Partida partida : partidas) {
            if (partida.getPontuacao() == pontuacao) {
                return partida;
            }
        }

        return null;
    }

    public boolean atualizar(int pontuacao, int novaDuracao) {

        Partida partida = buscarPorPontuacao(pontuacao);

        if (partida != null) {
            partida.setDuracao(novaDuracao);
            return true;
        }

        return false;
    }

    public boolean remover(int pontuacao) {

        Partida partida = buscarPorPontuacao(pontuacao);

        if (partida != null) {
            partidas.remove(partida);
            return true;
        }

        return false;
    }
}