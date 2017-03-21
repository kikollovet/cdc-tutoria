package br.com.caelum.projetocdc;

public class Livro {

	String titulo;
	String subTitulo;
	Autor autor;
	double precoImpresso;
	double precoEbook;
	Categoria categoria;

	public Livro(String titulo, String subTitulo, Autor autor, double precoImpresso, double precoEbook) {
		this.titulo = titulo;
		this.subTitulo = subTitulo;
		this.autor = autor;
		this.precoImpresso = precoImpresso;
		this.precoEbook = precoEbook;
	}
	
	public Livro(String titulo, String subTitulo, Autor autor, double precoImpresso, double precoEbook, Categoria categoria){
		this.titulo = titulo;
		this.subTitulo = subTitulo;
		this.autor = autor;
		this.precoImpresso = precoImpresso;
		this.precoEbook = precoEbook;
		this.categoria = categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getSubTitulo() {
		return subTitulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public double getPrecoImpresso() {
		return precoImpresso;
	}

	public double getPrecoEbook() {
		return precoEbook;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Livro other = (Livro) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		
		if(this.precoImpresso == 0.00)
			return "Título: " + this.titulo + "\nSubTítulo: " + this.subTitulo + "\nAutor: " + this.autor +
					 "\nPreço E-book: R$" + this.precoEbook + "\n=====";
		return "Título: " + this.titulo + "\nSubTítulo: " + this.subTitulo + "\nAutor: " + this.autor +
				"\nPreço impresso: R$" + this.precoImpresso + "\nPreço E-book: R$" + this.precoEbook + "\n=====";
	}

}
