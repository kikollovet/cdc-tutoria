package br.com.caelum.projetocdc;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class CarrinhoDeCompras {

	private Set<Item> itens = new HashSet<>();
	
	public Set<Item> getItens() {
		return itens;
	}
	
	public void adiciona(Item item){
		itens.add(item);
	}
	
	public int getQuantidadeItens(){
		int quantidadeTotal = 0;
		for (Item item : itens) {
			quantidadeTotal += item.getQuantidade();
		}
		return quantidadeTotal;
	}
	
	public double getValorTotal(){
		double valorTotal = 0.00;
		for (Item item : itens) {
			valorTotal += item.getPrecoTotal();
		}
		return valorTotal;
	}
	
	public void remove(Item item){
		itens.remove(item);
	}
	
	public void atualizarQuantidadeItem(Item item, int quantidade){
		for (Item itemNoCarrinho : itens) {
			if(itemNoCarrinho.equals(item)){
				itemNoCarrinho.setQuantidade(quantidade);
			}
		}
	}
	
	public Compra getCompra(Usuario usuario, Calendar data){
		Compra compra = new Compra(usuario, data);
		
		for (Item item : itens) {
			compra.getItens().add(item);
		}
		
		return compra;
	}
}
