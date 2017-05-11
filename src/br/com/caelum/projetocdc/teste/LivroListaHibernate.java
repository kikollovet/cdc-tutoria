package br.com.caelum.projetocdc.teste;

import java.util.List;

import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.dao.LivroBDDao;
import br.com.caelum.projetocdc.jpa.JPAUtil;

public class LivroListaHibernate {

	public static void main(String[] args) {
		JPAUtil jpa = new JPAUtil();
		
		LivroBDDao dao = new LivroBDDao(jpa.getEntityManager());
		
		List<Livro> lista = dao.getLista();
		
		System.out.println(lista);
	}

}
