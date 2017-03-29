package br.com.caelum.projetocdc.teste;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Site;
import br.com.caelum.projetocdc.Tipo;

public class ListaAcervoInteiro {

	public static void main(String[] args) {

		Site site = new Site();

		//destaques
		Autor everton = new Autor("Everton Coimbra de Araújo");
		Livro l1 = new Livro("ASP.NET MVC5", "Crie aplicações Web na plataforma Microsoft", everton, Tipo.EBOOK, 29.90);
		Livro l1Copia = new Livro("ASP.NET MVC5", "Crie aplicações Web na plataforma Microsoft", everton, Tipo.EBOOK, 29.90);

		Autor willian = new Autor("Willian Molinari");
		Livro l2 = new Livro("Desconstruindo a Web", "As tecnologias por tráz de uma requisição", willian, Tipo.EBOOK,
				29.90);

		Autor jMM = new Autor("Jonathan Lamim, Matheus Marabesi, Michael Douglas");
		Livro l3 = new Livro("Coleção CodeIgniter + Zend PHP", "", jMM, Tipo.EBOOK, 49.90);
		
		
		//ultimos atualizados
		Autor alexandre = new Autor("Alexandre Lourenço");
		Livro l4 = new Livro("Elasticsearch", "Consumindo dados real-time com ELK", alexandre, 
				Tipo.EBOOK, 29.90);
		
		Autor gM = new Autor("Guilherme Silveira, Mário Amaral");
		Livro l5 = new Livro("Java SE 8 Programmer I", "O guia para sua certificação Oracle Certified Associate", 
				gM, Tipo.EBOOK, 29.90);
		
		Autor joaquim = new Autor("Joaquim Torres");
		Livro l6 = new Livro("Guia da Startup", "Como startups e empresas estabelecidas podem criar produtos de software rentáveis", 
				joaquim, Tipo.EBOOK, 29.90);
		
		Autor david = new Autor("David Paniz");
		Livro l7 = new Livro("NoSQL", "Como armazenar os dados de uma aplicação moderna", david, 
				Tipo.EBOOK, 29.90);
		
		Livro l8 = new Livro("Desconstruindo a Web", "As tecnologias por tráz de uma requisição", willian, 
				Tipo.EBOOK, 29.90);
		
		//ultimos lançamentos
		Autor vinicius = new Autor("Vinicius Carvalho");
		Livro l9 = new Livro("PostgreSQL", "Banco de dados para aplicações web modernas", vinicius
				, Tipo.EBOOK, 29.90);
		
		Autor ronaldo = new Autor("Ronaldo Braghittoni");
		Livro l10 = new Livro("Business Intelligence", "Implementar do jeito certo e a custo zero", 
				ronaldo, Tipo.EBOOK, 29.90);
		
		Autor rodrigo = new Autor("Rodrigo Ferreira");
		Livro l11 = new Livro("Segurança", "em aplicações Web", rodrigo,
				Tipo.EBOOK, 29.90);
		
		Autor rian = new Autor("Rian van der Merwe");
		Livro l12 = new Livro("Making it right", "Gestão de produtos no mundo das Startups", rian, 
				Tipo.EBOOK, 29.90);
		
		Autor guilherme = new Autor("Guilherme Silveira");
		Livro l13 = new Livro("Algoritmos em Java", "Busca, ordenação e análise", guilherme, 
				Tipo.EBOOK, 29.90);
		
		//mais alguns livros no acervo
		Livro l14 = new Livro("Xamarin forms", "Desenvolvimento de aplicações móveis multiplataforma",
				everton, Tipo.EBOOK, 29.90);
		
		Autor rosangela = new Autor("Rosangela Marquesone");
		Livro l15 = new Livro("Big Data", "Técnicas e tecnologias para extração de valor dos dados",
				rosangela, Tipo.EBOOK, 29.90);
		
		Autor paulo = new Autor("Paulo Siqueira");
		Livro l16 = new Livro("Scala", "Como escalar sua produtividade", paulo, Tipo.IMPRESSO, 29.90);
		
		Autor jonathanLamin = new Autor("Jonathan Lamin Antunes");
		Livro l17 = new Livro("Amazon AWS", "Descomplicando a computação na nuvem", jonathanLamin, 
				Tipo.EBOOK, 29.90);
		
		Autor walmyr = new Autor("Walmyr Filho");
		Livro l18 = new Livro("Protractor", "Lições sobre testes end-to-end automatizados", walmyr,
				Tipo.EBOOK, 29.90);
		
	}
}
