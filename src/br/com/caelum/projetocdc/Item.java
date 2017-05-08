package br.com.caelum.projetocdc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="itens")
public class Item {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_compra")
	private Compra compra;
	
	@ManyToOne
	@JoinColumn(name="id_livro")
	private Livro livro;
	
	@Column(name = "quantidade")
	private int quantidade;
	
	@Column(name = "preco")
	private double precoUnitario;
	private transient double precoTotal;

	public Item(){}
	
	public Item(Livro livro, int quantidade) {
		this.livro = livro;
		this.quantidade = quantidade;
		this.precoUnitario = livro.getPreco();
		this.precoTotal = livro.getPreco() * quantidade;
	}
	
	public Item(Compra compra, Livro livro, int quantidade) {
		this.compra = compra;
		this.livro = livro;
		this.quantidade = quantidade;
		this.precoUnitario = livro.getPreco();
		this.precoTotal = livro.getPreco() * quantidade;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Compra getCompra() {
		return compra;
	}
	
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
		this.precoTotal = quantidade * this.precoUnitario;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
		this.precoTotal = precoUnitario * this.quantidade;
	}
	public double getPrecoTotal() {
		return precoTotal;
	}

	@Override
	public String toString() {
		return "Livro: " + livro.getTitulo() + "\nQuantidade: " + this.quantidade + "\nTipo: " + livro.getTipo() + "\nPreço unidade: R$"
				+ this.precoUnitario + "\nPreço Total: R$" + this.precoTotal + "\nData lancamento: " + livro.getDataLancamentoString() 
				+ "\nData ultima atualizacao: " + this.livro.getDataUltimaAtualizacaoString() + "\n=========\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((livro == null) ? 0 : livro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (livro == null) {
			if (other.livro != null)
				return false;
		} else if (!livro.equals(other.livro))
			return false;
		return true;
	}

}
