package br.com.caelum.projetocdc.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Tipo;
import br.com.caelum.projetocdc.dao.AutorBDDao;
import br.com.caelum.projetocdc.dao.LivroBDDao;
import br.com.caelum.projetocdc.jdbc.ConnectionFactory;

public class TestaLivroDAO {

	public static void main(String[] args) {

		Connection connection = new ConnectionFactory().getConnection();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cdc");
		
		EntityManager manager = factory.createEntityManager();
		
		AutorBDDao daoAutor = new AutorBDDao(manager);
		Autor willian = daoAutor.getAutor(6);
		
		
		Calendar dataUltimaAtualizacao = Calendar.getInstance();
		dataUltimaAtualizacao.set(2017, 03, 01);
		
		Calendar dataLancamento = Calendar.getInstance();
		dataLancamento.set(2014, 02, 15);
		
		
		Livro livro = new Livro("Desconstruindo a Web", "As tecnologias por tr�z de uma requisi��o", 
				willian, Tipo.IMPRESSO, 59.90, dataUltimaAtualizacao, dataLancamento);
		//livro.setId(1);
		
		LivroBDDao dao = new LivroBDDao(connection);
		//dao.adiciona(livro, connection);
		//dao.altera(livro, connection);
		System.out.println(dao.getLivro(3));
		//dao.remove(1, connection);
		
		try {
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
