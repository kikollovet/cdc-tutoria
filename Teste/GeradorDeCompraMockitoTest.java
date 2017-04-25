import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Properties;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.CarrinhoDeCompras;
import br.com.caelum.projetocdc.Compra;
import br.com.caelum.projetocdc.GeradoraDeCompra;
import br.com.caelum.projetocdc.Item;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Tipo;
import br.com.caelum.projetocdc.Usuario;
import br.com.caelum.projetocdc.VerificadorDeEstoque;
import br.com.caelum.projetocdc.VerificadorDeEstoqueMock;
import br.com.caelum.projetocdc.dao.EstoqueBDDao;
import br.com.caelum.projetocdc.dao.EstoqueDaoDeMentira;
import br.com.caelum.projetocdc.dao.LivroBDDao;
import br.com.caelum.projetocdc.dao.UsuarioBDDao;
import br.com.caelum.projetocdc.exception.QuantidadeInsuficienteNoEstoqueException;

public class GeradorDeCompraMockitoTest {

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
	
	@Mock
	VerificadorDeEstoque verificadorDeEstoqueMock;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		this.geradoraDeCompra = new GeradoraDeCompra(verificadorDeEstoqueMock);
		
		this.usuario = new Usuario("Fernando", "fernando.furtado@caelum.com.br");
		
		this.guiaStartup = new Livro("Guia de Startup", "Bla", new Autor("Luis"), Tipo.EBOOK, 10.00);
		this.descAWeb = new Livro("Guia de Startup", "Bla", new Autor("Luis"), Tipo.IMPRESSO, 10.00);
		descAWeb.setId(1);
		this.java = new Livro("Java", "Mais e mais", new Autor("Luis"), Tipo.IMPRESSO, 20.00);
		java.setId(2);
		
		this.estoqueDao = new EstoqueBDDao(connection);
				
		this.carrinhoDeCompras = new CarrinhoDeCompras();
	}
	
	@Test
	public void qualquerQuantidadeDeEbookEhPermitidaNumaCompra(){
		GeradoraDeCompra geradora = new GeradoraDeCompra(verificadorDeEstoqueMock);
		
		Item item = new Item(guiaStartup, 50);
		carrinhoDeCompras.adiciona(item);
		Mockito.when(verificadorDeEstoqueMock.verificaTemNoEstoque(item)).thenReturn(true);
		Compra compra = geradoraDeCompra.novaCompra(usuario, Calendar.getInstance(), carrinhoDeCompras);
		
		assertEquals(1, compra.getItens().size());
	}
	
	@Test
	public void quantidadeInsuficienteDeUmLivroNoEstoqueNaoEhAdicionadoACompra(){
		Item item = new Item(descAWeb, 7);
		carrinhoDeCompras.adiciona(item);
		Mockito.when(verificadorDeEstoqueMock.verificaTemNoEstoque(item)).thenReturn(false);
		Compra compra = geradoraDeCompra.novaCompra(usuario, Calendar.getInstance(), carrinhoDeCompras);
		
		assertEquals(0, compra.getItens().size());
	}
	
	@Test
	public void quantidadeSuficienteDeUmLivroNoEstoqueEhAdicionadoACompra(){
		Item item = new Item(descAWeb, 3);
		carrinhoDeCompras.adiciona(item);
		Mockito.when(verificadorDeEstoqueMock.verificaTemNoEstoque(item)).thenReturn(true);
		Compra compra = geradoraDeCompra.novaCompra(usuario, Calendar.getInstance(), carrinhoDeCompras);
		
		assertEquals(1, compra.getItens().size());
	}
	
	@Test(expected = QuantidadeInsuficienteNoEstoqueException.class)
	public void quantidadeInsuficienteNoEstoque(){
		Item item = new Item(descAWeb, 7);
		carrinhoDeCompras.adiciona(item);
		Mockito.when(verificadorDeEstoqueMock.verificaTemNoEstoque(item)).thenThrow(new QuantidadeInsuficienteNoEstoqueException());
		
		Compra compra = geradoraDeCompra.novaCompra(usuario, Calendar.getInstance(), carrinhoDeCompras);
	}

}
