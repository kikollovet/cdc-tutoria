package br.com.caelum.projetocdc.teste;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.CarrinhoDeCompras;
import br.com.caelum.projetocdc.Item;
import br.com.caelum.projetocdc.Livro;

public class TestaCarrinhoCompras {

	public static void main(String[] args) {
		
		Autor everton = new Autor("Everton Coimbra de Araújo");
		Livro livroUm = new Livro("ASP.NET MVC5", "Crie aplicações Web na plataforma Microsoft", everton, 69.90, 29.90,
				"10/10/2017", "20/03/2017");

		Autor willian = new Autor("Willian Molinari");
		Livro livroDois = new Livro("Desconstruindo a Web", "As tecnologias por tráz de uma requisição", willian, 69.90, 29.90,
				"09/10/2017", "15/03/2017");
		
		Item itemUm = new Item(livroUm, 3);
		Item itemDois = new Item(livroDois, 2);
		
		CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
		
		carrinhoDeCompras.adiciona(itemUm);
		carrinhoDeCompras.adiciona(itemDois);
		
		carrinhoDeCompras.getItens().forEach(item -> {
			System.out.println(item);
		});
		
		System.out.println(carrinhoDeCompras.getQuantidadeItens());
		
		System.out.println(carrinhoDeCompras.getValorTotal());
		
		
		carrinhoDeCompras.atualizarQuantidadeItem(itemUm, 1);
		carrinhoDeCompras.getItens().forEach(item -> {
			System.out.println(item);
		});

		carrinhoDeCompras.remove(itemUm);
	}

}
