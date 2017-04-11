package br.com.caelum.projetocdc.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.projetocdc.Compra;
import br.com.caelum.projetocdc.Item;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Usuario;
import br.com.caelum.projetocdc.dao.CompraBDDao;
import br.com.caelum.projetocdc.dao.LivroBDDao;
import br.com.caelum.projetocdc.dao.UsuarioBDDao;
import br.com.caelum.projetocdc.jdbc.ConnectionFactory;

public class TesteCompraBDDao {

	public static void main(String[] args) {
		
		Connection connection = new ConnectionFactory().getConnection();
		
		UsuarioBDDao uDao = new UsuarioBDDao(connection);
		Usuario usuario = uDao.getUsuario(1);
		
		LivroBDDao lDao = new LivroBDDao(connection);
		Livro guiaStartup = lDao.getLivro(2);
		Livro descAWeb = lDao.getLivro(3);
		
		Item item1 = new Item(guiaStartup, 2);
		Item item2 = new Item(descAWeb, 1);
		
		Calendar dataHoje = Calendar.getInstance();
		
		Compra compra = new Compra(usuario, dataHoje);
		compra.adicionaItens(item1);
		compra.adicionaItens(item2);
		
		CompraBDDao cDao = new CompraBDDao(connection);
		//cDao.adiciona(compra);
		
		System.out.println(cDao.getCompra(6));
		
		try {
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
