package br.com.caelum.projetocdc;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

	private List<Livro> listaLivroCarrinhoCompra = new ArrayList<>();
	
	public List<Livro> getListaLivroCarrinhoCompra() {
		return listaLivroCarrinhoCompra;
	}

	public void adiciona(Livro livro){
		this.listaLivroCarrinhoCompra.add(livro);
	}
	
	public int exibeQuantidadeLivrosCarrinho(){
		return this.listaLivroCarrinhoCompra.size();
	}
}
