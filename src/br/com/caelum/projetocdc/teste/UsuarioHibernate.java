package br.com.caelum.projetocdc.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.projetocdc.Usuario;
import br.com.caelum.projetocdc.dao.UsuarioBDDao;

public class UsuarioHibernate {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cdc");
		
		EntityManager manager = factory.createEntityManager();

		Usuario usuario = new Usuario("Maria Junqueira", "maria@email.com.br");
		
		UsuarioBDDao dao = new UsuarioBDDao(manager);
		dao.adiciona(usuario);
		
		manager.close();
		factory.close();
	}

}
