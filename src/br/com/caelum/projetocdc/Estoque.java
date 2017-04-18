package br.com.caelum.projetocdc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Estoque {

	List<ItemNoEstoque> estoque = new ArrayList<>();
	
	public List<ItemNoEstoque> getEstoque() {
		return Collections.unmodifiableList(this.estoque);
	}
	
	public void adiciona(ItemNoEstoque itemNoEstoque){
		this.estoque.add(itemNoEstoque);
	}
	
	
}
