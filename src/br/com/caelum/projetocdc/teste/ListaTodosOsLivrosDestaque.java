package br.com.caelum.projetocdc.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Site;

public class ListaTodosOsLivrosDestaque {

	public static void main(String[] args) {
		Site site = new Site();
		
		Autor everton = new Autor("Everton Coimbra de Araújo");
		Livro l1 = new Livro("ASP.NET MVC5", "Crie aplicações Web na plataforma Microsoft"
				, everton, 69.90, 29.90);
		site.adicionaDestaques(l1);
		
		Autor willian = new Autor("Willian Molinari");
		Livro l2 = new Livro("Desconstruindo a Web", "As tecnologias por tráz de uma requisição"
				, willian, 69.90, 29.90);
		site.adicionaDestaques(l2);
		
		Autor jMM = new Autor("Jonathan Lamim, Matheus Marabesi, Michael Douglas");
		Livro l3 = new Livro("Coleção CodeIgniter + Zend PHP", "", jMM
				, 0.00, 49.90);
		site.adicionaDestaques(l3);
		
		site.getDestaques().forEach(livro -> {
			System.out.println(livro);
		});
		
	}
}
