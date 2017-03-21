package br.com.caelum.projetocdc.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Site;

public class ListaTodosOsLivrosUltimosLancamentos {

	public static void main(String[] args) {
		Site site = new Site();
		
		Autor vinicius = new Autor("Vinicius Carvalho");
		Livro l1 = new Livro("PostgreSQL", "Banco de dados para aplicações web modernas", vinicius
				, 0.00, 29.90);
		site.adicionaUltimosLancamentos(l1);
		
		Autor ronaldo = new Autor("Ronaldo Braghittoni");
		Livro l2 = new Livro("Business Intelligence", "Implementar do jeito certo e a custo zero", 
				ronaldo, 69.90, 29.90);
		site.adicionaUltimosLancamentos(l2);
		
		Autor rodrigo = new Autor("Rodrigo Ferreira");
		Livro l3 = new Livro("Segurança", "em aplicações Web", rodrigo,
				69.90, 29.90);
		site.adicionaUltimosLancamentos(l3);
		
		Autor rian = new Autor("Rian van der Merwe");
		Livro l4 = new Livro("Making it right", "Gestão de produtos no mundo das Startups", rian, 
				69.90, 29.90);
		site.adicionaUltimosLancamentos(l4);
		
		Autor guilherme = new Autor("Guilherme Silveira");
		Livro l5 = new Livro("Algoritmos em Java", "Busca, ordenação e análise", guilherme, 
				69.90, 29.90);
		site.adicionaUltimosLancamentos(l5);
		
		site.getUltimosLancamentos().forEach(livro -> {
			System.out.println(livro);
		});
	}
}
