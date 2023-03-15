package br.edu.infnet.esports;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.esports.model.domain.Dungeons;
import br.edu.infnet.esports.model.domain.Game;
import br.edu.infnet.esports.model.service.DungeonsService;

@Component
@Order(2)
public class DungeonsLoader implements ApplicationRunner {

	@Autowired
	private DungeonsService dungeonsService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
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
					case "D": {
						game = new Dungeons(campos[1]);
						game.setTitulos(campos[2]);
						((Dungeons) game).setDano(campos[3]);
						((Dungeons) game).setSabedoria(campos[4]);
						((Dungeons) game).setVelocidade(campos[5]);
						game.setMediaEstatistica(game.calculaMediaEstatisticaGamer());
						game.setNivel(game.identificaNivelGamer());
						
						dungeonsService.incluir((Dungeons) game);
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