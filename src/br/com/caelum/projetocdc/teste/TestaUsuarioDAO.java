package br.com.caelum.projetocdc.teste;

import br.com.caelum.projetocdc.Usuario;
import br.com.caelum.projetocdc.dao.UsuarioBDDao;

public class TestaUsuarioDAO {

	public static void main(String[] args) {

		Usuario usuario = new Usuario("Joao Almeida", "joao.almeida@email.com");
		usuario.setId(1);
		UsuarioBDDao dao = new UsuarioBDDao();
		//dao.adiciona(usuario);
		//dao.altera(usuario);
	}

}
