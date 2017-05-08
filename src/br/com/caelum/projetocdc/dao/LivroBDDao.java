package br.com.caelum.projetocdc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Tipo;
import br.com.caelum.projetocdc.jdbc.ConnectionFactory;

public class LivroBDDao {
	
	private Connection connection;
	private EntityManager manager;
	
	public LivroBDDao(Connection connection){
		this.connection = connection;
	}
	
	public LivroBDDao(EntityManager manager){
		this.manager = manager;
	}

	public void adiciona(Livro livro){
		manager.persist(livro);
	}
	
	public void altera(Livro livro){
		manager.merge(livro);
	}
	
	public Livro getLivro(int id){
		return manager.find(Livro.class, id);
	}
	
	public void remove(Livro livro){
	manager.remove(livro);
	}		
}
