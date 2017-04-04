package br.com.caelum.projetocdc.teste;

import java.util.Calendar;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Site;
import br.com.caelum.projetocdc.Tipo;

public class TestaUltimosLancamentos {

	public static void main(String[] args) {
		Site site = new Site();
		
		Calendar dataUltimaAtualizacao = Calendar.getInstance();
		dataUltimaAtualizacao.set(2017, 03, 01);
		
		Calendar dataLancamento = Calendar.getInstance();
		dataLancamento.set(2014, 02, 15);
		
		Autor everton = new Autor("Everton Coimbra de Araújo");
		Livro l1 = new Livro("ASP.NET MVC5", "Crie aplicações Web na plataforma Microsoft", everton, Tipo.EBOOK, 29.90, dataUltimaAtualizacao, dataLancamento);
		site.inclui(l1);
		
		Autor willian = new Autor("Willian Molinari");
		Livro l2 = new Livro("Desconstruindo a Web", "As tecnologias por tráz de uma requisição", willian, Tipo.EBOOK,
				29.90, dataUltimaAtualizacao, dataLancamento);
		site.inclui(l2);

		Autor jMM = new Autor("Jonathan Lamim, Matheus Marabesi, Michael Douglas");
		Livro l3 = new Livro("Coleção CodeIgniter + Zend PHP", "", jMM, Tipo.EBOOK, 49.90, dataUltimaAtualizacao, dataLancamento);
		site.inclui(l3);
		
		//ultimos atualizados
		Autor alexandre = new Autor("Alexandre Lourenço");
		Livro l4 = new Livro("Elasticsearch", "Consumindo dados real-time com ELK", alexandre, 
				Tipo.EBOOK, 29.90, dataUltimaAtualizacao, dataLancamento);
		site.inclui(l4);
		
		Autor gM = new Autor("Guilherme Silveira, Mário Amaral");
		Livro l5 = new Livro("Java SE 8 Programmer I", "O guia para sua certificação Oracle Certified Associate", 
				gM, Tipo.EBOOK, 29.90, dataUltimaAtualizacao, dataLancamento);
		site.inclui(l5);
		
		Autor joaquim = new Autor("Joaquim Torres");
		Livro l6 = new Livro("Guia da Startup", "Como startups e empresas estabelecidas podem criar produtos de software rentáveis", 
				joaquim, Tipo.EBOOK, 29.90, dataUltimaAtualizacao, dataLancamento);
		site.inclui(l6);
		
		//site.imprimeTodosOsLivros();
		System.out.println("Ultimos Lançamentos\n==========");
		site.listaUltimosLancamentos().forEach(livro -> {
			System.out.println(livro.livroTituloDataLancamento());
		});;
		System.out.println("==========\nUltimos Atualizados\n===========");
		site.listaUltimasAtualizacoes().forEach(livro -> {
			System.out.println(livro.livroTituloDataUltimaAtualizacao());
		});
		System.out.println("==========\nDestaques\n=============");
		site.listaDestaques().forEach(livro -> {
			System.out.println(livro.livroDestaqueTituloDataLancamento());
		});
		
		
	}

}
