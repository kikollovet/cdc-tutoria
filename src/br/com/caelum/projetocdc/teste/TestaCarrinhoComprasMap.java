package br.com.caelum.projetocdc.teste;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.CarrinhoDeComprasMap;
import br.com.caelum.projetocdc.Livro;

public class TestaCarrinhoComprasMap {

	public static void main(String[] args) {

		Autor everton = new Autor("Everton Coimbra de Araújo");
		Livro l1 = new Livro("ASP.NET MVC5", "Crie aplicações Web na plataforma Microsoft", everton, 69.90, 29.90,
				"10/10/2017", "20/03/2017");

		Autor willian = new Autor("Willian Molinari");
		Livro l2 = new Livro("Desconstruindo a Web", "As tecnologias por tráz de uma requisição", willian, 69.90, 29.90,
				"09/10/2017", "15/03/2017");

		CarrinhoDeComprasMap carrinhoDeCompras = new CarrinhoDeComprasMap();

		
		carrinhoDeCompras.adiciona(l1, 2);
		carrinhoDeCompras.adiciona(l2, 3);
		
		System.out.println(carrinhoDeCompras.getQuantidadeLivrosCarrinho());
		
		System.out.println(carrinhoDeCompras.getValorTotalCarrinho());
		
		
		carrinhoDeCompras.atualizarQuantidadeMesmoLivro(l1, 1);
		
		System.out.println("======\n======\n======");
		carrinhoDeCompras.getMapaLivro().forEach((k,v)-> {
			System.out.println("Título: " + k.getTitulo() + "\nQuantidade: " + k.getQuantidade() +
					"\nPreço: R$" + (k.getPrecoImpresso()));
		});
		
		
	}
}
