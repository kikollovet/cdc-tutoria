package br.com.caelum.projetocdc.teste;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Site;

public class TestaUltimosLancamentos {

	public static void main(String[] args) {
		Site site = new Site();
		
		Autor everton = new Autor("Everton Coimbra de Araújo");
		Livro l1 = new Livro("ASP.NET MVC5", "Crie aplicações Web na plataforma Microsoft", everton, 69.90, 29.90, "10/10/2017", "20/03/2017");
		site.inclui(l1);
		
		Autor willian = new Autor("Willian Molinari");
		Livro l2 = new Livro("Desconstruindo a Web", "As tecnologias por tráz de uma requisição", willian, 69.90,
				29.90, "09/10/2017", "15/03/2017");
		site.inclui(l2);

		Autor jMM = new Autor("Jonathan Lamim, Matheus Marabesi, Michael Douglas");
		Livro l3 = new Livro("Coleção CodeIgniter + Zend PHP", "", jMM, 0.00, 49.90, "08/10/2017", "10/03/2017");
		site.inclui(l3);
		
		//ultimos atualizados
		Autor alexandre = new Autor("Alexandre Lourenço");
		Livro l4 = new Livro("Elasticsearch", "Consumindo dados real-time com ELK", alexandre, 
				69.90, 29.90, "07/10/2017", "05/03/2017");
		site.inclui(l4);
		
		Autor gM = new Autor("Guilherme Silveira, Mário Amaral");
		Livro l5 = new Livro("Java SE 8 Programmer I", "O guia para sua certificação Oracle Certified Associate", 
				gM, 69.90, 29.90, "06/10/2017", "03/03/2017");
		site.inclui(l5);
		
		Autor joaquim = new Autor("Joaquim Torres");
		Livro l6 = new Livro("Guia da Startup", "Como startups e empresas estabelecidas podem criar produtos de software rentáveis", 
				joaquim, 69.90, 29.90, "05/10/2017", "01/03/2017");
		site.inclui(l6);
		
		//site.imprimeTodosOsLivros();
		//site.imprimeUltimosLancamentos();
		//site.imprimeUltimasAtualizacoes();
		site.imprimeDestaques();
		
	}

}
