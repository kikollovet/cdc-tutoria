package br.com.caelum.projetocdc.dao;

import br.com.caelum.projetocdc.Autor;

public interface AutorDAO {

	public void adiciona(Autor autor);
	public void alteraNome(String nome, int id);
}
