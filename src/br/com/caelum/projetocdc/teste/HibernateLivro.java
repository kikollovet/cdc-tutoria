package br.com.caelum.projetocdc.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Tipo;
import br.com.caelum.projetocdc.dao.AutorBDDao;

public class HibernateLivro {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cdc");
		
		EntityManager manager = factory.createEntityManager();
		
		AutorBDDao dao = new AutorBDDao(manager);
		
		Autor autor = dao.getAutor(5);
		
		Calendar calendar = Calendar.getInstance();
		
		Livro livro = new Livro("Livro Teste", "Será?", autor, Tipo.IMPRESSO, 45.50, calendar, calendar);
		
		manager.getTransaction().begin();
		//manager.persist(livro);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}
}
