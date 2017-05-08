package br.com.caelum.projetocdc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.Compra;
import br.com.caelum.projetocdc.Item;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Tipo;
import br.com.caelum.projetocdc.Usuario;
import br.com.caelum.projetocdc.jdbc.ConnectionFactory;

public class CompraBDDao {

	private Connection connection;
	private EntityManager manager;
	
	public CompraBDDao(Connection connection){
		this.connection = connection;
	}
	
	public CompraBDDao(EntityManager manager){
		this.manager = manager;
	}
	
	public void adiciona(Compra compra) {
		manager.persist(compra);
		for(Item item : compra.getItens()){
			manager.persist(item);
		}
	}
	
	public Compra getCompra(int id) {
		Compra compra = manager.find(Compra.class, id);	
		return compra;
	}
	
}
