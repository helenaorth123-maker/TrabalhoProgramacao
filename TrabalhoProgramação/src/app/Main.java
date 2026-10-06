package app;

		import model.Jogo;
		import model.Jogador;
		import model.Partida;
		import repository.JogoRepository;
		import repository.JogadorRepository;
		import repository.PartidaRepository;

		import java.time.LocalDate;
		
		public class Main {

		    public static void main(String[] args) {


		        JogoRepository jogoRepository = new JogoRepository();

		        Jogo jogo = new Jogo(
		                "Minecraft",
		                "Sandbox",
		                "PC"
		        );

		        jogoRepository.inserir(jogo);

		        System.out.println("Jogo encontrado:");
		        System.out.println(jogoRepository.buscarPorTitulo("Minecraft").getTitulo());

		        jogoRepository.atualizar(
		                "Minecraft",
		                "Aventura",
		                "PC"
		        );

		        System.out.println("Gênero atualizado:");
		        System.out.println(jogoRepository.buscarPorTitulo("Minecraft").getGenero());

		        jogoRepository.remover("Minecraft");

		        System.out.println("Jogo removido!");
		        System.out.println();



		        JogadorRepository jogadorRepository = new JogadorRepository();

		        Jogador jogador = new Jogador(
		                "Helena",
		                "helena@email.com",
		                10
		        );

		        jogadorRepository.inserir(jogador);

		        System.out.println("Jogador encontrado:");
		        System.out.println(jogadorRepository.buscarPorNome("Helena").getNome());

		        jogadorRepository.atualizar(
		                "Helena",
		                "novoemail@email.com",
		                15
		        );

		        System.out.println("Nível atualizado:");
		        System.out.println(jogadorRepository.buscarPorNome("Helena").getNivel());

		        jogadorRepository.remover("Helena");

		        System.out.println("Jogador removido!");
		        System.out.println();



		        PartidaRepository partidaRepository = new PartidaRepository();

		        Partida partida = new Partida(
		                LocalDate.now(),
		                100,
		                60
		        );

		        partidaRepository.inserir(partida);

		        System.out.println("Partida encontrada:");
		        System.out.println(
		                partidaRepository.buscarPorPontuacao(100).getPontuacao()
		        );

		        partidaRepository.atualizar(
		                100,
		                90
		        );

		        System.out.println("Duração atualizada:");
		        System.out.println(
		                partidaRepository.buscarPorPontuacao(100).getDuracao()
		        );
		        
		        partidaRepository.remover(100);

		        System.out.println("Partida removida!");
		    }
		}


