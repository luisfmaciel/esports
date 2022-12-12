package br.edu.infnet.esports.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.esports.model.auxiliar.Constante;
import br.edu.infnet.esports.model.domain.CsGo;
import br.edu.infnet.esports.model.domain.Dungeons;
import br.edu.infnet.esports.model.domain.Equipe;
import br.edu.infnet.esports.model.domain.Fifa;
import br.edu.infnet.esports.model.domain.Game;
import br.edu.infnet.esports.model.domain.Gamer;
import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;
import br.edu.infnet.esports.model.exceptions.EquipeCompletaException;
import br.edu.infnet.esports.model.exceptions.GameNaoEncontradoException;
import br.edu.infnet.esports.model.exceptions.NivelDiferenteNivelException;
import br.edu.infnet.esports.model.exceptions.PlatformaDiferenteException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

public class ArquivoTeste {

	public static void main(String[] args) {
		String arq = "equipes.txt";
			
		FileReader fileR;
		try {
			fileR = new FileReader(arq);
			BufferedReader leitura = new BufferedReader(fileR);
			
			FileWriter fileW = new FileWriter("out_"+arq);
			BufferedWriter escrita = new BufferedWriter(fileW);
			
			String linha = leitura.readLine();
			System.out.println(linha);
			
			
			List<Game> meusGames = new ArrayList<Game>();
			List<Gamer> gamers = new ArrayList<Gamer>();
		
//			meusGames.add(new Fifa(Constante.PLATAFORMA_PS5));
//			meusGames.add(new CsGo(Constante.PLATAFORMA_PC));
//			meusGames.add(new Dungeons(Constante.PLATAFORMA_PS5));
			
			Equipe equipe = null;
			Gamer gamer = null;
			Fifa fifa = null;
			
			while(linha != null) {
				String[] campos = linha.split(";");
				switch (campos[0].toUpperCase()) {
				case "E": {
					try {
						equipe = new Equipe(campos[1], Integer.valueOf(campos[2]), Boolean.valueOf(campos[3]), campos[4], fifa);
						equipe.setGamers(gamers);
					} catch (ValorLimiteUltrapassadoException 
							| GameNaoEncontradoException 
							| EquipeCompletaException 
							| NivelDiferenteNivelException 
							| PlatformaDiferenteException e) {
						System.out.println("[ERRO] " + e.getMessage());
					}
					break;
				}
				case "F": {
					try {
						fifa = new Fifa(campos[2]);
						fifa.setFinalizacao(Float.valueOf(campos[5]));
						fifa.setMarcacao(Float.valueOf(campos[6]));
						fifa.setPasse(Float.valueOf(campos[7]));
						fifa.setNivel(fifa.calculaNivelGamer(gamer.getTitulos()));
						fifa.setMediaEstatistica(Float.valueOf(campos[4]));
						
						meusGames.add(fifa);
					} catch (ValorLimiteUltrapassadoException e) {
						System.out.println("[ERRO] " + e.getMessage());
					}
					break;
				}
				case "C": {
					break;
				}
				case "D": {
					break;
				}
				case "G": {
					try {
						gamer = new Gamer(campos[1], campos[2], Integer.valueOf(campos[3]), meusGames);
						gamers.add(gamer);
					} catch (NumberFormatException | ValorLimiteUltrapassadoException | EmailInvalidoException e) {
						System.out.println("[ERRO] " + e.getMessage());
					} 
					break;
				}
				default:
					break;
				}
				linha = leitura.readLine();
			}
			
			escrita.write(equipe.obterLinha());
			escrita.close();
			leitura.close();
			fileR.close();
		} catch (IOException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}
