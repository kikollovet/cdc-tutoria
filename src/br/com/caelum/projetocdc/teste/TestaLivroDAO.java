package br.com.caelum.projetocdc.teste;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Tipo;
import br.com.caelum.projetocdc.dao.LivroBDDao;

public class TestaLivroDAO {

	public static void main(String[] args) {

		Autor joaquim = new Autor("Joaquim Torres");
		joaquim.setId(1);
		
		Livro livro = new Livro("Guia da Startup", "Como startups e empresas estabelecidas podem criar produtos de software rentáveis", 
				joaquim, Tipo.EBOOK, 29.90, "01/03/2017", "15/02/2014");
		livro.setId(1);
		
		LivroBDDao dao = new LivroBDDao();
		//dao.adiciona(livro);
		//dao.altera(livro);
		//System.out.println(dao.getLivro(1));
		//dao.remove(1);
	}

}
