package br.com.caelum.projetocdc;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

	private List<Livro> listaLivro = new ArrayList<>();
	
	public List<Livro> getListaLivro() {
		return listaLivro;
	}

	public void adiciona(Livro livro){
		this.listaLivro.add(livro);
	}
	
	public int exibeQuantidadeLivrosCarrinho(){
		return this.listaLivro.size();
	}
	
	public double exibeValorTotalCarrinho(){
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
		String tituloLivro = livro.getTitulo();
		int totalMesmoLivro = 0;
		
		for (Livro livro2 : listaLivro) {
			if(tituloLivro.equals(livro2.getTitulo())){
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
	
	
}
