package br.com.caelum.projetocdc.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.projetocdc.CarrinhoDeCompras;
import br.com.caelum.projetocdc.Compra;
import br.com.caelum.projetocdc.GeradoraDeCompra;
import br.com.caelum.projetocdc.Item;
import br.com.caelum.projetocdc.ItemNoEstoque;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Usuario;
import br.com.caelum.projetocdc.dao.EstoqueBDDao;
import br.com.caelum.projetocdc.dao.LivroBDDao;
import br.com.caelum.projetocdc.dao.UsuarioBDDao;
import br.com.caelum.projetocdc.jdbc.ConnectionFactory;

public class TesteValidadorCompra {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		
		UsuarioBDDao uDao = new UsuarioBDDao(connection);
		Usuario usuario = uDao.getUsuario(1);
		
		LivroBDDao lDao = new LivroBDDao(connection);
		Livro guiaStartup = lDao.getLivro(2);
		Livro descAWeb = lDao.getLivro(3);
		
		EstoqueBDDao estoqueDao = new EstoqueBDDao(connection);
				
		ItemNoEstoque ine = estoqueDao.getItemNoEstoqueIdLivro(3);
		
		Compra compra = new Compra(usuario, Calendar.getInstance());
		Item item = new Item(descAWeb, 5);
		compra.adicionaItens(item);
		
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adiciona(item);
		
		GeradoraDeCompra geradoraDeCompra = new GeradoraDeCompra(estoqueDao);
		Compra compraDois = geradoraDeCompra.novaCompra(usuario, Calendar.getInstance(), carrinho);
		
		
		
		
		
	}
}
