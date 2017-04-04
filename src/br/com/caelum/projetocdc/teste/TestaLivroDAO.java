package br.com.caelum.projetocdc.teste;

import java.util.Calendar;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Tipo;
import br.com.caelum.projetocdc.dao.LivroBDDao;

public class TestaLivroDAO {

	public static void main(String[] args) {

		Autor joaquim = new Autor("Joaquim Torres");
		joaquim.setId(1);
		
		Calendar dataUltimaAtualizacao = Calendar.getInstance();
		dataUltimaAtualizacao.set(2017, 03, 01);
		
		Calendar dataLancamento = Calendar.getInstance();
		dataLancamento.set(2014, 02, 15);
		
		
		Livro livro = new Livro("Guia da Startup", "Como startups e empresas estabelecidas podem criar produtos de software rentáveis", 
				joaquim, Tipo.EBOOK, 29.90, dataUltimaAtualizacao, dataLancamento);
		livro.setId(1);
		
		LivroBDDao dao = new LivroBDDao();
		//dao.adiciona(livro);
		//dao.altera(livro);
		System.out.println(dao.getLivro(2).getDataUltimaAtualizacaoString());
		//dao.remove(1);
	}

}
