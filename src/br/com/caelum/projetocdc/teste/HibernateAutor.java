package br.com.caelum.projetocdc.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.projetocdc.Autor;

public class HibernateAutor {

	public static void main(String[] args) {

		Autor autor = new Autor("Hibernate Teste");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cdc");
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(autor);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}

}
