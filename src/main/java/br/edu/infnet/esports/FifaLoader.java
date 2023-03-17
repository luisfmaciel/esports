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
import br.edu.infnet.esports.model.service.UsuarioService;

@Component
@Order(2)
public class FifaLoader implements ApplicationRunner {

	@Autowired
	private FifaService fifaService;
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

				Game game = null;				

				while (linha != null) {
					String[] campos = linha.split(";");
					
					switch (campos[0].toUpperCase()) {
					case "F": {
						game = new Fifa(campos[1]);
						game.setTitulos(campos[2]);
						((Fifa) game).setFinalizacao(campos[3]);
						((Fifa) game).setMarcacao(campos[4]);
						((Fifa) game).setPasse(campos[5]);
						game.setUsuario(usuarioService.obterUsuarioById(Integer.parseInt(campos[6])));
						game.setMediaEstatistica(game.calculaMediaEstatisticaGamer());
						game.setNivel(game.identificaNivelGamer());
						
						fifaService.incluir((Fifa) game);
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