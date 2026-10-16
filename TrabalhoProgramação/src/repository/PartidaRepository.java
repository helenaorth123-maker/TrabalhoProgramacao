
package repository;

import java.util.ArrayList;
import model.Partida;

public class PartidaRepository {

    private ArrayList<Partida> partidas = new ArrayList<>();

    // inserir partida
    public boolean inserir(Partida partida) {

        if (partida == null || partida.getData() == null
                || partida.getDuracao() <= 0) {
            return false;
        }

        // Evita pontuações repetidas, pois a busca usa a pontuação
        if (buscarPorPontuacao(partida.getPontuacao()) != null) {
            return false;
        }

        partidas.add(partida);
        return true;
    }

    // listar partidas
    public ArrayList<Partida> listar() {
        return new ArrayList<>(partidas);
    }

    // buscar pela pontuação
    public Partida buscarPorPontuacao(int pontuacao) {

        for (Partida partida : partidas) {
            if (partida.getPontuacao() == pontuacao) {
                return partida;
            }
        }

        return null;
    }

    // atualizar duração
    public boolean atualizar(int pontuacao, int novaDuracao) {

        Partida partida = buscarPorPontuacao(pontuacao);

        if (partida == null || novaDuracao <= 0) {
            return false;
        }

        partida.setDuracao(novaDuracao);
        return true;
    }

    // remover pela pontuação
    public boolean remover(int pontuacao) {

        Partida partida = buscarPorPontuacao(pontuacao);

        if (partida == null) {
            return false;
        }

        partidas.remove(partida);
        return true;
    }
}
