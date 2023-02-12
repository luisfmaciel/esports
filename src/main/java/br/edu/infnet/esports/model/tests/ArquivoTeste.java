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
import br.edu.infnet.esports.model.exceptions.NivelDiferenteException;
import br.edu.infnet.esports.model.exceptions.PlatformaDiferenteException;
import br.edu.infnet.esports.model.exceptions.ValorLimiteUltrapassadoException;

public class ArquivoTeste {

	public static void main(String[] args) {
		
		try {
			String arq = "equipes.txt";
			
			FileReader fileR;
			try {
				fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);
				
				FileWriter fileW = new FileWriter("out_"+arq);
				BufferedWriter escrita = new BufferedWriter(fileW);
				
				String linha = leitura.readLine();

				List<Gamer> gamers = new ArrayList<Gamer>();

				Equipe equipe = null;
				Gamer gamer = null;
				
				Game game = null;
		
				while(linha != null) {
					String[] campos = linha.split(";");
					
					switch (campos[0].toUpperCase()) {
					case "E": {
						for(Gamer g : gamers) {
							try {
								equipe = new Equipe(campos[1], Integer.valueOf(campos[2]), Boolean.valueOf(campos[3]), campos[4], new Fifa(Constante.PLATAFORMA_PS5));
								equipe.setGamers(g);
							} catch (ValorLimiteUltrapassadoException 
									| GameNaoEncontradoException 
									| EquipeCompletaException 
									| NivelDiferenteException 
									| PlatformaDiferenteException e) {
								System.out.println("[ERRO] " + e.getMessage());
							}
						}
						break;
					}
					case "F": {
						try {
							game = new Fifa(campos[2]);
							((Fifa) game).setFinalizacao(Float.valueOf(campos[4]));
							((Fifa) game).setMarcacao(Float.valueOf(campos[5]));
							((Fifa) game).setPasse(Float.valueOf(campos[6]));
							((Fifa) game).setTitulos(Integer.valueOf(campos[7]));
							game.setMediaEstatistica(game.calculaMediaEstatisticaGamer());
							game.setNivel(game.identificaNivelGamer());
						} catch (ValorLimiteUltrapassadoException e) {
							System.out.println("[ERRO] " + e.getMessage());
						}
						break;
					}
					case "D": {
						try {
							game = new Dungeons(campos[2]);
							((Dungeons) game).setDano(Float.valueOf(campos[4]));
							((Dungeons) game).setSabedoria(Float.valueOf(campos[5]));
							((Dungeons) game).setVelocidade(Float.valueOf(campos[6]));
							((Dungeons) game).setTitulos(Integer.valueOf(campos[7]));
							game.setMediaEstatistica(game.calculaMediaEstatisticaGamer());
							game.setNivel(game.identificaNivelGamer());
						} catch (ValorLimiteUltrapassadoException e) {
							System.out.println("[ERRO] " + e.getMessage());
						}
						break;
					}
					case "C": {
						try {
							game = new CsGo(campos[2]);
							((CsGo) game).setPrecisao(Float.valueOf(campos[4]));
							((CsGo) game).setAgressividade(Float.valueOf(campos[5]));
							((CsGo) game).setTatica(Float.valueOf(campos[6]));
							((CsGo) game).setTitulos(Integer.valueOf(campos[7]));
							game.setMediaEstatistica(game.calculaMediaEstatisticaGamer());
							game.setNivel(game.identificaNivelGamer());
						} catch (ValorLimiteUltrapassadoException e) {
							System.out.println("[ERRO] " + e.getMessage());
						}
						break;
					}
					case "G": {
						try {
							List<Game> meusGames = new ArrayList<Game>();
							meusGames.add(game);
							
							gamer = new Gamer(campos[1], campos[2], campos[3], meusGames);
							gamers.add(gamer);
						} catch (NumberFormatException | EmailInvalidoException e) {
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
		} finally {
			System.out.println("Processamento finalizado!");
		}
		
	}
}
