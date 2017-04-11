package br.com.caelum.projetocdc.teste;

import java.sql.Connection;

import br.com.caelum.projetocdc.Usuario;
import br.com.caelum.projetocdc.dao.UsuarioBDDao;
import br.com.caelum.projetocdc.jdbc.ConnectionFactory;

public class TestaUsuarioDAO {

	public static void main(String[] args) {

		Connection connection = new ConnectionFactory().getConnection();
		
		Usuario usuario = new Usuario("Pedro Luis", "pedro.luis@email.com");
		usuario.setId(1);
		UsuarioBDDao dao = new UsuarioBDDao(connection);
		//dao.adiciona(usuario);
		//dao.altera(usuario);
		System.out.println(dao.getUsuario(1));
		//dao.remove(2);
		
	}

}
