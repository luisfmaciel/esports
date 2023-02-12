package br.edu.infnet.esports.model.repository;

import br.edu.infnet.esports.model.domain.Gamer;
import br.edu.infnet.esports.model.exceptions.EmailInvalidoException;

public class AcessoRepository {
	
	public static Gamer autenticar(Gamer gamer) throws EmailInvalidoException {
		if(gamer.getEmail().equalsIgnoreCase(gamer.getSenha())) {
			return new Gamer(gamer.getNome(), gamer.getEmail(), gamer.getSenha());
		}
		return null;
	}
}
