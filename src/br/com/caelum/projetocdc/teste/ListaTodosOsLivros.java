package br.com.caelum.projetocdc.teste;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Site;

public class ListaTodosOsLivros {

	public static void main(String[] args) {
		Site site = new Site();
		
		Autor everton = new Autor("Everton Coimbra de Araujo");
		Livro l1 = new Livro("Xamarin forms", "Desenvolvimento de aplicações móveis multiplataforma",
				everton, 69.90, 29.90);
		site.adicionaTodosOsLivros(l1);
		
		Autor rosangela = new Autor("Rosangela Marquesone");
		Livro l2 = new Livro("Big Data", "Técnicas e tecnologias para extração de valor dos dados",
				rosangela, 69.90, 29.90);
		site.adicionaTodosOsLivros(l2);
		
		Autor paulo = new Autor("Paulo Siqueira");
		Livro l3 = new Livro("Scala", "Como escalar sua produtividade", paulo, 69.90, 29.90);
		site.adicionaTodosOsLivros(l3);
		
		Autor jonathanLamin = new Autor("Jonathan Lamin Antunes");
		Livro l4 = new Livro("Amazon AWS", "Descomplicando a computação na nuvem", jonathanLamin, 
				69.90, 29.90);
		site.adicionaTodosOsLivros(l4);
		
		Autor walmyr = new Autor("Walmyr Filho");
		Livro l5 = new Livro("Protractor", "Lições sobre testes end-to-end automatizados", walmyr,
				69.90, 29.90);
		site.adicionaTodosOsLivros(l5);
		
		site.getTodosOsLivros().forEach(livro -> {
			System.out.println(livro);
		});
		
		
		
	}
}
