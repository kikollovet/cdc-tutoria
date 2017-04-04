package br.com.caelum.projetocdc;

public class Usuario {

	int id;
	String nome;
	String email;
	
	public Usuario(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}
	
	
}
