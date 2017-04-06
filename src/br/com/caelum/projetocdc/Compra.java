package br.com.caelum.projetocdc;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Compra {

	private int id;
	private Usuario usuario;
	private Calendar data;
	private Set<Item> itens = new HashSet<>();
	
	public Compra(Usuario usuario, Calendar data) {
		this.usuario = usuario;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Calendar getData() {
		return data;
	}

	public Set<Item> getItens() {
		return itens;
	}
	
	public void adicionaItens(Item item) {
		this.itens.add(item);
	}
	
	@Override
	public String toString() {
		return "Usuario: " + this.usuario + "Data da compra: " + this.data + "\nItens: " + this.itens;
	}
}
