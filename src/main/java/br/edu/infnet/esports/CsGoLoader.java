package br.edu.infnet.esports;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.esports.model.domain.CsGo;
import br.edu.infnet.esports.model.domain.Game;
import br.edu.infnet.esports.model.service.CsGoService;
import br.edu.infnet.esports.model.service.UsuarioService;

@Component
@Order(2)
public class CsGoLoader implements ApplicationRunner {

	@Autowired
	private CsGoService csgoService;
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
					case "C": {
						game = new CsGo(campos[1]);
						game.setTitulos(campos[2]);
						((CsGo) game).setPrecisao(campos[3]);
						((CsGo) game).setAgressividade(campos[4]);
						((CsGo) game).setTatica(campos[5]);
						game.setUsuario(usuarioService.obterUsuarioById(Integer.parseInt(campos[6])));
						game.setMediaEstatistica(game.calculaMediaEstatisticaGamer());
						game.setNivel(game.identificaNivelGamer());
						
						csgoService.incluir((CsGo) game);
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