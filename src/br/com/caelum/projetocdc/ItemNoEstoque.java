package br.com.caelum.projetocdc;

import br.com.caelum.projetocdc.exception.NaoPodeAdicionarEbookNoEstoqueException;

public class ItemNoEstoque {

	private int id;
	private Livro livro;
	private int quantidadeNoEstoque;
	
	public ItemNoEstoque(Livro livro, int quantidadeNoEstoque) throws NaoPodeAdicionarEbookNoEstoqueException {
		if(livro.getTipo().name().equals("EBOOK")){
			throw new NaoPodeAdicionarEbookNoEstoqueException("Ebook n�o entra no estoque");
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
	
	public int getQuantidadeNoEstoque() {
		return quantidadeNoEstoque;
	}
	
	@Override
	public String toString() {
		return "Id: " + this.id + "\nLivro: " + this.livro + "\nQuantidade: " + this.quantidadeNoEstoque;
	}
}
