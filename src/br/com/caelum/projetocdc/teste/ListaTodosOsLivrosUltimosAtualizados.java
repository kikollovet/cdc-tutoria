package br.com.caelum.projetocdc.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Site;

public class ListaTodosOsLivrosUltimosAtualizados {

	public static void main(String[] args) {
		
		Site site = new Site();
		
		Autor alexandre = new Autor("Alexandre Lourenço");
		Livro l1 = new Livro("Elasticsearch", "Consumindo dados real-time com ELK", alexandre, 
				69.90, 29.90);
		site.adicionaUltimosAtualizados(l1);
		
		Autor gM = new Autor("Guilherme Silveira, Mário Amaral");
		Livro l2 = new Livro("Java SE 8 Programmer I", "O guia para sua certificação Oracle Certified Associate", 
				gM, 69.90, 29.90);
		site.adicionaUltimosAtualizados(l2);
		
		Autor joaquim = new Autor("Joaquim Torres");
		Livro l3 = new Livro("Guia da Startup", "Como startups e empresas estabelecidas podem criar produtos de software rentáveis", 
				joaquim, 69.90, 29.90);
		site.adicionaUltimosAtualizados(l3);
		
		Autor david = new Autor("David Paniz");
		Livro l4 = new Livro("NoSQL", "Como armazenar os dados de uma aplicação moderna", david, 
				69.90, 29.90);
		site.adicionaUltimosAtualizados(l4);
		
		Autor willian = new Autor("Willian Molinari");
		Livro l5 = new Livro("Desconstruindo a Web", "As tecnologias por tráz de uma requisição", willian, 
				69.90, 29.90);
		site.adicionaUltimosAtualizados(l5);
		
		site.getUltimosAtualizados().forEach(livro -> {
			System.out.println(livro);
		});

	}

}
