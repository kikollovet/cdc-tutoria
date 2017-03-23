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
	
	public void remove(Livro livro){
		this.listaLivroCarrinhoCompra.remove(livro);
	}
	
	public void atualizarQuantidadeMesmoLivro(Livro livro, int numero){
		String tituloLivro = livro.getTitulo();
		int totalMesmoLivro = 0;
		
		for (Livro livro2 : listaLivroCarrinhoCompra) {
			if(tituloLivro.equals(livro2.getTitulo())){
				totalMesmoLivro++;
			}
		}
		
		int diferenca = Math.abs(numero - totalMesmoLivro);
		
		if(totalMesmoLivro < numero){
			for(int i = 0; i < diferenca; i++){
				this.listaLivroCarrinhoCompra.add(livro);
			}
		}
	}
}
