package br.com.caelum.projetocdc.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.projetocdc.ItemNoEstoque;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Tipo;

public class LivrosSemRegistroNoEstoqueBDDao {

	private EntityManager manager;

	public LivrosSemRegistroNoEstoqueBDDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Livro> getLista(){
		List<Livro> listaLivro = manager.createQuery("select l from Livro l where l.tipo = :tipo", Livro.class).setParameter("tipo", Tipo.IMPRESSO).getResultList();
		List<ItemNoEstoque> listaItem = manager.createQuery("select i from ItemNoEstoque i", ItemNoEstoque.class).getResultList();
		List<Livro> praRemover = new ArrayList<>();
		
		for(ItemNoEstoque item: listaItem){
			for(Livro livro: listaLivro){
				if(item.getLivro().equals(livro)){
					praRemover.add(livro);
				}
			}
		}
		listaLivro.removeAll(praRemover);
		
		return listaLivro;
	}
}
