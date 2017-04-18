package br.com.caelum.projetocdc.teste;

import java.sql.Connection;

import br.com.caelum.projetocdc.ItemNoEstoque;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Usuario;
import br.com.caelum.projetocdc.dao.EstoqueBDDao;
import br.com.caelum.projetocdc.dao.LivroBDDao;
import br.com.caelum.projetocdc.dao.UsuarioBDDao;
import br.com.caelum.projetocdc.jdbc.ConnectionFactory;

public class TesteEstoqueBDDao {

	public static void main(String[] args) {
		Connection connection = new ConnectionFactory().getConnection();
		
		UsuarioBDDao uDao = new UsuarioBDDao(connection);
		Usuario usuario = uDao.getUsuario(1);
		
		LivroBDDao lDao = new LivroBDDao(connection);
		Livro guiaStartup = lDao.getLivro(2);
		Livro descAWeb = lDao.getLivro(3);
		
		ItemNoEstoque ine = new ItemNoEstoque(descAWeb, 3);
		ine.setId(2);
		
		EstoqueBDDao eDao = new EstoqueBDDao(connection);
		//eDao.adiciona(ine);
		//eDao.diminuiQuantidade(ine, 3);
		eDao.aumentaQuantidade(ine, 4);
	}
}
