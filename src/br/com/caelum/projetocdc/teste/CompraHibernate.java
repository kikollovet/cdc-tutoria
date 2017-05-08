package br.com.caelum.projetocdc.teste;

import java.util.Calendar;

import br.com.caelum.projetocdc.Compra;
import br.com.caelum.projetocdc.Item;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Usuario;
import br.com.caelum.projetocdc.dao.CompraBDDao;
import br.com.caelum.projetocdc.dao.LivroBDDao;
import br.com.caelum.projetocdc.dao.UsuarioBDDao;
import br.com.caelum.projetocdc.jpa.JPAUtil;

public class CompraHibernate {

	public static void main(String[] args) {
		JPAUtil jpa = new JPAUtil();
		UsuarioBDDao usuarioDao = new UsuarioBDDao(jpa.getEntityManager());
		
		jpa.iniciaTransacao();
		Usuario usuario = usuarioDao.getUsuario(2);
		
		LivroBDDao livroDao = new LivroBDDao(jpa.getEntityManager());
		Livro livro = livroDao.getLivro(2);
		Livro livroDois = livroDao.getLivro(4);
		
		Compra compra = new Compra(usuario, Calendar.getInstance());
		
		Item itemUm = new Item(compra, livro, 3);
		Item itemDois = new Item(compra, livroDois, 4);
		
		compra.adicionaItens(itemUm);
		compra.adicionaItens(itemDois);
		
		CompraBDDao compraDao = new CompraBDDao(jpa.getEntityManager());
		//compraDao.adiciona(compra);
		System.out.println(compraDao.getCompra(11));
		
		jpa.comitaTransacao();
		jpa.fechaConexao();

	}

}
