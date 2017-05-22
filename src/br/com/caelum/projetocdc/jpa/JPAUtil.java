package br.com.caelum.projetocdc.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory;
	private EntityManager manager;
	
	public JPAUtil(){
		factory = Persistence.createEntityManagerFactory("cdc");
		this.manager = factory.createEntityManager();
	}
	
	public EntityManager getEntityManager(){
		return this.manager; 
	}
	
	public void iniciaTransacao(){
		this.manager.getTransaction().begin();
	}
	
	public void comitaTransacao(){
		this.manager.getTransaction().commit();
	}
	
	public void fechaConexao(){
		this.manager.close();
		this.factory.close();
	}
	
	public static void fechaFabrica(){
		factory.close();
	}
}
