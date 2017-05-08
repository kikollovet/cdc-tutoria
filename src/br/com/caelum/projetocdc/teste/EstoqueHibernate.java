package br.com.caelum.projetocdc.teste;

import br.com.caelum.projetocdc.ItemNoEstoque;
import br.com.caelum.projetocdc.dao.EstoqueBDDao;
import br.com.caelum.projetocdc.jpa.JPAUtil;

public class EstoqueHibernate {

	public static void main(String[] args) {
		JPAUtil jpa = new JPAUtil();
		EstoqueBDDao estoqueDao = new EstoqueBDDao(jpa.getEntityManager());
		jpa.iniciaTransacao();
		ItemNoEstoque item = estoqueDao.getItemNoEstoqueIdLivro(3);
		jpa.comitaTransacao();
		
		System.out.println(item);
	}

}
