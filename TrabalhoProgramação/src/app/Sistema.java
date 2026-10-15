package app;

import model.Jogo;
import model.JogoDeAcao;
import model.JogoDeEstrategia;
import model.Jogador;
import model.Partida;
import repository.JogoRepository;
import repository.JogadorRepository;
import repository.PartidaRepository;
import java.time.LocalDate;

public class Sistema {

    private JogoRepository jogoRepository = new JogoRepository();
    private JogadorRepository jogadorRepository = new JogadorRepository();
    private PartidaRepository partidaRepository = new PartidaRepository();

    public void executar() {
        testarJogos();
        testarJogadores();
        testarPartidas();
    }

    private void testarJogos() {
        System.out.println("=== TESTE DE JOGOS ===");

        Jogo jogo = new Jogo("Minecraft", "Sandbox", "PC");
        jogoRepository.inserir(jogo);

        System.out.println("Jogo cadastrado: "
                + jogoRepository.buscarPorTitulo("Minecraft").getTitulo());

        jogoRepository.atualizar("Minecraft", "Aventura", "PC");

        System.out.println("Genero atualizado: "
                + jogoRepository.buscarPorTitulo("Minecraft").getGenero());

        jogoRepository.remover("Minecraft");

        System.out.println("Jogo removido: "
                + (jogoRepository.buscarPorTitulo("Minecraft") == null));

        System.out.println("\n=== TESTE DE HERANCA E POLIMORFISMO ===");

        JogoDeAcao jogoAcao = new JogoDeAcao(
                "God of War", "Acao", "PlayStation", 5);

        JogoDeEstrategia jogoEstrategia = new JogoDeEstrategia("XCOM", "Estrategia", "PC", 20);

        jogoRepository.inserir(jogoAcao);
        jogoRepository.inserir(jogoEstrategia);

        Jogo primeiroJogo = jogoAcao;
        Jogo segundoJogo = jogoEstrategia;
        
        primeiroJogo.iniciar();
        segundoJogo.iniciar();

        System.out.println("Jogo de acao: " + primeiroJogo.getTitulo());
        jogoAcao.atacar();

        System.out.println("Jogo de estrategia: " + segundoJogo.getTitulo());

        System.out.println("Total de jogos cadastrados: "
                + jogoRepository.listar().size());
    }

    private void testarJogadores() {
        System.out.println("\n=== TESTE DE JOGADORES ===");

        Jogador jogador = new Jogador("Helena", "helena@email.com", 10);
        jogadorRepository.inserir(jogador);

        System.out.println("Jogador cadastrado: "
                + jogadorRepository.buscarPorNome("Helena").getNome());

        jogadorRepository.atualizar(
                "Helena", "novoemail@email.com", 15);

        System.out.println("Nivel atualizado: "
                + jogadorRepository.buscarPorNome("Helena").getNivel());

        jogadorRepository.remover("Helena");

        System.out.println("Jogador removido: "
                + (jogadorRepository.buscarPorNome("Helena") == null));
    }

    private void testarPartidas() {
        System.out.println("\n=== TESTE DE PARTIDAS ===");

        Partida partida = new Partida(LocalDate.now(), 100, 60);
        partidaRepository.inserir(partida);

        System.out.println("Partida cadastrada: "
                + partidaRepository.buscarPorPontuacao(100).getPontuacao());

        partidaRepository.atualizar(100, 90);

        System.out.println("Duracao atualizada: "
                + partidaRepository.buscarPorPontuacao(100).getDuracao());

        partidaRepository.remover(100);

        System.out.println("Partida removida: "
                + (partidaRepository.buscarPorPontuacao(100) == null));
    }
}