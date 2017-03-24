package br.com.caelum.projetocdc.teste;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.CarrinhoDeCompras;
import br.com.caelum.projetocdc.Livro;

public class TestaCarrinhoComprasMap {

	public static void main(String[] args) {

		Autor everton = new Autor("Everton Coimbra de Araújo");
		Livro l1 = new Livro("ASP.NET MVC5", "Crie aplicações Web na plataforma Microsoft", everton, 69.90, 29.90,
				"10/10/2017", "20/03/2017");

		Autor willian = new Autor("Willian Molinari");
		Livro l2 = new Livro("Desconstruindo a Web", "As tecnologias por tráz de uma requisição", willian, 69.90, 29.90,
				"09/10/2017", "15/03/2017");

		Autor alexandre = new Autor("Alexandre Lourenço");
		Livro l3 = new Livro("Elasticsearch", "Consumindo dados real-time com ELK", alexandre, 69.90, 29.90);
		CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

		// adicione livros no carrinho
		
		// exiba a quantidade de livros no carrinho
		
		// exiba o valor total do carrinho
		
		// remover livro do carrinho

		// atualizar a quantidade de determinado livro no carrinho
		// posso comprar mais de um do mesmo livro
		
		//liste todos os livros do carrinho
		
		//Imprime quantidade valor HashMap
		
		/*System.out.println("======\n======\n======");
		carrinhoDeCompras.getQuantidadeLivroValorMap().forEach((k,v)-> {
			System.out.println("Título: " + k.getTitulo() + "\nQuantidade: " + v +
					"\nPreço: R$" + (k.getPrecoImpresso() * v));
		});*/
		
		
	}
}
