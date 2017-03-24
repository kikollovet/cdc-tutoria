package br.com.caelum.projetocdc.teste;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.CarrinhoDeCompras;
import br.com.caelum.projetocdc.Item;
import br.com.caelum.projetocdc.Livro;

public class TestaCarrinhoCompras {

	public static void main(String[] args) {
		
		Autor everton = new Autor("Everton Coimbra de Araújo");
		Livro l1 = new Livro("ASP.NET MVC5", "Crie aplicações Web na plataforma Microsoft", everton, 69.90, 29.90,
				"10/10/2017", "20/03/2017");

		Autor willian = new Autor("Willian Molinari");
		Livro l2 = new Livro("Desconstruindo a Web", "As tecnologias por tráz de uma requisição", willian, 69.90, 29.90,
				"09/10/2017", "15/03/2017");
		
		Item i1 = new Item(l1, 3);
		Item i2 = new Item(l2, 2);
		
		CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
		
		carrinhoDeCompras.adiciona(i1);
		carrinhoDeCompras.adiciona(i2);
		
		carrinhoDeCompras.getItens().forEach(item -> {
			System.out.println(item);
		});
		
		System.out.println(carrinhoDeCompras.getQuantidadeItens());

	}

}
