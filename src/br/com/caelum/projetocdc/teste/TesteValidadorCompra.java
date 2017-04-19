package br.com.caelum.projetocdc.teste;

import java.sql.Connection;
import java.util.Calendar;

import br.com.caelum.projetocdc.Compra;
import br.com.caelum.projetocdc.Item;
import br.com.caelum.projetocdc.ItemNoEstoque;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Usuario;
import br.com.caelum.projetocdc.ValidadorCompra;
import br.com.caelum.projetocdc.dao.EstoqueBDDao;
import br.com.caelum.projetocdc.dao.LivroBDDao;
import br.com.caelum.projetocdc.dao.UsuarioBDDao;
import br.com.caelum.projetocdc.jdbc.ConnectionFactory;

public class TesteValidadorCompra {

	public static void main(String[] args) {
		Connection connection = new ConnectionFactory().getConnection();
		
		UsuarioBDDao uDao = new UsuarioBDDao(connection);
		Usuario usuario = uDao.getUsuario(1);
		
		LivroBDDao lDao = new LivroBDDao(connection);
		Livro guiaStartup = lDao.getLivro(2);
		Livro descAWeb = lDao.getLivro(3);
		
		EstoqueBDDao eDao = new EstoqueBDDao(connection);
				
		ItemNoEstoque ine = eDao.getItemNoEstoqueIdLivro(3);
		
		Compra compra = new Compra(usuario, Calendar.getInstance());
		Item item = new Item(descAWeb, 4);
		compra.adicionaItens(item);
		
		ValidadorCompra vC = new ValidadorCompra();
		//vC.validaCompra(compra, ine);
		vC.validaCompraDois(compra, connection);
		
	}
}
