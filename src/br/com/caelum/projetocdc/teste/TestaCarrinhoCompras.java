package br.com.caelum.projetocdc.teste;

import java.text.DecimalFormat;
import java.util.Map;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.CarrinhoDeCompras;
import br.com.caelum.projetocdc.Livro;

public class TestaCarrinhoCompras {

	public static void main(String[] args) {
		
		Autor everton = new Autor("Everton Coimbra de Araújo");
		Livro l1 = new Livro("ASP.NET MVC5", "Crie aplicações Web na plataforma Microsoft", everton, 69.90, 29.90, "10/10/2017", "20/03/2017");
		
		Autor willian = new Autor("Willian Molinari");
		Livro l2 = new Livro("Desconstruindo a Web", "As tecnologias por tráz de uma requisição", willian, 69.90,
				29.90, "09/10/2017", "15/03/2017");

		Autor alexandre = new Autor("Alexandre Lourenço");
		Livro l3 = new Livro("Elasticsearch", "Consumindo dados real-time com ELK", alexandre, 
				69.90, 29.90);
		CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
		
		//adicione livros no carrinho
		carrinhoDeCompras.adiciona(l1);
		carrinhoDeCompras.adiciona(l2);
		carrinhoDeCompras.adiciona(l1);
		
		carrinhoDeCompras.getListaLivro().forEach(livro -> {
			System.out.println(livro);
		});
		
		//exiba a quantidade de livros no carrinho
		
		System.out.println("Quantidade livros no carrinho " + 
		carrinhoDeCompras.exibeQuantidadeLivrosCarrinho());
		
		//exiba o valor total do carrinho
		DecimalFormat dF = new DecimalFormat("0.00");
		System.out.println("Preço total: R$" + dF.format(carrinhoDeCompras.exibeValorTotalCarrinho()));
		
		//remover livro do carrinho
		
		carrinhoDeCompras.remove(l1);
		
		carrinhoDeCompras.getListaLivro().forEach(livro -> {
			System.out.println(livro);
		});
		
		//atualizar a quantidade de determinado livro no carrinho
		//posso comprar mais de um do mesmo livro
		
		System.out.println("======\n======");
		carrinhoDeCompras.atualizarQuantidadeMesmoLivro(l1, 4);
		carrinhoDeCompras.getListaLivro().forEach(livro -> {
			System.out.println(livro);
		});
		
		System.out.println("=======\n======");
		carrinhoDeCompras.atualizarQuantidadeMesmoLivro(l1, 2);
		carrinhoDeCompras.getListaLivro().forEach(livro -> {
			System.out.println(livro);
		});
		
		System.out.println("========\n=======");
		carrinhoDeCompras.atualizarQuantidadeMesmoLivro(l3, 2);
		carrinhoDeCompras.getListaLivro().forEach(livro -> {
			System.out.println(livro);
		});
		
		//liste todos os livros do carrinho
		
		System.out.println("=========\n=======\nTodos os livros do carrinho");
		carrinhoDeCompras.getListaLivro().forEach(livro -> {
			System.out.println(livro);
		});
		
		
		//Imprime quantidade valor Set de String
		
		System.out.println("=========\n============\n=====");
		carrinhoDeCompras.getQuantidadeLivroValor().forEach(dadosLivro -> {
			System.out.println(dadosLivro);
		});
		
		//Imprime quantidade valor HashMap
		
		System.out.println("============\n==========\n========");
		for (Map.Entry<Livro, Integer> entry : carrinhoDeCompras.getQuantidadeLivroValorMap().entrySet()) {
			System.out.println(entry.getKey() + "\nQuantidade: " + entry.getValue() + 
					"\nValor: R$" + (entry.getKey().getPrecoImpresso()) * entry.getValue() + "\n=====");
		}
	}
}
