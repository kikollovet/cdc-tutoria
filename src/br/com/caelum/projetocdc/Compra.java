package br.com.caelum.projetocdc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="compra")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	@OneToMany(mappedBy="compra")
	private Set<Item> itens = new HashSet<>();
	
	public Compra(){}
	
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
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
	public Set<Item> getItens() {
		return Collections.unmodifiableSet(this.itens);
	}
	
	public void setItens(Set<Item> itens) {
		this.itens = itens;
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
