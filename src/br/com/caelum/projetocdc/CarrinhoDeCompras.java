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
	
	public double exibeValorTotalCarrinho(){
		double valorTotal = 0.0;
		for (Livro livro : listaLivroCarrinhoCompra) {
			valorTotal += livro.getPrecoImpresso();
		}
		return valorTotal;
	}
}
