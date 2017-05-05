package br.com.caelum.projetocdc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="livros")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "subtitulo")
	private String subTitulo;
	
	@ManyToOne
	@JoinColumn(name = "autor")
	private Autor autor;
	
	@Column(name = "dataultimaatualizacao")
	@Temporal(TemporalType.DATE)
	private Calendar dataUltimaAtualizacao;
	
	@Column(name = "datalancamento")
	@Temporal(TemporalType.DATE)
	private Calendar dataLancamento;
	
	@Column(name = "preco")
	private double preco;
	
	@Column(name = "tipo")
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	public Livro(){}
	
	public Livro(String titulo, String subTitulo, Autor autor, Tipo tipo, double preco) {
		this.titulo = titulo;
		this.subTitulo = subTitulo;
		this.autor = autor;
		this.tipo = tipo;
		this.preco = preco;
	}
	
	public Livro(String titulo, String subTitulo, Autor autor, Tipo tipoLivro, double preco,
			Calendar dataUltimaAtualizacao, Calendar dataLancamento) {
		this.titulo = titulo;
		this.subTitulo = subTitulo;
		this.autor = autor;
		this.tipo = tipoLivro;
		this.preco = preco;
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
		this.dataLancamento = dataLancamento;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	public double getPreco() {
		return preco;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public Calendar getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public String getDataUltimaAtualizacaoString() {
		Date data = this.dataUltimaAtualizacao.getTime();
		SimpleDateFormat simples = new SimpleDateFormat("dd/MM/yyyy");
		return simples.format(data);
	}

	public String getDataLancamentoString() {
		Date data = this.dataLancamento.getTime();
		SimpleDateFormat simples = new SimpleDateFormat("dd/MM/yyyy");
		return simples.format(data);
	}

	public String livroTituloDataLancamento() {
		return this.titulo + " " + this.getDataLancamentoString();
	}

	public String livroTituloDataUltimaAtualizacao() {
		return this.titulo + " " + this.getDataUltimaAtualizacaoString();
	}

	public String livroDestaqueTituloDataLancamento() {
		return this.titulo + " " + this.getDataLancamentoString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		if (tipo != other.tipo)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {

		return "Titulo: " + this.titulo + "\nSub-Titulo: " + this.subTitulo + "\nAutor: " + this.autor + "\nTipo: "
				+ this.tipo + "\nPreco: R$" + this.preco + "\n=====";
	}

}
