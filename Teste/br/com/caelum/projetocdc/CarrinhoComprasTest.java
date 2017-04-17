package br.com.caelum.projetocdc;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class CarrinhoComprasTest {

	public Autor everton;
	public Autor willian;
	public Livro livroUm;
	public Livro livroDois;
	public Livro livroTres;
	public CarrinhoDeCompras carrinhoDeCompras;
	public Item itemUm;
	public Item itemDois;
	public Item itemTres;
	
	@Before
	public void setUp(){
		Calendar dataUltimaAtualizacao = Calendar.getInstance();
		dataUltimaAtualizacao.set(2017, 03, 01);
		
		Calendar dataLancamento = Calendar.getInstance();
		dataLancamento.set(2014, 02, 15);
		
		this.everton = new Autor("Everton Coimbra de Araújo");
		this.livroUm = new Livro("ASP.NET MVC5", "Crie aplicações Web na plataforma Microsoft", everton, Tipo.EBOOK, 30,
				dataUltimaAtualizacao, dataLancamento);

		this.willian = new Autor("Willian Molinari");
		this.livroDois = new Livro("Desconstruindo a Web", "As tecnologias por tráz de uma requisição", willian, Tipo.IMPRESSO, 70,
				dataUltimaAtualizacao, dataLancamento);
		
		this.livroTres = new Livro("Desconstruindo a Web", "As tecnologias por tráz de uma requisição", willian, Tipo.EBOOK, 30,
				dataUltimaAtualizacao, dataLancamento);
		
		this.itemUm = new Item(livroUm, 1);
		this.itemDois = new Item(livroDois, 2);
		this.itemTres = new Item(livroTres, 1);
		
		this.carrinhoDeCompras = new CarrinhoDeCompras();
	}
	
	@Test
	public void validaQuantidadeDeItensNoCarrinho(){
		carrinhoDeCompras.adiciona(itemUm);
		carrinhoDeCompras.adiciona(itemDois);
		carrinhoDeCompras.adiciona(itemTres);
		
		assertEquals(4, carrinhoDeCompras.getQuantidadeItens());
	}
	
	@Test
	public void validaValorTotalDoCarrinho(){
		carrinhoDeCompras.adiciona(itemUm);
		carrinhoDeCompras.adiciona(itemDois);
		carrinhoDeCompras.adiciona(itemTres);
		
		assertEquals(200, carrinhoDeCompras.getValorTotal(), 0.00001);
	}
	
	@Test
	public void verificaAtualizaQuantidadeDeUmItemNoCarrinho(){
		carrinhoDeCompras.adiciona(itemUm);
		
		assertEquals(1, carrinhoDeCompras.getQuantidadeDeUmItem(itemUm));
		
		carrinhoDeCompras.atualizarQuantidadeItem(itemUm, 2);
		
		assertEquals(2, carrinhoDeCompras.getQuantidadeDeUmItem(itemUm));
	}
	
	@Test
	public void verificaSeContemTodosOsItensAdicionadosNoCarrinho(){
		carrinhoDeCompras.adiciona(itemUm);
		carrinhoDeCompras.adiciona(itemDois);
		carrinhoDeCompras.adiciona(itemTres);
		
		assertTrue(carrinhoDeCompras.getItens().contains(itemUm));
		assertTrue(carrinhoDeCompras.getItens().contains(itemDois));
		assertTrue(carrinhoDeCompras.getItens().contains(itemTres));
	}
	
	@Test
	public void naoAdicionaItensEquals(){
		carrinhoDeCompras.adiciona(itemUm);
		carrinhoDeCompras.adiciona(itemUm);
		
		assertEquals(1, carrinhoDeCompras.getItens().size());
	}
}
