package br.com.caelum.projetocdc;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class SiteTest {

	public Livro l1;
	public Livro l2;
	public Livro l3;
	public Livro l4;
	public Livro l5;
	public Livro l6;
	public Site site;
	public Autor everton;
	public Autor willian;
	public Autor jMM;
	public Autor alexandre;
	public Autor gM;
	public Autor joaquim;
	
	@Before
	public void setUp(){
		this.site = new Site();
		
		Calendar dataUltimaAtualizacao = Calendar.getInstance();
		dataUltimaAtualizacao.set(2017, 03, 01);
		
		Calendar dataLancamento = Calendar.getInstance();
		dataLancamento.set(2014, 02, 15);
		
		this.everton = new Autor("Everton Coimbra de Araújo");
		this.l1 = new Livro("ASP.NET MVC5", "Crie aplicações Web na plataforma Microsoft", everton, Tipo.EBOOK, 29.90, dataUltimaAtualizacao, dataLancamento);
		
		Calendar dataLancamentoDois = Calendar.getInstance();
		dataLancamentoDois.set(2015, 02, 15);
		
		Calendar dataUltimaAtualizacaoDois = Calendar.getInstance();
		dataUltimaAtualizacaoDois.set(2017, 03, 04);
		
		this.willian = new Autor("Willian Molinari");
		this.l2 = new Livro("Desconstruindo a Web", "As tecnologias por tráz de uma requisição", willian, Tipo.EBOOK,
				29.90, dataUltimaAtualizacaoDois, dataLancamentoDois);

		this.jMM = new Autor("Jonathan Lamim, Matheus Marabesi, Michael Douglas");
		this.l3 = new Livro("Coleção CodeIgniter + Zend PHP", "", jMM, Tipo.EBOOK, 49.90, dataUltimaAtualizacaoDois, dataLancamentoDois);
		
		this.alexandre = new Autor("Alexandre Lourenço");
		this.l4 = new Livro("Elasticsearch", "Consumindo dados real-time com ELK", alexandre, 
				Tipo.EBOOK, 29.90, dataUltimaAtualizacaoDois, dataLancamentoDois);
		
		this.gM = new Autor("Guilherme Silveira, Mário Amaral");
		this.l5 = new Livro("Java SE 8 Programmer I", "O guia para sua certificação Oracle Certified Associate", 
				gM, Tipo.EBOOK, 29.90, dataUltimaAtualizacaoDois, dataLancamentoDois);
		
		this.joaquim = new Autor("Joaquim Torres");
		this.l6 = new Livro("Guia da Startup", "Como startups e empresas estabelecidas podem criar produtos de software rentáveis", 
				joaquim, Tipo.EBOOK, 29.90, dataUltimaAtualizacaoDois, dataLancamentoDois);

	}
	
	@Test
	public void naoAceitaLivrosIguaisNoMetodoInclui(){
		Livro l1Copia = new Livro("ASP.NET MVC5", "Crie aplicações Web na plataforma Microsoft", everton, Tipo.EBOOK, 29.90);

		site.inclui(l1);
		site.inclui(l1Copia);
		
		assertEquals(1, site.getLivros().size());
	}

	@Test
	public void listaUltimosLancamentosSoRetornaOsCincoLivrosAdicionadosComDataMaisRecente(){
		site.inclui(l1);
		site.inclui(l2);
		site.inclui(l3);
		site.inclui(l4);
		site.inclui(l5);
		site.inclui(l6);
		
		assertEquals(5, site.listaUltimosLancamentos().size());
		assertFalse(site.listaUltimosLancamentos().contains(l1));
		assertTrue(site.listaUltimosLancamentos().contains(l2));
		assertTrue(site.listaUltimosLancamentos().contains(l3));
		assertTrue(site.listaUltimosLancamentos().contains(l4));
		assertTrue(site.listaUltimosLancamentos().contains(l5));
		assertTrue(site.listaUltimosLancamentos().contains(l6));
	}
	
	@Test
	public void listaUltimasAtualizacosSohContemOs5UltimosLivrosAtualizadosMaisRecentes(){
		site.inclui(l1);
		site.inclui(l2);
		site.inclui(l3);
		site.inclui(l4);
		site.inclui(l5);
		site.inclui(l6);
		
		assertEquals(5, site.listaUltimasAtualizacoes().size());
		assertFalse(site.listaUltimasAtualizacoes().contains(l1));
		assertTrue(site.listaUltimasAtualizacoes().contains(l2));
		assertTrue(site.listaUltimasAtualizacoes().contains(l3));
		assertTrue(site.listaUltimasAtualizacoes().contains(l4));
		assertTrue(site.listaUltimasAtualizacoes().contains(l5));
		assertTrue(site.listaUltimasAtualizacoes().contains(l6));
	}
	
	@Test
	public void listaDestaquesSohRetornaOsTresLivrosComDataLancamentoMaisRecente(){
		site.inclui(l1);
		site.inclui(l2);
		site.inclui(l3);
		site.inclui(l4);

		assertEquals(3, site.listaDestaques().size());
		assertFalse(site.listaDestaques().contains(l1));
		assertTrue(site.listaDestaques().contains(l2));
		assertTrue(site.listaDestaques().contains(l3));
		assertTrue(site.listaDestaques().contains(l4));
	}
}
