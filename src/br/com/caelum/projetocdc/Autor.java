package br.com.caelum.projetocdc;

public class Autor {

	private String nome;
	
	public Autor (String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
