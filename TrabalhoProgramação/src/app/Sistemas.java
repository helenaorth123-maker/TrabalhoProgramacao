
package app;

import java.time.LocalDate;
import java.util.Scanner;

import model.Jogo;
import model.JogoDeAcao;
import model.JogoDeEstrategia;
import model.Jogador;
import model.Partida;

import repository.JogoRepository;
import repository.JogadorRepository;
import repository.PartidaRepository;

public class Sistemas {

    private Scanner scanner = new Scanner(System.in);

    private JogoRepository jogos = new JogoRepository();
    private JogadorRepository jogadores = new JogadorRepository();
    private PartidaRepository partidas = new PartidaRepository();

    // Menu principal
    public void executar() {

        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE JOGOS =====");
            System.out.println("1 - Gerenciar jogos");
            System.out.println("2 - Gerenciar jogadores");
            System.out.println("3 - Gerenciar partidas");
            System.out.println("0 - Sair");

            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    menuJogos();
                    break;
                case 2:
                    menuJogadores();
                    break;
                case 3:
                    menuPartidas();
                    break;
                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    //controla jogos

    private void menuJogos() {

        int opcao;

        do {
            System.out.println("\n===== JOGOS =====");
            System.out.println("1 - Cadastrar jogo");
            System.out.println("2 - Listar jogos");
            System.out.println("3 - Buscar jogo");
            System.out.println("4 - Atualizar jogo");
            System.out.println("5 - Remover jogo");
            System.out.println("0 - Voltar");

            opcao = lerInteiro("Escolha: ");

            switch (opcao) {
                case 1:
                    cadastrarJogo();
                    break;
                case 2:
                    listarJogos();
                    break;
                case 3:
                    buscarJogo();
                    break;
                case 4:
                    atualizarJogo();
                    break;
                case 5:
                    removerJogo();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void cadastrarJogo() {

        System.out.println("\nTipo de jogo:");
        System.out.println("1 - Jogo comum");
        System.out.println("2 - Jogo de ação");
        System.out.println("3 - Jogo de estratégia");

        int tipo = lerInteiro("Escolha: ");

        String titulo = lerTexto("Título: ");
        String genero = lerTexto("Gênero: ");
        String plataforma = lerTexto("Plataforma: ");

        Jogo jogo;

        if (tipo == 1) {
            jogo = new Jogo(titulo, genero, plataforma);

        } else if (tipo == 2) {
            int dificuldade = lerInteiro("Dificuldade: ");

            jogo = new JogoDeAcao(
                    titulo, genero, plataforma, dificuldade);

        } else if (tipo == 3) {
            int unidades = lerInteiro("Número de unidades: ");

            jogo = new JogoDeEstrategia(
                    titulo, genero, plataforma, unidades);

        } else {
            System.out.println("Tipo inválido!");
            return;
        }

        if (jogos.inserir(jogo)) {
            System.out.println("Jogo cadastrado com sucesso!");
        } else {
            System.out.println("Cadastro inválido ou título já existente.");
        }
    }

    private void listarJogos() {

        if (jogos.listar().isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }

        for (Jogo jogo : jogos.listar()) {

            System.out.println("\nTítulo: " + jogo.getTitulo());
            System.out.println("Gênero: " + jogo.getGenero());
            System.out.println("Plataforma: " + jogo.getPlataforma());

            if (jogo instanceof JogoDeAcao) {
                JogoDeAcao acao = (JogoDeAcao) jogo;
                System.out.println("Dificuldade: " + acao.getDificuldade());

            } else if (jogo instanceof JogoDeEstrategia) {
                JogoDeEstrategia estrategia =
                        (JogoDeEstrategia) jogo;

                System.out.println(
                        "Unidades: " + estrategia.getNumUnidades());
            }
        }
    }

    private void buscarJogo() {

        String titulo = lerTexto("Título do jogo: ");
        Jogo jogo = jogos.buscarPorTitulo(titulo);

        if (jogo == null) {
            System.out.println("Jogo não encontrado.");
        } else {
            System.out.println("Encontrado: " + jogo.getTitulo()
                    + " | " + jogo.getGenero()
                    + " | " + jogo.getPlataforma());
        }
    }

    private void atualizarJogo() {

        String titulo = lerTexto("Título do jogo que será atualizado: ");
        String genero = lerTexto("Novo gênero: ");
        String plataforma = lerTexto("Nova plataforma: ");

        if (jogos.atualizar(titulo, genero, plataforma)) {
            System.out.println("Jogo atualizado!");
        } else {
            System.out.println("Jogo não encontrado ou dados inválidos.");
        }
    }

    private void removerJogo() {

        String titulo = lerTexto("Título do jogo que será removido: ");

        if (jogos.remover(titulo)) {
            System.out.println("Jogo removido!");
        } else {
            System.out.println("Jogo não encontrado.");
        }
    }

    //controla jogador

    private void menuJogadores() {

        int opcao;

        do {
            System.out.println("\n===== JOGADORES =====");
            System.out.println("1 - Cadastrar jogador");
            System.out.println("2 - Listar jogadores");
            System.out.println("3 - Buscar jogador");
            System.out.println("4 - Atualizar jogador");
            System.out.println("5 - Remover jogador");
            System.out.println("0 - Voltar");

            opcao = lerInteiro("Escolha: ");

            switch (opcao) {
                case 1:
                    cadastrarJogador();
                    break;
                case 2:
                    listarJogadores();
                    break;
                case 3:
                    buscarJogador();
                    break;
                case 4:
                    atualizarJogador();
                    break;
                case 5:
                    removerJogador();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void cadastrarJogador() {

        String nome = lerTexto("Nome: ");
        String email = lerTexto("E-mail: ");
        int nivel = lerInteiro("Nível: ");

        Jogador jogador = new Jogador(nome, email, nivel);

        if (jogadores.inserir(jogador)) {
            System.out.println("Jogador cadastrado!");
        } else {
            System.out.println("Nome inválido ou já cadastrado.");
        }
    }

    private void listarJogadores() {

        if (jogadores.listar().isEmpty()) {
            System.out.println("Nenhum jogador cadastrado.");
            return;
        }

        for (Jogador jogador : jogadores.listar()) {
            System.out.println(jogador.getNome()
                    + " | " + jogador.getEmail()
                    + " | Nível: " + jogador.getNivel());
        }
    }

    private void buscarJogador() {

        String nome = lerTexto("Nome do jogador: ");
        Jogador jogador = jogadores.buscarPorNome(nome);

        if (jogador == null) {
            System.out.println("Jogador não encontrado.");
        } else {
            System.out.println(jogador.getNome()
                    + " | " + jogador.getEmail()
                    + " | Nível: " + jogador.getNivel());
        }
    }

    private void atualizarJogador() {

        String nome = lerTexto("Nome do jogador: ");
        String email = lerTexto("Novo e-mail: ");
        int nivel = lerInteiro("Novo nível: ");

        if (jogadores.atualizar(nome, email, nivel)) {
            System.out.println("Jogador atualizado!");
        } else {
            System.out.println("Jogador não encontrado ou dados inválidos.");
        }
    }

    private void removerJogador() {

        String nome = lerTexto("Nome do jogador que será removido: ");

        if (jogadores.remover(nome)) {
            System.out.println("Jogador removido!");
        } else {
            System.out.println("Jogador não encontrado.");
        }
    }

    // controla partidas

    private void menuPartidas() {

        int opcao;

        do {
            System.out.println("\n===== PARTIDAS =====");
            System.out.println("1 - Cadastrar partida");
            System.out.println("2 - Listar partidas");
            System.out.println("3 - Buscar partida");
            System.out.println("4 - Atualizar duração");
            System.out.println("5 - Remover partida");
            System.out.println("0 - Voltar");

            opcao = lerInteiro("Escolha: ");

            switch (opcao) {
                case 1:
                    cadastrarPartida();
                    break;
                case 2:
                    listarPartidas();
                    break;
                case 3:
                    buscarPartida();
                    break;
                case 4:
                    atualizarPartida();
                    break;
                case 5:
                    removerPartida();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void cadastrarPartida() {

        try {
            String textoData = lerTexto("Data (AAAA-MM-DD): ");
            LocalDate data = LocalDate.parse(textoData);

            int pontuacao = lerInteiro("Pontuação: ");
            int duracao = lerInteiro("Duração em minutos: ");

            Partida partida = new Partida(data, pontuacao, duracao);

            if (partidas.inserir(partida)) {
                System.out.println("Partida cadastrada!");
            } else {
                System.out.println(
                        "Partida inválida ou pontuação já cadastrada.");
            }

        } catch (Exception e) {
            System.out.println("Data inválida! Use AAAA-MM-DD.");
        }
    }

    private void listarPartidas() {

        if (partidas.listar().isEmpty()) {
            System.out.println("Nenhuma partida cadastrada.");
            return;
        }

        for (Partida partida : partidas.listar()) {
            System.out.println("Data: " + partida.getData()
                    + " | Pontuação: " + partida.getPontuacao()
                    + " | Duração: " + partida.getDuracao() + " min");
        }
    }

    private void buscarPartida() {

        int pontuacao = lerInteiro("Pontuação da partida: ");
        Partida partida = partidas.buscarPorPontuacao(pontuacao);

        if (partida == null) {
            System.out.println("Partida não encontrada.");
        } else {
            System.out.println("Data: " + partida.getData()
                    + " | Pontuação: " + partida.getPontuacao()
                    + " | Duração: " + partida.getDuracao() + " min");
        }
    }

    private void atualizarPartida() {

        int pontuacao = lerInteiro("Pontuação da partida: ");
        int duracao = lerInteiro("Nova duração em minutos: ");

        if (partidas.atualizar(pontuacao, duracao)) {
            System.out.println("Partida atualizada!");
        } else {
            System.out.println("Partida não encontrada ou duração inválida.");
        }
    }

    private void removerPartida() {

        int pontuacao = lerInteiro("Pontuação da partida: ");

        if (partidas.remover(pontuacao)) {
            System.out.println("Partida removida!");
        } else {
            System.out.println("Partida não encontrada.");
        }
    }

    //leitura dados

    private String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().trim();
    }

    private int lerInteiro(String mensagem) {

        while (true) {
            try {
                System.out.print(mensagem);
                int valor = Integer.parseInt(scanner.nextLine().trim());
                return valor;

            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }
}
