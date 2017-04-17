package br.com.caelum.projetocdc;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {

	@Before
	public void setUp(){
		
	}
	
	@Test
	public void validaSePrecoTotalEhCalculadoCertoAPartirDaQuantidade(){
		Calendar dataUltimaAtualizacao = Calendar.getInstance();
		dataUltimaAtualizacao.set(2017, 03, 01);
		
		Calendar dataLancamento = Calendar.getInstance();
		dataLancamento.set(2014, 02, 15);
		
		Autor everton = new Autor("Everton Coimbra de Araújo");
		Livro livroUm = new Livro("ASP.NET MVC5", "Crie aplicações Web na plataforma Microsoft", everton, Tipo.EBOOK, 30,
				dataUltimaAtualizacao, dataLancamento);
		
		Item item = new Item(livroUm, 2);
		
		assertEquals(60, item.getPrecoTotal(), 0.00001);
	}
	
	@Test
	public void validaSePrecoTotalMudaQuandoQuantidadeDeLivrosEhAlterada(){
		Calendar dataUltimaAtualizacao = Calendar.getInstance();
		dataUltimaAtualizacao.set(2017, 03, 01);
		
		Calendar dataLancamento = Calendar.getInstance();
		dataLancamento.set(2014, 02, 15);
		
		Autor everton = new Autor("Everton Coimbra de Araújo");
		Livro livroUm = new Livro("ASP.NET MVC5", "Crie aplicações Web na plataforma Microsoft", everton, Tipo.EBOOK, 30,
				dataUltimaAtualizacao, dataLancamento);
		
		Item item = new Item(livroUm, 2);
		
		assertEquals(60, item.getPrecoTotal(), 0.00001);
		
		item.setQuantidade(3);
		
		assertEquals(90, item.getPrecoTotal(), 0.00001);
	}
	
	@Test
	public void validaSeMudandoPrecoUnitarioAlteraOValorDoPrecoTotal(){
		Calendar dataUltimaAtualizacao = Calendar.getInstance();
		dataUltimaAtualizacao.set(2017, 03, 01);
		
		Calendar dataLancamento = Calendar.getInstance();
		dataLancamento.set(2014, 02, 15);
		
		Autor everton = new Autor("Everton Coimbra de Araújo");
		Livro livroUm = new Livro("ASP.NET MVC5", "Crie aplicações Web na plataforma Microsoft", everton, Tipo.EBOOK, 30,
				dataUltimaAtualizacao, dataLancamento);
		
		Item item = new Item(livroUm, 2);
		
		assertEquals(60, item.getPrecoTotal(), 0.00001);
		
		item.setPrecoUnitario(20);
		
		assertEquals(40, item.getPrecoTotal(), 0.00001);
	}
}
