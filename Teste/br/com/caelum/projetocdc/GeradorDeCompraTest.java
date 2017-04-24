package br.com.caelum.projetocdc;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.projetocdc.dao.EstoqueBDDao;
import br.com.caelum.projetocdc.dao.EstoqueDaoDeMentira;
import br.com.caelum.projetocdc.dao.LivroBDDao;
import br.com.caelum.projetocdc.dao.UsuarioBDDao;
import br.com.caelum.projetocdc.exception.QuantidadeInsuficienteNoEstoqueException;
import br.com.caelum.projetocdc.jdbc.ConnectionFactory;

public class GeradorDeCompraTest {

	public Connection connection;
	public UsuarioBDDao usuarioDao;
	public Usuario usuario;
	public LivroBDDao livroDao;
	public Livro guiaStartup;
	public Livro descAWeb;
	public Livro java;
	public EstoqueBDDao estoqueDao;
	public CarrinhoDeCompras carrinhoDeCompras;
	public VerificadorDeEstoque verificadorDeEstoque;
	public GeradoraDeCompra geradoraDeCompra;
	
	@Before
	public void setUp(){
		
		this.usuario = new Usuario("Fernando", "fernando.furtado@caelum.com.br");
		
		this.guiaStartup = new Livro("Guia de Startup", "Bla", new Autor("Luis"), Tipo.EBOOK, 10.00);
		this.descAWeb = new Livro("Guia de Startup", "Bla", new Autor("Luis"), Tipo.IMPRESSO, 10.00);
		descAWeb.setId(1);
		this.java = new Livro("Java", "Mais e mais", new Autor("Luis"), Tipo.IMPRESSO, 20.00);
		java.setId(2);
		
		
		this.estoqueDao = new EstoqueDaoDeMentira();
				
		this.carrinhoDeCompras = new CarrinhoDeCompras();
		//carrinho.adiciona(item);
		
		this.verificadorDeEstoque = new VerificadorDeEstoque(estoqueDao);
		
		this.geradoraDeCompra = new GeradoraDeCompra(verificadorDeEstoque);
		//Compra compraDois = geradoraDeCompra.novaCompra(usuario, Calendar.getInstance(), carrinho);
	}
	
	@Test
	public void qualquerQuantidadeDeEbookEhPermitidaNumaCompra(){
		Item item = new Item(guiaStartup, 50);
		carrinhoDeCompras.adiciona(item);
		Compra compra = geradoraDeCompra.novaCompra(usuario, Calendar.getInstance(), carrinhoDeCompras);
		
		assertEquals(1, compra.getItens().size());
	}
	
	@Test
	public void quantidadeSuficienteDeUmLivroNoEstoqueEhAdicionadoACompra(){
		Item item = new Item(descAWeb, 3);
		carrinhoDeCompras.adiciona(item);
		Compra compra = geradoraDeCompra.novaCompra(usuario, Calendar.getInstance(), carrinhoDeCompras);
		
		assertEquals(1, compra.getItens().size());
	}
	
	@Test(expected = QuantidadeInsuficienteNoEstoqueException.class)
	public void quantidadeInsuficienteNoEstoque(){
		Item item = new Item(java, 5);
		carrinhoDeCompras.adiciona(item);
		geradoraDeCompra.novaCompra(usuario, Calendar.getInstance(), carrinhoDeCompras);
				
	}
}
