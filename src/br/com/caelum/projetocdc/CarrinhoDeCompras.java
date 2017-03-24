package br.com.caelum.projetocdc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CarrinhoDeCompras {

	private List<Livro> listaLivro = new ArrayList<>();
	private Map<Livro, Integer> mapaLivro = new HashMap<>();
	
	public Map<Livro, Integer> getMapaLivro(){
		return mapaLivro;
	}

	public void adiciona(Livro livro, int quantidade){
		this.mapaLivro.put(livro, quantidade);
	}
	
	public int getQuantidadeLivrosCarrinho(){
		return this.listaLivro.size();
	}
	
	public double getValorTotalCarrinho(){
		double valorTotal = 0.0;
		for (Livro livro : listaLivro) {
			valorTotal += livro.getPrecoImpresso();
		}
		return valorTotal;
	}
	
	public void remove(Livro livro){
		this.listaLivro.remove(livro);
	}
	
	public void atualizarQuantidadeMesmoLivro(Livro livro, int numero){
		int totalMesmoLivro = 0;
		
		for (Livro livro2 : listaLivro) {
			if(livro.equals(livro2)){
				totalMesmoLivro++;
			}
		}
		
		int diferenca = Math.abs(numero - totalMesmoLivro);
		
		if(totalMesmoLivro < numero){
			for(int i = 0; i < diferenca; i++){
				this.listaLivro.add(livro);
			}
		}
		
		if(totalMesmoLivro > numero){
			for(int i = 0; i < diferenca; i++){
				this.listaLivro.remove(livro);
			}
		}
	}
	
	public Map<Livro, Integer> getQuantidadeLivroValorMap(){
		Map<Livro, Integer> listaQuantidadeValor = new HashMap<>();
		
		int quantMesmoLivro = 0;
				
		for(int i = 0; i < this.listaLivro.size(); i++){
			Livro livroUm = listaLivro.get(i);
			
			for (Livro livro : listaLivro) {
				if(livro.equals(livroUm)){
					quantMesmoLivro++;
				}
			}
			
			listaQuantidadeValor.put(livroUm, quantMesmoLivro);
			quantMesmoLivro = 0;
			
		}
		return listaQuantidadeValor;
	}
	
	
}
