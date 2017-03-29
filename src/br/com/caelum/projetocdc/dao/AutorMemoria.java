package br.com.caelum.projetocdc.dao;

import java.util.HashSet;
import java.util.Set;

import br.com.caelum.projetocdc.Autor;

public class AutorMemoria implements AutorDAO{

	private Set<Autor> autores = new HashSet<>();

	public Set<Autor> getAutores() {
		return autores;
	}

	
	public void adiciona(Autor autor) {
		autores.add(autor);
	}


	@Override
	public void altera(Autor autor, int id) {
		// TODO Auto-generated method stub
		
	}
}
