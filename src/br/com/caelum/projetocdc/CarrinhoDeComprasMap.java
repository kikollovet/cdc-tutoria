package br.com.caelum.projetocdc;

import java.util.HashMap;
import java.util.Map;

public class CarrinhoDeComprasMap {

	private Map<Livro, Integer> mapaLivro = new HashMap<>();
	
	public Map<Livro, Integer> getMapaLivro(){
		return mapaLivro;
	}

	public void adiciona(Livro livro, int quantidade){
		this.mapaLivro.put(livro, quantidade);
	}
	
	public int getQuantidadeLivrosCarrinho(){
		int quantidadeTotalLivro = 0;
		for(Map.Entry<Livro, Integer> mapa: this.mapaLivro.entrySet()){
			quantidadeTotalLivro += mapa.getValue();
		}
		return quantidadeTotalLivro;
	}
	
	public double getValorTotalCarrinho(){
		double valorTotal = 0.0;
		for(Map.Entry<Livro, Integer> mapa: this.mapaLivro.entrySet()){
			valorTotal += (mapa.getKey().getPrecoImpresso() * mapa.getValue());
		}
		return valorTotal;
	}
	
	public void remove(Livro livro){
		this.mapaLivro.remove(livro);
	}
	
	public void atualizarQuantidadeMesmoLivro(Livro livro, int quantidade){
		this.mapaLivro.put(livro, quantidade);
	}
	
}
