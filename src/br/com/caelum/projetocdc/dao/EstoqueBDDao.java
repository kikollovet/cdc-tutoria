package br.com.caelum.projetocdc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.ItemNoEstoque;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Tipo;
import br.com.caelum.projetocdc.exception.NaoPodeAdicionarEbookNoEstoqueException;

public class EstoqueBDDao {

	EntityManager manager;
	
	public EstoqueBDDao(EntityManager manager){
		this.manager = manager;
	}
	
	public void adiciona(ItemNoEstoque itemNoEstoque) throws NaoPodeAdicionarEbookNoEstoqueException{
		manager.persist(itemNoEstoque);
	}
	
	public void diminuiQuantidade(ItemNoEstoque itemNoEstoque, int quantidade){
		itemNoEstoque.setQuantidadeNoEstoque(itemNoEstoque.getQuantidadeNoEstoque() - quantidade);
		manager.merge(itemNoEstoque);
	}
	
	public void aumentaQuantidade(ItemNoEstoque itemNoEstoque, int quantidade){
		itemNoEstoque.setQuantidadeNoEstoque(itemNoEstoque.getQuantidadeNoEstoque() + quantidade);
		manager.merge(itemNoEstoque);
	}
	
	public ItemNoEstoque getItemNoEstoque(int id) throws NaoPodeAdicionarEbookNoEstoqueException{
		return manager.find(ItemNoEstoque.class, id);
	}
	
	public ItemNoEstoque getItemNoEstoqueIdLivro(int id) throws NaoPodeAdicionarEbookNoEstoqueException{
		Query query = manager.createQuery("select e from ItemNoEstoque e where e.livro.id = :id");
		query.setParameter("id", id);
		try{
			ItemNoEstoque item = (ItemNoEstoque) query.getSingleResult();
			return item;
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
