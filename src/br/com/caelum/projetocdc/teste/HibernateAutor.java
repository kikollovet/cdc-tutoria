package br.com.caelum.projetocdc.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.dao.AutorBDDao;

public class HibernateAutor {

	public static void main(String[] args) {

		Autor autor = new Autor("Henrique Almeida");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cdc");
		
		EntityManager manager = factory.createEntityManager();
		
		AutorBDDao dao = new AutorBDDao(manager);
		
		dao.add(autor);
		
		
		
		manager.close();
		factory.close();
	}

}
