package br.com.caelum.projetocdc;

public class Item {

	private Livro livro;
	private int quantidade;
	private double precoUnitario;
	private double precoTotal;

	public Item(Livro livro, int quantidade) {
		this.livro = livro;
		this.quantidade = quantidade;
		this.precoUnitario = livro.getPreco();
		this.precoTotal = livro.getPreco() * quantidade;
	}

	public Livro getLivro() {
		return livro;
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

	public double getPrecoTotal() {
		return precoTotal;
	}

	@Override
	public String toString() {
		return "Livro: " + livro.getTitulo() + "\nQuantidade: " + this.quantidade + "\nTipo: " + livro.getTipo() + "\nPreço unidade: R$"
				+ this.precoUnitario + "\nPreço Total: R$" + this.precoTotal + "\n=========";
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
