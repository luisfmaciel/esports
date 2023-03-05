package br.edu.infnet.esports;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.esports.model.domain.Fifa;
import br.edu.infnet.esports.model.domain.Game;
import br.edu.infnet.esports.model.service.FifaService;
import br.edu.infnet.esports.model.service.GameService;

@Component
@Order(2)
public class FifaLoader implements ApplicationRunner {

	@Autowired
	private FifaService fifaService;
	@Autowired
	private GameService gameService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			System.out.println("FIFA LOADER");
			String arq = "massa.txt";

			FileReader fileR;
			try {
				fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);
				String linha = leitura.readLine();

				Game game = null;				

				while (linha != null) {
					String[] campos = linha.split(";");
					
					switch (campos[0].toUpperCase()) {
					case "F": {
						game = new Fifa(campos[1]);
						game.setTitulos(Integer.parseInt(campos[2]));
						((Fifa) game).setFinalizacao(Integer.parseInt(campos[3]));
						((Fifa) game).setMarcacao(Integer.parseInt(campos[4]));
						((Fifa) game).setPasse(Integer.parseInt(campos[5]));
						game.setMediaEstatistica(game.calculaMediaEstatisticaGamer());
						game.setNivel(game.identificaNivelGamer());
						
						fifaService.incluir((Fifa) game);
						gameService.incluir((Fifa) game);
						System.out.println("Inclusão do game" + game.getNome() + " realizada com sucesso!");
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