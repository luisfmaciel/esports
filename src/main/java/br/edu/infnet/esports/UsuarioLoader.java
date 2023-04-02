package br.edu.infnet.esports;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.esports.model.domain.Endereco;
import br.edu.infnet.esports.model.domain.Usuario;
import br.edu.infnet.esports.model.service.EnderecoService;
import br.edu.infnet.esports.model.service.UsuarioService;

@Component
@Order(1)
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private EnderecoService enderecoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			String arq = "massa.txt";

			FileReader fileR;
			try {
				fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);
				String linha = leitura.readLine();

				Usuario usuario = null;			

				while (linha != null) {
					String[] campos = linha.split(";");
					
					switch (campos[0].toUpperCase()) {
					case "U": {
						usuario = new Usuario();
						usuario.setNome(campos[1]);
						usuario.setEmail(campos[2]);
						usuario.setSenha(campos[3]);
						usuario.setPerfil(campos[4]);
						usuario.setAdmin(Boolean.parseBoolean(campos[5]));

						Endereco endereco = enderecoService.buscaPorCep(campos[6]);
						usuario.setEndereco(endereco);
						
						usuarioService.incluir(usuario);
						System.out.println("Inclusão do usuário @" + usuario.getUsername() + " realizada com sucesso!");
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
