package br.com.caelum.projetocdc.dao;

import java.util.HashSet;
import java.util.Set;

import br.com.caelum.projetocdc.Autor;

public class AutorMemoria implements AutorDAO{

	private Set<Autor> autores = new HashSet<>();
	private int id = 1;

	public Set<Autor> getAutores() {
		return autores;
	}

	
	public void adiciona(Autor autor) {
		autor.setId(id);
		autores.add(autor);
		id++;
	}


	@Override
	public void alteraNome(String nome, int id) {
		for (Autor autor : autores) {
			if(autor.getId() == id){
				autor.setNome(nome);
			}
		}
		
	}
}
