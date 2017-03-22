package br.com.caelum.projetocdc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Livro {

	String titulo;
	String subTitulo;
	Autor autor;
	double precoImpresso;
	double precoEbook;
	Calendar dataUltimaAtualizacao;
	Calendar dataLancamento;

	public Livro(String titulo, String subTitulo, Autor autor, double precoImpresso, double precoEbook) {
		this.titulo = titulo;
		this.subTitulo = subTitulo;
		this.autor = autor;
		this.precoImpresso = precoImpresso;
		this.precoEbook = precoEbook;
	}
	
	public Livro(String titulo, String subTitulo, Autor autor, double precoImpresso, double precoEbook, String dataUltimaAtualizacao, String dataLancamento) {
		this.titulo = titulo;
		this.subTitulo = subTitulo;
		this.autor = autor;
		this.precoImpresso = precoImpresso;
		this.precoEbook = precoEbook;
		
		try{
			Date dUA = new SimpleDateFormat("dd/MM/yyyy").parse(dataUltimaAtualizacao);
			this.dataUltimaAtualizacao = Calendar.getInstance();
			this.dataUltimaAtualizacao.setTime(dUA);
		} catch (ParseException e) {
			System.out.println("Erro de conversão da data");
		}
		
		try{
			Date dL = new SimpleDateFormat("dd/MM/yyyy").parse(dataLancamento);
			this.dataLancamento = Calendar.getInstance();
			this.dataLancamento.setTime(dL);
		} catch (ParseException e) {
			System.out.println("Erro de conversão da data");
		}
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
	
	public Calendar getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}
	
	public Calendar getDataLancamento() {
		return dataLancamento;
	}
	
	public String getDataUltimaAtualizacaoString(){
		Date data = this.dataUltimaAtualizacao.getTime();
		SimpleDateFormat simples = new SimpleDateFormat("dd/MM/yyyy");
		return simples.format(data);
	}
	
	public String getDataLancamentoString(){
		Date data = this.dataLancamento.getTime();
		SimpleDateFormat simples = new SimpleDateFormat("dd/MM/yyyy");
		return simples.format(data);
	}
	
	public String livroTituloDataLancamento(){
		return this.titulo + " " + this.getDataLancamentoString();
	}
	
	public String livroTituloDataUltimaAtualizacao(){
		return this.titulo + " " + this.getDataUltimaAtualizacaoString();
	}
	
	public String livroDestaqueTituloDataLancamento(){
		return this.titulo + " " + this.getDataLancamentoString();
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
