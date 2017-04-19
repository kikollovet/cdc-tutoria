package br.com.caelum.projetocdc;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import br.com.caelum.projetocdc.exception.QuantidadeInsuficienteNoEstoqueException;

public class Compra {

	private int id;
	private Usuario usuario;
	private Calendar data;
	private Set<Item> itens = new HashSet<>();
	
	public Compra(Usuario usuario, Calendar data) {
		this.usuario = usuario;
		this.data = data;
	}
	
	public Compra(Usuario usuario, Calendar data, CarrinhoDeCompras carrinhoDeCompras){
		this.usuario = usuario;
		this.data = data;
		for(Item item : carrinhoDeCompras.getItens()){
			this.itens.add(item);
		}
		
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
		return Collections.unmodifiableSet(this.itens);
	}
	
	public void adicionaItens(Item item) {
		this.itens.add(item);
	}
	
	public String getDataCompraString(){
		Date data = this.data.getTime();
		SimpleDateFormat simples = new SimpleDateFormat("dd/MM/yyyy");
		return simples.format(data);
	}
	
	@Override
	public String toString() {
		return "Usuario: " + this.usuario + "\nData da compra: " + getDataCompraString() + "\nItens: " + this.itens;
	}
}
