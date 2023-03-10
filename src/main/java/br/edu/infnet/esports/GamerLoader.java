package br.edu.infnet.esports;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.esports.model.domain.Game;
import br.edu.infnet.esports.model.domain.Gamer;
import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.service.GameService;
import br.edu.infnet.esports.model.service.GamerService;
import br.edu.infnet.esports.model.service.UsuarioService;

@Component
@Order(3)
public class GamerLoader implements ApplicationRunner {

	@Autowired
	private GamerService gamerService;
	@Autowired
	private GameService gameService;	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			String arq = "massa.txt";

			FileReader fileR;
			try {
				fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);
				String linha = leitura.readLine();

				List<Game> meusJogos = null;

				while (linha != null) {
					String[] campos = linha.split(";");
					meusJogos = new ArrayList<Game>();
					switch (campos[0].toUpperCase()) {
					case "G": {
						Gamer gamer = new Gamer();
						gamer.setNome(campos[1]);
						gamer.setEmail(campos[2]);
						
						Usuario usuario = usuarioService.obterUsuarioById(Integer.parseInt(campos[3]));
						
						gamer.setUsuario(usuario);
						
						for(String idGame : campos[4].split(",")) {
							meusJogos.add(gameService.obterGameById(Integer.parseInt(idGame)));
						}
						gamer.setGames(meusJogos);

						gamerService.incluir(gamer);
						System.out.println("Inclusão do gamer @" + gamer.getUsername() + " realizada com sucesso!");
						break;
					}
					default:
						break;
					}
					linha = leitura.readLine();
				}
				
				leitura.close();
				fileR.close();
			} catch (Exception e) {
				System.out.println("[ERRO] " + e.getMessage());
			}
		} finally {
			System.out.println("Processamento finalizado!");
		}
	}
}
