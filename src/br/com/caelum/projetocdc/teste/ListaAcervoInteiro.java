package br.com.caelum.projetocdc.teste;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Site;

public class ListaAcervoInteiro {

	public static void main(String[] args) {

		Site site = new Site();

		//destaques
		Autor everton = new Autor("Everton Coimbra de Araújo");
		Livro l1 = new Livro("ASP.NET MVC5", "Crie aplicações Web na plataforma Microsoft", everton, 69.90, 29.90);
		Livro l1Copia = new Livro("ASP.NET MVC5", "Crie aplicações Web na plataforma Microsoft", everton, 69.90, 29.90);
		site.adicionaDestaques(l1);
		site.adicionaDestaques(l1Copia);
		site.adicionaTodosOsLivros(l1);

		Autor willian = new Autor("Willian Molinari");
		Livro l2 = new Livro("Desconstruindo a Web", "As tecnologias por tráz de uma requisição", willian, 69.90,
				29.90);
		site.adicionaDestaques(l2);
		site.adicionaTodosOsLivros(l2);

		Autor jMM = new Autor("Jonathan Lamim, Matheus Marabesi, Michael Douglas");
		Livro l3 = new Livro("Coleção CodeIgniter + Zend PHP", "", jMM, 0.00, 49.90);
		site.adicionaDestaques(l3);
		site.adicionaTodosOsLivros(l3);
		
		
		//ultimos atualizados
		Autor alexandre = new Autor("Alexandre Lourenço");
		Livro l4 = new Livro("Elasticsearch", "Consumindo dados real-time com ELK", alexandre, 
				69.90, 29.90);
		site.adicionaUltimosAtualizados(l4);
		site.adicionaTodosOsLivros(l4);
		
		Autor gM = new Autor("Guilherme Silveira, Mário Amaral");
		Livro l5 = new Livro("Java SE 8 Programmer I", "O guia para sua certificação Oracle Certified Associate", 
				gM, 69.90, 29.90);
		site.adicionaUltimosAtualizados(l5);
		site.adicionaTodosOsLivros(l5);
		
		Autor joaquim = new Autor("Joaquim Torres");
		Livro l6 = new Livro("Guia da Startup", "Como startups e empresas estabelecidas podem criar produtos de software rentáveis", 
				joaquim, 69.90, 29.90);
		site.adicionaUltimosAtualizados(l6);
		site.adicionaTodosOsLivros(l6);
		
		Autor david = new Autor("David Paniz");
		Livro l7 = new Livro("NoSQL", "Como armazenar os dados de uma aplicação moderna", david, 
				69.90, 29.90);
		site.adicionaUltimosAtualizados(l7);
		site.adicionaTodosOsLivros(l7);
		
		Livro l8 = new Livro("Desconstruindo a Web", "As tecnologias por tráz de uma requisição", willian, 
				69.90, 29.90);
		site.adicionaUltimosAtualizados(l8);
		site.adicionaTodosOsLivros(l8);
		
		//ultimos lançamentos
		Autor vinicius = new Autor("Vinicius Carvalho");
		Livro l9 = new Livro("PostgreSQL", "Banco de dados para aplicações web modernas", vinicius
				, 0.00, 29.90);
		site.adicionaUltimosLancamentos(l9);
		site.adicionaTodosOsLivros(l9);
		
		Autor ronaldo = new Autor("Ronaldo Braghittoni");
		Livro l10 = new Livro("Business Intelligence", "Implementar do jeito certo e a custo zero", 
				ronaldo, 69.90, 29.90);
		site.adicionaUltimosLancamentos(l10);
		site.adicionaTodosOsLivros(l10);
		
		Autor rodrigo = new Autor("Rodrigo Ferreira");
		Livro l11 = new Livro("Segurança", "em aplicações Web", rodrigo,
				69.90, 29.90);
		site.adicionaUltimosLancamentos(l11);
		site.adicionaTodosOsLivros(l11);
		
		Autor rian = new Autor("Rian van der Merwe");
		Livro l12 = new Livro("Making it right", "Gestão de produtos no mundo das Startups", rian, 
				69.90, 29.90);
		site.adicionaUltimosLancamentos(l12);
		site.adicionaTodosOsLivros(l12);
		
		Autor guilherme = new Autor("Guilherme Silveira");
		Livro l13 = new Livro("Algoritmos em Java", "Busca, ordenação e análise", guilherme, 
				69.90, 29.90);
		site.adicionaUltimosLancamentos(l13);
		site.adicionaTodosOsLivros(l13);
		
		//mais alguns livros no acervo
		Livro l14 = new Livro("Xamarin forms", "Desenvolvimento de aplicações móveis multiplataforma",
				everton, 69.90, 29.90);
		site.adicionaTodosOsLivros(l14);
		
		Autor rosangela = new Autor("Rosangela Marquesone");
		Livro l15 = new Livro("Big Data", "Técnicas e tecnologias para extração de valor dos dados",
				rosangela, 69.90, 29.90);
		site.adicionaTodosOsLivros(l15);
		
		Autor paulo = new Autor("Paulo Siqueira");
		Livro l16 = new Livro("Scala", "Como escalar sua produtividade", paulo, 69.90, 29.90);
		site.adicionaTodosOsLivros(l16);
		
		Autor jonathanLamin = new Autor("Jonathan Lamin Antunes");
		Livro l17 = new Livro("Amazon AWS", "Descomplicando a computação na nuvem", jonathanLamin, 
				69.90, 29.90);
		site.adicionaTodosOsLivros(l17);
		
		Autor walmyr = new Autor("Walmyr Filho");
		Livro l18 = new Livro("Protractor", "Lições sobre testes end-to-end automatizados", walmyr,
				69.90, 29.90);
		site.adicionaTodosOsLivros(l18);
		
		site.imprimeAcervoInteiro();
		
		
		
		
	
	}
}
