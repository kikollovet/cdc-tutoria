package br.com.caelum.projetocdc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.jdbc.ConnectionFactory;

public class AutorBDDao implements AutorDAO{

	private EntityManager manager;
	
	public AutorBDDao(EntityManager manager){
		this.manager = manager;
	}
	
	public void adiciona(Autor autor){
		manager.persist(autor);
	}
	
	public Autor getAutor(int id){
		return manager.find(Autor.class, id);
	}
	
	public void remove(Autor autor){
		manager.remove(autor);
	}
	
	public void altera(Autor autor){
	}
	
	public List<Autor> getLista(){
		return manager.createQuery("select a from Autor a").getResultList();
	}
	
	
	
}
