package br.com.caelum.projetocdc.autentificador;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.caelum.projetocdc.Usuario;

public class Autentificador {

	EntityManager manager;
	
	public Autentificador(EntityManager manager){
		this.manager = manager;
	}
	
	public Usuario autentifica(String nome, String email){
		
		Query query = manager.createQuery("select u from Usuario u where u.nome = :nome and u.email = :email");
		query.setParameter("nome", nome);
		query.setParameter("email", email);
		
		try{
			return (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
