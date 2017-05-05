package br.com.caelum.projetocdc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import br.com.caelum.projetocdc.Usuario;
import br.com.caelum.projetocdc.jdbc.ConnectionFactory;

public class UsuarioBDDao {

	private Connection connection;
	private EntityManager manager;
	
	public UsuarioBDDao(Connection connection){
		this.connection = connection;
	}
	
	public UsuarioBDDao(EntityManager manager){
		this.manager = manager;
	}
	
	public void adiciona(Usuario usuario){
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
	}
	
	public void altera(Usuario usuario) {
	}
	
	public Usuario getUsuario(int id){
		return manager.find(Usuario.class, id);
	}
	
	public void remove(Usuario usuario){
		manager.getTransaction().begin();
		manager.remove(usuario);
		manager.getTransaction().commit();
	}
}
