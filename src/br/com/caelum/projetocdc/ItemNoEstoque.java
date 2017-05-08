package br.com.caelum.projetocdc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import br.com.caelum.projetocdc.exception.NaoPodeAdicionarEbookNoEstoqueException;

@Entity
@Table(name = "estoque")
public class ItemNoEstoque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name = "id_livro")
	private Livro livro;
	
	@Column(name = "quantidade")
	private int quantidadeNoEstoque;
	
	public ItemNoEstoque(){}
	
	public ItemNoEstoque(Livro livro, int quantidadeNoEstoque) throws NaoPodeAdicionarEbookNoEstoqueException {
		if(livro.getTipo().equals(Tipo.EBOOK)){
			throw new NaoPodeAdicionarEbookNoEstoqueException("N�o pode criar ItemNoEstoque com ebook");
		}
		this.livro = livro;
		this.quantidadeNoEstoque = quantidadeNoEstoque;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public int getQuantidadeNoEstoque() {
		return quantidadeNoEstoque;
	}
	
	public void setQuantidadeNoEstoque(int quantidadeNoEstoque) {
		this.quantidadeNoEstoque = quantidadeNoEstoque;
	}
	
	@Override
	public String toString() {
		return "Id: " + this.id + "\nLivro: " + this.livro + "\nQuantidade: " + this.quantidadeNoEstoque;
	}
}
