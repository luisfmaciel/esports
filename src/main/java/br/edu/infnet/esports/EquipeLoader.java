package br.edu.infnet.esports;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.esports.model.domain.Equipe;
import br.edu.infnet.esports.model.service.EquipeService;
import br.edu.infnet.esports.model.service.GameService;
import br.edu.infnet.esports.model.service.GamerService;

@Component
@Order(4)
public class EquipeLoader implements ApplicationRunner {

	@Autowired
	private EquipeService equipeService;
	@Autowired
	private GamerService gamerService;
	@Autowired
	private GameService gameService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			String arq = "massa.txt";

			FileReader fileR;
			try {
				fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);
				String linha = leitura.readLine();

				while (linha != null) {
					String[] campos = linha.split(";");
					
					switch (campos[0].toUpperCase()) {
					case "E": {
						Equipe equipe = new Equipe();
						equipe.setNome(campos[1]);
						equipe.setLimiteParticipantes(campos[2]);
						equipe.setMultiPlataforma(Boolean.parseBoolean(campos[3]));
						equipe.setNivel(campos[4]);
						equipe.setGame(gameService.obterGameById(Integer.parseInt(campos[5])));
						for(String id : campos[6].split(",")) {
							equipe.setGamers(gamerService.obterGamerById(Integer.parseInt(id)));							
						}
						equipe.setPlataforma(campos[7]);
						
						equipeService.incluir(equipe);
						System.out.println("Inclusão da equipe " + equipe.getNome() + " realizada com sucesso!");
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
	
		System.out.println("Inclusão da equipe realizada com sucesso!");
	}
}