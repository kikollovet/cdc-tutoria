package br.com.caelum.projetocdc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.dao.AutorBDDao;
import br.com.caelum.projetocdc.jdbc.ConnectionFactory;

public class TestaAutorDAO {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		
		Autor autor = new Autor("Pedro Albuquerque");
		autor.setId(2);
		
		AutorBDDao dao = new AutorBDDao(connection); 
		//dao.adiciona(autor);
		
		System.out.println("adicionado");
		//dao.altera(autor);
		
		System.out.println(dao.getAutor(2));
		
		//dao.remove(9);
	}
}
